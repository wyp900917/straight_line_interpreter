package com.ping.table;

/*
 * 定于的符号表类，一个对象代表一个符号
 * 该类有两个属性，一个是符号名称，为字符串类型；一个是符号的值，为整型类型
 */
public class Table {
	public String id;
	public int value;

	/*
	 * 构造方法
	 */
	public Table(String id, int value) {
		this.id = id;
		this.value = value;
	}
	
	/*
	 * 更新符号的值
	 */
	public void update(String id, int value) {
		this.id = id;
		this.value = value;
	}

}
