package com.ping.grammar.exp;

import com.ping.symbol.Exp;
import com.ping.symbol.Stm;

public class EseqExp extends Exp {

	public Stm stm;
	public Exp exp;
	private final static String name = "eseq_exp";

	public EseqExp(Stm stm, Exp exp) {
		super(name);
		this.stm = stm;
		this.exp = exp;
	}

}
