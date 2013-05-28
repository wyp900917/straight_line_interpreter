package com.ping.grammar.explist;

import com.ping.symbol.Exp;
import com.ping.symbol.ExpList;

/*
 * 前表达式列表类，该类继承了表达式列表类ExpList
 * 有两个成员属性，一个是表达式头，为Exp类型；一个是表达式列表尾部，为ExpList类型
 */
public class PairExpList extends ExpList {
	public Exp head;
	public ExpList tail;
	final public static String name = "pair_explist";  //定义该前表达式列表类的静态名字，用于判断语句的具体类型

	public PairExpList(Exp head, ExpList tail) {
		super(name);	//使用该类的静态名字字符串，为父类构造方法提供参数，用于动态绑定，实现多态
		this.head = head;
		this.tail = tail;
	}

}
