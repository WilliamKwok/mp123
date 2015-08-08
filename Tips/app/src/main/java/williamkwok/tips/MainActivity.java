package williamkwok.tips;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Properties;



public class MainActivity extends Activity implements OnClickListener{

    Button buttontip12;
    Button buttontip15;
    Button buttontip20;
    EditText amountText;
    TextView calculatedAmount;
    String calculatedString;
    double amountEntered;
    double tipAmount;
    //GradientDrawable background12, background15, background20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttontip12 = (Button)findViewById(R.id.tip12);
        buttontip15 = (Button)findViewById(R.id.tip15);
        buttontip20 = (Button)findViewById(R.id.tip20);
        amountText = (EditText)findViewById(R.id.amountText);
        calculatedAmount = (TextView)findViewById(R.id.calculatedAmount);

        buttontip12.setOnClickListener(this);
        buttontip15.setOnClickListener(this);
        buttontip20.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view){
        resetColors();
        String amountString = amountText.getText().toString();

        if(amountString == null || amountString.isEmpty()) {
            amountEntered = 0;
        }
        else {
            amountEntered = Double.parseDouble(amountString);
        }
        switch(view.getId()){
            case R.id.tip12:
                tipAmount = amountEntered * 1.12;
                buttontip12.setBackgroundColor(0xFFFFAD5C);
                break;
            case R.id.tip15:
                tipAmount = amountEntered * 1.15;
                buttontip15.setBackgroundColor(0xFFFFAD5C);
                break;
            case R.id.tip20:
                tipAmount = amountEntered * 1.20;
                buttontip20.setBackgroundColor(0xFFFFAD5C);
                break;
            default:
                break;
        }

        tipAmount = Math.round(tipAmount * 100.0) / 100.0;
        calculatedString = String.format("%.2f",tipAmount);
        calculatedAmount.setText(calculatedString);
        return;
    }

    public void resetColors(){
        buttontip12.setBackgroundResource(android.R.drawable.btn_default);
        buttontip15.setBackgroundResource(android.R.drawable.btn_default);
        buttontip20.setBackgroundResource(android.R.drawable.btn_default);
    }
}
