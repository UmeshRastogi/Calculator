package utils.milestone.spotcues.com.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity implements OnItemSelectedListener, AddClickListener {
    EditText num1, num2;
    Button eql_btn;
    TextView ans;
    Spinner option;
    String[] ops={" ","+","-","*","/"};
    String opselected;
    Integer a, b, c;
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mRecyclerAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<RecyclerData> myList = new ArrayList<>();
    String numb1 = "",numb2 = "",opsn="",ansr="";

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

            RecyclerData mLog = new RecyclerData();
            mLog.setNumbr(num1);
            mLog.setNumbr(num2);
            myList.add(mLog);
            mRecyclerAdapter.notifyData(myList);
            num1.setText("");
            num2.setText("");

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.recycler);
        mRecyclerAdapter= new RecyclerAdapter(myList,this);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mRecyclerAdapter);

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
    @Override
    public void onAddClick(int index){
        myList.add(index);
        mRecyclerAdapter.notifyData(myList);
    }
}
