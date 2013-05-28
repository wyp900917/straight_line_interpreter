package com.ping.grammar.exp;

import com.ping.symbol.Exp;

public class IdExp extends Exp {
	public String id;
	private final static String name = "id_exp";

	public IdExp(String id) {
		super(name);
		this.id = id;
	}

}
