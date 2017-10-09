package behavior.observer.client;

import behavior.observer.material.Observer1;
import behavior.observer.material.Observer2;
import behavior.observer.process.MySubject;
import behavior.observer.process.Subject;

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