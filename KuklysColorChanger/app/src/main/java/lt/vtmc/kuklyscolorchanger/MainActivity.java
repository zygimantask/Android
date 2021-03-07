package lt.vtmc.kuklyscolorchanger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout pirmasVaizdas;
    private LinearLayout antrasVaizdas;
    private LinearLayout treciasVaizdas;
    private LinearLayout ketvirtasVaizdas;

    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pirmasVaizdas = findViewById(R.id.pirmasVaizdas);
        antrasVaizdas = findViewById(R.id.antrasVaizdas);
        treciasVaizdas = findViewById(R.id.treciasVaizdas);
        ketvirtasVaizdas = findViewById(R.id.ketvirtasVaizdas);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pirmasVaizdas.setBackgroundResource(R.color.green);
                        antrasVaizdas.setBackgroundResource(R.color.white);
                        treciasVaizdas.setBackgroundResource(R.color.white);
                        ketvirtasVaizdas.setBackgroundResource(R.color.white);
                        text1.setText(R.string.textGreen);
                        text2.setText("");
                        text3.setText("");
                        text4.setText("");
                    }
                });
                break;
            case R.id.button2:
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pirmasVaizdas.setBackgroundResource(R.color.white);
                        antrasVaizdas.setBackgroundResource(R.color.blue);
                        treciasVaizdas.setBackgroundResource(R.color.white);
                        ketvirtasVaizdas.setBackgroundResource(R.color.white);
                        text1.setText("");
                        text2.setText(R.string.textBlue);
                        text3.setText("");
                        text4.setText("");
                    }
                });
                break;
            case R.id.button3:
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pirmasVaizdas.setBackgroundResource(R.color.white);
                        antrasVaizdas.setBackgroundResource(R.color.white);
                        treciasVaizdas.setBackgroundResource(R.color.red);
                        ketvirtasVaizdas.setBackgroundResource(R.color.white);
                        text1.setText("");
                        text2.setText("");
                        text3.setText(R.string.textRed);
                        text4.setText("");
                    }
                });
                break;
            case R.id.button4:
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pirmasVaizdas.setBackgroundResource(R.color.white);
                        antrasVaizdas.setBackgroundResource(R.color.white);
                        treciasVaizdas.setBackgroundResource(R.color.white);
                        ketvirtasVaizdas.setBackgroundResource(R.color.yellow);
                        text1.setText("");
                        text2.setText("");
                        text3.setText("");
                        text4.setText(R.string.textYellow);
                    }
                });
                break;

        }
    }
}