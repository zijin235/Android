package com.example.homework_1;


import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv_result;//利用textview视图显示结果
    // 第一个操作数
    private String firstNum = "";
    // 运算符
    private String operator = "";
    // 第二个操作数
    private String secondNum = "";
    // 当前的计算结果
    private String result = "";
    // 显示的文本内容
    private String showText = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//填充当前布局视图
        // 获取TextView
        tv_result = findViewById(R.id.tv_result);
        // 注册监听器
        findViewById(R.id.btn_cancel).setOnClickListener(this);//取消
        findViewById(R.id.btn_divide).setOnClickListener(this);     // “除法”按钮
        findViewById(R.id.btn_multiply).setOnClickListener(this);   // “乘法”按钮
        findViewById(R.id.btn_clear).setOnClickListener(this);  // “清除”按钮
        findViewById(R.id.btn_seven).setOnClickListener(this);  // 数字7
        findViewById(R.id.btn_eight).setOnClickListener(this);  // 数字8
        findViewById(R.id.btn_nine).setOnClickListener(this);   // 数字9
        findViewById(R.id.btn_plus).setOnClickListener(this);   // “加法”按钮
        findViewById(R.id.btn_four).setOnClickListener(this);   // 数字4
        findViewById(R.id.btn_five).setOnClickListener(this);   // 数字5
        findViewById(R.id.btn_six).setOnClickListener(this);    // 数字6
        findViewById(R.id.btn_minus).setOnClickListener(this);  // “减法”按钮
        findViewById(R.id.btn_one).setOnClickListener(this);    // 数字1
        findViewById(R.id.btn_two).setOnClickListener(this);    // 数字2
        findViewById(R.id.btn_three).setOnClickListener(this);  // 数字3
        findViewById(R.id.btn_reciprocal).setOnClickListener(this);     // 求倒数按钮
        findViewById(R.id.btn_zero).setOnClickListener(this);   // 数字0
        findViewById(R.id.btn_dot).setOnClickListener(this);    // “小数点”按钮
        findViewById(R.id.btn_equal).setOnClickListener(this);  // “等号”按钮
        findViewById(R.id.ib_sqrt).setOnClickListener(this);   // “开平方”按钮
    }

    @Override
    public void onClick(View v) {
        String inputText;
        // 如果是开根号按钮
        if (v.getId() == R.id.ib_sqrt) {
            inputText = "√";
        } else {
            // 除了开根号之外的其他按钮
            inputText = ((TextView) v).getText().toString();//获取内容
        }
        switch (v.getId()) {
            // 清除按钮
            case R.id.btn_clear:
                clear("");//清除
                break;
            case R.id.btn_cancel:
                if (operator.equals("")) { // 无操作符，则表示逐位取消前一个操作数
                    if (firstNum.length() == 1) {
                        firstNum = "0";//只有一个数就直接置为0
                    } else if (firstNum.length() > 0) {//超过1个数
                        firstNum = firstNum.substring(0, firstNum.length() - 1);//去除最后一个数
                    } else {//没有数
                        Toast.makeText(this, "没有可取消的数字了", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    showText = firstNum;
                    tv_result.setText(showText);
                } else { // 有操作符，则表示逐位取消后一个操作数
                    if (secondNum.length() == 1) {
                        secondNum = "";//取消后一个操作数
                    } else if (secondNum.length() > 0) {
                        secondNum = secondNum.substring(0, secondNum.length() - 1);
                    } else {
                        Toast.makeText(this, "没有可取消的数字了", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    showText = showText.substring(0, showText.length() - 1);
                    tv_result.setText(showText);
                }
            // 加、减、乘、除按钮
            case R.id.btn_plus:
            case R.id.btn_minus:
            case R.id.btn_multiply:
            case R.id.btn_divide:
                operator = inputText; // 运算符
                refreshText(showText + operator);//刷新运算界面
                break;
            // 等号按钮
            case R.id.btn_equal:
                // 加减乘除四则运算
                double calculate_result = calculateFour();
                refreshOperate(String.valueOf(calculate_result));
                refreshText(showText + "=" + result);
                break;
            // 开根号按钮
            case R.id.ib_sqrt:
                double sqrt_result = Math.sqrt(Double.parseDouble(firstNum));
                refreshOperate(String.valueOf(sqrt_result));
                refreshText(showText + "√=" + result);
                break;
            // 求倒数按钮
            case R.id.btn_reciprocal:
                double reciprocal_result = 1.0 / Double.parseDouble(firstNum);
                refreshOperate(String.valueOf(reciprocal_result));
                refreshText(showText + "/=" + result);
                break;
            // 其他按钮，包括数字和小数点
            default:
                // 清除上次的运算结果
                if (operator.equals("＝")) { // 上一次点击了等号按钮，则清空操作符
                    operator = "";
                    firstNum = "";
                    showText = "";
                }

                // 无运算符，则继续拼接第一个操作数
                if (operator.equals("")) {
                    firstNum = firstNum + inputText;
                } else {
                    // 有运算符，则继续拼接第二个操作数
                    secondNum = secondNum + inputText;
                }
                // 整数不需要前面的0
                showText = showText + inputText;
                tv_result.setText(showText);
                break;
        }
    }

    // 加减乘除四则运算，返回计算结果
    private double calculateFour() {
        switch (operator) {
            case "＋":
                return Double.parseDouble(firstNum) + Double.parseDouble(secondNum);
            case "－":
                return Double.parseDouble(firstNum) - Double.parseDouble(secondNum);
            case "×":
                return Double.parseDouble(firstNum) * Double.parseDouble(secondNum);
            default:
                if(Double.parseDouble(secondNum) == 0)
                {
                    Toast.makeText(this, "除数不能为零", Toast.LENGTH_SHORT).show();
                    clear("");
                    return 0;
                }
                else return Double.parseDouble(firstNum) / Double.parseDouble(secondNum);
        }
    }

    // 清空并初始化
    private void clear(String text) {
        showText = text;
        tv_result.setText(showText);
        operator = "";
        firstNum = "";
        secondNum = "";
        result = "";
    }

    // 刷新运算结果
    private void refreshOperate(String new_result) {
        result = new_result;
        firstNum = result;
        secondNum = "";
        operator = "";
    }

    // 刷新文本显示
    private void refreshText(String text) {
        showText = text;
        tv_result.setText(showText);
    }

}
