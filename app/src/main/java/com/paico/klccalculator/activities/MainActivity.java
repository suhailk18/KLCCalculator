package com.paico.klccalculator.activities;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.TextView;

import com.paico.klccalculator.R;
import com.paico.klccalculator.apputility.OperationUtil;
import com.paico.klccalculator.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    String selectedOperator = "";
    String currentValue = "";
    boolean autoClean;
    String value1 = "";
    boolean isMinus;

    @BindView(R.id.input)
    TextView mTextInput;

    @BindView(R.id.one)
    Button oneButton;

    @BindView(R.id.two)
    Button twoButton;

    @BindView(R.id.three)
    Button threeButton;

    @BindView(R.id.four)
    Button fourButton;

    @BindView(R.id.five)
    Button fiveButton;

    @BindView(R.id.six)
    Button sixButton;

    @BindView(R.id.seven)
    Button seveButton;

    @BindView(R.id.eight)
    Button eightButton;

    @BindView(R.id.nine)
    Button nineButton;

    @BindView(R.id.zero)
    Button zeroButton;

    @BindView(R.id.clear)
    Button clearButton;

    @BindView(R.id.plus_minus)
    Button plusMinusButton;

    @BindView(R.id.percentage)
    Button percentageButton;

    @BindView(R.id.divide)
    Button divideButton;

    @BindView(R.id.multiply)
    Button multiplyButton;

    @BindView(R.id.minus)
    Button minusButton;

    @BindView(R.id.plus)
    Button plusButton;

    @BindView(R.id.decimal)
    Button decimalButton;

    @BindView(R.id.equal)
    Button equalButton;


    @OnClick(R.id.one)
    void onClickOne() {
        concedeValue(oneButton.getText().toString());
    }

    @OnClick(R.id.two)
    void onClickTwo() {
        concedeValue(twoButton.getText().toString());
    }

    @OnClick(R.id.three)
    void onClickThree() {
        concedeValue(threeButton.getText().toString());
    }

    @OnClick(R.id.four)
    void onClickFour() {
        concedeValue(fourButton.getText().toString());
    }

    @OnClick(R.id.five)
    void onClickFive() {
        concedeValue(fiveButton.getText().toString());
    }

    @OnClick(R.id.six)
    void onClickSix() {
        concedeValue(sixButton.getText().toString());
    }

    @OnClick(R.id.seven)
    void onClickSeven() {
        concedeValue(seveButton.getText().toString());
    }

    @OnClick(R.id.eight)
    void onClickEight() {
        concedeValue(eightButton.getText().toString());
    }

    @OnClick(R.id.nine)
    void onClickNine() {
        concedeValue(nineButton.getText().toString());
    }

    @OnClick(R.id.zero)
    void onClickZero() {
        concedeValue(zeroButton.getText().toString());
    }

    @OnClick(R.id.decimal)
    void onClickDecimal() {
        concedeValue(decimalButton.getText().toString());
    }

    @OnClick(R.id.equal)
    void onClickEqual() {
        concedeValue(equalButton.getText().toString());
    }

    @OnClick(R.id.plus)
    void onClickPlus() {
        concedeValue(plusButton.getText().toString());
    }

    @OnClick(R.id.minus)
    void onClickMinus() {
        concedeValue(minusButton.getText().toString());
    }

    @OnClick(R.id.divide)
    void onClickDivide() {
        concedeValue(divideButton.getText().toString());
    }

    @OnClick(R.id.multiply)
    void onClickMultiply() {
        concedeValue(multiplyButton.getText().toString());
    }

    @OnClick(R.id.percentage)
    void onClickPercentage() {
        mTextInput.setText(OperationUtil.modelerValues(mTextInput.getText().toString().trim()));
    }

    @OnClick(R.id.plus_minus)
    void onClickPlusMinus() {
        if (isMinus) {
            String textValue = mTextInput.getText().toString().trim();
            mTextInput.setText(textValue.replaceAll("-", ""));
            isMinus = false;
        } else {
            String textValue = mTextInput.getText().toString().trim();
            mTextInput.setText("-" + textValue);
            isMinus = true;
        }
    }

    @OnClick(R.id.clear)
    void onClickClear() {
        mTextInput.setText("");
        currentValue = "";
        selectedOperator = "";
    }

    @OnClick(R.id.allclear)
    void onClickAllClear() {
        mTextInput.setText("");
        value1 = "";
        currentValue = "";
        selectedOperator = "";
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        getSupportActionBar().hide();
        ButterKnife.bind(this);

    }
    void concedeValue(String buttonValue) {

        if (autoClean) {
            if (isNumeric(buttonValue)) {
                value1 = mTextInput.getText().toString().trim();
                mTextInput.setText("");
            }
        }
        String concaveString = mTextInput.getText().toString().trim();
        if (concaveString.length() == 0 && buttonValue.equals(".")) {
            buttonValue = "0.";
        }
        concaveString = concaveString + "" + buttonValue;
        autoClean = false;

        if (isNumeric(concaveString)) {
            mTextInput.setText(concaveString);
            currentValue = concaveString;

        } else if (buttonValue.equals("=")) {
            if (value1.length() != 0 && currentValue.length() != 0) {
                double calculatedValue = 0;
                switch (selectedOperator) {
                    case "+":
                        calculatedValue = Double.valueOf(value1) + Double.valueOf(currentValue);
                        mTextInput.setText(OperationUtil.formattedValue(calculatedValue));
                        value1 = String.valueOf(calculatedValue);
                        break;
                    case "-":
                        calculatedValue = Double.valueOf(value1) - Double.valueOf(currentValue);
                        mTextInput.setText(OperationUtil.formattedValue(calculatedValue));
                        value1 = String.valueOf(calculatedValue);
                        break;

                    case "X":
                        calculatedValue = Double.valueOf(value1) * Double.valueOf(currentValue);
                        mTextInput.setText(OperationUtil.formattedValue(calculatedValue));
                        value1 = String.valueOf(calculatedValue);
                        break;
                    case "÷":
                        calculatedValue = Double.valueOf(value1) / Double.valueOf(currentValue);
                        mTextInput.setText(OperationUtil.formattedValue(calculatedValue));
                        value1 = String.valueOf(calculatedValue);
                        break;
                }
            }

        } else {
            operationFunction(buttonValue);
        }
    }
    boolean isNumeric(String val) {
        try {
            Double num = Double.parseDouble(val);
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }
    void operationFunction(String operationStr) {
        selectedOperator = operationStr;
        autoClean = true;
    }
}
