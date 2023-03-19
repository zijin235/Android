package com.example.home_work4;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.util.ViewUtil;

import java.io.File;
import java.util.Map;

public class Login extends AppCompatActivity {

    private EditText edt_username;
    private EditText edt_password;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        edt_username=findViewById(R.id.login_username);
        edt_password=findViewById(R.id.login_password);

        edt_username.addTextChangedListener(new HideTextWatcher(edt_username,3));//添加文本监听器
        edt_password.addTextChangedListener(new HideTextWatcher(edt_password,6));//添加文本监听器

        mContext=Login.this;

    }


    public void toLogin(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        String username=edt_username.getText().toString();
        String password=edt_password.getText().toString();

        File f = new File(
                "/data/data/com.example.home_work4/shared_prefs/share.xml");
        if(f.exists())
        {
            SharedPreferences shared=getSharedPreferences("share",MODE_PRIVATE);
            String username_check=shared.getString("username","");
            String password_check= shared.getString("password","");
            if(username.equals(username_check)&&password.equals(password_check)){
                Intent intent =new Intent(mContext,LoginSuccess.class);
                startActivity(intent);
                finish();
            }
            else if(username_check.equals("")){
                AlertDialog dialog=builder.setTitle("error")
                        .setMessage("请先创建用户！")
                        .setCancelable(true)
                        .setPositiveButton("确定",new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog ,int which){
                                Intent intent =new Intent(mContext,Register.class);
                                startActivity(intent);
                                dialog.dismiss();
                            }
                        }).create();
                dialog.show();
            }
            else{
                AlertDialog dialog=builder.setTitle("error")
                        .setMessage("用户信息输入有误")
                        .setCancelable(true)
                        .setPositiveButton("确定",new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog ,int which){
                                dialog.dismiss();
                            }
                        }).create();
                dialog.show();
            }
        }
        else {
            AlertDialog dialog=builder.setTitle("error")
                    .setMessage("请先创建用户！")
                    .setCancelable(true)
                    .setPositiveButton("确定",new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog ,int which){
                            Intent intent =new Intent(mContext,Register.class);
                            startActivity(intent);
                            dialog.dismiss();
                        }
                    }).create();
            dialog.show();
        }

    }

    private class HideTextWatcher implements TextWatcher {
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
                ViewUtil.hideOneInputMethod(Login.this, mView);
            }
        }

    }

    public void toRegister(View view)
    {
        Intent intent=new Intent(this,Register.class);
        startActivity(intent);
    }
}
