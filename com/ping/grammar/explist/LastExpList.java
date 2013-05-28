package com.ping.grammar.explist;

import com.ping.symbol.Exp;
import com.ping.symbol.ExpList;

/*
 * 最后表达式列表类，该类继承了表达式列表类ExpList
 * 有一个成员属性，表达式头，为Exp类型
 */
public class LastExpList extends ExpList {
	public Exp head;
	final public static String name = "last_explist";	//定义该最后表达式列表类的静态名字，用于判断语句的具体类型

	public LastExpList(Exp head) {
		super(name);	//使用该类的静态名字字符串，为父类构造方法提供参数，用于动态绑定，实现多态
		this.head = head;
	}

}
