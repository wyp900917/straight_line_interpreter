package com.ping.grammar.stm;

import com.ping.symbol.Exp;
import com.ping.symbol.Stm;

public class AssignStm extends Stm {
	public String id;
	public Exp exp;
	final public static String name = "assign_stm";

	public AssignStm(String id, Exp exp) {
		super(name);
		this.id = id;
		this.exp = exp;
	}

}
