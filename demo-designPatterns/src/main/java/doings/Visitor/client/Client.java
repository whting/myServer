package doings.Visitor.client;

import doings.Visitor.material.MySubject;
import doings.Visitor.material.MyVisitor;
import doings.Visitor.material.Subject;
import doings.Visitor.material.Visitor;

public class Client
{

	public static void main(String[] args)
	{
		// Visitor访问者与Subject访问目标,相互持有实例.
		// 1.Visitor访问者先交付实例给Subject访问目标
		// 2.访问目标Subject,以持有的访问者Visitor,进行访问行为visit(this),并传递访问目标Subject实例
		// 3.此时,接受到访问行为的访问者Visitor,具备具体访问目标的实例,并进行行为操作getSubject().

		// 我的通俗理解:我先给你,你再还我,还要把你的给我. 
		
		// visit the subject：love 访问主题：爱情
		Visitor visitor = new MyVisitor();// 我的访问
		Subject sub = new MySubject();// 我的主题-love
		sub.accept(visitor);// 接受
	}
}