package my.edu.tarc.loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    public static final String DOWNPAYMENT = "MainActivity.DOWNPAYMENT";
    public static final String LOANPERIOD = "MainActivity.LOANPERIOD";
    public static final String INTEREST = "MainActivity.INTEREST";
    public static final String MONTHREPAYMENT = "MainActivity.MONTHREPAYMENT";
    public static final String RESULT = "MainActivity.RESULT";
    private EditText price, downpayment, repayment, salary, interest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateLoan(View v) {

        price = (EditText) findViewById(R.id.price);
        downpayment = (EditText) findViewById(R.id.downpayment);
        repayment = (EditText) findViewById(R.id.repayment);
        salary = (EditText) findViewById(R.id.salary);
        interest = (EditText) findViewById(R.id.interest);

        double Price = Double.parseDouble(price.getText().toString());
        double Downpayment = Double.parseDouble(downpayment.getText().toString());
        double Salary = Double.parseDouble(salary.getText().toString());
        double Repayment = Double.parseDouble(repayment.getText().toString());
        double Interest = Double.parseDouble(interest.getText().toString()) / 100;

        double totalInterest = (Price - Downpayment) * Interest * (Repayment / 12);
        double totalLoan = (Price - Downpayment) + totalInterest;
        double monthPayment = totalLoan / Repayment;

        String result = "";

        if(monthPayment > (Salary * 0.3)) {
            result = (getString(R.string.reject));
        } else {
            result = (getString(R.string.accept));
        }


        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(DOWNPAYMENT, Downpayment);
        intent.putExtra(LOANPERIOD, Repayment);
        intent.putExtra(INTEREST, Interest);
        intent.putExtra(MONTHREPAYMENT, monthPayment);
        intent.putExtra(RESULT, result);

        startActivity(intent);

    }
}
