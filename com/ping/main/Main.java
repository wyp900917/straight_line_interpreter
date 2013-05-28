package com.ping.main;

import java.util.ArrayList;
import java.util.List;

import com.ping.grammar.exp.EseqExp;
import com.ping.grammar.exp.IdExp;
import com.ping.grammar.exp.NumExp;
import com.ping.grammar.exp.OpExp;
import com.ping.grammar.explist.LastExpList;
import com.ping.grammar.explist.PairExpList;
import com.ping.grammar.stm.AssignStm;
import com.ping.grammar.stm.CompoundStm;
import com.ping.grammar.stm.PrintStm;
import com.ping.symbol.Exp;
import com.ping.symbol.ExpList;
import com.ping.symbol.Stm;
import com.ping.table.Table;

public class Main {

	/*
	 * 定义一个全局的符号列表，每一个元素代表一个Table类型，包括标识符的名字和值
	 */
	public static List<Table> table_list = new ArrayList<Table>();

	public static void main(String[] args) {

		/*
		 * 测试语句如下： a:=5+3; b:=(print(a,a-1),10*a); print(b);
		 */
		Stm prog = new CompoundStm(new AssignStm("a", new OpExp(new NumExp(5),
				new NumExp(3), OpExp.Plus)), new CompoundStm(new AssignStm("b",
				new EseqExp(new PrintStm(new PairExpList(new IdExp("a"),
						new LastExpList(new OpExp(new IdExp("a"),
								new NumExp(1), OpExp.Minus)))), new OpExp(
						new NumExp(10), new IdExp("a"), OpExp.Times))),
				new PrintStm(new LastExpList(new IdExp("b")))));
		/*
		 * 对上述定义的语句进行解析
		 */
		interpStm(prog);
	}

	/*
	 * 解析语句，参数为Stm类型，是所有文法规则的父类。运用Java的多态性
	 * 1、如果该语句为一个复合语句CompoundStm，则分别对其两个子语句进行递归解析
	 * 2、如果该语句为一个赋值语句AssignStm，则首先计算出表达式的值，并且将该值赋值给左标识符
	 * 3、如果该语句为一个打印语句PrintStm，则打印出语句中的对应表达式的值
	 */
	private static void interpStm(Stm s) {
		Table table;
		if (s.kind.trim().equals("compound_stm")) {
			CompoundStm c_stm = (CompoundStm) s;
			interpStm(c_stm.stm1);	//递归解析左语句
			interpStm(c_stm.stm2);	//递归解析右语句
		} else if (s.kind.trim().equals("assign_stm")) {
			AssignStm a_stm = (AssignStm) s;
			int result = interpExp(a_stm.exp);	//计算出表达式的值
			table = new Table(a_stm.id, result);	//通过新建一个Table对象，将该标识符以及值添加到标识符列表中
			table_list.add(table);
		} else if (s.kind.trim().equals("print_stm")) {
			interpExpList(((PrintStm) s).exps);	//打印
		}
	}

	/*
	 * 返回一个表达式的值（默认该值都为整型值） 
	 * 1、如果该表达式为一个标识符类型“IdExp”，则在符号表中找到该标识符并返回其值
	 * 2、如果该表达式为一个数值类型“NumExp”，则返回该数值即可
	 * 3、如果该表达式为一个运算表达式“OpExp”，则分别对该表达式的左子式和右子式进行递归运算，
	 * 	    分别算出左子式的值left和右子式的值right，最后将左子式的值和右子式的值进行操作符运算，最后返回结果
	 * 4、如果该表达式为一个复合语句，则解析该复合语句的前一个Stm以及后一个Exp表达式，并且最后该语句的值也是该Exp表达式的值
	 */
	private static int interpExp(Exp e) {
		int result = 0;
		if (e.kind.trim().equals("id_exp")) {
			result = lookup(((IdExp) e).id);	//查找符号表，获取该标识符的值
		} else if (e.kind.trim().equals("num_exp")) {
			result = ((NumExp) e).num;	//直接返回该数值
		} else if (e.kind.trim().equals("op_exp")) {
			OpExp op_exp = (OpExp) e;
			int left = interpExp(op_exp.left);	//对左子式递归调用，计算出左子式的值赋值给整型变量left
			int right = interpExp(op_exp.right);	//对右子式递归调用，计算出右子式的值赋值给整型变量right
			switch (op_exp.oper) {	//OpExp类中定义了各个操作符的静态整型数值；1：代表+运算；2：代表-运算；3：代表*运算；4：代表/运算
			case 1:
				result = left + right;
				break;
			case 2:
				result = left - right;
				break;
			case 3:
				result = left * right;
				break;
			case 4:
				result = left / right;
				break;
			default:
				System.out.println("操作错误！！");	//如果操作符非以上的四个，则打印出错信息
			}
		} else if (e.kind.trim().equals("eseq_exp")) {
			interpStm(((EseqExp) e).stm);	//先解析前一个Stm语句
			result = interpExp(((EseqExp) e).exp);	//计算后面的表达式值，返回该值为整个语句的最后值
		}
		return result;
	}

	/*
	 * 遍历符号表table_list,查找符号表中对应名称为关键字key的标识符，如果符号表中存在该标识符，则返回该标识符的值
	 * 如果符号表中不存在该标识符，则打印错误信息
	 */
	private static int lookup(String key) {
		for (int i = 0; i < table_list.size(); i++) {
			if (table_list.get(i).id.equals(key)) {
				return table_list.get(i).value;
			}
		}
		System.out.println("找不到该值！！");
		return 0;
	}

	/*
	 * 打印语句中的表达式对应的值
	 * 1、如果打印列表为复合表达式，则先计算出复合表达式头的具体值，然后进行打印，再次对后续表达式进行递归打印，直到最后一个表达式为单一表达式类型
	 * 2、如果打印列表为单一表达式，则计算出该表达式的值，进行打印，退出即可
	 */
	private static void interpExpList(ExpList exps) {
		int print;
		if (exps.kind.trim().equals("pair_explist")) {
			PairExpList p_explist = (PairExpList) exps;
			print = interpExp(p_explist.head);	//计算出表达式的值
			System.out.println("print:" + print);
			interpExpList(p_explist.tail);	//对后续表达式进行递归打印
		} else if (exps.kind.trim().equals("last_explist")) {
			LastExpList l_explist = (LastExpList) exps;
			print = interpExp(l_explist.head);	//计算出表达式的值
			System.out.println("print:" + print);
		}
	}

}
