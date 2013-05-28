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
//hk
public class Main {

	/*
	 * ����һ��ȫ�ֵķ����б���ÿһ��Ԫ�ش���һ��Table���ͣ�������ʶ�������ֺ�ֵ
	 */
	public static List<Table> table_list = new ArrayList<Table>();

	public static void main(String[] args) {

		/*
		 * �����������£� a:=5+3; b:=(print(a,a-1),10*a); print(b);
		 */
		Stm prog = new CompoundStm(new AssignStm("a", new OpExp(new NumExp(5),
				new NumExp(3), OpExp.Plus)), new CompoundStm(new AssignStm("b",
				new EseqExp(new PrintStm(new PairExpList(new IdExp("a"),
						new LastExpList(new OpExp(new IdExp("a"),
								new NumExp(1), OpExp.Minus)))), new OpExp(
						new NumExp(10), new IdExp("a"), OpExp.Times))),
				new PrintStm(new LastExpList(new IdExp("b")))));
		/*
		 * �������������������н���
		 */
		interpStm(prog);
	}

	/*
	 * �������䣬����ΪStm���ͣ��������ķ������ĸ��ࡣ����Java�Ķ�̬��
	 * 1������������Ϊһ����������CompoundStm�����ֱ������������������еݹ�����
	 * 2������������Ϊһ����ֵ����AssignStm�������ȼ���������ʽ��ֵ�����ҽ���
	 */
	private static void interpStm(Stm s) {
		Table table;
		if (s.kind.trim().equals("compound_stm")) {
			CompoundStm c_stm = (CompoundStm) s;
			interpStm(c_stm.stm1);
			interpStm(c_stm.stm2);
		} else if (s.kind.trim().equals("assign_stm")) {
			AssignStm a_stm = (AssignStm) s;
			int result = interpExp(a_stm.exp);
			table = new Table(a_stm.id, result);
			table_list.add(table);
		} else if (s.kind.trim().equals("print_stm")) {
			interpExpList(((PrintStm) s).exps);
		}
	}

	/*
	 * ����һ������ʽ��ֵ��Ĭ�ϸ�ֵ��Ϊ����ֵ�� 
	 * 1�������ñ���ʽΪһ����ʶ�����͡�IdExp�������ڷ��ű����ҵ��ñ�ʶ����������ֵ
	 * 2�������ñ���ʽΪһ����ֵ���͡�NumExp�����򷵻ظ���ֵ����
	 * 3�������ñ���ʽΪһ����������ʽ��OpExp�������ֱ��Ըñ���ʽ������ʽ������ʽ���еݹ����㣬
	 * 	    �ֱ���������ʽ��ֵleft������ʽ��ֵright������������ʽ��ֵ������ʽ��ֵ���в��������㣬���󷵻ؽ���
	 * 4�������ñ���ʽΪһ���������䣬�������ø���������ǰһ��Stm�Լ���һ��Exp����ʽ������������������ֵҲ�Ǹ�Exp����ʽ��ֵ
	 */
	private static int interpExp(Exp e) {
		int result = 0;
		if (e.kind.trim().equals("id_exp")) {
			result = lookup(((IdExp) e).id);	//���ҷ��ű�����ȡ�ñ�ʶ����ֵ
		} else if (e.kind.trim().equals("num_exp")) {
			result = ((NumExp) e).num;	//ֱ�ӷ��ظ���ֵ
		} else if (e.kind.trim().equals("op_exp")) {
			OpExp op_exp = (OpExp) e;
			int left = interpExp(op_exp.left);	//������ʽ�ݹ����ã�����������ʽ��ֵ��ֵ�����ͱ���left
			int right = interpExp(op_exp.right);	//������ʽ�ݹ����ã�����������ʽ��ֵ��ֵ�����ͱ���right
			switch (op_exp.oper) {	//OpExp���ж����˸����������ľ�̬������ֵ��1������+���㣻2������-���㣻3������*���㣻4������/����
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
				System.out.println("�������󣡣�");	//���������������ϵ��ĸ�������ӡ������Ϣ
			}
		} else if (e.kind.trim().equals("eseq_exp")) {
			interpStm(((EseqExp) e).stm);	//�Ƚ���ǰһ��Stm����
			result = interpExp(((EseqExp) e).exp);	//���������ı���ʽֵ�����ظ�ֵΪ��������������ֵ
		}
		return result;
	}

	/*
	 * �������ű�table_list,���ҷ��ű��ж�Ӧ����Ϊ�ؼ���key�ı�ʶ�����������ű��д��ڸñ�ʶ�����򷵻ظñ�ʶ����ֵ
	 * �������ű��в����ڸñ�ʶ��������ӡ������Ϣ
	 */
	private static int lookup(String key) {
		for (int i = 0; i < table_list.size(); i++) {
			if (table_list.get(i).id.equals(key)) {
				return table_list.get(i).value;
			}
		}
		System.out.println("�Ҳ�����ֵ����");
		return 0;
	}

	private static void interpExpList(ExpList exps) {
		int print;
		if (exps.kind.trim().equals("pair_explist")) {
			PairExpList p_explist = (PairExpList) exps;
			print = interpExp(p_explist.head);
			System.out.println("print:" + print);
			interpExpList(p_explist.tail);
		} else if (exps.kind.trim().equals("last_explist")) {
			LastExpList l_explist = (LastExpList) exps;
			print = interpExp(l_explist.head);
			System.out.println("print:" + print);
		}
	}

}
