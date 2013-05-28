package com.ping.grammar.stm;

import com.ping.symbol.Stm;

/*
 * 复合语句类，该类继承了语句类Stm
 * 有两个成员属性，为左右语句，Stm类型
 */
public class CompoundStm extends Stm {

	public Stm stm1, stm2;
	final public static String name = "compound_stm";	//定义该赋值类的静态名字，用于判断语句的具体类型

	public CompoundStm(Stm stm1, Stm stm2) {
		super(name);	//使用该类的静态名字字符串，为父类构造方法提供参数，用于动态绑定，实现多态
		this.stm1 = stm1;
		this.stm2 = stm2;
	}
}
