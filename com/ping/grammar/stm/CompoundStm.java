package com.ping.grammar.stm;

import com.ping.symbol.Stm;

/*
 * ��������࣬����̳��������Stm
 * ��������Ա���ԣ�Ϊ������䣬Stm����
 */
public class CompoundStm extends Stm {

	public Stm stm1, stm2;
	final public static String name = "compound_stm";	//����ø�ֵ��ľ�̬���֣������ж����ľ�������

	public CompoundStm(Stm stm1, Stm stm2) {
		super(name);	//ʹ�ø���ľ�̬�����ַ�����Ϊ���๹�췽���ṩ���������ڶ�̬�󶨣�ʵ�ֶ�̬
		this.stm1 = stm1;
		this.stm2 = stm2;
	}
}
