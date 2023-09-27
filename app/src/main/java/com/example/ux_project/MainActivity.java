package com.example.ux_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View button = findViewById(R.id.button);
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        TextView errMsg = findViewById(R.id.errMsg);
        button.setOnClickListener(e->{
            if(username.length()<=0) {
                errMsg.setText("Username Must be Filled");
            }else if(password.length()==0){
                errMsg.setText("Password Must be Filled");
            }else if (password.length()<8){
                errMsg.setText("Password Must be Greater Than 8 Characters");
            }else{
                String nama = String.valueOf(username.getText());
                Intent intent = new Intent(this, HomeActivity.class);
                intent.putExtra("Username", nama);
                startActivity(intent);
            }
        });
    }
}