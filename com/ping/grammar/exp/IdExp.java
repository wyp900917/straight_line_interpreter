package com.ping.grammar.exp;

import com.ping.symbol.Exp;

/*
 * ���ű��ʽ�࣬����̳��˱��ʽ��Exp
 * ��һ����Ա���ԣ��������ƣ�ΪString����
 */
public class IdExp extends Exp {
	public String id;
	private final static String name = "id_exp";	//����÷��ű��ʽ��ľ�̬���֣������ж����ľ�������

	public IdExp(String id) {
		super(name);	//ʹ�ø���ľ�̬�����ַ�����Ϊ���๹�췽���ṩ���������ڶ�̬�󶨣�ʵ�ֶ�̬
		this.id = id;
	}

}
