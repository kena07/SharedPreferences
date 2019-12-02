package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText name,email,password;
    Button b1,b2,b3;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Pass = "PassWord";
    public static final String Email = "emailKey";

    public void save()
    {
        SharedPreferences sharedpreferences;
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        name = (EditText)findViewById(R.id.edtName);
        email = (EditText)findViewById(R.id.edtEmail);
        password = (EditText)findViewById(R.id.edtPass);

        String n  = name.getText().toString();
        String e  = email.getText().toString();
        String p  = password.getText().toString();

        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putString(Name, n);
        editor.putString(Pass, p);
        editor.putString(Email, e);
        editor.commit();
        Toast.makeText(MainActivity.this,"Saved",Toast.LENGTH_LONG).show();
    }

    public void retrieve()
    {
        SharedPreferences sharedpreferences;
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String Rname,Rpass,Remail;
        name = (EditText)findViewById(R.id.edtName);
        email = (EditText)findViewById(R.id.edtEmail);
        password = (EditText)findViewById(R.id.edtPass);

        String n  = name.getText().toString();
        String e  = email.getText().toString();
        String p  = password.getText().toString();

        Rname = (String) sharedpreferences.getString(Name, n);
        Rpass = (String) sharedpreferences.getString(Pass, p);
        Remail =(String) sharedpreferences.getString(Email, e);

        if (Rname.equals(n) && Rpass.equals(p) && Remail.equals(e))
        {
            Toast.makeText(MainActivity.this,"Data Retrieved",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(MainActivity.this,"Data is not saved or Invalid Data ",Toast.LENGTH_LONG).show();
        }

    }
    public void Clear()
    {
        name = (EditText)findViewById(R.id.edtName);
        email = (EditText)findViewById(R.id.edtEmail);
        password = (EditText)findViewById(R.id.edtPass);
        name.setText("");
        email.setText("");
        password.setText("");
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.edtName);
        email=(EditText)findViewById(R.id.edtEmail);
        password=(EditText)findViewById(R.id.edtPass);

        b1=(Button)findViewById(R.id.btnSave);
        b1.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                save();
            }
        });

        b2=(Button)findViewById(R.id.btnRetrive);
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                retrieve();
            }
        });

        b3 = (Button)findViewById(R.id.btnClear);
        b3.setOnClickListener((new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Clear();
            }
        }));
    }

}