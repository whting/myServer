package doings.Mediator.client;

import doings.Mediator.material.Mediator;
import doings.Mediator.material.MyMediator;

public class Client
{

	public static void main(String[] args)
	{
		/*
		 * User��ͳһ�ӿڣ�User1��User2�ֱ��ǲ�ͬ�Ķ��󣬶���֮���й���������������н���ģʽ������Ҫ�����໥�������ã�
		 * �������ߵ���϶Ⱥܸ�
		 * ��Ϊ�˽��������Mediator�࣬�ṩͳһ�ӿڣ�MyMediatorΪ��ʵ���࣬�������User1��User2��ʵ��
		 * ������ʵ�ֶ�User1��User2�Ŀ���
		 * ������User1��User2���������໥����������ֻ��Ҫ���ֺú�Mediator֮��Ĺ�ϵ���У�ʣ�µ�ȫ��MyMediator����ά��
		 */
		Mediator mediator = new MyMediator();
		mediator.createMediator();
		mediator.workAll();
	}
}