package com.example.adino.kalkulator;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * Created by adino on 19.03.2018.
 */

public class Calculator implements Serializable{
    private Double result;
    private StringBuilder actualValue;
    private String operation;
    private boolean isDotted;
    private boolean isEqualed;
    private StringBuilder operationSequence;
    private HashMap<String,String> operatorsBuff;
    private boolean isSetOperation;
    private boolean isOneOperand;
    private String operationSequenceBuffer;



    public Calculator(){
        actualValue = new StringBuilder("0");
        operation = "add";
        result = new Double(0);
        isDotted = false;
        isEqualed = false;
        isSetOperation = false;
        operationSequence = new StringBuilder();

        operatorsBuff = new HashMap<>();
        operatorsBuff.put("add", "+");
        operatorsBuff.put("substract", "-");
        operatorsBuff.put("multiply","*");
        operatorsBuff.put("divide","/");
        operatorsBuff.put("pow", "^");

        isOneOperand = false;
        //actualValue = actualValue.toString();

    }

    public Double getResult(){
        return  result;
    }

    public String getActualValue(){
        return actualValue.toString();
    }

    public String getOperationSequence() {
        return operationSequence.toString();
    }

    /*public String getActualValue(){
        return actualValue;
    }*/





    public void addDigitToValue(String digit){
        if(isSetOperation){
            if(isOneOperand){
                operationSequence = new StringBuilder(operationSequenceBuffer);
                isOneOperand = false;
            }
            actualValue = new StringBuilder("0");
            isSetOperation = false;
            isDotted=false;
            //result = new Double(0);
        }
        if(actualValue.toString().equals("0")){
            if(!isDotted) {
                actualValue.setLength(0);
            }
        }
        actualValue.append(digit);

    }

    public void addDot(){
        if(!isDotted){
            isDotted = true;
            addDigitToValue(".");

        }
    }

    private void validateValue(){
        int indexOfLastChar = actualValue.length() - 1;
        if(actualValue.charAt(indexOfLastChar) == '.'){
            actualValue.deleteCharAt(indexOfLastChar);
        }
        double buf = Double.valueOf(actualValue.toString());
        if(!(buf == (int)buf)){
            isDotted = true;
        }

    }




    private void compute() throws InvocationTargetException{

        validateValue();

        if(!isOneOperand) {
            operationSequence.append(actualValue);

        } else {
            isOneOperand = false;
        }
        try {
            Calculator.class.getMethod(this.operation).invoke(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }




    }

    public void equal() throws InvocationTargetException{
        compute();
        isEqualed = true;
        operationSequence.setLength(0);
    }

    public void setOperation(String operation) throws InvocationTargetException{
        afterIsEqualed();

        compute();
        operationSequence.append(operatorsBuff.get(operation));
        this.operation = operation;
        isSetOperation = true;
        actualValue = new StringBuilder(result.toString());
    }

    private void afterIsEqualed() {
        if(isEqualed){
            actualValue = new StringBuilder(result.toString());
            result = new Double(0);
            isEqualed = false;
            this.operation = "add";



        }
        operationSequenceBuffer = operationSequence.toString();

    }


    public void add(){
        result += Double.valueOf(actualValue.toString());
    }

    public void substract(){
        result -= Double.valueOf(actualValue.toString());
    }

    public void multiply(){
        result *= Double.valueOf(actualValue.toString());
    }

    public void divide() throws IllegalArgumentException{
        if(actualValue.toString().equals("0")){
            throw new IllegalArgumentException("Denominator is 0");
        }
        result /= Double.valueOf(actualValue.toString());
    }

    public void opposite(){
        validateValue();
        if(isEqualed){
            afterIsEqualed();
            actualValue = new StringBuilder(String.valueOf(Double.valueOf(actualValue.toString()) * (-1)));

        }
        else {
            actualValue = new StringBuilder(String.valueOf(Double.valueOf(actualValue.toString()) * (-1)));
        }
    }

    public void resetAll(){
        result = new Double(0);
        actualValue = new StringBuilder("0");
        operationSequence.setLength(0);
        operation = "add";
        isDotted = false;
        isEqualed = false;
        isSetOperation = false;
        isOneOperand =  false;
    }

    public void resetActualValue(){
        actualValue =  new StringBuilder("0");
        isDotted = false;
    }

    public void cos(){
        afterIsEqualed();
        isOneOperand = true;
        operationSequence.append("cos(" + actualValue + ")");
        actualValue = new StringBuilder(String.valueOf(Math.cos(Double.valueOf(actualValue.toString()))));
        isSetOperation = true;
    }

    public void  sin(){
        afterIsEqualed();
        isOneOperand = true;
        operationSequence.append("sin(" + actualValue + ")");
        actualValue = new StringBuilder(String.valueOf(Math.sin(Double.valueOf(actualValue.toString()))));
        isSetOperation = true;
    }

    public void tg(){
        afterIsEqualed();
        isOneOperand = true;
        operationSequence.append("tan(" + actualValue + ")");
        actualValue = new StringBuilder(String.valueOf(Math.tan(Double.valueOf(actualValue.toString()))));
        isSetOperation = true;
    }

    public void ln(){
        afterIsEqualed();
        isOneOperand = true;
        operationSequence.append("ln(" + actualValue + ")");
        actualValue = new StringBuilder(String.valueOf(Math.log(Double.valueOf(actualValue.toString()))));
        isSetOperation = true;
    }

    public void log(){
        afterIsEqualed();
        isOneOperand = true;
        operationSequence.append("log(" + actualValue + ")");
        actualValue = new StringBuilder(String.valueOf(Math.log10(Double.valueOf(actualValue.toString()))));
        isSetOperation = true;
    }

    public void sqrt(){
        afterIsEqualed();
        isOneOperand = true;
        operationSequence.append("sqrt(" + actualValue + ")");
        actualValue = new StringBuilder(String.valueOf(Math.sqrt(Double.valueOf(actualValue.toString()))));
        isSetOperation = true;
    }

    public void pow2(){
        afterIsEqualed();
        isOneOperand = true;
        operationSequence.append(actualValue + "^2");
        actualValue = new StringBuilder(String.valueOf(Math.pow(Double.valueOf(actualValue.toString()), 2)));
        isSetOperation = true;
    }

    public void pow(){
        result = Math.pow(result, Double.valueOf(actualValue.toString()));
    }

    public void percent(){
        actualValue = new StringBuilder(String.valueOf(Double.valueOf(actualValue.toString()) * 0.01));
    }



}
