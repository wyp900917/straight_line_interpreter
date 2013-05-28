package com.ping.grammar.exp;

import com.ping.symbol.Exp;
import com.ping.symbol.Stm;

/*
 * ���ӱ��ʽ�࣬����̳��˱��ʽ��Exp
 * ��������Ա���ԣ�һ��������䣬ΪStm���ͣ�һ�����ұ��ʽ��ΪExp����
 */
public class EseqExp extends Exp {

	public Stm stm;
	public Exp exp;
	private final static String name = "eseq_exp";	//����ø��ӱ��ʽ��ľ�̬���֣������ж����ľ�������

	public EseqExp(Stm stm, Exp exp) {
		super(name);	//ʹ�ø���ľ�̬�����ַ�����Ϊ���๹�췽���ṩ���������ڶ�̬�󶨣�ʵ�ֶ�̬
		this.stm = stm;
		this.exp = exp;
	}

}
