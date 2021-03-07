package lt.vtmc.kuklysprecentcounter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.text.InputFilter;
import android.text.Spanned;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    TextView procentuReiksme;
    TextView tipTable, totalTable, resultTable;
    EditText enterNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        procentuReiksme = (TextView) findViewById(R.id.textView);
        tipTable = (TextView) findViewById(R.id.tipTable);
        totalTable = (TextView) findViewById(R.id.totalTable);
        resultTable = (TextView) findViewById(R.id.resultTable);
        enterNumber = (EditText) findViewById(R.id.enterAmount);
        enterNumber.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(11, 2)});
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onStopTrackingTouch(SeekBar bar) {
                try {
                    double num = Double.parseDouble(enterNumber.getText().toString());
                    double value = seekBar.getProgress();
                    double totalPercent = percentTip(num, value);
                    double totalSums = totalSum(num, value);

                    String pirmas = String.format("%.2f", num);
                    String antras = String.format("%.2f", totalPercent);
                    String trecias = String.format("%.2f", totalSums);

                    tipTable.setText(String.format("%.2f", totalPercent));
                    totalTable.setText(String.format("%.2f", totalSums));
                    resultTable.setText("Įvesta suma: " + pirmas + "\n" + "Pritaikyta nuolaida: " + antras + "\n" + "Suma su nuolaida: " + trecias + "");
                } catch (NumberFormatException ignored) {

                }

            }

            public void onProgressChanged(SeekBar bar,
                                          int paramInt, boolean paramBoolean) {
                procentuReiksme.setText("" + paramInt + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

        });

    }

    public double percentTip(double enterNumber, double paramInt) {
        return (double) ((paramInt / 100) * enterNumber);
    }

    public double totalSum(double enterNumber, double paramInt) {
        return (double) (enterNumber - ((paramInt / 100) * enterNumber));
    }

    class DecimalDigitsInputFilter implements InputFilter {
        private Pattern mPattern;

        DecimalDigitsInputFilter(int digitsBeforeZero, int digitsAfterZero) {
            mPattern = Pattern.compile("[0-9]{0," + (digitsBeforeZero - 1) + "}+((\\.[0-9]{0," + (digitsAfterZero - 1) + "})?)||(\\.)?");
        }

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            Matcher matcher = mPattern.matcher(dest);
            if (!matcher.matches())
                return "";
            return null;
        }

    }
}
