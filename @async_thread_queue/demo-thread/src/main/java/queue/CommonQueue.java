package queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class CommonQueue {

    public static void common1() {
        Queue<String> queue = new LinkedList<String>();
        //追加元素
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        queue.offer("four");
        System.out.println(queue);// [one, two, three, four]
        //从队首取出元素并删除
        String poll = queue.poll();
        System.out.println(poll);// one
        System.out.println(queue);// [two, three, four]
        //从队首取出元素但是不删除
        String peek = queue.peek();
        System.out.println(peek);// two
        System.out.println(queue);// [two, three, four]
        //遍历队列，这里要注意，每次取完元素后都会删除，整个
        //队列会变短，所以只需要判断队列的大小即可
        while (queue.size() > 0) {
            System.out.println(queue.poll());// two , three , four
        }
    }

    public static void common2() {
        Deque<String> deque = new LinkedList<String>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);
        //获取栈首元素后，元素不会出栈
        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            //获取栈首元素后，元素将会出栈
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }

    public static void common3() {
        //add()和remove()方法在失败的时候会抛出异常(不推荐)
        Queue<String> queue = new LinkedList<String>();
        //添加元素
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        for (String q : queue) {
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("poll=" + queue.poll()); // 返回第一个元素，并在队列中删除
        for (String q : queue) {
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("element=" + queue.element()); // 返回队列头部的元素/如果队列为空，则抛出一个NoSuchElementException异常
        for (String q : queue) {
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("peek=" + queue.peek()); // 返返回队列头部的元素/如果队列为空，则返回null
        for (String q : queue) {
            System.out.println(q);
        }
    }

    public static void main(String[] args) {
//        common1();
        common2();
//        common3();
    }
}

/**
 * `Java中的queue和deque`
 * http://blog.csdn.net/shf4715/article/details/47052385
 *
 * `java集合类深入分析之Queue篇 - 点缀星辰 - ITeye技术网站`
 * http://shmilyaw-hotmail-com.iteye.com/blog/1700599
 */