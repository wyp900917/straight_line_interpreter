package com.ping.grammar.explist;

import com.ping.symbol.Exp;
import com.ping.symbol.ExpList;

/*
 * �����ʽ�б��࣬����̳��˱��ʽ�б���ExpList
 * ��һ����Ա���ԣ����ʽͷ��ΪExp����
 */
public class LastExpList extends ExpList {
	public Exp head;
	final public static String name = "last_explist";	//����������ʽ�б���ľ�̬���֣������ж����ľ�������

	public LastExpList(Exp head) {
		super(name);	//ʹ�ø���ľ�̬�����ַ�����Ϊ���๹�췽���ṩ���������ڶ�̬�󶨣�ʵ�ֶ�̬
		this.head = head;
	}

}
