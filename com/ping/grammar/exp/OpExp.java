package com.ping.grammar.exp;

import com.ping.symbol.Exp;

/*
 * 运算表达式类，该类继承了表达式类Exp
 * 有三个成员属性，分别是左表达式和右表达式，为Exp类型；一个是操作符，为Int类型
 */
public class OpExp extends Exp {
	public Exp left, right;
	public int oper;
	/*
	 * 为操作符定义静态整型变量，用具体的整型数值代表各个操作符
	 */
	final public static int Plus = 1;	
	final public static int Minus = 2;
	final public static int Times = 3;
	final public static int Div = 4;
	final public static String name = "op_exp";		//定义该运算表达式类的静态名字，用于判断语句的具体类型

	public OpExp(Exp left, Exp right, int oper) {
		super(name);	//使用该类的静态名字字符串，为父类构造方法提供参数，用于动态绑定，实现多态
		this.left = left;
		this.right = right;
		this.oper = oper;
	}

}
