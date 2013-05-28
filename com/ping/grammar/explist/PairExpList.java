package com.ping.grammar.explist;

import com.ping.symbol.Exp;
import com.ping.symbol.ExpList;

/*
 * ǰ���ʽ�б��࣬����̳��˱��ʽ�б���ExpList
 * ��������Ա���ԣ�һ���Ǳ��ʽͷ��ΪExp���ͣ�һ���Ǳ��ʽ�б�β����ΪExpList����
 */
public class PairExpList extends ExpList {
	public Exp head;
	public ExpList tail;
	final public static String name = "pair_explist";  //�����ǰ���ʽ�б���ľ�̬���֣������ж����ľ�������

	public PairExpList(Exp head, ExpList tail) {
		super(name);	//ʹ�ø���ľ�̬�����ַ�����Ϊ���๹�췽���ṩ���������ڶ�̬�󶨣�ʵ�ֶ�̬
		this.head = head;
		this.tail = tail;
	}

}
