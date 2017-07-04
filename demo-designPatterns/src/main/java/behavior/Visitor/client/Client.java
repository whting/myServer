package behavior.Visitor.client;

import behavior.Visitor.material.MySubject;
import behavior.Visitor.material.MyVisitor;
import behavior.Visitor.material.Subject;
import behavior.Visitor.material.Visitor;

public class Client
{

	public static void main(String[] args)
	{
		// Visitor��������Subject����Ŀ��,�໥����ʵ��.
		// 1.Visitor�������Ƚ���ʵ����Subject����Ŀ��
		// 2.����Ŀ��Subject,�Գ��еķ�����Visitor,���з�����Ϊvisit(this),�����ݷ���Ŀ��Subjectʵ��
		// 3.��ʱ,���ܵ�������Ϊ�ķ�����Visitor,�߱��������Ŀ���ʵ��,��������Ϊ����getSubject().

		// �ҵ�ͨ�����:���ȸ���,���ٻ���,��Ҫ����ĸ���. 
		
		// visit the subject��love �������⣺����
		Visitor visitor = new MyVisitor();// �ҵķ���
		Subject sub = new MySubject();// �ҵ�����-love
		sub.accept(visitor);// ����
	}
}