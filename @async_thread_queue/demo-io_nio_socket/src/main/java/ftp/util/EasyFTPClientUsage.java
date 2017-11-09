package ftp.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.util.TimeZone;

/**
 * 通过commons net中的FTP包进行FTP的简单操作.FTP登陆，上传文件，上传文件夹，下载，退出登陆
 *
 * @author范芳铭
 */

public class EasyFTPClientUsage {

    private FTPClient ftpClient;

    private String strIp;

    private int intPort;

    private String user;

    private String password;

    /**
     * Ftp构造函数
     */
    public EasyFTPClientUsage(String strIp, int intPort, String user, String Password) {
        this.strIp = strIp;
        this.intPort = intPort;
        this.user = user;
        this.password = Password;
        this.ftpClient = new FTPClient();
    }


    /**
     * @return判断是否登入成功
     */

    public boolean ftpLogin() {

        boolean isLogin = false;
        FTPClientConfig ftpClientConfig = new FTPClientConfig();
        ftpClientConfig.setServerTimeZoneId(TimeZone.getDefault().getID());
        this.ftpClient.setControlEncoding("GBK");
        this.ftpClient.configure(ftpClientConfig);

        try {

            if (this.intPort > 0) {
                this.ftpClient.connect(this.strIp, this.intPort);
            } else {
                this.ftpClient.connect(this.strIp);
            }

            // FTP服务器连接回答
            int reply = this.ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                this.ftpClient.disconnect();
                System.out.println("登录FTP服务失败！");
                return isLogin;
            }

            this.ftpClient.login(this.user, this.password);

            // 设置传输协议
            this.ftpClient.enterLocalPassiveMode();
            this.ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            System.out.println("恭喜" + this.user + "成功登陆FTP服务器:" + this.strIp);
            isLogin = true;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(this.user + "登录FTP服务失败！" + e.getMessage());
        }

