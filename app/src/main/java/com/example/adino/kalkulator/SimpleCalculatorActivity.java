package com.example.adino.kalkulator;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by adino on 19.03.2018.
 */

public class SimpleCalculatorActivity extends AppCompatActivity{
    protected Calculator calculator = new Calculator();



    protected TextView result;
    protected TextView operation;

    private Button btnNumber0;
    private Button btnNumber1;
    private Button btnNumber2;
    private Button btnNumber3;
    private Button btnNumber4;
    private Button btnNumber5;
    private Button btnNumber6;
    private Button btnNumber7;
    private Button btnNumber8;
    private Button btnNumber9;

    private Button btnDot;
    private Button btnAdd;
    private Button btnEqual;
    private Button btnSubstract;
    private Button btnOpposite;
    private Button btnAC;
    private Button btnC;
    private Button btnMultiply;
    private Button btnDivide;

    private  int i = 0;

    public void setView(){
        setContentView(R.layout.simple_calculator);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();

        if ((savedInstanceState != null) && (savedInstanceState.getSerializable("calculator") != null)) {
            calculator = (Calculator) savedInstanceState.getSerializable("calculator");
        }

        result = (TextView) findViewById(R.id.result);
        operation = (TextView) findViewById(R.id.operation);

        result.setText(calculator.getResult().toString());
        operation.setText(calculator.getOperationSequence());

        btnNumber0 = (Button) findViewById(R.id.number0);
        btnNumber0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addDigitToValue("0");
                result.setText(calculator.getActualValue());
            }
        });

        btnNumber1 = (Button) findViewById(R.id.number1);
        btnNumber1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addDigitToValue("1");
                result.setText(calculator.getActualValue());
            }
        });

        btnNumber2 = (Button) findViewById(R.id.number2);
        btnNumber2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addDigitToValue("2");
                result.setText(calculator.getActualValue());
            }
        });

        btnNumber3 = (Button) findViewById(R.id.number3);
        btnNumber3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addDigitToValue("3");
                result.setText(calculator.getActualValue());
            }
        });

        btnNumber4 = (Button) findViewById(R.id.number4);
        btnNumber4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addDigitToValue("4");
                result.setText(calculator.getActualValue());
            }
        });

        btnNumber5 = (Button) findViewById(R.id.number5);
        btnNumber5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addDigitToValue("5");
                result.setText(calculator.getActualValue());
            }
        });

        btnNumber6 = (Button) findViewById(R.id.number6);
        btnNumber6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addDigitToValue("6");
                result.setText(calculator.getActualValue());
            }
        });

        btnNumber7 = (Button) findViewById(R.id.number7);
        btnNumber7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addDigitToValue("7");
                result.setText(calculator.getActualValue());
            }
        });

        btnNumber8 = (Button) findViewById(R.id.number8);
        btnNumber8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addDigitToValue("8");
                result.setText(calculator.getActualValue());
            }
        });



        btnNumber9 = (Button) findViewById(R.id.number9);
        btnNumber9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addDigitToValue("9");
                result.setText(calculator.getActualValue());
            }
        });

        btnDot = (Button) findViewById(R.id.dot);
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.addDot();
                result.setText(calculator.getActualValue());
            }
        });



            btnAdd = (Button) findViewById(R.id.add);
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        calculator.setOperation("add");
                        result.setText(calculator.getResult().toString());
                        operation.setText(calculator.getOperationSequence());
                    } catch (IllegalArgumentException|InvocationTargetException e){
                        Toast.makeText(SimpleCalculatorActivity.this, "You can't divide by 0", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            btnEqual = (Button) findViewById(R.id.equal);
            btnEqual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        calculator.equal();
                        result.setText(calculator.getResult().toString());
                        operation.setText(calculator.getOperationSequence());
                    } catch (IllegalArgumentException|InvocationTargetException e){
                        Toast.makeText(SimpleCalculatorActivity.this, "You can't divide by 0", Toast.LENGTH_SHORT).show();
                    }

                }
            });

            btnSubstract = (Button) findViewById(R.id.substract);
            btnSubstract.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        calculator.setOperation("substract");
                        result.setText(calculator.getResult().toString());
                        operation.setText(calculator.getOperationSequence());
                    } catch (IllegalArgumentException|InvocationTargetException e){
                        Toast.makeText(SimpleCalculatorActivity.this, "You can't divide by 0", Toast.LENGTH_SHORT).show();
                    }
                }
            });


            btnMultiply = (Button) findViewById(R.id.multiply);
            btnMultiply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        calculator.setOperation("multiply");
                        result.setText(calculator.getResult().toString());
                        operation.setText(calculator.getOperationSequence());
                    } catch (IllegalArgumentException|InvocationTargetException e){
                        Toast.makeText(SimpleCalculatorActivity.this, "You can't divide by 0", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            btnDivide = (Button) findViewById(R.id.divide);
            btnDivide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                    calculator.setOperation("divide");
                    result.setText(calculator.getResult().toString());
                    operation.setText(calculator.getOperationSequence());
                     } catch (IllegalArgumentException|InvocationTargetException e){
                       Toast.makeText(SimpleCalculatorActivity.this, "You can't divide by 0", Toast.LENGTH_SHORT).show();
                     }
                }
            });



        btnOpposite = (Button) findViewById(R.id.opposite);
        btnOpposite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.opposite();
                result.setText(calculator.getActualValue());
            }
        });

        btnAC = (Button) findViewById(R.id.AC);
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.resetAll();
                result.setText(calculator.getActualValue());
                operation.setText(calculator.getOperationSequence());
            }
        });

        btnC = (Button) findViewById(R.id.C);
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i == 1){
                            calculator.resetActualValue();
                            result.setText(calculator.getActualValue());
                        } else if(i == 2){
                            calculator.resetAll();
                            result.setText(calculator.getActualValue());
                            operation.setText(calculator.getOperationSequence());
                        }

                        i=0;
                    }
                }, 500);

            }
        });



    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        //outState.putString(GAME_STATE_KEY, mGameState);
        //outState.putString(TEXT_VIEW_KEY, mTextView.getText())
        outState.putSerializable("calculator", calculator);

        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }
}
