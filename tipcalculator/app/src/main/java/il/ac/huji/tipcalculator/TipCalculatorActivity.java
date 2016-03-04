package il.ac.huji.tipcalculator;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;



public class TipCalculatorActivity extends AppCompatActivity {
    double present = 0.12;

    private boolean isEmpty(EditText etText) {

        return etText.getText().toString().trim().length() == 0;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        EditText priceField = (EditText)findViewById(R.id.inputEditText);
        if(!isEmpty(priceField)){
            double price = Double.parseDouble(priceField.getText().toString());

            displayClculateTip(price);
        }
        else {
            displayClculateTip(0);
        }
    }

    public void displayClculateTip(double price){
        Log.w("myApp", "in display" + String.valueOf(price));

        CheckBox isChacked = (CheckBox) findViewById(R.id.notify_me_checkbox);
        TextView quantityTextView = (TextView) findViewById(
                R.id.summary_text_view);
        double value = price * present;
        if(isChacked.isChecked()){
            quantityTextView.setText("Tip: " + NumberFormat.getCurrencyInstance().format((int) (value)));
        }
        else{
            quantityTextView.setText("Tip: " + NumberFormat.getCurrencyInstance().format(value));
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tip_calculator, menu);
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
}

