package com.example.december.modric;

import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.CursorJoiner;
import android.os.Bundle;
import android.renderscript.Double2;
import android.service.media.MediaBrowserService;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_0;//0数字按钮
    Button btn_1;//1数字按钮
    Button btn_2;//2数字按钮
    Button btn_3;//3数字按钮
    Button btn_4;//4数字按钮
    Button btn_5;//5数字按钮
    Button btn_6;//6数字按钮
    Button btn_7;//7数字按钮
    Button btn_8;//8数字按钮
    Button btn_9;//9数字按钮
    Button btn_point;//小数点按钮
    Button btn_clear;//清除按钮
    Button btn_DEL;//删除按钮
    Button btn_plus;//加号按钮
    Button btn_minus;//减号按钮
    Button btn_multiply;//乘号按钮
    Button btn_divide;//除号按钮
    Button btn_equal;//等号按钮
    EditText et_input;//显示输入内容
    boolean clear_bag;//清空标示


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0 = (Button) findViewById(R.id.button14);
        btn_1 = (Button) findViewById(R.id.button16);
        btn_2 = (Button) findViewById(R.id.button17);
        btn_3 = (Button) findViewById(R.id.button18);
        btn_4 = (Button) findViewById(R.id.button9);
        btn_5 = (Button) findViewById(R.id.button10);
        btn_6 = (Button) findViewById(R.id.button11);
        btn_7 = (Button) findViewById(R.id.button5);
        btn_8 = (Button) findViewById(R.id.button6);
        btn_9 = (Button) findViewById(R.id.button7);
        btn_plus= (Button) findViewById(R.id.button12);
        btn_point = (Button) findViewById(R.id.button15);
        btn_DEL = (Button) findViewById(R.id.button2);
        btn_minus = (Button) findViewById(R.id.button8);
        btn_multiply = (Button) findViewById(R.id.button3);
        btn_divide = (Button) findViewById(R.id.button4);
        btn_equal = (Button) findViewById(R.id.button13);
        btn_clear = (Button) findViewById(R.id.button);
        et_input = (EditText) findViewById(R.id.editText);
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_DEL.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        et_input.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        String str = et_input.getText().toString();
        switch (v.getId()) {
            case R.id.button5:
            case R.id.button6:
            case R.id.button7:
            case R.id.button9:
            case R.id.button10:
            case R.id.button11:
            case R.id.button14:
            case R.id.button15:
            case R.id.button16:
            case R.id.button17:
            case R.id.button18:
                if (clear_bag) {
                    clear_bag = false;
                    str = "";
                    et_input.setText("");
                }
                et_input.setText(str + ((Button) v).getText());
                break;
            case R.id.button3:
            case R.id.button4:
            case R.id.button8:
            case R.id.button12:
                if (clear_bag) {
                    clear_bag = false;
                    str = "";
                    et_input.setText("");
                }
                et_input.setText(str + ((Button) v).getText());
                break;
            case R.id.button2:
                if (clear_bag) {
                    clear_bag = false;
                    str = "";
                    et_input.setText("");
                }
                if (et_input.getText().toString().length()!=0) {
                    char ch = et_input.getText().toString().charAt(str.length()-1);
                    if (!Character.isDigit(ch)){
                        et_input.setText(str.substring(0,str.length() - 3));
                    }else
                        et_input.setText(str.substring(0,str.length() - 1));

                    et_input.invalidate();
                }

                break;
            case R.id.button:
                clear_bag = false;
                str = "";
                et_input.setText("");
                break;
            case R.id.button13:
                getResult();
                break;


        }
    }
    private void getResult(){
        String exp = et_input.getText().toString();
        if (exp==null||exp.equals("")) {
            return;
        }
        if (!exp.contains("")) {
            return;
        }
        if (clear_bag) {
            clear_bag = false;
            return;
        }
         clear_bag = true;
        double result = 0.0;
        String[] s = exp.split(" ");
        String s1 = s[0];
        String op = s[1];
        String s2 = s[2];
        if (!s1.equals("")&&!s2.equals("")){
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);

            if (op.equals("+")){
              result = d1 + d2;
            }else if (op.equals("-")) {
              result = d1 - d2;
            }else if (op.equals("*")){
                result = d1 * d2;
            }else if (op.equals("/")){
                if (d2==0){
                    result = 0;
                }else {
                    result = d1 / d2;

                }
                et_input.setText(result+"");

                Log.i("what",result+"");

            }
            if (!s1.contains(".")&&!s2.contains(".")) {
                double r = result;
                et_input.setText(r+"");
            }else {
                et_input.setText(result+"");
            }
        }else if (!s1.equals("")&&s2.equals("")){
            et_input.setText(exp);
        }else if (s1.equals("")&&!s2.equals("")){
            double d2 = Double.parseDouble(s2);

            if (op.equals("+")){
                result =  d2;
            }else if (op.equals("-")) {
                result = - d2;
            }else if (op.equals("*")){
                result = 0;
            }else if (op.equals("/")){
                   result = 0;
                }
            if (!s2.contains(".")){
                int r = (int) result;
                et_input.setText(r+"");
            }else {
                et_input.setText(result+"");
            }
        }else{
            et_input.setText("");
        }
    }
}