        this.ftpClient.setBufferSize(1024 * 2);
        this.ftpClient.setDataTimeout(30 * 1000);
        return isLogin;
    }


    /**
     * @退出关闭服务器链接
     */

    public void ftpLogOut() {

        if (null != this.ftpClient && this.ftpClient.isConnected()) {
            try {
                boolean reuslt = this.ftpClient.logout();// 退出FTP服务器
                if (reuslt) {
                    System.out.println("成功退出服务器");
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("退出FTP服务器异常！" + e.getMessage());
            } finally {

                try {
                    this.ftpClient.disconnect();// 关闭FTP服务器的连接
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭FTP服务器的连接异常！");
                }
            }
        }

    }


    /***
     * 上传Ftp文件
     *
     * @param localFile
     *           当地文件
     * @param romotUpLoadePath 上传服务器路径 -应该以/结束
     * */

    public boolean uploadFile(File localFile, String romotUpLoadePath) {

        BufferedInputStream inStream = null;
        boolean success = false;

        try {

            this.ftpClient.changeWorkingDirectory(romotUpLoadePath);// 改变工作路径
            inStream = new BufferedInputStream(new FileInputStream(localFile));
            System.out.println(localFile.getName() + "开始上传.....");
            success = this.ftpClient.storeFile(localFile.getName(), inStream);

            if (success == true) {
                System.out.println(localFile.getName() + "上传成功");
                return success;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(localFile + "未找到");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return success;
    }


    /***
     * 下载文件
     *
     * @param remoteFileName
     *           待下载文件名称
     * @param localDires
     *           下载到当地那个路径下
     * @param remoteDownLoadPath
     *           remoteFileName所在的路径
     * */
    public boolean downloadFile(String remoteFileName, String localDires, String remoteDownLoadPath) {

        String strFilePath = localDires + remoteFileName;
        BufferedOutputStream outStream = null;
        boolean success = false;

        try {
            this.ftpClient.changeWorkingDirectory(remoteDownLoadPath);
            outStream = new BufferedOutputStream(new FileOutputStream(strFilePath));
            System.out.println(remoteFileName + "开始下载....");
            success = this.ftpClient.retrieveFile(remoteFileName, outStream);
            if (success == true) {
                System.out.println(remoteFileName + "成功下载到" + strFilePath);
                return success;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(remoteFileName + "下载失败");
        } finally {

            if (null != outStream) {
                try {
                    outStream.flush();
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (success == false) {
            System.out.println(remoteFileName + "下载失败!!!");
        }
        return success;
    }


    /***
     * @上传文件夹
     * @param localDirectory
     *           当地文件夹
     * @param remoteDirectoryPath
     *           Ftp 服务器路径以目录"/"结束
     * */

    public boolean uploadDirectory(String localDirectory,

                                   String remoteDirectoryPath) {

        File src = new File(localDirectory);

        try {
            remoteDirectoryPath = remoteDirectoryPath + src.getName() + "//";
            this.ftpClient.makeDirectory(remoteDirectoryPath);
            // ftpClient.listDirectories();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(remoteDirectoryPath + "目录创建失败");
        }

        File[] allFile = src.listFiles();
        for (int currentFile = 0; currentFile < allFile.length; currentFile++) {
            if (!allFile[currentFile].isDirectory()) {
                String srcName = allFile[currentFile].getPath().toString();
                uploadFile(new File(srcName), remoteDirectoryPath);
            }
        }

        for (int currentFile = 0; currentFile < allFile.length; currentFile++) {
            if (allFile[currentFile].isDirectory()) {
                // 递归
                uploadDirectory(allFile[currentFile].getPath().toString(),
                        remoteDirectoryPath);
            }
        }
        return true;
    }


    /***
     * @下载文件夹
     * @param localDirectoryPath 本地地址
     * @param remoteDirectory
     *           远程文件夹
     * */

    public boolean downLoadDirectory(String localDirectoryPath,String remoteDirectory) {

        try {

            String fileName = new File(remoteDirectory).getName();
            localDirectoryPath = localDirectoryPath + fileName + "/";
            new File(localDirectoryPath).mkdirs();
            FTPFile[] allFile = this.ftpClient.listFiles(remoteDirectory);

            for (int currentFile = 0; currentFile < allFile.length; currentFile++) {
                if (!allFile[currentFile].isDirectory()) {
                    downloadFile(allFile[currentFile].getName(),
                            localDirectoryPath, remoteDirectory);
                }
            }

            for (int currentFile = 0; currentFile < allFile.length; currentFile++) {

                //要去掉可能的当前目录，否则会导致死循环
                if (allFile[currentFile].isDirectory()) {
                    if (allFile[currentFile].getName().equals(".") ||
                            allFile[currentFile].getName().equals("..")) {
                        continue; //要去掉可能的当前目录
                    } else {
                        String strremoteDirectoryPath = remoteDirectory + "/"
                                + allFile[currentFile].getName();
                        downLoadDirectory(localDirectoryPath,

                                strremoteDirectoryPath);
                    }
                }
            }

        } catch (IOException e) {

            e.printStackTrace();

            System.out.println("下载文件夹失败");

            return false;

        }

        return true;
    }


    // FtpClient的Set 和 Get 函数

    public FTPClient getFtpClient() {
        return ftpClient;
    }


    public void setFtpClient(FTPClient ftpClient) {
        this.ftpClient = ftpClient;
    }


    public static void main(String[] args) throws IOException {

        EasyFTPClientUsage ftp = new EasyFTPClientUsage("192.168.1.1", 21, "fanfangming", "ffm");
        ftp.ftpLogin();

        //上传单个文件
        ftp.uploadFile(new File("D:/ffm83/ffm83.txt"), "/ftpFile/");

        // 上传文件夹
        ftp.uploadDirectory("D:/ffm83/", "/ftpFile/");

        // 下载文件夹
        ftp.downLoadDirectory("D:/ffm83/tmp/", "/ftpFile/ffm83/");

        ftp.ftpLogOut();
    }

}