package com.mycompany.hex_converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnKeyListener{
    //初始化控件
    private EditText input_B;
    private EditText input_D;
    private EditText input_O;
    private EditText input_X;

    public  String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到控件
        input_B = (EditText)findViewById(R.id.input_2);
        input_D = (EditText)findViewById(R.id.input_10);
        input_O = (EditText)findViewById(R.id.input_8);
        input_X = (EditText)findViewById(R.id.input_16);
        //实现方法
        input_B.setOnKeyListener(this);
        input_D.setOnKeyListener(this);
        input_O.setOnKeyListener(this);
        input_X.setOnKeyListener(this);

    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        //十进制数
        int numberD;
        //double numberDD;
        //一次键盘输入android会响应2次-按下和按上所以现在取按上则只执行一次
        try {
            if (event.getAction() == KeyEvent.ACTION_UP) {
                switch (v.getId()) {
                    case R.id.input_2:
                        number = input_B.getText().toString();
                        if (number !=null && number !=""){
                            numberD = Integer.valueOf(number, 2);
                            input_O.setText(Integer.toOctalString(numberD));
                            input_X.setText(Integer.toHexString(numberD));
                            input_D.setText("" + numberD);
                        }
                        break;
                    case R.id.input_8:
                        number = input_O.getText().toString();
                        if (number !=null && number !="") {
                            numberD = Integer.valueOf(number, 8);
                            input_B.setText(Integer.toBinaryString(numberD));
                            input_D.setText("" + numberD);
                            input_X.setText(Integer.toHexString(numberD));
                        }
                            break;
                    case R.id.input_10:
                        number = input_D.getText().toString();
                        if (number !=null && number !="") {
                            numberD = Integer.valueOf(number);
                            input_B.setText(Integer.toBinaryString(numberD));
                            input_O.setText(Integer.toOctalString(numberD));
                            input_X.setText(Integer.toHexString(numberD));
                        }
                            break;
                    case R.id.input_16:
                        number = input_X.getText().toString();
                        if (number !=null && number !="") {
                            numberD = Integer.valueOf(number, 16);
                            input_B.setText(Integer.toBinaryString(numberD));
                            input_O.setText(Integer.toOctalString(numberD));
                            input_D.setText("" + numberD);
                        }
                            break;
                    default:
                        break;
                }

            }
        }catch (Exception e){
            e.printStackTrace();
            clear();
        }
                return false;
    }

    private void clear() {
        input_D.setText("");
        input_O.setText("");
        input_B.setText("");
        input_X.setText("");
    }
}
