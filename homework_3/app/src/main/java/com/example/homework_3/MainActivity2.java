package com.example.homework_3;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    private EditText username_edt;//用户名文本
    private EditText password_edt;//输入密码文本
    private EditText password2_edt;//确认密码文本

    private Context mContext;//上下文环境

    private final static String LOG_TAG = MainActivity2.class.getSimpleName();//日志

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        username_edt=findViewById(R.id.register_username);//获取用户名编辑框
        password_edt=findViewById(R.id.register_password);//获取输入密码编辑框
        password2_edt=findViewById(R.id.register_password2);//获取确认密码编辑框

    }

    public static int check(String username,String password1,String password2)
    {
        if(username.length()<3){//用户名小于3位
            return 1;
        }
        else if(password1.length()>6)return 2;//密码大于6位
        else if(!password1.equals(password2))return 3;//两次密码不一致
        else return 0;
    }

    public void Register(View view) {
        String username=username_edt.getText().toString();
        String password=password_edt.getText().toString();
        String password2=password2_edt.getText().toString();
        mContext=MainActivity2.this;

        int flag=check(username,password,password2);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if(flag==0)
        {
            Intent intent =new Intent(this,MainActivity3.class);
            startActivity(intent);
            finish();//注册成功后销毁注册页面
        }
        else if(flag==1)
        {
            AlertDialog dialog=builder.setTitle("用户名不合法")
                    .setMessage("用户名不能少于三位")
                    .setCancelable(true)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(mContext, "取消注册", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }).create();
            dialog.show();
        }
        else if(flag==2)
        {
            AlertDialog dialog=builder.setTitle("密码长度错误")
                    .setMessage("密码不得超过6位！")
                    .setCancelable(true)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(mContext, "取消注册", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }).create();
            dialog.show();
        }
        else if(flag==3)
        {
            AlertDialog dialog=builder.setTitle("密码不匹配")
                    .setMessage("两次输入的密码不匹配！")
                    .setCancelable(true)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(mContext, "取消注册", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }).create();
            dialog.show();
        }
    }
}
