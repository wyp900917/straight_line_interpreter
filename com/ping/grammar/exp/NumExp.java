package com.ping.grammar.exp;

import com.ping.symbol.Exp;

public class NumExp extends Exp {
	public int num;
	private final static String name = "num_exp";

	public NumExp(int num) {
		super(name);
		this.num = num;
	};

}
