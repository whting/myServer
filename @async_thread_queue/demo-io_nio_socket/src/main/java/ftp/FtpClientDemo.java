package ftp;

import encode.EncodingDemo;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;

public class FtpClientDemo {

    static FTPClient ftpClient;

    /**
     * 连接并登陆ftp
     */
    public static void connect(String host, int port, String username, String password) throws IOException {
        ftpClient = new FTPClient();
        ftpClient.connect(host, port);//连接ftp
        ftpClient.setConnectTimeout(60000);//定义连接时间
        ftpClient.login(username, password);//登录ftp
//        ftpClient.setControlEncoding("utf-8");

        // 检测连接是否成功
        int reply = ftpClient.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            System.out.println(reply);
            System.exit(1);
        }
        // 设置上传模式binally or ascii
        ftpClient.setFileType(ftpClient.BINARY_FILE_TYPE);
    }

    /**
     * target--目标文件名称
     * <p>
     * source--源文件名称
     */

    public static void put(String target, String source) throws IOException {

        InputStream iStream = null;
        try {
            iStream = new FileInputStream(source);
            ftpClient.storeFile(target, iStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (iStream != null) {
                iStream.close();
            }
        }
    }

    /**
     * 下载文件
     *
     * @param remoteFileName       --服务器上的文件名
     * @param localFileName--本地文件名
     * @return true 下载成功，false 下载失败
     */
    public boolean loadFile(String remoteFileName, String localFileName) {
        boolean flag = true;
        // 下载文件
        BufferedOutputStream buffOut = null;
        try {
            buffOut = new BufferedOutputStream(new FileOutputStream(localFileName));
            flag = ftpClient.retrieveFile(remoteFileName, buffOut);
        } catch (Exception e) {
            e.printStackTrace();
            // logger.debug("本地文件下载失败！", e);
        } finally {
            try {
                if (buffOut != null)
                    buffOut.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    /**
     * BufferedInputStream重复读
     */
    public void reRead() throws IOException, IllegalAccessException {
        FtpClientDemo.connect("127.0.0.1", 2121, "anonymous", "");
        for (FTPFile ftpFile : ftpClient.listFiles()) {
            if (".DS_Store".equals(ftpFile.getName())) {
                continue;
            }

            System.out.println(EncodingDemo.getEncoding(ftpFile.getName()));
            String fileNameCN = new String(ftpFile.getName().getBytes("ISO-8859-1"), "utf-8");
            System.out.println(fileNameCN);

            // 读取内容(字节-不便转码)
            InputStream inputStream = ftpClient.retrieveFileStream(ftpFile.getName());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            if (!bufferedInputStream.markSupported()) {
                System.out.println("mark/reset not supported!");
            }

            int readinput, index = 0;
            while (-1 != (readinput = bufferedInputStream.read())) {
                bufferedInputStream.mark(index += readinput);
                System.out.print((char) readinput);
            }
            bufferedInputStream.reset();

            index = 0;
            while (-1 != (readinput = bufferedInputStream.read())) {
                bufferedInputStream.mark(index += readinput);
                System.out.print((char) readinput);
            }

        }
    }

    public static void main(String[] args) throws IOException, IllegalAccessException {

        FtpClientDemo.connect("127.0.0.1", 2121, "anonymous", "");
        for (FTPFile ftpFile : ftpClient.listFiles()) {
            if (".DS_Store".equals(ftpFile.getName())) {
                continue;
            }

            System.out.println(EncodingDemo.getEncoding(ftpFile.getName()));
            String fileNameCN = new String(ftpFile.getName().getBytes("ISO-8859-1"), "utf-8");
            System.out.println(fileNameCN);

            // 下载
            BufferedOutputStream buffOut = new BufferedOutputStream(new FileOutputStream("/Users/liuxiang/Desktop/" + fileNameCN));
            System.out.println(ftpClient.retrieveFile(ftpFile.getName(), buffOut));
            buffOut.close();// 关流,写盘

            // 读取内容(字节-不便转码)
            InputStream inputStream = ftpClient.retrieveFileStream(ftpFile.getName());
            if (false) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                int readinput, index = 0;
                while (-1 != (readinput = bufferedInputStream.read())) {
                    bufferedInputStream.mark(index += readinput);
                    System.out.print((char) readinput);
                }
            }

            // 读取内容(按行-方便转码)
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));// 关闭上文阀门(BufferedInputStream),才可重读
            String reader = null;
            while (null != (reader = bufferedReader.readLine())) {
                System.out.println(reader);
            }
        }
    }

}

/**
 * Ftpserver
 * <p>
 * download中文.txt
 * 123
 * 456
 * 中文
 * 678
 */