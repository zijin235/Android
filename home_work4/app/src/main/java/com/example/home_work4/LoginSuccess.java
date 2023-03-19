package com.example.home_work4;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class LoginSuccess extends AppCompatActivity {

    private TextView tv_share;//文本对象获取信息
    private Context mContext;
    private  SharedPreferences shared;

    private EditText passwordEdit;
    private EditText ageEdit;
    private RadioButton man, woman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginsuccess);

        mContext=LoginSuccess.this;
        tv_share=findViewById(R.id.tv_share);

        shared=getSharedPreferences("share",MODE_PRIVATE);

        readSharedPreferences();//读取信息


    }

    private void readSharedPreferences(){
        //从share.xml中获取共享参数
        String desc="用户信息如下：";
        Map<String, Object>mapParam= (Map<String, Object>) shared.getAll();
        for (Map.Entry<String, Object>item_map : mapParam.entrySet()){
            String key=item_map.getKey();
            Object value=item_map.getValue();

            desc=String.format("%s\n%s的取值为%s", desc, key,shared.getString(key, ""));
        }
        tv_share.setText(desc);
    }


    public void toEdit(View view) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
//        builder.setView(R.layout.editinfo);
//        AlertDialog dialog = builder.create();
//        dialog = builder.setTitle("修改信息")
//                .setCancelable(true)
//                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                    }
//                }).setNegativeButton("取消",new DialogInterface.OnClickListener() {
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(mContext, "取消", Toast.LENGTH_SHORT).show();
//                        dialog.dismiss();
//                    }
//                }).create();
//        dialog.show();
        Intent intent =new Intent(mContext,EditInfo.class);
        startActivity(intent);
    }


    public void Delete(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        AlertDialog dialog = null;
        dialog = builder.setTitle("提示:")
                .setMessage("是否注销，这将会删除用户数据!")
                .setCancelable(true)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mContext, "删除数据", Toast.LENGTH_SHORT).show();
                        SharedPreferences.Editor editor = shared.edit();    // 获取editor
                        editor.clear();     // 清除所有数据
                        editor.commit();    // 提交
                        dialog.dismiss();
                        Intent intent = new Intent(mContext,Login.class);
                        startActivity(intent);
                    }
                }).setNegativeButton("取消",new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mContext, "取消", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();
    }
}
