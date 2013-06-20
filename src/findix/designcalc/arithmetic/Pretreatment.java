package findix.designcalc.arithmetic;

public class Pretreatment {
	public static StringBuffer doPretreatment(StringBuffer expression) {
		expression = standardization(expression);
		// ����������
		expression = handleMinus(expression);
		// ����С����ʡ����������
		expression = handleDecimal(expression);
		// // ���ų˷�
		expression = bracketsTimes(expression);
		return expression;
	}

	public static boolean isParenthese(StringBuffer expression) {
		// System.out.println(expression.toString());
		String symbols = "+-*/";
		// ���С����
		if (expression.toString().contains(".0.")) {
			return false;
		}
		//С�����������
		for (int i = 1; i < expression.length()-1; i++) {
			if ((expression.charAt(i) == '.' && !Character.isDigit(expression
					.charAt(i + 1)))) {
				return false;
			}
		}
		// ֻ��һ������
		if (expression.length() == 1
				&& !(Character.isDigit(expression.charAt(0)))) {
			return false;
		}
		// ��ͷΪ�Ƿ�����
		if (!(Character.isDigit(expression.charAt(0)))
				&& !(expression.charAt(0) == '+')
				&& !(expression.charAt(0) == '-')
				&& !(expression.charAt(0) == '.')
				&& !(expression.charAt(0) == '(')) {
			return false;
		}
		// ��βΪ�Ƿ�����
		if (!(Character.isDigit(expression.charAt(expression.length() - 1)))
				&& !(expression.charAt(expression.length() - 1) == ')')) {
			return false;
		}
		// ������������������
		for (int i = 0; i < expression.length() - 1; i++) {
			if (symbols.contains(expression.charAt(i) + "")
					&& symbols.contains(expression.charAt(i + 1) + "")) {
				return false;
			}
		}
		if (expression.toString().contains("()")) {
			return false;
		}
		//�����ź���ֱ�Ӹ�����
		for (int i = 1; i < expression.length()-1; i++) {
			if ((expression.charAt(i) == ')' && Character.isDigit(expression
					.charAt(i + 1)))) {
				return false;
			}
		}
		// ���ŵݹ���֤
		System.out.println(expression + "��ʼ���ŵݹ���֤");
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

	// ��ȫ����
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

	// ��׼��
	private static StringBuffer standardization(StringBuffer expression) {
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '��') {
				expression.replace(i, i + 1, "*");
			} else if (expression.charAt(i) == '��') {
				expression.replace(i, i + 1, "/");
			}
		}
		return expression;
	}

	// ����������
	private static StringBuffer handleMinus(StringBuffer expression) {
		for (int i = 0; i < expression.length(); i++) {
			if ((expression.charAt(i) == '+' || expression.charAt(i) == '-')
					&& (i == 0 || expression.charAt(i - 1) == '(')) {
				expression = new StringBuffer(expression).insert(i, '0');
			}
		}
		return expression;
	}

	// ����С����ʡ����������
	private static StringBuffer handleDecimal(StringBuffer expression) {
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '.'
					&& (i == 0 || !Character.isDigit(expression.charAt(i - 1)))) {
				expression = new StringBuffer(expression).insert(i, '0');
			}
		}
		return expression;
	}

	// ���ų˷�
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
