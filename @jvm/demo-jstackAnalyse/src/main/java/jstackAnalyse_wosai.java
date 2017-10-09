import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class jstackAnalyse_wosai
{

    public static void main(String[] args) throws ParseException
    {
        // 基础流应用
        basisStream();
    }

    /**
     * 基础流应用
     * File 文件基础类 FileReader/FileWriter 读取字符文件的便捷类(读取文本类型文件-字符流) FileInputStream/FileOutputStream用于读取诸如图像数据之类的原始字节流(读取非文本类型文件-字节流)
     * InputStreamReader/OutputStreamWriter 字节流与字符流的转换桥梁，其次还用于编码的设置 BufferedReader/BufferedWriter 从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取
     * BufferedInputStream/BufferedOutputStream 字节流缓冲类，就不需要每次字节写入调用底层系统
     * 
     * @throws ParseException
     */
    public static void basisStream() throws ParseException
    {
        // 当文件不存在只,读取特定目标文件
        File read = new File("C:\\Users\\Administrator\\Desktop\\jstack.log");
        File write = new File("C:\\Users\\Administrator\\Desktop\\chackThread.txt");

        if (!read.isFile())
        {
            // 读取默认当前目录下文件
            read = new File("jstack.log");
            write = new File("chackThread.txt");
        }

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try
        {
            // 1. 字符缓冲流
            bufferedReader = new BufferedReader(new FileReader(read));
            bufferedWriter = new BufferedWriter(new FileWriter(write));

            show(bufferedReader, bufferedWriter);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e)
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
     * @return void [返回类型说明]
     * @throws ParseException
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static void show(BufferedReader bufferedReader, BufferedWriter bufferedWriter) throws IOException, ParseException
    {

        Map<String, Integer> map = new HashMap<String, Integer>();

        int LogNum = 0;// 日志行数标记
        boolean isAsia = false;
        boolean isRun = false;// 活动
        boolean isBlock = false;// 锁定
        boolean isOther = false;// 其它
        String threadUp = "";// 上个线程备份
        int catlogNum = 0;// 手动打印过几次

        String readerUp = "";// 上一行日志备份
        String reader = null;

        Date beginTime = new Date();
        Date endTime = new Date();
        SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (null != (reader = bufferedReader.readLine()))
        {
            if (readerUp.contains("2015-")) // TODO jstack 本次,打印次数
            {
                catlogNum++;// jstack次数
                LogNum = 0;

                // 时间标记
                if (catlogNum == 1)
                {
                    beginTime = simp.parse(readerUp);
                }
                endTime = simp.parse(readerUp);

                System.out.println("\n\n" + readerUp);

            }

            if (readerUp.contains("nid="))
            {
                System.out.println(readerUp);

                // 截取线程名
                String threadStatus = reader.indexOf("java.lang.Thread.State") != -1 ? reader.substring(
                        reader.indexOf("java.lang.Thread.State") + 23, reader.length()) : "";
                        
                // TODO 配合项目日志格式
                String readerTeam = "[线程状态:" + threadStatus + " ] " + readerUp.substring(readerUp.indexOf("&quot;") + 6, readerUp.length());
                
                // (分析次线程时,确认上次现场是否"非Asia日志",则剔除
                if (!isAsia)
                {
                    map.remove(threadUp);
                }

                /** 登记线程名,作用:找出重复多次出现未销毁的线程(线程内容可能存在变化-执行慢) */
                // threadUp = mapThread(map, readerTeam);

                /** 登记完整线程,作用:找出重复多次出现未销毁的线程.且线程内容未曾改变(存在代码行执行时间特别长 或 lock未释放--执行不动) */
                threadUp = mapThread(map, "[线程状态:" + threadStatus + " ] " + readerUp);

                // 重置华为标记
                isAsia = false;
                isRun = false;
                isBlock = false;
                isOther = false;

                System.out.println((++LogNum) + ":" + readerTeam);
            }

            // if (readerUp.contains("com.huashu.boss"))// TODO 定位项目线程
            if (readerUp.contains("com.wosai"))// TODO 定位项目线程
            {
                isAsia = true;
            }

            if (readerUp.contains("RUNNABLE")) // RUNNABLE活动 BLOCKED锁定
            {
                isRun = true;
            }

            if (readerUp.contains("BLOCKED")) // RUNNABLE活动 BLOCKED锁定
            {
                isBlock = true;
            }

            if (readerUp.contains("Property")) // 其它属性
            {
                isOther = true;
            }

            readerUp = reader;// 上一行日志备份
        }

        // 删除最后一个非业务堆栈
        map.remove(threadUp);

        String dateStr = dateTime(endTime.getTime() - beginTime.getTime());

        /** 打印结果 */
        System.out.println("\n--------------- 总打印次数(以下为<打印次数的项目线程) : " + catlogNum + "次,首尾打印时间间隔[" + dateStr + "]");
        bufferedWriter.write("\n--------------- 总打印次数(以下为<打印次数的项目线程) : " + catlogNum + "次,首尾打印时间间隔[" + dateStr + "]");
        bufferedWriter.newLine();

        int mapnum = 0;
        for (Entry<String, Integer> entry : map.entrySet())
        {
            if (entry.getValue() < catlogNum)
            {
                System.out.println((++mapnum) + ":[次数-" + entry.getValue() + "]| 线程-" + entry.getKey());

                // 嫌疑线程记录到文件
                bufferedWriter.write((mapnum) + ":[次数-" + entry.getValue() + "]|线程-" + entry.getKey());
                bufferedWriter.newLine();
            }
        }

        System.out.println("\n--------------- 总打印次数(以下为=打印次数的项目线程) : " + catlogNum + "次,首尾打印时间间隔[" + dateStr + "]");
        bufferedWriter.newLine();
        bufferedWriter.write("\n--------------- 总打印次数(以下为=打印次数的项目线程) : " + catlogNum + "次,首尾打印时间间隔[" + dateStr + "]");
        bufferedWriter.newLine();

        mapnum = 0;
        for (Entry<String, Integer> entry : map.entrySet())
        {
            if (entry.getValue() >= catlogNum)// 出现次数等同线程打印次数,说明在此期间一直未结束
            {
                System.out.println((++mapnum) + ":[次数-" + entry.getValue() + "]|线程-" + entry.getKey());

                // 嫌疑线程记录到文件
                bufferedWriter.write((mapnum) + ":[次数-" + entry.getValue() + "]|线程-" + entry.getKey());
                bufferedWriter.newLine();
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
     * @return void [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static String mapThreadName(Map<String, Integer> map, String readerTeam)
    {
        // 线程登记
        if (map.containsKey(readerTeam))
        {
            map.put(readerTeam, map.get(readerTeam) + 1);
        } else
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
        } else
        {
            map.put(reader, 1);
        }

        // 备份线程
        return reader;
    }

    public static String dateTime(long dateTime)
    {
        long between = (dateTime) / 1000;// 除以1000是为了转换成秒
        long day1 = between / (24 * 3600);
        long hour1 = between % (24 * 3600) / 3600;
        long minute1 = between % 3600 / 60;
        long second1 = between % 60;
        // System.out.println(""+day1+"天"+hour1+"小时"+minute1+"分"+second1+"秒");
        return minute1 + "分" + second1 + "秒";
    }

}
