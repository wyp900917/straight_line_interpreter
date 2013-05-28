package com.ping.grammar.exp;

import com.ping.symbol.Exp;

/*
 * 符号表达式类，该类继承了表达式类Exp
 * 有一个成员属性，符号名称，为String类型
 */
public class IdExp extends Exp {
	public String id;
	private final static String name = "id_exp";	//定义该符号表达式类的静态名字，用于判断语句的具体类型

	public IdExp(String id) {
		super(name);	//使用该类的静态名字字符串，为父类构造方法提供参数，用于动态绑定，实现多态
		this.id = id;
	}

}
