package utils.milestone.spotcues.com.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemSelectedListener {
    EditText num1, num2;
    Button eql_btn;
    TextView ans;
    Spinner option;
    String[] ops={" ","+","-","*","/"};
    String opselected;
    Integer a, b, c;
    private OnClickListener clickListener = new OnClickListener() {
        public void onClick(View v) {
            a = Integer.parseInt(num1.getText().toString());
            b = Integer.parseInt(num2.getText().toString());
            if (opselected == "+") {
                c = a + b;
                ans.setText(Integer.toString(c));
            } else if (opselected == "-") {
                c = a - b;
                ans.setText(Integer.toString(c));
            } else if (opselected == "*") {
                c = a * b;
                ans.setText(Integer.toString(c));
            } else if (opselected == "/") {
                c = a / b;
                ans.setText(Integer.toString(c));
            } else {
                ans.setText(" ");
            }
            //ans = (TextView)findViewById(R.id.ans);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ans=(TextView)findViewById(R.id.ans);
        eql_btn=(Button)findViewById(R.id.eql_btn);
        eql_btn.setText("=");
        eql_btn.setOnClickListener(clickListener);

        num1 = (EditText)findViewById(R.id.num1);
        num1.setText("");
        num2 = (EditText)findViewById(R.id.num2);
        num2.setText("");

        option = (Spinner)findViewById(R.id.option);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ops);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        option.setAdapter(dataAdapter);
        option.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        opselected=ops[position];
        String optn = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub

    }
}
