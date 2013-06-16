package findix.designcalc;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.text.InputType;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
	private EditText editText = null;
	private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, point, PI, E = null;
	private Button add, min, times, div, percentage, CE = null;
	private Button sin, cos, tan, abs, mod, sqrt, squal, power, Lbrackets,
			Rbrackets, equals, bk = null;
	private boolean isGetValue = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editText = (EditText) findViewById(R.id.editText);
		editText.setCursorVisible(false);
		editText.setInputType(InputType.TYPE_NULL);
		editText.setSingleLine(false);
		editText.setHorizontallyScrolling(true);

		b0 = (Button) findViewById(R.id.button0);
		b1 = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);
		b3 = (Button) findViewById(R.id.button3);
		b4 = (Button) findViewById(R.id.button4);
		b5 = (Button) findViewById(R.id.button5);
		b6 = (Button) findViewById(R.id.button6);
		b7 = (Button) findViewById(R.id.button7);
		b8 = (Button) findViewById(R.id.button8);
		b9 = (Button) findViewById(R.id.button9);
		point = (Button) findViewById(R.id.buttonPoint);
		add = (Button) findViewById(R.id.button_add);
		min = (Button) findViewById(R.id.button_minus);
		times = (Button) findViewById(R.id.button_times);
		div = (Button) findViewById(R.id.button_div);
		CE = (Button) findViewById(R.id.button_ce);
		Lbrackets = (Button) findViewById(R.id.button_lbrackets);
		Rbrackets = (Button) findViewById(R.id.button_rbrackets);
		equals = (Button) findViewById(R.id.button_equ);
		bk = (Button) findViewById(R.id.button_bk);

		b0.setOnClickListener(this);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		b6.setOnClickListener(this);
		b7.setOnClickListener(this);
		b8.setOnClickListener(this);
		b9.setOnClickListener(this);
		point.setOnClickListener(this);
		add.setOnClickListener(this);
		min.setOnClickListener(this);
		times.setOnClickListener(this);
		div.setOnClickListener(this);
		CE.setOnClickListener(this);
		Lbrackets.setOnClickListener(this);
		Rbrackets.setOnClickListener(this);
		equals.setOnClickListener(this);
		bk.setOnClickListener(this);

		SpannableString ss = new SpannableString(Save.getValue());
		String[] lines = ss.toString().split("\r\n");
		ss.setSpan(new ForegroundColorSpan(Color.LTGRAY), 0, ss.length()
				- lines[lines.length - 1].length(),
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		ss.setSpan(new AbsoluteSizeSpan(24, true), 0, ss.length()
				- lines[lines.length - 1].length(),
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		editText.setText(ss);
		editText.setSelection(editText.getText().length());
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button0:
			if (isGetValue) {
				setTextColor();
				editText.append("\r\n");
				editText.setSelection(editText.getText().length());
				isGetValue = false;
			}
			editText.append("0");
			break;
		case R.id.button1:
			if (isGetValue) {
				setTextColor();
				editText.append("\r\n");
				editText.setSelection(editText.getText().length());
				isGetValue = false;
			}
			editText.append("1");
			break;
		case R.id.button2:
			if (isGetValue) {
				setTextColor();
				editText.append("\r\n");
				editText.setSelection(editText.getText().length());
				isGetValue = false;
			}
			editText.append("2");
			break;
		case R.id.button3:
			if (isGetValue) {
				setTextColor();
				editText.append("\r\n");
				editText.setSelection(editText.getText().length());
				isGetValue = false;
			}
			editText.append("3");
			break;
		case R.id.button4:
			if (isGetValue) {
				setTextColor();
				editText.append("\r\n");
				editText.setSelection(editText.getText().length());
				isGetValue = false;
			}
			editText.append("4");
			break;
		case R.id.button5:
			if (isGetValue) {
				setTextColor();
				editText.append("\r\n");
				editText.setSelection(editText.getText().length());
				isGetValue = false;
			}
			editText.append("5");
			break;
		case R.id.button6:
			if (isGetValue) {
				setTextColor();
				editText.append("\r\n");
				editText.setSelection(editText.getText().length());
				isGetValue = false;
			}
			editText.append("6");
			break;
		case R.id.button7:
			if (isGetValue) {
				setTextColor();
				editText.append("\r\n");
				editText.setSelection(editText.getText().length());
				isGetValue = false;
			}
			editText.append("7");
			break;
		case R.id.button8:
			if (isGetValue) {
				setTextColor();
				editText.append("\r\n");
				editText.setSelection(editText.getText().length());
				isGetValue = false;
			}
			editText.append("8");
			break;
		case R.id.button9:
			if (isGetValue) {
				setTextColor();
				editText.append("\r\n");
				editText.setSelection(editText.getText().length());
				isGetValue = false;
			}
			editText.append("9");
			break;
		case R.id.buttonPoint:
			if (isGetValue) {
				setTextColor();
				editText.append("\r\n");
				editText.setSelection(editText.getText().length());
				isGetValue = false;
			}
			editText.append(".");
			break;
		case R.id.button_add:
			if (isGetValue) {
				setTextColor();
				editText.append("\r\n");
				editText.setSelection(editText.getText().length());
				isGetValue = false;
			}
			editText.append("+");
			break;
		case R.id.button_minus:
			if (isGetValue) {
				setTextColor();
				editText.append("\r\n");
				editText.setSelection(editText.getText().length());
				isGetValue = false;
			}
			editText.append("-");
			break;
		case R.id.button_times:
			if (isGetValue) {
				setTextColor();
				editText.append("\r\n");
				editText.setSelection(editText.getText().length());
				isGetValue = false;
			}
			editText.append("¡Á");
			break;
		case R.id.button_div:
			if (isGetValue) {
				setTextColor();
				editText.append("\r\n");
				editText.setSelection(editText.getText().length());
				isGetValue = false;
			}
			editText.append("¡Â");
			break;
		case R.id.button_ce:
			editText.setText("");
			break;
		case R.id.button_lbrackets:
			if (isGetValue) {
				setTextColor();
				editText.append("\r\n");
				editText.setSelection(editText.getText().length());
				isGetValue = false;
			}
			editText.append("(");
			break;
		case R.id.button_rbrackets:
			if (isGetValue) {
				setTextColor();
				editText.append("\r\n");
				editText.setSelection(editText.getText().length());
				isGetValue = false;
			}
			editText.append(")");
			break;
		case R.id.button_equ:
			if (editText.getText().toString().length() == 0)
				break;

			String[] lines = editText.getText().toString().split("\r\n");
			MPattern MP = new MPattern(lines[lines.length - 1]);
			for (int i = 0; i < MP.fillParenthese(); i++) {
				editText.append(")");
			}
			setTextColor();
			editText.append("\r\n");
			double solve = MP.solvePattern(true);
			NumberFormat ddf1 = NumberFormat.getNumberInstance();
			ddf1.setMaximumFractionDigits(8);
			String s = ddf1.format(solve);
			editText.append(((Math.round(solve) - solve == 0) ? String
					.valueOf((int) solve) : s));
			editText.setSelection(editText.getText().length());
			isGetValue = true;
			break;
		case R.id.button_bk:
			editText.clearFocus();
			if (editText.length() != 0) {
				editText.setText(editText
						.getText()
						.toString()
						.substring(0,
								editText.getText().toString().length() - 1));
			}
			if (editText.getText().toString().length() >= 2
					&& editText.getText().toString()
							.substring(editText.getText().length() - 2)
							.contains("\r\n")) {
				editText.setText(editText
						.getText()
						.toString()
						.substring(0,
								editText.getText().toString().length() - 2));
			}
			setTextColorExceptLastLine();
			editText.setSelection(editText.getText().length());
			break;
		}
	}

	private void setTextColor() {
		SpannableString ss = new SpannableString(editText.getText());
		String[] lines = ss.toString().split("\r\n");
		ss.setSpan(new ForegroundColorSpan(Color.LTGRAY), 0, ss.length(),
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		ss.setSpan(new AbsoluteSizeSpan(24, true), 0, ss.length(),
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		editText.setText(ss);

	}

	private void setTextColorExceptLastLine() {
		SpannableString ss = new SpannableString(editText.getText());
		String[] lines = ss.toString().split("\r\n");
		ss.setSpan(new ForegroundColorSpan(Color.LTGRAY), 0, ss.length()
				- lines[lines.length - 1].length(),
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		ss.setSpan(new AbsoluteSizeSpan(24, true), 0, ss.length()
				- lines[lines.length - 1].length(),
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		editText.setText(ss);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Save.inputValue(editText.getText().toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
