package com.ping.symbol;

/*
 * ���ʽ�ĸ��࣬����Ϊһ��������
 * ��һ����Ա����Ϊkind�����ñ��ʽ�����ͣ�Ϊ�ַ�������
 */
public abstract class Exp {
	public String kind;

	/*
	 * ���췽��
	 */
	public Exp(String kind) {
		this.kind = kind;
	}
}
