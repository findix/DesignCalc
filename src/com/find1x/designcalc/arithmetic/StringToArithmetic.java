package com.find1x.designcalc.arithmetic;

import java.util.Stack;
import java.util.regex.*;

public class StringToArithmetic {
	private StringToArithmetic() {
	}

	/**
	 * 给出一个算术表达式，返回结果。 例如 (5+8+10)*1，返回23
	 * 
	 * @param string
	 */
	public static double stringToArithmetic(String string) {
		return suffixToArithmetic(infixToSuffix(string));
	}

	/**
	 * 中缀表达式转后缀表达式
	 */
	private static String infixToSuffix(String infix) {
		Stack<Character> stack = new Stack<Character>();
		String suffix = "";
		int length = infix.length();
		for (int i = 0; i < length; i++) {
			Character temp;
			char c = infix.charAt(i);
			switch (c) {
			// 忽略空格
			case ' ':
				break;
			// 碰到'('，push到栈
			case '(':
				stack.push(c);
				break;
			// 碰到'+''-'，将栈中所有运算符弹出，送到输出队列中
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
			// 碰到'*''/'，将栈中所有乘除运算符弹出，送到输出队列中
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
			// 碰到右括号，将靠近栈顶的第一个左括号上面的运算符全部依次弹出，送至输出队列后，再丢弃左括号
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

	// 处理正负号
	private static String handleMinus(String infix) {
		for (int i = 0; i < infix.length(); i++) {
			if ((infix.charAt(i) == '+'||infix.charAt(i) == '-')
					&& (i == 0 || infix.charAt(i - 1) == '(')) {
				infix = new StringBuffer(infix).insert(i, '0').toString();
			}
		}
		return infix;
	}

	// 处理小数点省略整数部分
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
	 * 通过后缀表达式求出算术结果
	 * 
	 * @param String
	 *            postfix
	 * @return double
	 */
	private static double suffixToArithmetic(String postfix) {
		Pattern pattern = Pattern.compile("\\d+||(\\d+\\.\\d+)"); // 匹配数字
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