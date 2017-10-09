
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
 
public class jstackAnalyse_huawei
{
   
    public static void main(String[] args)
    {
        // 基础流应用
        basisStream();
    }
   
    /**
     * 基础流应用
     *
     * File 文件基础类 FileReader/FileWriter 读取字符文件的便捷类(读取文本类型文件-字符流) FileInputStream/FileOutputStream用于读取诸如图像数据之类的原始字节流(读取非文本类型文件-字节流)
     * InputStreamReader/OutputStreamWriter 字节流与字符流的转换桥梁，其次还用于编码的设置 BufferedReader/BufferedWriter 从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取
     * BufferedInputStream/BufferedOutputStream 字节流缓冲类，就不需要每次字节写入调用底层系统
     */
    public static void basisStream()
    {
       
        File read = new File("C:\\Documents and Settings\\s00108360\\桌面\\1028manager挂死\\jstack1028.txt");
        // File read = new File("C:\\Documents and Settings\\s00108360\\桌面\\默认线程池日志\\iManager_jstack1811.log");
        File write = new File("D:B.txt");
       
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
       
        try
        {
            // 1. 字符缓冲流
            bufferedReader = new BufferedReader(new FileReader(read));
            bufferedWriter = new BufferedWriter(new FileWriter(write));
           
            show(bufferedReader, bufferedWriter);
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
                bufferedReader.close();
                bufferedWriter.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
           
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
        Map<String, Integer> map = new HashMap<String, Integer>();
       
        int LogNum = 0;// 日志行数标记
        boolean isHuawei = false;
        boolean isRun = false;
        boolean isOther = false;// 其它
        String readerbak = "";
        int catlogNum = 0;// 手动打印过几次
        while (null != (reader = bufferedReader.readLine()))
        {
            if (reader.contains("2012-"))
            {
                catlogNum++;// log次数
                LogNum = 0;
                System.out.println("\n\n" + reader);
            }
           
            if (reader.contains("\""))
            {
                // 截取线程名
                String readerTeam = reader.substring(reader.indexOf("\""), reader.lastIndexOf("\"") + 1);
               
                // 非huawei日志,忽略
                if (!isHuawei || !isRun)
                {
                    map.remove(readerbak);
                }
               
                /** 登记线程名,作用:找出重复多次出现未销毁的线程(现场内容可能存在变化-执行慢) */
                // readerbak = mapThread(map, readerTeam);
               
                /** 登记完整线程,作用:找出重复多次出现未销毁的线程.且线程内容未曾改变(存在代码行执行时间特别长 或 lock未释放--执行不动) */
                readerbak = mapThread(map, reader);
               
                // 重置华为标记
                isHuawei = false;
                isRun = false;
                isOther = false;
               
                System.out.println((++LogNum) + ":" + readerTeam);
            }
           
            if (reader.contains("com.huawei.iread"))
            {
                isHuawei = true;
            }
           
            if (reader.contains("RUNNABLE"))
            {
                isRun = true;
            }
           
            if (reader.contains("Property"))
            {
                isOther = true;
            }
           
            bufferedWriter.write(reader);
            bufferedWriter.newLine();
        }
       
        // 删除最后一个非业务堆栈
        map.remove(readerbak);     
       
        System.out.println("\n\n");
       
        // 打印结果
        int mapnum = 0;
       
        for (Entry<String, Integer> entry : map.entrySet())
        {
            if (entry.getValue() < catlogNum)
            {
                System.out.println((++mapnum) + ":[" + entry.getValue() + "]|" + entry.getKey());
            }
        }
       
        System.out.println();
       
        mapnum = 0;
        for (Entry<String, Integer> entry : map.entrySet())
        {
            if (entry.getValue() >= catlogNum)
            {
                System.out.println((++mapnum) + ":[" + entry.getValue() + "]|" + entry.getKey());
            }
        }
       
    }
   
    /**
     * 登记线程名,作用:找出重复多次出现未销毁的线程 <功能详细描述>
     *
     * @param isHuawei
     * @param map
     * @param readerbak
     * @param reader [参数说明]
     *
     * @return void [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     * */
    public static String mapThreadName(Map<String, Integer> map, String readerTeam)
    {
        // 线程登记
        if (map.containsKey(readerTeam))
        {
            map.put(readerTeam, map.get(readerTeam) + 1);
        }
        else
        {
            map.put(readerTeam, 1);
        }
       
        // 备份线程
        return readerTeam;
    }
   
    /**
     * 登记完整线程,作用:找出重复多次出现未销毁的线程.且线程内容未曾改变(存在代码行执行时间特别长 或 lock未释放) <功能详细描述>
     *
     * @param isHuawei
     * @param map
     * @param readerbak
     * @param reader [参数说明]
     *
     * @return void [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static String mapThread(Map<String, Integer> map, String reader)
    {
       
        // 线程登记
        if (map.containsKey(reader))
        {
            map.put(reader, map.get(reader) + 1);
        }
        else
        {
            map.put(reader, 1);
        }
       
        // 备份线程
        return reader;
    }
   
}
 