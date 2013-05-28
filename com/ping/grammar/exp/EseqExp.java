package com.ping.grammar.exp;

import com.ping.symbol.Exp;
import com.ping.symbol.Stm;

/*
 * 复杂表达式类，该类继承了表达式类Exp
 * 有两个成员属性，一个是左语句，为Stm类型；一个是右表达式，为Exp类型
 */
public class EseqExp extends Exp {

	public Stm stm;
	public Exp exp;
	private final static String name = "eseq_exp";	//定义该复杂表达式类的静态名字，用于判断语句的具体类型

	public EseqExp(Stm stm, Exp exp) {
		super(name);	//使用该类的静态名字字符串，为父类构造方法提供参数，用于动态绑定，实现多态
		this.stm = stm;
		this.exp = exp;
	}

}
