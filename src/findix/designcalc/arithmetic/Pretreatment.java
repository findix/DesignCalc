package findix.designcalc.arithmetic;

public class Pretreatment {
	public static StringBuffer doPretreatment(StringBuffer expression) {
		expression = standardization(expression);
		// 处理正负号
		expression = handleMinus(expression);
		// 处理小数点省略整数部分
		expression = handleDecimal(expression);
		// // 括号乘法
		expression = bracketsTimes(expression);
		return expression;
	}

	public static boolean isParenthese(StringBuffer expression) {
		// System.out.println(expression.toString());
		String symbols = "+-*/";
		// 多个小数点
		if (expression.toString().contains(".0.")) {
			return false;
		}
		//小数点后不是数字
		for (int i = 1; i < expression.length()-1; i++) {
			if ((expression.charAt(i) == '.' && !Character.isDigit(expression
					.charAt(i + 1)))) {
				return false;
			}
		}
		// 只有一个符号
		if (expression.length() == 1
				&& !(Character.isDigit(expression.charAt(0)))) {
			return false;
		}
		// 开头为非法符号
		if (!(Character.isDigit(expression.charAt(0)))
				&& !(expression.charAt(0) == '+')
				&& !(expression.charAt(0) == '-')
				&& !(expression.charAt(0) == '.')
				&& !(expression.charAt(0) == '(')) {
			return false;
		}
		// 结尾为非法符号
		if (!(Character.isDigit(expression.charAt(expression.length() - 1)))
				&& !(expression.charAt(expression.length() - 1) == ')')) {
			return false;
		}
		// 两个及以上连续符号
		for (int i = 0; i < expression.length() - 1; i++) {
			if (symbols.contains(expression.charAt(i) + "")
					&& symbols.contains(expression.charAt(i + 1) + "")) {
				return false;
			}
		}
		if (expression.toString().contains("()")) {
			return false;
		}
		//右括号后面直接跟数字
		for (int i = 1; i < expression.length()-1; i++) {
			if ((expression.charAt(i) == ')' && Character.isDigit(expression
					.charAt(i + 1)))) {
				return false;
			}
		}
		// 括号递归验证
		System.out.println(expression + "开始括号递归验证");
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '(') {
				int sum = 1;
				int last = i;
				for (int j = i+1; j < expression.length(); j++) {
					if (expression.charAt(j) == '(') {
						sum++;
						last = j;
					}
					if (expression.charAt(j) == ')') {
						sum--;
					}
					if (sum == 0) {
						System.out.println(expression.substring(last+1, j));
						return isParenthese(new StringBuffer(
								expression.substring(last+1, j)));
					}
				}
			}
		}
		return true;
	}

	// 补全括号
	public static int fillParenthese(StringBuffer expression) {
		int lNum = 0, rNum = 0;
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '(') {
				lNum++;
			}
			if (expression.charAt(i) == ')') {
				rNum++;
			}
			if (lNum < rNum) {
				return -1;
			}
		}
		return lNum - rNum;

	}

	// 标准化
	private static StringBuffer standardization(StringBuffer expression) {
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '×') {
				expression.replace(i, i + 1, "*");
			} else if (expression.charAt(i) == '÷') {
				expression.replace(i, i + 1, "/");
			}
		}
		return expression;
	}

	// 处理正负号
	private static StringBuffer handleMinus(StringBuffer expression) {
		for (int i = 0; i < expression.length(); i++) {
			if ((expression.charAt(i) == '+' || expression.charAt(i) == '-')
					&& (i == 0 || expression.charAt(i - 1) == '(')) {
				expression = new StringBuffer(expression).insert(i, '0');
			}
		}
		return expression;
	}

	// 处理小数点省略整数部分
	private static StringBuffer handleDecimal(StringBuffer expression) {
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '.'
					&& (i == 0 || !Character.isDigit(expression.charAt(i - 1)))) {
				expression = new StringBuffer(expression).insert(i, '0');
			}
		}
		return expression;
	}

	// 括号乘法
	private static StringBuffer bracketsTimes(StringBuffer expression) {
		for (int i = 1; i < expression.length(); i++) {
			if ((expression.charAt(i) == '(' && Character.isDigit(expression
					.charAt(i - 1)))) {
				expression = new StringBuffer(expression).insert(i, '*');
			}
		}
		return expression;
	}
}
