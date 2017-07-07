package jp.techacademy.ayako.kawakami.calc;

import android.content.Intent;
import android.icu.math.BigDecimal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        Intent intent = new Intent(this, jp.techacademy.ayako.kawakami.calc.SecondActivity.class);

        BigDecimal bd1 = new BigDecimal("0.0");
        BigDecimal bd2 = new BigDecimal("0.0");

        EditText value1 = (EditText) findViewById(R.id.text1);
        EditText value2 = (EditText) findViewById(R.id.text2);

        String str1 = value1.getText().toString();
        String str2 = value2.getText().toString();

        if (!str1.equals("")){
            bd1 = new BigDecimal(str1);
        }else{
        }

        if (!str2.equals("")){
            bd2 = new BigDecimal(str2);
        }else{
        }


        BigDecimal result;
        intent.putExtra("RESULT", "nya-n");

        if(v.getId()==R.id.button1){
            result = bd1.add(bd2);
            intent.putExtra("RESULT", String.valueOf(result));
        }else if(v.getId()==R.id.button2){
            result = bd1.subtract(bd2);
            intent.putExtra("RESULT", String.valueOf(result));

        }else if(v.getId()==R.id.button3){
            result = bd1.multiply(bd2);
            intent.putExtra("RESULT", String.valueOf(result));

        }else if(v.getId()==R.id.button4){

            if(bd2.compareTo(new BigDecimal("0"))!=0){
                result = bd1.divide(bd2, 3, BigDecimal.ROUND_HALF_UP);
                intent.putExtra("RESULT", String.valueOf(result));
            }else{
                Toast ts = Toast.makeText(this, "0で割ることはできません", Toast.LENGTH_LONG);
                ts.show();
                String str_result=new String("エラー");
                intent.putExtra("RESULT", str_result);
            }
        }else{

        }

        startActivity(intent);
    }
}

