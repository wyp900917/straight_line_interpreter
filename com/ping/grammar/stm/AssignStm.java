package com.ping.grammar.stm;

import com.ping.symbol.Exp;
import com.ping.symbol.Stm;

/*
 * 赋值语句类，该类继承了语句类Stm
 * 有两个成员属性，一个为该赋值语句的右符号Id，为字符串类型；一个是左表达式类型，为Exp类型
 */
public class AssignStm extends Stm {
	public String id;
	public Exp exp;
	final public static String name = "assign_stm";	//定义该赋值类的静态名字，用于判断语句的具体类型

	/*
	 * 构造方法
	 */
	public AssignStm(String id, Exp exp) {
		super(name);	//使用该类的静态名字字符串，为父类构造方法提供参数，用于动态绑定，实现多态
		this.id = id;
		this.exp = exp;
	}

}
