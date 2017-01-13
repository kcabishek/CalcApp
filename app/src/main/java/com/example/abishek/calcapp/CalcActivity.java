package com.example.abishek.calcapp;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends Activity {

        String displayNumber = "";
        String leftNumber = "";
        String rightNumber = "";

        public enum Operations {

            ADD, SUBTRACT, MULTIPLY, DIVIDE, EQUAL
        }

        Operations currentOperation;

        TextView resultView;
        double result = 0;
        double res = 0;
        int final_res = 0;
        //float result_dec = 0;
        //String dec_result ="";
        //float div_value = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button oneBtn = (Button) findViewById(R.id.one);
        Button twoBtn = (Button) findViewById(R.id.two);
        Button threeBtn = (Button) findViewById(R.id.three);
        Button fourBtn = (Button) findViewById(R.id.four);
        Button fiveBtn = (Button) findViewById(R.id.five);
        Button sixBtn = (Button) findViewById(R.id.six);
        Button sevenBtn = (Button) findViewById(R.id.seven);
        Button eightBtn = (Button) findViewById(R.id.eight);
        Button nineBtn = (Button) findViewById(R.id.nine);
        Button zeroBtn = (Button) findViewById(R.id.zero);

        ImageButton divBtn = (ImageButton) findViewById(R.id.divide);
        ImageButton multBtn = (ImageButton) findViewById(R.id.multiply);
        ImageButton subBtn = (ImageButton) findViewById(R.id.subtract);
        ImageButton addBtn = (ImageButton) findViewById(R.id.addition);
        ImageButton equalBtn = (ImageButton) findViewById(R.id.equal);

        Button clearBtn = (Button) findViewById(R.id.clear);
        resultView = (TextView) findViewById(R.id.result);

        resultView.setText("0");

        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClicked(1);
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClicked(2);
            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClicked(3);
            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClicked(4);
            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClicked(5);
            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClicked(6);
            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClicked(7);
            }
        });

        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClicked(8);
            }
        });

        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClicked(9);
            }
        });

        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClicked(0);
            }
        });

        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operations.DIVIDE);
            }
        });

        multBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operations.MULTIPLY);
            }
        });

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operations.SUBTRACT);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operations.ADD);
            }
        });

        equalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operations.EQUAL);
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftNumber = "";
                rightNumber = "";
                result = 0;
                displayNumber = "";
                currentOperation = null;
                resultView.setText("0");
            }
        });

    }

    void numberClicked(int number){

        displayNumber += String.valueOf(number);
        resultView.setText(displayNumber);
    }

    void processOperation(Operations operation){

        if(currentOperation != null){

            if(displayNumber != ""){

                rightNumber = displayNumber;
                displayNumber = "";

                switch (currentOperation) {

                    case ADD:
                        result = Double.parseDouble(leftNumber) + Double.parseDouble(rightNumber);
                        break;
                    case SUBTRACT:
                        result = Double.parseDouble(leftNumber) - Double.parseDouble(rightNumber);
                        break;
                    case MULTIPLY:
                        result = Double.parseDouble(leftNumber) * Double.parseDouble(rightNumber);
                        break;
                    case DIVIDE:
/*                        try{
                            result = Double.parseDouble(leftNumber) / Double.parseDouble(rightNumber);
//                            leftNumber = String.valueOf(res);
//                            resultView.setText(leftNumber);
                            //result = (int) res;
                            //result_dec = Integer.parseInt(leftNumber) % Integer.parseInt(rightNumber);
                            //dec_result = result + "." + result_dec;
                            //result = Integer.parseInt(dec_result);
                        }

                        catch(ArithmeticException e){
                            displayNumber = "Error";
                            resultView.setText(displayNumber);
                        }*/
                        //break;
                        if(rightNumber=="0"){
                            resultView.setText("Infinity");
                        }
                        else{
                            result = Double.parseDouble(leftNumber) / Double.parseDouble(rightNumber);
                        }
                        break;
                }
                    res = result - Math.floor(result);
                    if(Math.abs(res)>0){
                        leftNumber = String.valueOf(result);
                        resultView.setText(leftNumber);
                    }
                    else if(res==0){
                        final_res = (int) result;
                        leftNumber = String.valueOf(final_res);
                        resultView.setText(leftNumber);
                    }
            }

        }
        else{

            leftNumber = displayNumber;
            displayNumber = "";
        }

        currentOperation = operation;
    }
}
