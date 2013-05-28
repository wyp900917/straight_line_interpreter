package com.ping.table;

public class Table {
	public String id;
	public int value;
	//public Table tail;

	public Table(String id, int value) {
		this.id = id;
		this.value = value;
		//this.tail = tail;
	}
	
	public void update(String id, int value) {
		this.id = id;
		this.value = value;
	}

}
