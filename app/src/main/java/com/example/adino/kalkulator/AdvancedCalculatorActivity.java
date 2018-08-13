package com.example.adino.kalkulator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by adino on 31.03.2018.
 */

public class AdvancedCalculatorActivity extends SimpleCalculatorActivity {
    private Button btnCos;
    private Button btnSin;
    private Button btnTg;
    private Button btnLn;
    private Button btnLog;
    private Button btnSqrt;
    private Button btnPow2;
    private Button btnPow;
    private Button btnPercent;


    @Override
    public void setView(){
        setContentView(R.layout.advanced_calculator);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btnCos = (Button) findViewById(R.id.cos);
        btnCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.cos();
                result.setText(calculator.getActualValue());
                operation.setText(calculator.getOperationSequence());
            }
        });

        btnSin = (Button) findViewById(R.id.sin);
        btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.sin();
                result.setText(calculator.getActualValue());
                operation.setText(calculator.getOperationSequence());
            }
        });

        btnTg = (Button) findViewById(R.id.tan);
        btnTg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.tg();
                result.setText(calculator.getActualValue());
                operation.setText(calculator.getOperationSequence());
            }
        });

        btnLn = (Button) findViewById(R.id.ln);
        btnLn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.ln();
                result.setText(calculator.getActualValue());
                operation.setText(calculator.getOperationSequence());
            }
        });

        btnLog = (Button) findViewById(R.id.log);
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.log();
                result.setText(calculator.getActualValue());
                operation.setText(calculator.getOperationSequence());
            }
        });

        btnSqrt = (Button) findViewById(R.id.sqrt);
        btnSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.sqrt();
                result.setText(calculator.getActualValue());
                operation.setText(calculator.getOperationSequence());
            }
        });

        btnPow2 = (Button) findViewById(R.id.xTo2);
        btnPow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.pow2();
                result.setText(calculator.getActualValue());
                operation.setText(calculator.getOperationSequence());
            }
        });

        btnPow = (Button) findViewById(R.id.xToy);
        btnPow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    calculator.setOperation("pow");
                    result.setText(calculator.getResult().toString());
                    operation.setText(calculator.getOperationSequence());
                } catch (IllegalArgumentException|InvocationTargetException e){
                    Toast.makeText(AdvancedCalculatorActivity.this, "You can't divide by 0", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnPercent = (Button) findViewById(R.id.percent);
        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.percent();
                result.setText(calculator.getActualValue());
                operation.setText(calculator.getOperationSequence());
            }
        });

    }
}
