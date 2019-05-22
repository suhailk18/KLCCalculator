package com.paico.klccalculator.apputility;

public class OperationUtil {


    public static  String modelerValues(String v1){

        double value = Double.valueOf(v1) / 100d;

        String valueStr;
        if((value % 1) != 0){
            valueStr =String.valueOf(value);
        }else {
            valueStr = String.valueOf((int)value);
        }

        return valueStr;

    }

    public static String formattedValue(double value){

        String valueStr;
        if((value % 1) != 0){
            valueStr =String.valueOf(value);
        }else {
            valueStr = String.valueOf((int)value);
        }

        return valueStr;

    }
    /*void operationFunction(String operationStr) {


        *//*if (value1.length() != 0 && currentValue.length() != 0) {

            if (selectedOperator.equals(operationStr)) {

                double calculatedValue = 0;
                switch (operationStr) {

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

        }*//*
        selectedOperator = operationStr;

        autoClean = true;
    }*/
}
