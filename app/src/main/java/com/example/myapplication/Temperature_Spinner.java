package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Temperature_Spinner extends AppCompatActivity {
    private ImageView backArrow;
    private TextInputEditText input;
    private AutoCompleteTextView out;
    private MaterialButton btn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    String[] temperature;
    String[] temperature1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_spinner);
        getWindow().setStatusBarColor(ContextCompat.getColor(Temperature_Spinner.this, R.color.yellow));

        input=(TextInputEditText) findViewById(R.id.Input);
        out=(AutoCompleteTextView) findViewById(R.id.output);
        btn=(MaterialButton) findViewById(R.id.convertBtn);

        backArrow=findViewById(R.id.arrowBackId);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),NavigationBarView.class);
                startActivity(intent);
            }
        });

        temperature=getResources().getStringArray(R.array.temper);
        temperature1=getResources().getStringArray(R.array.temper1);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.sample_view,R.id.textViewSampleId,temperature);
        ArrayAdapter<String> adapter1=new ArrayAdapter<>(this,R.layout.sample_view,R.id.textViewSampleId,temperature1);
        AutoCompleteTextView autoCompleteTextView=findViewById(R.id.spinnerId);
        AutoCompleteTextView autoCompleteTextView1=findViewById(R.id.spinnerId1);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView1.setThreshold(1);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView1.setAdapter(adapter1);





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

        try{
            String value=autoCompleteTextView.getText().toString();
            String value1=autoCompleteTextView1.getText().toString();
            Double result;
            Double amount=Double.parseDouble(input.getText().toString());
            if(value.equals("Celsius") && value1.equals("Celsius"))
            {
                result=amount;
                out.setText(""+result);
            }

            else if(value.equals("Celsius") && value1.equals("Fahrenheit"))
            {
                result=(amount*9/5)+32;
                out.setText(""+result);
            }else if(value.equals("Celsius") && value1.equals("Kelvin"))
            {
                result=amount+273.15;
                out.setText(""+result);
            }else if(value.equals("Fahrenheit") && value1.equals("Fahrenheit"))
            {
                result=amount;
                out.setText(""+result);
            }else if(value.equals("Fahrenheit") && value1.equals("Celsius"))
            {
                result=(amount-32)*5/9;
                out.setText(""+result);
            }else if(value.equals("Fahrenheit") && value1.equals("Kelvin"))
            {
                result=(amount+459.67)*5/9;
                out.setText(""+result);
            }
            else if(value.equals("Kelvin") && value1.equals("Kelvin"))
            {
                result=amount;
                out.setText(""+result);
            }
            else if(value.equals("Kelvin") && value1.equals("Fahrenheit"))
            {
                result=(amount-273.15)*9/5+32;
                out.setText(""+result);
            }
            else if(value.equals("Kelvin") && value1.equals("Celsius"))
            {
                result=amount-273.15;
                out.setText(""+result);
            }

            //firebase

            String Fvalue = autoCompleteTextView.getText().toString();
            String Tvalue1 = autoCompleteTextView1.getText().toString();

            if(!(Fvalue.equals("")|| Tvalue1.equals("")))
            {
                rootNode=FirebaseDatabase.getInstance();
                reference=rootNode.getReference("appData");
                String Calc=out.getText().toString();
                String Edittext=input.getText().toString();

                String calculatedValue="From" +" "+ Edittext+ " "+Fvalue+ " "+" To"+" "+Tvalue1+" "+"="+" "+Calc;
                String key=reference.push().getKey();
                StoringAppData storingAppData=new StoringAppData(calculatedValue);
                reference.child(key).setValue(storingAppData);

            }

        }
        catch (Exception e)
        {
            Toast.makeText(Temperature_Spinner.this, "Invalid Choice", Toast.LENGTH_SHORT).show();
        }

            }
        });


    }
}