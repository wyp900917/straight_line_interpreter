package com.ping.table;

/*
 * ���ڵķ��ű��࣬һ���������һ������
 * �������������ԣ�һ���Ƿ������ƣ�Ϊ�ַ������ͣ�һ���Ƿ��ŵ�ֵ��Ϊ��������
 */
public class Table {
	public String id;
	public int value;

	/*
	 * ���췽��
	 */
	public Table(String id, int value) {
		this.id = id;
		this.value = value;
	}
	
	/*
	 * ���·��ŵ�ֵ
	 */
	public void update(String id, int value) {
		this.id = id;
		this.value = value;
	}

}
