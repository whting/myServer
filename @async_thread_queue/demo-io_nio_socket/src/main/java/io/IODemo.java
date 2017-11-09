package io;
 
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
 
public class IODemo
{
   
    public static void main(String[] args)
    {
        // 基础流应用
        basisStream();
       
        // 拷贝文件
        copyFile("E:/test1.txt", "E:/test2.txt");
       
        // 校验文件
        fileCheck("E:/test1.txt");
       
        // 压缩
        doZip("E:/压缩目录");
       
        // 解压
        unzip("E:/book/myBook.zip", "E:/book/");
       
        // 常规转码示例
        encoding();
    }
   
    /**
     * 基础流应用
     *
     * @File 文件基础类
     * @FileReader/FileWriter 读取字符文件的便捷类(场景：读取文本类型文件-字符流)
     * @FileInputStream/FileOutputStream用于读取诸如图像数据之类的原始字节流(场景：读取非文本类型文件-字节流)
     * @InputStreamReader/OutputStreamWriter 字节流与字符流的转换桥梁，其次还用于编码的设置
     * @BufferedReader/BufferedWriter 从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取
     * @BufferedInputStream/BufferedOutputStream 字节流缓冲类，就不需要每次字节写入调用底层系统
     * @PrintStream/PrintWriter 字节缓存输入流/字符缓存输出流. 场景：需要格式化输出时使用！
     *
     * @区别:FileInputStream：以字节流方式读取；/ FileReader：把文件转换为字符流读入；
     * @区别:PrintStream是OutputStream(字节)的子类;/ PrintWriter是Writer(字符)的子类；
     */
    public static void basisStream()
    {
       
        File read = new File("E:A.txt");
        File write = new File("E:B.txt");
       
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
       
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
       
        try
        {
            /** -------- 1. 字符流 ------ */
            FileReader fileReader = new FileReader(read);
            FileWriter fileWriter = new FileWriter(write);
           
            char[] charBuf = new char[1024];
            int charLen = 0;
            while (0 < (charLen = fileReader.read(charBuf)))
            {
                System.out.println(charBuf);
                fileWriter.write(charBuf, 0, charLen);
            }
            fileWriter.flush();// 刷新,写入数据
 
            /** -------- 2. 字节流 ------ */
            FileInputStream fileInputStream = new FileInputStream(read);
            FileOutputStream fileOutputStream = new FileOutputStream(write);
           
            byte[] byteBuf = new byte[1024];
            int byteLen = 0;
            while (0 < (byteLen = fileInputStream.read(byteBuf)))
            {
                System.out.println(byteBuf);
                fileOutputStream.write(byteBuf, 0, byteLen);
            }
           
            /** -------- 3. 字符缓冲流 ------ */
            bufferedReader = new BufferedReader(new FileReader(read));
            bufferedWriter = new BufferedWriter(new FileWriter(write));
           
            show(bufferedReader, bufferedWriter);
           
            /** -------- 4. 字节缓冲流 ------ */
            bufferedInputStream = new BufferedInputStream(new FileInputStream(read));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(write));
           
            int readinput;
            while (-1 != (readinput = bufferedInputStream.read()))
            {
                System.out.print((char)readinput);
                bufferedOutputStream.write(readinput);
            }
           
            /** -------- 5.流类型转换及编码控制 ------ */
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(read), "UTF-8")); // 字节流通向字符流<I>
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(write), "UTF-8"));// 字符流通向字节流<O>
           
            show(bufferedReader, bufferedWriter);
           
            /** -------- 6.Print格式化输出流 ------ */
            PrintStream printStream = new PrintStream(new FileOutputStream(new File("E:C.txt")));
            PrintWriter printWriter = new PrintWriter(new FileWriter(new File("E:D.txt")));
            // pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File("E:C.txt"))));// 字节->字符->printWriter
            // pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(......)))); // 多余,printwriter会内部构建BufferWriter
           
            // 文本写入
            printStream.write("message".getBytes());// 转字节
            printWriter.write("message"); // 字符直接使用
            
            // 流写入
            String reader = null;
            while (null != (reader = bufferedReader.readLine()))
            {
                System.out.println(reader);
                printStream.write(reader.getBytes());// 转字节
                printWriter.write(reader); // 字符直接使用
            }
           
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                bufferedReader.close();
                bufferedWriter.close();
               
                bufferedInputStream.close();
                bufferedOutputStream.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
           
        }
       
    }
   
    /**
     * 拷贝文件 <功能详细描述>
     *
     * @param inName
     * @param outName [参数说明]
     *
     * @return void [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static void copyFile(String inName, String outName)
    {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
       
        try
        {
            File tmp = new File(outName);
            if (!tmp.canRead())
            {
                tmp.createNewFile();
            }
           
            in = new BufferedInputStream(new FileInputStream(inName));
            out = new BufferedOutputStream(new FileOutputStream(outName));
           
            int b;
            while ((b = in.read()) != -1)
            {
                out.write(b);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
                in.close();
                out.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
       
    }
   
    /**
     * 校验文件信息
     *
     * @param name
     * @throws IOException [参数说明]
     *
     * @return void [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static void fileCheck(String name)
    {
        System.out.println("---" + name + "---");
        File f = new File(name);
       
        if (!f.exists())
        {
            System.out.println("fle not exist!");
            return;
        }
       
        try
        {
            System.out.println("Canonical  name:" + f.getCanonicalPath());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
       
        String p = f.getParent();
        if (p != null)
            System.out.println("Parent directory :" + p);
       
        if (f.canRead())
            System.out.println("file can be read!");
       
        if (f.canWrite())
            System.out.println("file can be writable!");
       
        Date d = new Date();
        d.setTime(f.lastModified());
        System.out.println("last modified time :" + d);
       
        if (f.isFile())
        {
            System.out.println("file size is :" + f.length() + " bytes");
        }
        else if (f.isDirectory())
        {
            System.out.println("is a directry!");
        }
        else
        {
            System.out.println("neither a directory or a file!");
        }
    }
   
    /**
     * 打印及写入
     *
     * @param bufferedReader
     * @param bufferedWriter
     * @throws IOException [参数说明]
     *
     * @return void [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static void show(BufferedReader bufferedReader, BufferedWriter bufferedWriter)
        throws IOException
    {
        String reader = null;
        while (null != (reader = bufferedReader.readLine()))
        {
            System.out.println(reader);
            bufferedWriter.write(reader);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();// 刷新,写入数据
    }
   
    /**
     * 压缩 <功能详细描述>
     *
     * @param zipDir 指定需要压缩的目录
     *
     * @return void [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static void doZip(String zipDir)
    {
        BufferedInputStream bufferedInputStream = null;
        ZipOutputStream zipOutputStream = null;
        try
        {
           
            // zip压缩工具
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(new File(zipDir + "/../myBook.zip"))));
           
            for (File file : new File(zipDir).listFiles())
            {
                zipOutputStream.putNextEntry(new ZipEntry(file.getName()));// 开始写入新的 ZIP 文件条目并将流定位到条目数据的开始处
               
                // 压缩对象
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
               
                int readinput;
                while (-1 != (readinput = bufferedInputStream.read()))
                {
                    System.out.print((char)readinput);
                    zipOutputStream.write(readinput);
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                bufferedInputStream.close();
                zipOutputStream.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
   
    /**
     * 解压
     *
     * @param zipDir 压缩对象(目录)
     * @param targetPath 解压目录
     *
     * @return void [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static void unzip(String zipDir, String targetPath)
    {
        ZipInputStream zipInputStream = null;
        FileOutputStream fileOutputStream = null;
        try
        {
            zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(new File(zipDir))));
           
            ZipEntry zipEntry;
            while (null != (zipEntry = zipInputStream.getNextEntry()))
            {
                fileOutputStream = new FileOutputStream(new File(targetPath + zipEntry.getName()));
               
                int zipInputStreamInt;
                while (-1 != (zipInputStreamInt = zipInputStream.read()))
                {
                    System.out.print((char)zipInputStreamInt);
                    fileOutputStream.write(zipInputStreamInt);
                }
            }
           
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                zipInputStream.close();
                fileOutputStream.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
   
    /**
     * 常规转码示例 <功能详细描述> [参数说明]
     *
     * @return void [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static void encoding()
    {
        /**
         * <pre> 乱码的由来
         * 在所有的流操作里。字节永远是最基础的。任何基于字节的操作都是正确的。无论你是文本文件还是二进制的文件。
         * 如果确认流里面只有可打印的字符，包括英文的和各种国家的文字，也包括中文，那么可以考虑用字符流。
         * 由于编码不同，多字节的字符可能占用多个字节。比如GBK的汉字就占用2个字节，而UTF-8的汉字就占用3个字节。
         * 所以，字符流是根据指定的编码，将1个或多个字节转化为java里面的unicode的字符，然后进行操作。
         * 字符操作一般使用Writer,Reader等， 字节操作一般都是InputStream, OutputStream 以及各种包装类，比如BufferedInputStream和BufferedOutputStream等。
         * 总结：如果你确认你要处理的流是可打印的字符，那么使用字符流会看上去简单一点。如果不确认，那么用字节流总是不会错的。
         * </pre>
         */
       
        try
        {
            // 文件转码
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(""), "UTF-8"));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(""), "UTF-8"));
           
            // servlet,网络转码
            String message_I = java.net.URLEncoder.encode("message", "UTF-8");// 转码
            String message_O = java.net.URLDecoder.decode("message", "utf-8");// 解码
            // response.setCharacterEncoding("UTF-8");
           
            // Html编码
            String htmlCoding = "<body><head>...<META http-equiv=Content-Type content='text/html; charset=utf-8' /><META content='MSHTML 6.00.6000.16788' name=GENERATOR /></head><body>";
           
            // XML
            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
           
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    /*--------------------------------------------------------------------------------------------------------*/
}
 