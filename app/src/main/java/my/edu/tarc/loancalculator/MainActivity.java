package my.edu.tarc.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private EditText price, downpayment, repayment, salary, interest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateLoan(View v) {

        result = (TextView) findViewById(R.id.result);
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

        if(monthPayment > (Salary * 0.3)) {
            result.setText(getString(R.string.reject));
        } else {
            result.setText(getString(R.string.accept));
        }


    }
}
