package com.ping.grammar.stm;

import com.ping.symbol.ExpList;
import com.ping.symbol.Stm;

/*
 * 打印语句类，该类继承了语句类Stm
 * 有一个成员属性，表达式列表，为ExpList类型
 */
public class PrintStm extends Stm {
	public ExpList exps;
	final public static String name = "print_stm";	//定义该赋值类的静态名字，用于判断语句的具体类型

	public PrintStm(ExpList exps) {
		super(name);	//使用该类的静态名字字符串，为父类构造方法提供参数，用于动态绑定，实现多态
		this.exps = exps;
	}

}
