package com.ping.grammar.explist;

import com.ping.symbol.Exp;
import com.ping.symbol.ExpList;

public class PairExpList extends ExpList {
	public Exp head;
	public ExpList tail;
	final public static String name = "pair_explist";  

	public PairExpList(Exp head, ExpList tail) {
		super(name);
		this.head = head;
		this.tail = tail;
	}

}
