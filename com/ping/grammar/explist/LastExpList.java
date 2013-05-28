package com.ping.grammar.explist;

import com.ping.symbol.Exp;
import com.ping.symbol.ExpList;

public class LastExpList extends ExpList {
	public Exp head;
	final public static String name = "last_explist";

	public LastExpList(Exp head) {
		super(name);
		this.head = head;
	}

}
