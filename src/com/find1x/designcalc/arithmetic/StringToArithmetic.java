package com.find1x.designcalc.arithmetic;

import java.util.Stack;
import java.util.regex.*;

public class StringToArithmetic {
	private StringToArithmetic() {
	}

	/**
	 * ����һ���������ʽ�����ؽ���� ���� (5+8+10)*1������23
	 * 
	 * @param string
	 */
	public static double stringToArithmetic(String string) {
		return suffixToArithmetic(infixToSuffix(string));
	}

	/**
	 * ��׺���ʽת��׺���ʽ
	 */
	private static String infixToSuffix(String infix) {
		Stack<Character> stack = new Stack<Character>();
		String suffix = "";
		int length = infix.length();
		for (int i = 0; i < length; i++) {
			Character temp;
			char c = infix.charAt(i);
			switch (c) {
			// ���Կո�
			case ' ':
				break;
			// ����'('��push��ջ
			case '(':
				stack.push(c);
				break;
			// ����'+''-'����ջ������������������͵����������
			case '+':
			case '-':
				while (stack.size() != 0) {
					temp = stack.pop();
					if (temp == '(') {
						stack.push('(');
						break;
					}
					suffix += " " + temp;
				}
				stack.push(c);
				suffix += " ";
				break;
			// ����'*''/'����ջ�����г˳�������������͵����������
			case '*':
			case '/':
				while (stack.size() != 0) {
					temp = stack.pop();
					if (temp == '(' || temp == '+' || temp == '-') {
						stack.push(temp);
						break;
					} else {
						suffix += " " + temp;
					}
				}
				stack.push(c);
				suffix += " ";
				break;
			// ���������ţ�������ջ���ĵ�һ������������������ȫ�����ε���������������к��ٶ���������
			case ')':
				while (stack.size() != 0) {
					temp = stack.pop();
					if (temp == '(')
						break;
					else
						suffix += " " + temp;
				}
				// suffix += " ";
				break;
			default:
				suffix += c;
			}
		}
		while (stack.size() != 0)
			suffix += " " + stack.pop();
		System.out.println(suffix);
		return suffix;
	}

	// ����������
	private static String handleMinus(String infix) {
		for (int i = 0; i < infix.length(); i++) {
			if ((infix.charAt(i) == '+'||infix.charAt(i) == '-')
					&& (i == 0 || infix.charAt(i - 1) == '(')) {
				infix = new StringBuffer(infix).insert(i, '0').toString();
			}
		}
		return infix;
	}

	// ����С����ʡ����������
	private static String handleDecimal(String infix) {
		for (int i = 0; i < infix.length(); i++) {
			if (infix.charAt(i) == '.'
					&& (i == 0 || !Character.isDigit(infix.charAt(i - 1)))) {
				infix = new StringBuffer(infix).insert(i, '0').toString();
			}
		}
		return infix;
	}

	/**
	 * ͨ����׺���ʽ����������
	 * 
	 * @param String
	 *            postfix
	 * @return double
	 */
	private static double suffixToArithmetic(String postfix) {
		Pattern pattern = Pattern.compile("\\d+||(\\d+\\.\\d+)"); // ƥ������
		String strings[] = postfix.split(" ");
		for (int i = 0; i < strings.length; i++)
			strings[i].trim();
		Stack<Double> stack = new Stack<Double>();
		for (int i = 0; i < strings.length; i++) {

			if (strings[i].equals(""))
				continue;
			if ((pattern.matcher(strings[i])).matches()) {

				stack.push(Double.parseDouble(strings[i]));
			} else {

				double y = stack.pop();
				double x = stack.pop();
				stack.push(caculate(x, y, strings[i]));
			}
		}
		return stack.pop();

	}

	private static double caculate(double x, double y, String simble) {
		if (simble.trim().equals("+"))
			return x + y;
		if (simble.trim().equals("-"))
			return x - y;
		if (simble.trim().equals("*"))
			return x * y;
		if (simble.trim().equals("/"))
			return x / y;
		return 0;
	}
}