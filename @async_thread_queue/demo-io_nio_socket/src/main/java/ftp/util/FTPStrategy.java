package ftp.util;

import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;

public class FTPStrategy {
    protected URL url;
    protected String ftpUser = "";
    protected String ftpPass = "";

    public FTPStrategy(String url) throws MalformedURLException {
        // String url = "ftp://10.57.240.181:2121";
        // String url="ftp://sysop:abcde123@83.25.46.53/opt/activemq/patches/";
        this.url = new URL("ftp://10.57.240.181:2121");
    }

    protected void setUserInformation(String userInfo) {
        if (userInfo != null) {
            String[] userPass = userInfo.split(":");
            if (userPass.length > 0) this.ftpUser = userPass[0];
            if (userPass.length > 1) this.ftpPass = userPass[1];
        } else {
            this.ftpUser = "anonymous";
            this.ftpPass = "anonymous";
        }
    }

    protected FTPClient createFTP() throws IOException {
        String connectUrl = this.url.getHost();
        setUserInformation(this.url.getUserInfo());
        int port = this.url.getPort() < 1 ? 21 : this.url.getPort();

        FTPClient ftp = new FTPClient();
        try {
            ftp.connect(connectUrl, port);
        } catch (ConnectException e) {
            System.out.println(e);
            //throw new JMSException("Problem connecting the FTP-server");
        }
        if (!ftp.login(this.ftpUser, this.ftpPass)) {
            ftp.quit();
            ftp.disconnect();
            System.out.println("Cant Authentificate to FTP-Server");
//            throw new JMSException("Cant Authentificate to FTP-Server");
        }
        return ftp;
    }

    public URL uploadFile(File file) throws IOException {
        FTPClient ftp = createFTP();
        try {
            String path = this.url.getPath();
            String workingDir = path.substring(0, path.lastIndexOf("/"));
            String filename = file.getName();
            ftp.setFileType(2);
            String url;
            if (!ftp.changeWorkingDirectory(workingDir))
                url = this.url.toString().replaceFirst(this.url.getPath(), "") + "/";
            else {
                url = this.url.toString();
            }
            InputStream in = new FileInputStream(file);
            if (!ftp.storeFile(filename, in)) {
                System.out.println("FTP store failed: " + ftp.getReplyString());
//                throw new JMSException("FTP store failed: " + ftp.getReplyString());
            }
            return new URL(url + filename);
        } finally {
            ftp.quit();
            ftp.disconnect();
        }
    }
}

/**
 * 用Java实现FTP上传
 * http://www.jianshu.com/p/6c3ff9381890
 */