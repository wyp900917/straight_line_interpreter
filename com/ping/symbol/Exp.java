package com.ping.symbol;

/*
 * 表达式的父类，该类为一个抽象类
 * 有一个成员属性为kind，即该表达式的类型，为字符串类型
 */
public abstract class Exp {
	public String kind;

	/*
	 * 构造方法
	 */
	public Exp(String kind) {
		this.kind = kind;
	}
}
