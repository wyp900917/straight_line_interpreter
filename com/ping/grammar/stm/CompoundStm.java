package com.ping.grammar.stm;

import com.ping.symbol.Stm;

public class CompoundStm extends Stm {

	public Stm stm1, stm2;
	final public static String name = "compound_stm";

	public CompoundStm(Stm stm1, Stm stm2) {
		super(name);
		this.stm1 = stm1;
		this.stm2 = stm2;
	}
}
