package com.ping.grammar.stm;

import com.ping.symbol.ExpList;
import com.ping.symbol.Stm;

public class PrintStm extends Stm {
	public ExpList exps;
	final public static String name = "print_stm";

	public PrintStm(ExpList exps) {
		super(name);
		this.exps = exps;
	}

}
