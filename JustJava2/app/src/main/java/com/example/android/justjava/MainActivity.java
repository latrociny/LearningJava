/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;



import android.content.Intent;
import android.net.Uri;
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
    //lower bound/default value of coffee is always 2
    int quantity = 2;
    boolean whippedCreamQ;
    boolean chocolateQ;
    private String name;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**order_summary_text_view
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String priceText = createOrderSummary(quantity, whippedCreamQ, chocolateQ);
        displayMessage(priceText);
    }

    /** This feeds in the string to be output to the submitOrder method
     * I did it differently, since I take in quantity and return the whole summary
     * The solution takes in price and outputs the order summary, while still calling the calculatePrice method
     * @return whole shebang
     *
     */
    private String createOrderSummary (int quantity, boolean whippedCreamQ, boolean chocolateQ) {
        int pricePerCoffee = 5;
        int pricePerWhippedCream = 1;
        int pricePerChocolate = 2;
        int whippedCreamNr = whippedCreamQ ? 1 : 0;
        int chocolateNr = chocolateQ ? 1 : 0;
        int totalPrice = quantity * (pricePerCoffee + (pricePerWhippedCream * whippedCreamNr)
                + (pricePerChocolate * chocolateNr));
        return name + "\n" + "Add whipped cream? " + whippedCreamQ +  "\n" +
                 "Add chocolate? " + chocolateQ +  "\n" +
                "Quantity: " + quantity + "\n" + "Total: $ " + totalPrice + "\nThank you!";
    }

    /**
     * This method sets the message from the submitOrder method on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        if (quantity >= 100) {
            Toast.makeText(getApplicationContext(),"Cannot order more than " +
                    "100 coffees",Toast.LENGTH_SHORT).show();
        } else {
            quantity = quantity + 1;
            displayQuantity(quantity);
        }
    }
    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        if (quantity <= 1) {
            Toast.makeText(getApplicationContext(),"Cannot order less than " +
                    "1 coffee",Toast.LENGTH_SHORT).show();
//            Equivalent is to use this instead of getApplicationContext
//             Toast.makeText(this,"Cannot order less than " +
//                    "1 coffee",Toast.LENGTH_SHORT).show();
        } else {
            quantity = quantity - 1;
            displayQuantity(quantity);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    public void userInputs (View v) {
        CheckBox whippedCreamCheckBox = findViewById(R.id.whippedCreamCheckBox);
        CheckBox chocolateCheckBox = findViewById(R.id.chocolateCheckBox);
        TextView nameView = findViewById(R.id.name);

        name = nameView.getText().toString();
        whippedCreamQ = whippedCreamCheckBox.isChecked();
        chocolateQ = chocolateCheckBox.isChecked();

        //Log.v(TAG, "Checkbox value is " + checked );
        }

    /** This is another way of implementing the above

        public void indicateBoxChecked(View v) {
        CheckBox whippedCreamCheckBox = (CheckBox) v;
        boolean checked = whippedCreamCheckBox.isChecked();
        Log.v(TAG, "Checkbox value is " + checked );
    }
*/




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

//To show if the check box was checked on not
//Example:
//        boolean mybool;
//        if (faculty.isChecked()) {
//            mybool = true;
//
//        } else {
//            mybool = false;