package com.example.ux_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GameDetailActivity extends AppCompatActivity{

    private Dialog customDialog;
    private Dialog customDialog2;
    private View btnInsertName;
    private View btnInsertName2;
    private View btnOpenDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);

        ImageView gambar = findViewById(R.id.gambar);
        TextView title = findViewById(R.id.title);
        TextView desc = findViewById(R.id.desc);


        Intent in = getIntent();
        Bundle bundle = in.getExtras();

        RelativeLayout button = findViewById(R.id.button);

        Spinner dropdown = findViewById(R.id.dropdown);

        List<String> items = new ArrayList<>();
        items.add("Select Payment Method");
        items.add("Visa");
        items.add("Master Card");
        items.add("Credit Card");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);

        dropdown.setSelection(0);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            TextView pay = findViewById(R.id.pay);

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                switch (position){
                    case 1:
                        dropdown.setSelection(1);
                        pay.setText("Visa");
                        break;
                    case 2:
                        dropdown.setSelection(2);
                        pay.setText("Master Card");
                        break;
                    case 3:
                        dropdown.setSelection(3);
                        pay.setText("Credit Card");
                        break;
                    case 0:
                        pay.setText("Select payment Method");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        String namaSimpan;
        namaSimpan = (String) bundle.get("Username");
        if(bundle!=null){
            int value = (int) bundle.get("foto");
            if(value==1){
                gambar.setImageDrawable(getDrawable(R.drawable.gta));
                title.setText("GTA V");
                desc.setText("Action-Adventure");
            }else if(value==2){
                gambar.setImageDrawable(getDrawable(R.drawable.apex));
                title.setText("Apex Legends");
                desc.setText("Online Battle Royale");
            }else if(value==3){
                gambar.setImageDrawable(getDrawable(R.drawable.dota));
                title.setText("Dota 2");
                desc.setText("MOBA 5v5");
            }else if(value==4){
                gambar.setImageDrawable(getDrawable(R.drawable.csgo));
                title.setText("CS:GO");
                desc.setText("FPS Multiplayer");
            }else if(value==5){
                gambar.setImageDrawable(getDrawable(R.drawable.watchdogs));
                title.setText("Watch_Dogs");
                desc.setText("Third-Person Adventure");
            }
        }
        ImageView backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(e->{
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("Username", namaSimpan);
            startActivity(intent);
        });

        initViews();
    }

    private void initViews(){
        initCustomDialog();
        initViewComponents();
    }

    private void initViewComponents() {
        Spinner dropdown = findViewById(R.id.dropdown);
        btnOpenDialog = findViewById(R.id.button2);
        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value =0;
                String text = String.valueOf(dropdown.getSelectedItem());
                if(text.equals("Visa")||text.equals("Master Card")||text.equals("Credit card")){
                    value=1;
                }
                EditText email = findViewById(R.id.email);
                if (email.getText().length()<=0||value==0){
                    customDialog.show();
                }else{
                    customDialog2.show();
                }
            }
        });
    }

    private void initCustomDialog() {
        customDialog = new Dialog(GameDetailActivity.this);
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customDialog.setContentView(R.layout.dialog);
        customDialog.setCancelable(true);

        customDialog2 = new Dialog(GameDetailActivity.this);
        customDialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customDialog2.setContentView(R.layout.dialog_berhasil);
        customDialog2.setCancelable(true);

        btnInsertName = customDialog.findViewById(R.id.btnInsertName);
        btnInsertName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog.dismiss();
            }
        });

        btnInsertName2 = customDialog2.findViewById(R.id.btnInsertName2);
        btnInsertName2.setOnClickListener(new View.OnClickListener() {

            Intent in = getIntent();
            Bundle bundle = in.getExtras();
            String namaSimpan = (String) bundle.get("Username");

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameDetailActivity.this, HomeActivity.class);
                intent.putExtra("Username", namaSimpan);
                startActivity(intent);
            }
        });
    }
}