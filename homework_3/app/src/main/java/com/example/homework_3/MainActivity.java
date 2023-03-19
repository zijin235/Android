package com.example.homework_3;

import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import com.example.util.ViewUtil;

public class MainActivity extends AppCompatActivity {

    private EditText edt_username;
    private EditText edt_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_username=findViewById(R.id.login_username);
        edt_password=findViewById(R.id.login_password);

        edt_username.addTextChangedListener(new HideTextWatcher(edt_username,3));//添加文本监听器
        edt_password.addTextChangedListener(new HideTextWatcher(edt_password,6));//添加文本监听器
    }

    private class HideTextWatcher implements TextWatcher{
        private EditText mView;//编辑框对象
        private int MaxLength;//最大长度

        public HideTextWatcher(EditText v,int maxLength){
            super();
            mView=v;
            MaxLength=maxLength;
        }

        public void beforeTextChanged(CharSequence s,int start,int count,int after){}

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            //在编辑框的输入文本变化前触发
        }

        //在编辑框的输入文本变化时触发
        @Override
        public void afterTextChanged(Editable s){
            String str=s.toString();//获得已输入文本
            //文本到达限定长度关闭输入框
            if((str.length()==3&&MaxLength==3)||(str.length()==6&&MaxLength==6)){
                ViewUtil.hideOneInputMethod(MainActivity.this, mView);
            }
        }

    }

//    public void toRegister(View view) {//弹出对话框，实现注册
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("注册窗口");
//        View Register = this.getLayoutInflater().inflate(R.layout.activity_main2,null);
//
//        builder.setView(Register);
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//    }
    public void toRegister(View view)
    {
        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
}
