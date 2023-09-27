package com.example.ux_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = findViewById(R.id.profile_toolbar);
        setSupportActionBar(toolbar);

        TextView nama = findViewById(R.id.nama);
        TextView email = findViewById(R.id.email);

        Intent in = getIntent();
        Bundle bundle = in.getExtras();
        String namaSimpan;
        if(bundle!=null){
            namaSimpan = (String) bundle.get("Username");
            nama.setText("Hi, "+namaSimpan);
            email.setText(namaSimpan+"@gmail.com");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.profile_menu_list, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent in = getIntent();
        Bundle bundle = in.getExtras();
        String namaSimpan = (String) bundle.get("Username");
        switch (item.getItemId()) {
            case R.id.home:
                Intent intent1 = new Intent(this, HomeActivity.class);
                intent1.putExtra("Username", namaSimpan);
                startActivity(intent1);
                return true;
            case R.id.items:
                Intent intent2 = new Intent(this, ItemActivity.class);
                intent2.putExtra("Username", namaSimpan);
                startActivity(intent2);
                return true;
            case R.id.logout:
                Intent intent3 = new Intent(this, MainActivity.class);
                intent3.putExtra("Username", namaSimpan);
                startActivity(intent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}