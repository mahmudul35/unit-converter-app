package com.example.myapplication;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

import java.text.DecimalFormat;


public class Currency_Spinner extends AppCompatActivity {
    private ImageView backArrow;
    private TextInputEditText input;
    private AutoCompleteTextView out;
    private MaterialButton btn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    String[] currency;
    String[] currency1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_spinner);
        getWindow().setStatusBarColor(ContextCompat.getColor(Currency_Spinner.this, R.color.yellow));

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

        currency=getResources().getStringArray(R.array.currency);
        currency1=getResources().getStringArray(R.array.currency1);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.sample_view,R.id.textViewSampleId,currency);
        ArrayAdapter<String> adapter1=new ArrayAdapter<>(this,R.layout.sample_view,R.id.textViewSampleId,currency1);
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
                    if(value.equals("") || value1.equals(""))
                    {
                        Toast.makeText(Currency_Spinner.this, "please select an item", Toast.LENGTH_SHORT).show();

                    }

                    else if(value.equals("BDT") && value1.equals("BDT"))
                    {
                        result=amount;
                        out.setText(""+result);

                    }

                    else if(value.equals("BDT") && value1.equals("AUD"))
                    {
                        result=(amount*.0133);
                        out.setText(""+result);
                    }

                    else if(value.equals("BDT") && value1.equals("CAD"))
                    {
                        result=amount*0.0129;
                        out.setText(""+result);
                    }

                    else if(value.equals("BDT") && value1.equals("EUR"))
                    {
                        result=amount*.00896;
                        out.setText(""+result);
                    }

                    else if(value.equals("BDT") && value1.equals("INR"))
                    {
                        result= amount*.791;
                        out.setText(""+result);
                    }

                    else if(value.equals("BDT") && value1.equals("RUB"))
                    {
                        result=amount*.672;
                        out.setText(""+result);
                    }
                    else if(value.equals("BDT") && value1.equals("SGD"))
                    {
                        result=amount*.0129;
                        out.setText(""+result);
                    }else if(value.equals("BDT") && value1.equals("USD"))
                    {
                        result=amount*.00954;
                        out.setText(""+result);
                    }else if(value.equals("AUD") && value1.equals("AUD"))
                    {
                        result=amount;
                        out.setText(""+result);
                    }else if(value.equals("AUD") && value1.equals("BDT"))
                    {
                        result=amount*75.2;
                        out.setText(""+result);
                    }else if(value.equals("AUD") && value1.equals("CAD"))
                    {
                        result=amount*.945;
                        out.setText(""+result);
                    }else if(value.equals("AUD") && value1.equals("EUR"))
                    {
                        result=amount*.653;
                        out.setText(""+result);
                    }else if(value.equals("AUD") && value1.equals("INR"))
                    {
                        result=amount*57.9;
                        out.setText(""+result);
                    }else if(value.equals("AUD") && value1.equals("RUB"))
                    {
                        result=amount*49.54;
                        out.setText(""+result);
                    }else if(value.equals("AUD") && value1.equals("SGD"))
                    {
                        result=amount*.933;
                        out.setText(""+result);
                    }else if(value.equals("AUD") && value1.equals("USD"))
                    {
                        result=amount*.71;
                        out.setText(""+result);
                    }


                    //CANADIAN DOLLar convert
                    else if(value.equals("CAD") && value1.equals("CAD"))
                    {
                        result=amount;
                        out.setText(""+result);
                    }
                    else if(value.equals("CAD") && value1.equals("BDT"))
                    {
                        result=amount*79.55;
                        out.setText(""+result);
                    }else if(value.equals("CAD") && value1.equals("AUD"))
                    {
                        result=amount*1.06;
                        out.setText(""+result);
                    }

                    else if(value.equals("CAD") && value1.equals("EUR"))
                    {
                        result=amount*.691;
                        out.setText(""+result);
                    }else if(value.equals("CAD") && value1.equals("INR"))
                    {
                        result=amount*61.25;
                        out.setText(""+result);
                    }else if(value.equals("CAD") && value1.equals("RUB"))
                    {
                        result=amount*52.4;
                        out.setText(""+result);
                    }else if(value.equals("CAD") && value1.equals("SGD"))
                    {
                        result=amount*.986;
                        out.setText(""+result);
                    }else if(value.equals("CAD") && value1.equals("USD"))
                    {
                        result=amount*.751;
                        out.setText(""+result);
                    }
                    //euro convert

                    else if(value.equals("EUR") && value1.equals("EUR"))
                    {
                        result=amount;
                        out.setText(""+result);
                    }else if(value.equals("EUR") && value1.equals("BDT"))
                    {
                        result=amount*115;
                        out.setText(""+result);
                    }else if(value.equals("EUR") && value1.equals("AUD"))
                    {
                        result=amount*1.53;
                        out.setText(""+result);
                    }else if(value.equals("EUR") && value1.equals("CAD"))
                    {
                        result=amount*1.45;
                        out.setText(""+result);
                    }else if(value.equals("EUR") && value1.equals("INR"))
                    {
                        result=amount*88.6;
                        out.setText(""+result);
                    }


                    else if(value.equals("EUR") && value1.equals("RUB"))
                    {
                        result=amount*75.81;
                        out.setText(""+result);
                    }

                    else if(value.equals("EUR") && value1.equals("SGD"))
                    {
                        result=amount*1.43;
                        out.setText(""+result);
                    }else if(value.equals("EUR") && value1.equals("USD"))
                    {
                        result=amount*1.09;
                        out.setText(""+result);
                    }
                    //INDIAIN RUPPEE CONVERT
                    else if(value.equals("INR") && value1.equals("INR"))
                    {
                        result=amount;
                        out.setText(""+result);
                    }else if(value.equals("INR") && value1.equals("BDT"))
                    {
                        result=amount*1.3;
                        out.setText(""+result);
                    }else if(value.equals("INR") && value1.equals("AUD"))
                    {
                        result=amount*.0172;
                        out.setText(""+result);
                    }else if(value.equals("INR") && value1.equals("CAD"))
                    {
                        result=amount*.0163;
                        out.setText(""+result);
                    }else if(value.equals("INR") && value1.equals("EUR"))
                    {
                        result=amount*.0113;
                        out.setText(""+result);
                    }else if(value.equals("INR") && value1.equals("RUB"))
                    {
                        result=amount*.856;
                        out.setText(""+result);
                    }else if(value.equals("INR") && value1.equals("SGD"))
                    {
                        result=amount*.0161;
                        out.setText(""+result);
                    }else if(value.equals("INR") && value1.equals("USD"))
                    {
                        result=amount*.0123;
                        out.setText(""+result);
                    }
                    //RUSSIAN BUBLE CONVERT
                    else if(value.equals("RUB") && value1.equals("RUB"))
                    {
                        result=amount;
                        out.setText(""+result);
                    }else if(value.equals("RUB") && value1.equals("BDT"))
                    {
                        result=amount*1.52;
                        out.setText(""+result);
                    }else if(value.equals("RUB") && value1.equals("AUD"))
                    {
                        result=amount*.0201;
                        out.setText(""+result);
                    }else if(value.equals("RUB") && value1.equals("CAD"))
                    {
                        result=amount*.0191;
                        out.setText(""+result);
                    }else if(value.equals("RUB") && value1.equals("EUR"))
                    {
                        result=amount*.0132;
                        out.setText(""+result);
                    }else if(value.equals("RUB") && value1.equals("INR"))
                    {
                        result=amount*1.17;
                        out.setText(""+result);
                    }else if(value.equals("RUB") && value1.equals("SGD"))
                    {
                        result=amount*.0188;
                        out.setText(""+result);
                    }else if(value.equals("RUB") && value1.equals("USD"))
                    {
                        result=amount*.0143;
                        out.setText(""+result);
                    }

                    //SINGAPORE DOLLAR CONVERT
                    else if(value.equals("SGD") && value1.equals("SGD"))
                    {
                        result=amount;
                        out.setText(""+result);
                    }else if(value.equals("SGD") && value1.equals("BDT"))
                    {
                        result=amount*80.58;
                        out.setText(""+result);
                    }else if(value.equals("SGD") && value1.equals("AUD"))
                    {
                        result=amount*1.07;
                        out.setText(""+result);
                    }else if(value.equals("SGD") && value1.equals("CAD"))
                    {
                        result=amount*1.01;
                        out.setText(""+result);
                    }else if(value.equals("SGD") && value1.equals("EUR"))
                    {
                        result=amount*.701;
                        out.setText(""+result);
                    }else if(value.equals("SGD") && value1.equals("INR"))
                    {
                        result=amount*62.08;
                        out.setText(""+result);
                    }else if(value.equals("SGD") && value1.equals("RUB"))
                    {
                        result=amount*53.12;
                        out.setText(""+result);
                    }else if(value.equals("SGD") && value1.equals("USD"))
                    {
                        result=amount*.762;
                        out.setText(""+result);
                    }


                    //AMERICAN DOLLAR CONVERT
                    else if(value.equals("USD") && value1.equals("USD"))
                    {
                        result=amount;
                        out.setText(""+result);
                    }else if(value.equals("USD") && value1.equals("BDT"))
                    {
                        result=amount*105;
                        out.setText(""+result);
                    }else if(value.equals("USD") && value1.equals("AUD"))
                    {
                        result=amount*1.4;
                        out.setText(""+result);
                    }else if(value.equals("USD") && value1.equals("CAD"))
                    {
                        result=amount*1.33;
                        out.setText(""+result);
                    }else if(value.equals("USD") && value1.equals("EUR"))
                    {
                        result=amount*.92;
                        out.setText(""+result);
                    }else if(value.equals("USD") && value1.equals("INR"))
                    {
                        result=amount*81.51;
                        out.setText(""+result);
                    }else if(value.equals("USD") && value1.equals("RUB"))
                    {
                        result=amount*69.75;
                        out.setText(""+result);
                    }else if(value.equals("USD") && value1.equals("SGD"))
                    {
                        result=amount*1.31;
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


                }catch(Exception e)
                {
                    Toast.makeText(Currency_Spinner.this, "Invalid Choice", Toast.LENGTH_SHORT).show();
                }




        }});
    }
}

