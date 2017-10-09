package queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Administrator on 2017/5/13 0013.
 */
public class MyPriorityQueue {
    private String name;
    private int population;

    public MyPriorityQueue(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return this.name;
    }

    public int getPopulation() {
        return this.population;
    }

    public String toString() {
        return getName() + " - " + getPopulation();
    }

    public static void main(String args[]) {

        Queue<MyPriorityQueue> priorityQueue = new PriorityQueue<MyPriorityQueue>(12,
                new Comparator<MyPriorityQueue>() {
                    public int compare(MyPriorityQueue o1, MyPriorityQueue o2) {
                        return o1.getPopulation() - o2.getPopulation();
                    }
                });

        MyPriorityQueue t1 = new MyPriorityQueue("t1", 1);
        MyPriorityQueue t3 = new MyPriorityQueue("t3", 3);
        MyPriorityQueue t2 = new MyPriorityQueue("t2", 2);
        MyPriorityQueue t4 = new MyPriorityQueue("t4", 0);
        MyPriorityQueue t5 = new MyPriorityQueue("t5", 1);

        priorityQueue.add(t1);
        priorityQueue.add(t3);
        priorityQueue.add(t2);
        priorityQueue.add(t4);
        priorityQueue.add(t5);

        // 集合方式遍历，元素不会被移除
        for (MyPriorityQueue x : priorityQueue) {
            System.out.println(x.getName() + " " + x.getPopulation());
        }
        System.out.println("-------------");

        //队列方式遍历，元素逐个被移除
        while (priorityQueue.peek() != null) {
            System.out.println(priorityQueue.poll());
        }
    }
}

/**
 * java中PriorityQueue优先级队列使用方法 - hiphopmattshi的专栏 - 博客频道 - CSDN.NET
 * http://blog.csdn.net/hiphopmattshi/article/details/7334487
 * <p>
 * 解析Java中PriorityQueue优先级队列结构的源码及用法_java_脚本之家
 * http://www.jb51.net/article/84371.htm
 */