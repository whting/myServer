package behavior.memento.client;

import behavior.memento.material.Original;
import behavior.memento.material.Storage;

public class Client
{

	public static void main(String[] args)
	{

		// ����ԭʼ��
		Original origi = new Original("egg");

		// ��������¼
		Storage storage = new Storage(origi.createMemento());// Memento Ϊ����

		// �޸�ԭʼ���״̬
		System.out.println("��ʼ��״̬Ϊ��" + origi.getValue());
		origi.setValue("niu");
		System.out.println("�޸ĺ��״̬Ϊ��" + origi.getValue());

		// �ظ�ԭʼ���״̬
		origi.restoreMemento(storage.getMemento());
		System.out.println("�ָ����״̬Ϊ��" + origi.getValue());
	}
}