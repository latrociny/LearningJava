/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.example.android.justjava.R;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String priceText = createOrderSummary(quantity);
        displayMessage(priceText);
    }

    /** This feeds in the string to be output to the submitOrder method
     * I did it differently, since I take in quantity and return the whole summary
     * The solution takes in price and outputs the order summary, while still calling the calculatePrice method
     * @return whole shebang
     *
     */
    private String createOrderSummary (int quantity) {
        int price = quantity * 5;
        String naam = "Name: Keshav";
        return naam + "\n" + "Quantity: " + quantity + "\n" + "Total: $ " + price + "\nThank you!";
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }
    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }

    //To show if the check box was checked on not
    //Example:
//        boolean mybool;
//        if (faculty.isChecked()) {
//            mybool = true;
//
//        } else {
//            mybool = false;

    public void indicateBoxChecked(View v) {
        CheckBox whippedCreamCheckBox = findViewById(R.id.whippedCreamCheckBox);
        boolean checked = whippedCreamCheckBox.isChecked();
        Log.v(TAG, "Checkbox value is " + checked );
        }

    /** This is another way of implementing the above

        public void indicateBoxChecked(View v) {
        CheckBox whippedCreamCheckBox = (CheckBox) v;
        boolean checked = whippedCreamCheckBox.isChecked();
        Log.v(TAG, "Checkbox value is " + checked );
    }
*/

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method sets the message from the submitOrder method on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    // ****These are not used anymore*********

    /**
     * Calculates the price of the order.
     * @return total price

    private int calculatePrice() {
        return quantity * 7;
    }
     */
    /**
     * This method displays the given price on the screen.

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
     */
}