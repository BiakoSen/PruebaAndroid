package com.example.pruebaandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
    }

    public void toTabsNavigation(View view){

        if(user.getText().toString().isEmpty()){
            user.setError("Igresar usuario");
            user.requestFocus();
            return;
        }

        if(pass.getText().toString().isEmpty()){
            pass.setError("Igresar contraseña");
            pass.requestFocus();
            return;
        }

        if(!user.getText().toString().equals("admin")){
            user.setError("Usuario incorrecto");
            user.requestFocus();
            return;
        }

        if(!pass.getText().toString().equals("admin")){
            pass.setError("contraseña incorrecta");
            pass.requestFocus();
            return;
        }

        Intent intent = new Intent(this, TabNavigator.class);
        startActivity(intent);
    }
}