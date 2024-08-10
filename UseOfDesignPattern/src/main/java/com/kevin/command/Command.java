package com.kevin.command;


//��������ӿ�
public interface Command {

	//ִ�ж���(����)
	public void execute();
	//��������(����)
	public void undo();
}
