package com.ping.grammar.exp;

import com.ping.symbol.Exp;

/*
 * ��ֵ���ʽ�࣬����̳��˱��ʽ��Exp
 * ��һ����Ա���ԣ���ֵ��ΪInt����
 */
public class NumExp extends Exp {
	public int num;
	private final static String name = "num_exp";	//�������ֵ���ʽ��ľ�̬���֣������ж����ľ�������

	public NumExp(int num) {
		super(name);	//ʹ�ø���ľ�̬�����ַ�����Ϊ���๹�췽���ṩ���������ڶ�̬�󶨣�ʵ�ֶ�̬
		this.num = num;
	};

}
