import java.io.File;

public class IonicSplash {

    static void getFile(String filePath) {
        File file = new File(filePath);
        if (!file.isDirectory()) {
            System.out.println("请指定文件夹");
        } else if (file.isDirectory()) {
            String[] filelist = file.list();// 文件列表
            for (String fileName : filelist) {
                File childDirectory = new File(filePath + "\\" + fileName);
                String childDirectoryName = childDirectory.getName();
                String[] childFileList = childDirectory.list();
                if (childFileList != null && childFileList.length != 0) {
                    File childFile = new File(filePath + "\\" + fileName + "\\" + childFileList[0]);
                    childFile.renameTo(new File(filePath + "\\" + childDirectoryName + "-" + childFile.getName()));// 重命名
                }
            }
        }
    }

    public static void main(String[] args) {
        getFile("E:\\楼宇 app icon\\android");
    }
}
