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


public class Pressure_Spinner extends AppCompatActivity {
    private ImageView backArrow;
    private TextInputEditText input;
    private AutoCompleteTextView out;
    private MaterialButton btn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    String[] pressure;
    String[] pressure1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure_spinner);
        getWindow().setStatusBarColor(ContextCompat.getColor(Pressure_Spinner.this, R.color.yellow));

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

        pressure=getResources().getStringArray(R.array.Pressure);
        pressure1=getResources().getStringArray(R.array.Pressure1);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.sample_view,R.id.textViewSampleId,pressure);
        ArrayAdapter<String> adapter1=new ArrayAdapter<>(this,R.layout.sample_view,R.id.textViewSampleId,pressure1);
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

                //calculation unit
                String value = autoCompleteTextView.getText().toString();
                String value1 = autoCompleteTextView1.getText().toString();
                Double result;
                Double amount = Double.parseDouble(input.getText().toString());
                if(value.equals("") || value1.equals(""))
                {
                    Toast.makeText(Pressure_Spinner.this, "Please select an item", Toast.LENGTH_SHORT).show();

                }

                else if (value.equals("Atmosphere") && value1.equals("Atmosphere")) {
                    result = amount;
                    out.setText(""+result);
                } else if (value.equals("Atmosphere") && value1.equals("Bar")) {
                    result = amount *1.01325;
                    out.setText(""+result);
                } else if (value.equals("Atmosphere") && value1.equals("mmHg")) {
                    result = amount *760;
                    out.setText(""+result);
                } else if (value.equals("Atmosphere") && value1.equals("Pascal")) {
                    result = (amount *101325.0);
                    out.setText(""+result);
                } else if (value.equals("Atmosphere") && value1.equals("Torr")) {
                    result = amount*760;
                    out.setText(""+result);
                }
                //bar cal
                else if (value.equals("Bar") && value1.equals("Bar")) {
                    result = amount;
                    out.setText(""+result);
                }
                else if (value.equals("Bar") && value1.equals("Atmosphere")) {
                    result = amount *.9869;
                    out.setText(""+result);
                }
                else if (value.equals("Bar") && value1.equals("mmHg")) {
                    result = amount *750.06;
                    out.setText(""+result);
                }
                else if (value.equals("Bar") && value1.equals("Pascal")) {
                    result = (amount *100000);
                    out.setText(""+result);
                }
                else if (value.equals("Bar") && value1.equals("Torr")) {
                    result = amount*750.06;
                    out.setText(""+result);
                }

                //mmhg cal
                else if (value.equals("mmHg") && value1.equals("mmHg")) {
                    result = amount;
                    out.setText(""+result);
                } else if (value.equals("mmHg") && value1.equals("Atmosphere")) {
                    result = amount * .00121;
                    out.setText(""+result);
                } else if (value.equals("mmHg") && value1.equals("Bar")) {
                    result = amount * .001333;
                    out.setText(""+result);
                } else if (value.equals("mmHg") && value1.equals("Pascal")) {
                    result = (amount *133.32);
                    out.setText(""+result);
                } else if (value.equals("mmHg") && value1.equals("Torr")) {
                    result = amount*1;
                    out.setText(""+result);
                }

                //pascal cal
                else if (value.equals("Pascal") && value1.equals("Pascal")) {
                    result = amount;
                    out.setText(""+result);
                }
                else if (value.equals("Pascal") && value1.equals("Atmosphere")) {
                    result = amount * .032;
                    out.setText(""+result);
                }
                else if (value.equals("Pascal") && value1.equals("Bar")) {
                    result = amount * .394;
                    out.setText(""+result);
                }
                else if (value.equals("Pascal") && value1.equals("mmHg")) {
                    result = (amount * 6.21);
                    out.setText(""+result);
                }
                else if (value.equals("Pascal") && value1.equals("Torr")) {
                    result = amount / 100000;
                    out.setText(""+result);
                }

                //torr cal

                else if (value.equals("Torr") && value1.equals("Torr")) {
                    result = amount;
                    out.setText(""+result);
                }
                else if (value.equals("Torr") && value1.equals("Atmosphere")) {
                    result = amount *.00131;
                    out.setText(""+result);
                }
                else if (value.equals("Torr") && value1.equals("Bar")) {
                    result = amount * .001333;
                    out.setText(""+result);
                }
                else if (value.equals("Torr") && value1.equals("mmHg")) {
                    result = (amount *1);
                    out.setText(""+result);
                }
                else if (value.equals("Torr") && value1.equals("Pascal")) {
                    result = amount*133.32;
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
                Toast.makeText(Pressure_Spinner.this, "Invalid Choice", Toast.LENGTH_SHORT).show();
            }


            }
        });

    }
}