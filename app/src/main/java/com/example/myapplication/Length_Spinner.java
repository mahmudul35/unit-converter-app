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
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Length_Spinner extends AppCompatActivity {
    private ImageView backArrow;
    private TextInputEditText input;
    private AutoCompleteTextView out;
    private MaterialButton btn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    String[] length;
    String[] length1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_spinner);
        getWindow().setStatusBarColor(ContextCompat.getColor(Length_Spinner.this, R.color.yellow));

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

        length=getResources().getStringArray(R.array.Length);
        length1=getResources().getStringArray(R.array.Length1);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.sample_view,R.id.textViewSampleId,length);
        ArrayAdapter<String> adapter1=new ArrayAdapter<>(this,R.layout.sample_view,R.id.textViewSampleId,length1);
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
                       Toast.makeText(Length_Spinner.this, "please select an item", Toast.LENGTH_SHORT).show();

                   }
                   else if(value.equals("Centimeter") && value1.equals("Centimeter"))
                   {
                       result=amount;
                       out.setText(""+result);
                   }

                   else if(value.equals("Centimeter") && value1.equals("Decimeter"))
                   {
                       result=(amount*.1);
                       out.setText(""+result);
                   }else if(value.equals("Centimeter") && value1.equals("Foot"))
                   {
                       result=amount/30.48;
                       out.setText(""+result);
                   }else if(value.equals("Centimeter") && value1.equals("Inch"))
                   {
                       result=amount/2.54;
                       String tot=String.format("%.2f",result);
                       out.setText(""+tot);
                   }else if(value.equals("Centimeter") && value1.equals("Mile"))
                   {
                       result=(amount/160900);
                       out.setText(""+result);
                   }else if(value.equals("Centimeter") && value1.equals("Kilometer"))
                   {
                       result=amount/100000;
                       out.setText(""+result);
                   }
                   else if(value.equals("Centimeter") && value1.equals("Meter"))
                   {
                       result=amount*.01;
                       out.setText(""+result);
                   }

                   //decimeter calculation
                   else if(value.equals("Decimeter") && value1.equals("Decimeter"))
                   {
                       result=amount;
                       out.setText(""+result);
                   }
                   else if(value.equals("Decimeter") && value1.equals("Centimeter"))
                   {
                       result=amount*10;
                       out.setText(""+result);
                   }else if(value.equals("Decimeter") && value1.equals("Foot"))
                   {
                       result=amount*.32;
                       out.setText(""+result);
                   }else if(value.equals("Decimeter") && value1.equals("Inch"))
                   {
                       result=amount*3.93;
                       out.setText(""+result);
                   }else if(value.equals("Decimeter") && value1.equals("Mile"))
                   {
                       result=amount*6.21;
                       out.setText(""+result);
                   }else if(value.equals("Decimeter") && value1.equals("Kilometer"))
                   {
                       result=amount*10000;
                       out.setText(""+result);
                   }else if(value.equals("Decimeter") && value1.equals("Meter"))
                   {
                       result=amount*.1;
                       out.setText(""+result);
                   }else if(value.equals("Foot") && value1.equals("Foot"))
                   {
                       result=amount;
                       out.setText(""+result);
                   }else if(value.equals("Foot") && value1.equals("Centimeter"))
                   {
                       result=amount*30.48;
                       out.setText(""+result);
                   }else if(value.equals("Foot") && value1.equals("Decimeter"))
                   {
                       result=amount*3.04;
                       out.setText(""+result);
                   }else if(value.equals("Foot") && value1.equals("Inch"))
                   {
                       result=amount*12;
                       out.setText(""+result);
                   }else if(value.equals("Foot") && value1.equals("Mile"))
                   {
                       result=amount/5280;
                       out.setText(""+result);
                   }else if(value.equals("Foot") && value1.equals("Kilometer"))
                   {
                       result=amount/3281;
                       out.setText(""+result);
                   }else if(value.equals("Foot") && value1.equals("Meter"))
                   {
                       result=amount*.30;
                       out.setText(""+result);
                   }else if(value.equals("Inch") && value1.equals("Inch"))
                   {
                       result=amount;
                       out.setText(""+result);
                   }else if(value.equals("Inch") && value1.equals("Centimeter"))
                   {
                       result=amount*2.53;
                       out.setText(""+result);
                   }else if(value.equals("Inch") && value1.equals("Decimeter"))
                   {
                       result=amount*25;
                       out.setText(""+result);
                   }else if(value.equals("Inch") && value1.equals("Foot"))
                   {
                       result=amount*.08;
                       out.setText(""+result);
                   }else if(value.equals("Inch") && value1.equals("Mile"))
                   {
                       result=amount*1.57E-5;
                       out.setText(""+result);
                   }else if(value.equals("Inch") && value1.equals("Kilometer"))
                   {
                       result=amount/63360;
                       out.setText(""+result);
                   }else if(value.equals("Inch") && value1.equals("Meter"))
                   {
                       result=amount*.02;
                       out.setText(""+result);
                   }else if(value.equals("Mile") && value1.equals("Mile"))
                   {
                       result=amount;
                       out.setText(""+result);
                   }else if(value.equals("Mile") && value1.equals("Centimeter"))
                   {
                       result=amount*160934;
                       out.setText(""+result);
                   }else if(value.equals("Mile") && value1.equals("Decimeter"))
                   {
                       result=amount*16093;
                       out.setText(""+result);
                   }else if(value.equals("Mile") && value1.equals("Foot"))
                   {
                       result=amount*5280;
                       out.setText(""+result);
                   }else if(value.equals("Mile") && value1.equals("Inch"))
                   {
                       result=amount*63360;
                       out.setText(""+result);
                   }else if(value.equals("Mile") && value1.equals("Kilometer"))
                   {
                       result=amount*1.60;
                       out.setText(""+result);
                   }else if(value.equals("Mile") && value1.equals("Meter"))
                   {
                       result=amount*1609.34;
                       out.setText(""+result);
                   }else if(value.equals("Kilometer") && value1.equals("Kilometer"))
                   {
                       result=amount;
                       out.setText(""+result);
                   }else if(value.equals("Kilometer") && value1.equals("Centimeter"))
                   {
                       result=amount*100000;
                       out.setText(""+result);;
                   }else if(value.equals("Kilometer") && value1.equals("Decimeter"))
                   {
                       result=amount*10000;
                       out.setText(""+result);
                   }else if(value.equals("Kilometer") && value1.equals("Foot"))
                   {
                       result=amount*3280.83;
                       out.setText(""+result);
                   }else if(value.equals("Kilometer") && value1.equals("Inch"))
                   {
                       result=amount*39370.07;
                       out.setText(""+result);
                   }else if(value.equals("Kilometer") && value1.equals("Mile"))
                   {
                       result=amount*.62;
                       out.setText(""+result);
                   }else if(value.equals("Kilometer") && value1.equals("Meter"))
                   {
                       result=amount*1000;
                       out.setText(""+result);
                   }else if(value.equals("Meter") && value1.equals("Meter"))
                   {
                       result=amount;
                       out.setText(""+result);
                   }else if(value.equals("Meter") && value1.equals("Centimeter"))
                   {
                       result=amount*100;
                       out.setText(""+result);
                   }else if(value.equals("Meter") && value1.equals("Decimeter"))
                   {
                       result=amount*10;
                       out.setText(""+result);
                   }else if(value.equals("Meter") && value1.equals("Foot"))
                   {
                       result=amount*3.28;
                       out.setText(""+result);
                   }else if(value.equals("Meter") && value1.equals("Inch"))
                   {
                       result=amount*39.37;
                       out.setText(""+result);
                   }else if(value.equals("Meter") && value1.equals("Mile"))
                   {
                       result=amount/1609;
                       out.setText(""+result);
                   }else if(value.equals("Meter") && value1.equals("Kilometer"))
                   {
                       result=amount*.001;
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
                   Toast.makeText(Length_Spinner.this, "Invalid Choice", Toast.LENGTH_SHORT).show();
               }

            }
        });

    }


}