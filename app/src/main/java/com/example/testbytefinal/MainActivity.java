package com.example.testbytefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login;
    EditText user,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        login = (Button) findViewById(R.id.ingresar);
        user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);

        login.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {

                if(user.getText().toString().length() < 8 ){
                    Toast toast = Toast.makeText(getApplicationContext(), "El Usuario ingresado debe ser mayor a 8 caracteres.", Toast.LENGTH_SHORT);
                    toast.show();
                }if(password.getText().toString().length() < 6){
                    Toast toast = Toast.makeText(getApplicationContext(), "El pasword ingresado debe ser mayor a 6 caracteres", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    Intent intent = new Intent(getApplicationContext(), ReportActivity.class);
                    intent.putExtra("user", user.getText().toString().trim());
                    startActivity(intent);
                }

            }
        });
    }
}