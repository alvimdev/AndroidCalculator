package alvimlinks.netlify.app.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import org.w3c.dom.Text;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button n0, n1, n2, n3, n4, n5, n6, n7, n8, n9, bks, clr, pow, sum, sub, div, mul, eql, dot;
    private TextView exp, res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        Objects.requireNonNull(getSupportActionBar()).hide();

        n0.setOnClickListener(this);
        n1.setOnClickListener(this);
        n2.setOnClickListener(this);
        n3.setOnClickListener(this);
        n4.setOnClickListener(this);
        n5.setOnClickListener(this);
        n6.setOnClickListener(this);
        n7.setOnClickListener(this);
        n8.setOnClickListener(this);
        n9.setOnClickListener(this);
        dot.setOnClickListener(this);
        sum.setOnClickListener(this);
        sub.setOnClickListener(this);
        div.setOnClickListener(this);
        mul.setOnClickListener(this);
        pow.setOnClickListener(this);

        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText("");
                res.setText("");
            }
        });

        bks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView expression = findViewById(R.id.txt_expression);
                String str = expression.getText().toString();

                if (!str.isEmpty()) {
                    byte v0 = 0;
                    int strl = (str.length() - 1);
                    expression.setText(str.substring(v0,strl));
                }

                res.setText("");
            }
        });

        eql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    Expression expressao = new ExpressionBuilder(exp.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;

                    if (resultado == (double) longResult)
                        res.setText((CharSequence) String.valueOf(longResult));
                    else
                        res.setText((CharSequence) String.valueOf(resultado));
                }
                //                                                     ´bruh´
                catch (Exception err){ res.setText("\uD835\uDD1F\uD835\uDD2F\uD835\uDD32\uD835\uDD25"); }
            }
        });
    }

    private void initComponents(){
        n0 = findViewById(R.id.btn_0);
        n1 = findViewById(R.id.btn_1);
        n2 = findViewById(R.id.btn_2);
        n3 = findViewById(R.id.btn_3);
        n4 = findViewById(R.id.btn_4);
        n5 = findViewById(R.id.btn_5);
        n6 = findViewById(R.id.btn_6);
        n7 = findViewById(R.id.btn_7);
        n8 = findViewById(R.id.btn_8);
        n9 = findViewById(R.id.btn_9);
        dot = findViewById(R.id.btn_comma);
        bks = findViewById(R.id.btn_backspace);
        clr = findViewById(R.id.btn_clear);
        pow = findViewById(R.id.btn_power);
        div = findViewById(R.id.btn_split);
        mul = findViewById(R.id.btn_times);
        sub = findViewById(R.id.btn_minus);
        sum = findViewById(R.id.btn_plus);
        eql = findViewById(R.id.btn_equals);
        exp = findViewById(R.id.txt_expression);
        res = findViewById(R.id.txt_result);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_0:
                addExpression("0", true);
                break;
            case R.id.btn_1:
                addExpression("1", true);
                break;
            case R.id.btn_2:
                addExpression("2", true);
                break;
            case R.id.btn_3:
                addExpression("3", true);
                break;
            case R.id.btn_4:
                addExpression("4", true);
                break;
            case R.id.btn_5:
                addExpression("5", true);
                break;
            case R.id.btn_6:
                addExpression("6", true);
                break;
            case R.id.btn_7:
                addExpression("7", true);
                break;
            case R.id.btn_8:
                addExpression("8", true);
                break;
            case R.id.btn_9:
                addExpression("9", true);
                break;
            case R.id.btn_comma:
                addExpression(".", true);
                break;
            case R.id.btn_plus:
                addExpression("+", false);
                break;
            case R.id.btn_minus:
                addExpression("-", false);
                break;
            case R.id.btn_times:
                addExpression("*", false);
                break;
            case R.id.btn_split:
                addExpression("/", false);
                break;
            case R.id.btn_power:
                addExpression("^", false);
        }


    }

    public void addExpression(String str, boolean cl_data){
        if (res.getText().equals(""))
            exp.setText(" ");

        if (cl_data) {
            res.setText(" ");
            exp.append(str);
        } else {
            exp.append(res.getText());
            exp.append(str);
            res.setText(" ");
        }


    }

}