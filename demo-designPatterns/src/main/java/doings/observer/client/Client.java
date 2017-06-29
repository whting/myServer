package doings.observer.client;

import doings.observer.material.Observer1;
import doings.observer.material.Observer2;
import doings.observer.process.MySubject;
import doings.observer.process.Subject;

public class Client
{

	public static void main(String[] args)
	{
		Subject sub = new MySubject();
		sub.add(new Observer1());// 订阅
		sub.add(new Observer2());// 订阅

		sub.operation();// 发布
	}

}