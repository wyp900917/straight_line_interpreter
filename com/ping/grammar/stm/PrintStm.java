package com.ping.grammar.stm;

import com.ping.symbol.ExpList;
import com.ping.symbol.Stm;

/*
 * ��ӡ����࣬����̳��������Stm
 * ��һ����Ա���ԣ����ʽ�б�ΪExpList����
 */
public class PrintStm extends Stm {
	public ExpList exps;
	final public static String name = "print_stm";	//����ø�ֵ��ľ�̬���֣������ж����ľ�������

	public PrintStm(ExpList exps) {
		super(name);	//ʹ�ø���ľ�̬�����ַ�����Ϊ���๹�췽���ṩ���������ڶ�̬�󶨣�ʵ�ֶ�̬
		this.exps = exps;
	}

}
