package com.ping.grammar.exp;

import com.ping.symbol.Exp;

/*
 * 数值表达式类，该类继承了表达式类Exp
 * 有一个成员属性，数值，为Int类型
 */
public class NumExp extends Exp {
	public int num;
	private final static String name = "num_exp";	//定义该数值表达式类的静态名字，用于判断语句的具体类型

	public NumExp(int num) {
		super(name);	//使用该类的静态名字字符串，为父类构造方法提供参数，用于动态绑定，实现多态
		this.num = num;
	};

}
