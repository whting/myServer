package create.abstractFactory.process;

import create.abstractFactory.material.Sender;

public interface Provider
{
	public Sender produce();
}