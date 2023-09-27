package com.example.ux_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Toolbar toolbar = findViewById(R.id.item_toolbar);
        setSupportActionBar(toolbar);

        Intent in = getIntent();
        Bundle bundle = in.getExtras();
        String namaSimpan = null;
        if(bundle!=null){
            namaSimpan = (String) bundle.get("Username");
        }


        ImageView gta = findViewById(R.id.gta);
        Bitmap gtaBitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.gta)).getBitmap();
        Bitmap gtaImageRounded = Bitmap.createBitmap(gtaBitmap.getWidth(), gtaBitmap.getHeight(), gtaBitmap.getConfig());
        Canvas gtaCanvas = new Canvas(gtaImageRounded);
        Paint gtaPaint = new Paint();
        gtaPaint.setAntiAlias(true);
        gtaPaint.setShader(new BitmapShader(gtaBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        gtaCanvas.drawRoundRect(new RectF(0,0,gtaBitmap.getWidth(), gtaBitmap.getHeight()), 17, 17, gtaPaint);
        gta.setImageBitmap(gtaImageRounded);

        ImageView apex = findViewById(R.id.apex);
        Bitmap apexBitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.apex)).getBitmap();
        Bitmap apexImageRounded = Bitmap.createBitmap(apexBitmap.getWidth(), apexBitmap.getHeight(), apexBitmap.getConfig());
        Canvas apexCanvas = new Canvas(apexImageRounded);
        Paint apexPaint = new Paint();
        apexPaint.setAntiAlias(true);
        apexPaint.setShader(new BitmapShader(apexBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        apexCanvas.drawRoundRect(new RectF(0,0,apexBitmap.getWidth(), apexBitmap.getHeight()), 47, 47, apexPaint);
        apex.setImageBitmap(apexImageRounded);

        ImageView dota = findViewById(R.id.dota);
        Bitmap dotaBitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.dota)).getBitmap();
        Bitmap dotaImageRounded = Bitmap.createBitmap(dotaBitmap.getWidth(), dotaBitmap.getHeight(), dotaBitmap.getConfig());
        Canvas dotaCanvas = new Canvas(dotaImageRounded);
        Paint dotaPaint = new Paint();
        dotaPaint.setAntiAlias(true);
        dotaPaint.setShader(new BitmapShader(dotaBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        dotaCanvas.drawRoundRect(new RectF(0,0,dotaBitmap.getWidth(), dotaBitmap.getHeight()), 47, 47, dotaPaint);
        dota.setImageBitmap(dotaImageRounded);

        ImageView csgo = findViewById(R.id.csgo);
        Bitmap csgoBitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.csgo)).getBitmap();
        Bitmap csgoImageRounded = Bitmap.createBitmap(csgoBitmap.getWidth(), csgoBitmap.getHeight(), csgoBitmap.getConfig());
        Canvas csgoCanvas = new Canvas(csgoImageRounded);
        Paint csgoPaint = new Paint();
        csgoPaint.setAntiAlias(true);
        csgoPaint.setShader(new BitmapShader(csgoBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        csgoCanvas.drawRoundRect(new RectF(0,0,csgoBitmap.getWidth(), csgoBitmap.getHeight()), 47, 47, csgoPaint);
        csgo.setImageBitmap(csgoImageRounded);

        ImageView wd = findViewById(R.id.watchdogs);
        Bitmap wdBitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.watchdogs)).getBitmap();
        Bitmap wdImageRounded = Bitmap.createBitmap(wdBitmap.getWidth(), wdBitmap.getHeight(), wdBitmap.getConfig());
        Canvas wdCanvas = new Canvas(wdImageRounded);
        Paint wdPaint = new Paint();
        wdPaint.setAntiAlias(true);
        wdPaint.setShader(new BitmapShader(wdBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        wdCanvas.drawRoundRect(new RectF(0,0,wdBitmap.getWidth(), wdBitmap.getHeight()), 87, 87, wdPaint);
        wd.setImageBitmap(wdImageRounded);

        RelativeLayout gtaTap = findViewById(R.id.gtaTap);
        RelativeLayout apexTap = findViewById(R.id.apexTap);
        RelativeLayout dotaTap = findViewById(R.id.dotaTap);
        RelativeLayout csTap = findViewById(R.id.csTap);
        RelativeLayout wdTap = findViewById(R.id.wdTap);

        String finalNamaSimpan = namaSimpan;
        gtaTap.setOnClickListener(e->{
            Intent intent = new Intent(this, GameDetailActivity.class);
            intent.putExtra("foto", 1);
            intent.putExtra("Username", finalNamaSimpan);
            startActivity(intent);
        });
        apexTap.setOnClickListener(e->{
            Intent intent = new Intent(this, GameDetailActivity.class);
            intent.putExtra("foto", 2);
            intent.putExtra("Username", finalNamaSimpan);
            startActivity(intent);
        });
        dotaTap.setOnClickListener(e->{
            Intent intent = new Intent(this, GameDetailActivity.class);
            intent.putExtra("foto", 3);
            intent.putExtra("Username", finalNamaSimpan);
            startActivity(intent);
        });
        csTap.setOnClickListener(e->{
            Intent intent = new Intent(this, GameDetailActivity.class);
            intent.putExtra("foto", 4);
            intent.putExtra("Username", finalNamaSimpan);
            startActivity(intent);
        });
        wdTap.setOnClickListener(e->{
            Intent intent = new Intent(this, GameDetailActivity.class);
            intent.putExtra("foto", 5);
            intent.putExtra("Username", finalNamaSimpan);
            startActivity(intent);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_menu_list, menu);
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
            case R.id.profile:
                Intent intent2 = new Intent(this, ProfileActivity.class);
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