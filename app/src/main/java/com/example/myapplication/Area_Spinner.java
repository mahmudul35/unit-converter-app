package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;

public class Area_Spinner extends AppCompatActivity {
    private ImageView backArrow;
    private TextInputEditText input;
    private AutoCompleteTextView out;
    private MaterialButton btn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    String[] area;
    String[] area1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_spinner);
        getWindow().setStatusBarColor(ContextCompat.getColor(Area_Spinner.this, R.color.yellow));

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

        area=getResources().getStringArray(R.array.area);
        area1=getResources().getStringArray(R.array.area1);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.sample_view,R.id.textViewSampleId,area);
        ArrayAdapter<String> adapter1=new ArrayAdapter<>(this,R.layout.sample_view,R.id.textViewSampleId,area1);
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
                        Toast.makeText(Area_Spinner.this, "please select an item", Toast.LENGTH_SHORT).show();

                    }
                    else if(value.equals("Square CM") && value1.equals("Square CM"))
                    {
                        result=amount;
                        out.setText(""+result);
                    }

                    else if(value.equals("Square CM") && value1.equals("Square DM"))
                    {
                        result=(amount*.01);
                        out.setText(""+result);
                    }else if(value.equals("Square CM") && value1.equals("Square foot"))
                    {
                        result=amount*.0010;
                        out.setText(""+result);
                    }else if(value.equals("Square CM") && value1.equals("Square M"))
                    {
                        result=amount/10000;
                        out.setText(""+result);
                    }else if(value.equals("Square CM") && value1.equals("Square Km"))
                    {
                        result= amount/1000000000;
                        out.setText(""+result);
                    }
                    //calculating
                    else if(value.equals("Square DM") && value1.equals("Square DM"))
                    {
                        result=amount;
                        out.setText(""+result);
                    }
                    else if(value.equals("Square DM") && value1.equals("Square CM"))
                    {
                        result=amount*100;
                        out.setText(""+result);
                    }
                    else if(value.equals("Square DM") && value1.equals("Square foot"))
                    {
                        result=(amount*.107);
                        out.setText(""+result);
                    }
                    if(value.equals("Square DM") && value1.equals("Square M"))
                    {
                        result=amount*.01;
                        out.setText(""+result);;
                    }else if(value.equals("Square DM") && value1.equals("Square Km"))
                    {
                        result=amount/100000000;
                        out.setText(""+result);
                    }
                    //calculating square foot
                    else if(value.equals("Square foot") && value1.equals("Square foot"))
                    {
                        result=amount;
                        out.setText(""+result);
                    }else if(value.equals("Square foot") && value1.equals("Square CM"))
                    {
                        result=amount*929.03;
                        out.setText(""+result);
                    }else if(value.equals("Square foot") && value1.equals("Square DM"))
                    {
                        result=amount*9.29;
                        out.setText(""+result);
                    }else if(value.equals("Square foot") && value1.equals("Square M"))
                    {
                        result=amount*.092;
                        out.setText(""+result);
                    }else if(value.equals("Square foot") && value1.equals("Square Km"))
                    {
                        result=amount;
                        out.setText(""+result);
                    }else if(value.equals("Square M") && value1.equals("Square M"))
                    {
                        result=amount;
                        out.setText(""+result);
                    }else if(value.equals("Square M") && value1.equals("Square CM"))
                    {
                        result=amount*10000;
                        out.setText(""+result);
                    }else if(value.equals("Square M") && value1.equals("Square DM"))
                    {
                        result=amount*100;
                        out.setText(""+result);
                    }else if(value.equals("Square M") && value1.equals("Square foot"))
                    {
                        result=amount*10.76;
                        out.setText(""+result);
                    }else if(value.equals("Square M") && value1.equals("Square Km"))
                    {
                        result=amount/1000000;
                        out.setText(""+result);
                    }

                    //calculating square meter
                    else if(value.equals("Square Km") && value1.equals("Square Km"))
                    {
                        result=amount;
                        out.setText(""+result);
                    }else if(value.equals("Square Km") && value1.equals("Square CM"))
                    {
                        result=amount*1000000000;
                        out.setText(""+result);
                    }
                    else if(value.equals("Square Km") && value1.equals("Square DM"))
                    {
                        result=amount*100000000;
                        out.setText(""+result);
                    }else if(value.equals("Square Km") && value1.equals("Square foot"))
                    {
                        result=amount-273.15;
                        out.setText(""+result);
                    }else if(value.equals("Square Km") && value1.equals("Square M"))
                    {
                        result=amount*1000000;
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
                    Toast.makeText(Area_Spinner.this, "Invalid Choice", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }


}