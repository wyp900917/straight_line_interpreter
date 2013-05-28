package com.ping.symbol;

/*
 * 语句的父类，该类为一个抽象类
 * 有一个成员属性为kind，即该语句的类型，为字符串类型
 */
public abstract class Stm {
	public String kind;

	/*
	 * 构造方法
	 */
	public Stm(String kind) {
		this.kind = kind;
	}

}
