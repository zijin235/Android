package com.example.home_work4;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    private EditText username_edt;//用户名文本
    private EditText password_edt;//输入密码文本
    private EditText password2_edt;//确认密码文本

    private RadioButton man, woman;//性别选项
    private EditText age_edt;//性别文本
    private SharedPreferences mShared;//声明一个共享参数对象
    private Context mContext;//上下文环境

    private final static String LOG_TAG = Login.class.getSimpleName();//日志

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        username_edt=findViewById(R.id.register_username);//获取用户名编辑框
        password_edt=findViewById(R.id.register_password);//获取输入密码编辑框
        password2_edt=findViewById(R.id.register_password2);//获取确认密码编辑框
        age_edt=findViewById(R.id.register_age);//获取年龄
        man = findViewById(R.id.man);//获取复选框的值
        woman = findViewById(R.id.woman);
        mShared=getSharedPreferences("share",MODE_PRIVATE);
    }

    public static int check(String username,String password1,String password2,String age,String sex)
    {
        if(username.length()<3){//用户名小于3位
            return 1;
        }
        else if(password1.length()>6)return 2;//密码大于6位
        else if(!password1.equals(password2))return 3;//两次密码不一致
        else if(age.length()<1)return 4;
        else if(sex.equals("none"))return 5;
        else return 0;
    }

    public void toRegister(View view) {
        String username=username_edt.getText().toString();
        String password=password_edt.getText().toString();
        String password2=password2_edt.getText().toString();
        String age=age_edt.getText().toString();
        String sex;
        if(man.isChecked())sex="男";
        else if(woman.isChecked())sex="女";
        else sex="none";
        mContext=Register.this;

        int flag=check(username,password,password2,age,sex);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if(flag==0)
        {
            SharedPreferences.Editor editor=mShared.edit();//获取编辑器的对象
            editor.putString("username",username);
            editor.putString("password",password);
            editor.putString("age",age);
            editor.putString("sex",sex);
            editor.apply();
            AlertDialog dialog=builder.setTitle("success")
                            .setMessage("Success!")
                            .setCancelable(true)
                            .setPositiveButton("确定",new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog ,int which){
                                    Intent intent =new Intent(mContext,Login.class);
                                    startActivity(intent);
                                    Toast.makeText(mContext, "注册成功！", Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                    finish();//注册成功后销毁注册页面
                                }
                            }).create();
            dialog.show();
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
        else if(flag==4)
        {
            AlertDialog dialog=builder.setTitle("年龄为空")
                    .setMessage("请输入年龄！")
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
        else if(flag==5)
        {
            AlertDialog dialog=builder.setTitle("性别为空")
                    .setMessage("请选择性别！")
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
