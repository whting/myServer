package hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class HdfsCommon {

    static String resoucePath = ClassLoader.getSystemResource("").getPath() + "../../src/main/java/";
    static String pathString = resoucePath + "hdfs/hdfs_test.txt";
    static String pathString_write = resoucePath + "hdfs/hdfs_test_w.txt";

    /**
     * 创建目录
     * <p>
     * hadoop fs -mkdir input (相对目录：/user/Administrator/input)
     *
     * @throws IOException
     */
    public static void makeDir() throws IOException {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);
        Path path = new Path("input");// (/input 为根目录) (input 为相对目录)
        fs.create(path);
        fs.close();
    }

    /**
     * read from HDFS
     *
     * @throws Exception
     */
    public static void read() throws Exception {
        String pathString = "my.txt";

        Configuration conf = new Configuration();
        FileSystem fileSystem = FileSystem.get(conf);// get

        FSDataInputStream fsDataInputStream = fileSystem.open(new Path(pathString));// (相对目录：/user/Administrator/)
        IOUtils.copyBytes(fsDataInputStream, System.out, 4096, false);
    }

    /**
     * write to HDFS
     *
     * @throws Exception
     */
    public static void write() throws Exception {
        Configuration conf = new Configuration();
        FileSystem fileSystem = FileSystem.get(conf);
//        FSDataOutputStream outStream = fileSystem.create(new Path("hdfs://localhost:9000/input/my.txt"));
        FSDataOutputStream outStream = fileSystem.create(new Path("my.txt"));// (相对目录：/user/Administrator/)
        FileInputStream instream = new FileInputStream(new File(pathString));

        try {
            IOUtils.copyBytes(instream, outStream, 4096, false);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(instream);
            IOUtils.closeStream(outStream);
        }
    }

    /**
     * write to HDFS from LocalFileSystem
     *
     * @throws Exception
     */
    public static void write2() throws Exception {
        Configuration conf = new Configuration();
        FileSystem fileSystem = FileSystem.get(conf);
//        FSDataOutputStream outStream = fileSystem.create(new Path("my.txt"));
        FSDataOutputStream outStream = fileSystem.create(new Path("input/my.txt"));

        LocalFileSystem localFileSystem = FileSystem.getLocal(conf);// getLocal
        InputStream instream = localFileSystem.open(new Path(pathString));
//        InputStream instream = localFileSystem.open(new Path(pathString.substring(0, pathString.lastIndexOf("/"))));// 目录

        try {
            IOUtils.copyBytes(instream, outStream, 4096, false);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(instream);
            IOUtils.closeStream(outStream);
        }
    }

    /**
     * read from LocalFileSystem
     *
     * @throws Exception
     */
    public static void readFromLocal() throws Exception {
        Configuration conf = new Configuration();
        LocalFileSystem fileSystem = FileSystem.getLocal(conf);// getLocal

        FSDataInputStream fsDataInputStream = fileSystem.open(new Path(pathString));
        IOUtils.copyBytes(fsDataInputStream, System.out, 4096, false);
    }

    /**
     * write to HDFS from LocalFileSystem
     *
     * @throws Exception
     */
    public static void writeFromLocal() throws Exception {
        Configuration conf = new Configuration();
        FileSystem fileSystem = FileSystem.get(conf);
        LocalFileSystem localFileSystem = FileSystem.getLocal(conf);

        FSDataOutputStream outStream = fileSystem.create(new Path("my.txt"));
        InputStream instream = localFileSystem.open(new Path(pathString));

        IOUtils.copyBytes(instream, outStream, 4096, false);
    }


    public static void main(String[] args) throws Exception {
        /* hdfs操作 */
//        makeDir();
        write();
//        write2();
//        read();

        /* 本地操作 */
//        readFromLocal();
//        writeFromLocal();// 同write2();
    }
}
