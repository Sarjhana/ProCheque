package com.example.sarjhu.procheque;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Details extends AppCompatActivity {

    EditText date1,payto,words,nums,accno,cheq,micr,brno,two;
    DatabaseReference mref = FirebaseDatabase.getInstance().getReference();;
    FirebaseDatabase database = FirebaseDatabase.getInstance();;
    Button button;
    String date;
    int year_x, month_x, day_x;
    final static int dialog_id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        date1= findViewById(R.id.date1);
        payto=findViewById(R.id.payto);
        words=findViewById(R.id.words);
        nums=findViewById(R.id.nums);
        accno=findViewById(R.id.accno);
        cheq=findViewById(R.id.cheqno);
        micr=findViewById(R.id.micr);

        button = findViewById(R.id.ok);

        FirebaseApp.initializeApp(this);

        date1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(dialog_id);
                    }
                }

        );

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        insert();
                        Intent i=new Intent(Details.this,OcrScreen.class);
                        startActivity(i);
                    }
                }

        );

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == dialog_id)
            return new DatePickerDialog(this, dpickerlistener, year_x, month_x, day_x);
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerlistener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            year_x = year;
            month_x = month;
            day_x = dayOfMonth;
            date = day_x + "/" + month_x + "/" + year_x;
        }
    };

    public void insert()
    {
        String textdate = date1.getText().toString().trim();
        String textpayto = payto.getText().toString().trim();
        String textwords = words.getText().toString().trim();
        Integer textnums = Integer.getInteger(nums.getText().toString());
        Integer textaccno = Integer.getInteger(accno.getText().toString());
        Integer textcheq = Integer.getInteger(cheq.getText().toString());
        Integer textmicr = Integer.getInteger(micr.getText().toString());


        if(TextUtils.isEmpty(textpayto)){
            Toast.makeText(this, "Enter the name", Toast.LENGTH_LONG).show();
        }
        else
        {
            String dbId = mref.push().getKey();

            ManualDetails md = new ManualDetails (textcheq, textdate, textpayto, textwords, textnums, textmicr, textaccno);
            mref.child("cheq").setValue(md);

            Toast.makeText(this,"Values uploaded ", Toast.LENGTH_LONG).show();

        }

    }
}
