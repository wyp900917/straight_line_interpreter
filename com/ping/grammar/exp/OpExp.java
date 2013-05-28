package com.ping.grammar.exp;

import com.ping.symbol.Exp;

/*
 * ������ʽ�࣬����̳��˱��ʽ��Exp
 * ��������Ա���ԣ��ֱ�������ʽ���ұ��ʽ��ΪExp���ͣ�һ���ǲ�������ΪInt����
 */
public class OpExp extends Exp {
	public Exp left, right;
	public int oper;
	/*
	 * Ϊ���������徲̬���ͱ������þ����������ֵ�������������
	 */
	final public static int Plus = 1;	
	final public static int Minus = 2;
	final public static int Times = 3;
	final public static int Div = 4;
	final public static String name = "op_exp";		//�����������ʽ��ľ�̬���֣������ж����ľ�������

	public OpExp(Exp left, Exp right, int oper) {
		super(name);	//ʹ�ø���ľ�̬�����ַ�����Ϊ���๹�췽���ṩ���������ڶ�̬�󶨣�ʵ�ֶ�̬
		this.left = left;
		this.right = right;
		this.oper = oper;
	}

}
