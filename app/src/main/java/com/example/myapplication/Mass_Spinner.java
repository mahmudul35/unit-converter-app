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


public class Mass_Spinner extends AppCompatActivity {
    private ImageView backArrow;
    private TextInputEditText input;
    private AutoCompleteTextView out;
    private MaterialButton btn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    String[] mass;
    String[] mass1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass_spinner);
        getWindow().setStatusBarColor(ContextCompat.getColor(Mass_Spinner.this, R.color.yellow));

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

        mass=getResources().getStringArray(R.array.Mass);
        mass1=getResources().getStringArray(R.array.Mass1);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.sample_view,R.id.textViewSampleId,mass);
        ArrayAdapter<String> adapter1=new ArrayAdapter<>(this,R.layout.sample_view,R.id.textViewSampleId,mass1);
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
                        Toast.makeText(Mass_Spinner.this, "please select an item", Toast.LENGTH_SHORT).show();

                    }

                    else if(value.equals("Centigram") && value1.equals("Centigram"))
                    {
                        result=amount;
                        out.setText(""+result);

                    }

                    else if(value.equals("Centigram") && value1.equals("Dyne"))
                    {
                        result=(amount*9.80);
                        out.setText(""+result);
                    }

                    else if(value.equals("Centigram") && value1.equals("Gram"))
                    {
                        result=amount*0.01;
                        out.setText(""+result);
                    }

                    else if(value.equals("Centigram") && value1.equals("Kilogram"))
                    {
                        result=amount/100000;
                        out.setText(""+result);
                    }

                    else if(value.equals("Centigram") && value1.equals("Miligram"))
                    {
                        result= amount*10;
                        out.setText(""+result);
                    }

                    else if(value.equals("Centigram") && value1.equals("Microgram"))
                    {
                        result=amount*10000;
                        out.setText(""+result);
                    }
                    else if(value.equals("Centigram") && value1.equals("Pound"))
                    {
                        result=amount/45360;
                        out.setText(""+result);
                    }else if(value.equals("Centigram") && value1.equals("Ounce"))
                    {
                        result=amount/2835;
                        out.setText(""+result);
                    }


                    //cal dyne

                    else if(value.equals("Dyne") && value1.equals("Dyne"))
                    {
                        result=amount;
                        out.setText(""+result);
                    }else if(value.equals("Dyne") && value1.equals("Centigram"))
                    {
                        result=amount*.101;
                        out.setText(""+result);
                    }else if(value.equals("Dyne") && value1.equals("Gram"))
                    {
                        result=amount*.0010;
                        out.setText(""+result);
                    }else if(value.equals("Dyne") && value1.equals("Kilogram"))
                    {
                        result=amount/980392.15;
                        out.setText(""+result);
                    }else if(value.equals("Dyne") && value1.equals("Miligram"))
                    {
                        result=amount*1.019;
                        out.setText(""+result);
                    }else if(value.equals("Dyne") && value1.equals("Microgram"))
                    {
                        result=amount*1019.71;
                        out.setText(""+result);
                    }else if(value.equals("Dyne") && value1.equals("Pound"))
                    {
                        result=amount/444800;
                        out.setText(""+result);
                    }else if(value.equals("Dyne") && value1.equals("Ounce"))
                    {
                        result=amount/27801;
                        out.setText(""+result);;
                    }


                    //gram convert
                    else if(value.equals("Gram") && value1.equals("Gram"))
                    {
                        result=amount;
                        out.setText(""+result);
                    }
                    else if(value.equals("Gram") && value1.equals("Centigram"))
                    {
                        result=amount*100;
                        out.setText(""+result);
                    }else if(value.equals("Gram") && value1.equals("Dyne"))
                    {
                        result=amount*980.66;
                        out.setText(""+result);
                    }

                    else if(value.equals("Gram") && value1.equals("Kilogram"))
                    {
                        result=amount*.001;
                        out.setText(""+result);
                    }else if(value.equals("Gram") && value1.equals("Miligram"))
                    {
                        result=amount*1000;
                        out.setText(""+result);
                    }else if(value.equals("Gram") && value1.equals("Microgram"))
                    {
                        result=amount*1000000;
                        out.setText(""+result);
                    }else if(value.equals("Gram") && value1.equals("Pound"))
                    {
                        result=amount*.0027;
                        out.setText(""+result);
                    }else if(value.equals("Gram") && value1.equals("Ounce"))
                    {
                        result=amount*.0352;
                        out.setText(""+result);
                    }
                    //Kilogram convert

                    else if(value.equals("Kilogram") && value1.equals("Kilogram"))
                    {
                        result=amount;
                        out.setText(""+result);
                    }else if(value.equals("Kilogram") && value1.equals("Centigram"))
                    {
                        result=amount*100000;
                        out.setText(""+result);
                    }else if(value.equals("Kilogram") && value1.equals("Dyne"))
                    {
                        result=amount*980665;
                        out.setText(""+result);
                    }else if(value.equals("Kilogram") && value1.equals("Gram"))
                    {
                        result=amount*1000;
                        out.setText(""+result);
                    }else if(value.equals("Kilogram") && value1.equals("Miligram"))
                    {
                        result=amount*1000000;
                        out.setText(""+result);
                    }


                    else if(value.equals("Kilogram") && value1.equals("Microgram"))
                    {
                        result=amount*100000000;
                        out.setText(""+result);
                    }

                    else if(value.equals("Kilogram") && value1.equals("Pound"))
                    {
                        result=amount*2.67;
                        out.setText(""+result);
                    }else if(value.equals("Kilogram") && value1.equals("Ounce"))
                    {
                        result=amount*35.27;
                        out.setText(""+result);
                    }


                    //Miligram  CONVERT
                    else if(value.equals("Miligram") && value1.equals("Miligram"))
                    {
                        result=amount;
                        out.setText(""+result);
                    }else if(value.equals("Miligram") && value1.equals("Centigram"))
                    {
                        result=amount*.099;
                        out.setText(""+result);
                    }else if(value.equals("Miligram") && value1.equals("Dyne"))
                    {
                        result=amount*.98;
                        out.setText(""+result);
                    }else if(value.equals("Miligram") && value1.equals("Gram"))
                    {
                        result=amount*.001;
                        out.setText(""+result);
                    }else if(value.equals("Miligram") && value1.equals("Kilogram"))
                    {
                        result=amount/1000000;
                        out.setText(""+result);
                    }else if(value.equals("Miligram") && value1.equals("Microgram"))
                    {
                        result=amount*1000;
                        out.setText(""+result);
                    }else if(value.equals("Miligram") && value1.equals("Pound"))
                    {
                        result=amount/453600;
                        out.setText(""+result);
                    }else if(value.equals("Miligram") && value1.equals("Ounce"))
                    {
                        result=amount/28350;
                        out.setText(""+result);
                    }
                    //Microgram  CONVERT
                    else if(value.equals("Microgram") && value1.equals("Microgram"))
                    {
                        result=amount;
                        out.setText(""+result);
                    }else if(value.equals("Microgram") && value1.equals("Centigram"))
                    {
                        result=amount/10000;
                        out.setText(""+result);
                    }else if(value.equals("Microgram") && value1.equals("Dyne"))
                    {
                        result=amount/1019.71;
                        out.setText(""+result);
                    }else if(value.equals("Microgram") && value1.equals("Gram"))
                    {
                        result=amount/1000000;
                        out.setText(""+result);
                    }else if(value.equals("Microgram") && value1.equals("Kilogram"))
                    {
                        result=amount/100000000;
                        out.setText(""+result);
                    }else if(value.equals("Microgram") && value1.equals("Miligram"))
                    {
                        result=amount*.001;
                        out.setText(""+result);
                    }else if(value.equals("Microgram") && value1.equals("Pound"))
                    {
                        result=amount/453592370;
                        out.setText(""+result);
                    }else if(value.equals("Microgram") && value1.equals("Ounce"))
                    {
                        result=amount/352739619;
                        out.setText(""+result);
                    }

                    //pound DOLLAR CONVERT
                    else if(value.equals("Pound") && value1.equals("Pound"))
                    {
                        result=amount;
                        out.setText(""+result);
                    }
                    else if(value.equals("Pound") && value1.equals("Centigram"))
                    {
                        result=amount*37324.17;
                        out.setText(""+result);
                    }else if(value.equals("Pound") && value1.equals("Dyne"))
                    {
                        result=amount*366025.09;
                        out.setText(""+result);
                    }else if(value.equals("Pound") && value1.equals("Gram"))
                    {
                        result=amount*373.24;
                        out.setText(""+result);
                    }else if(value.equals("Pound") && value1.equals("Kilogram"))
                    {
                        result=amount*.373;
                        out.setText(""+result);
                    }else if(value.equals("Pound") && value1.equals("Miligram"))
                    {
                        result=amount*373241.72;
                        out.setText(""+result);
                    }else if(value.equals("Pound") && value1.equals("Microgram"))
                    {
                        result=amount*453592370;
                        out.setText(""+result);
                    }else if(value.equals("Pound") && value1.equals("Ounce"))
                    {
                        result=amount*13.16;
                        out.setText(""+result);
                    }


                    //ounce  CONVERT
                    else if(value.equals("Ounce") && value1.equals("Ounce"))
                    {
                        result=amount;
                        out.setText(""+result);
                    }else if(value.equals("Ounce") && value1.equals("Centigram"))
                    {
                        result=amount*2834.95;
                        out.setText(""+result);
                    }else if(value.equals("Ounce") && value1.equals("Dyne"))
                    {
                        result=amount*27801.38;
                        out.setText(""+result);
                    }else if(value.equals("Ounce") && value1.equals("Gram"))
                    {
                        result=amount*28.34;
                        out.setText(""+result);
                    }else if(value.equals("Ounce") && value1.equals("Kilogram"))
                    {
                        result=amount*.028;
                        out.setText(""+result);
                    }else if(value.equals("Ounce") && value1.equals("Miligram"))
                    {
                        result=amount*28349.52;
                        out.setText(""+result);
                    }else if(value.equals("Ounce") && value1.equals("Microgram"))
                    {
                        result=amount*352739619;
                        out.setText(""+result);
                    }else if(value.equals("Ounce") && value1.equals("Pound"))
                    {
                        result=amount*.075;
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
                    Toast.makeText(Mass_Spinner.this, "Invalid Choice", Toast.LENGTH_SHORT).show();
                }
            }});

    }
}