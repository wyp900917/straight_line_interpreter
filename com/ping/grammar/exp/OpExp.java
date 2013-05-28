package com.ping.grammar.exp;

import com.ping.symbol.Exp;

public class OpExp extends Exp {
	public Exp left, right;
	public int oper;
	final public static int Plus = 1;
	final public static int Minus = 2;
	final public static int Times = 3;
	final public static int Div = 4;
	final public static String name = "op_exp";

	public OpExp(Exp left, Exp right, int oper) {
		super(name);
		this.left = left;
		this.right = right;
		this.oper = oper;
	}

}
