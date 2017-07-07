package jp.techacademy.ayako.kawakami.calc;

import android.content.Intent;
import android.icu.math.BigDecimal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    String result = new String("0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        result = intent.getStringExtra("RESULT");

        TextView textView = (TextView) findViewById(R.id.resultText);
        textView.setText("計算結果：" + String.valueOf(result));
    }
}
