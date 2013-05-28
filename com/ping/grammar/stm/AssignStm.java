package com.ping.grammar.stm;

import com.ping.symbol.Exp;
import com.ping.symbol.Stm;

/*
 * ��ֵ����࣬����̳��������Stm
 * ��������Ա���ԣ�һ��Ϊ�ø�ֵ�����ҷ���Id��Ϊ�ַ������ͣ�һ��������ʽ���ͣ�ΪExp����
 */
public class AssignStm extends Stm {
	public String id;
	public Exp exp;
	final public static String name = "assign_stm";	//����ø�ֵ��ľ�̬���֣������ж����ľ�������

	/*
	 * ���췽��
	 */
	public AssignStm(String id, Exp exp) {
		super(name);	//ʹ�ø���ľ�̬�����ַ�����Ϊ���๹�췽���ṩ���������ڶ�̬�󶨣�ʵ�ֶ�̬
		this.id = id;
		this.exp = exp;
	}

}
