package com.example.ux_project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {

    ViewPager2 viewpager;
    int[] sampleImages = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3
    };
    int currentPage =0;
    final long DELAY_MS = 2000;
    final long PERIOD_MS = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent in = getIntent();
        Bundle bundle = in.getExtras();
        String namaSimpan = null;
        if(bundle!=null){
            namaSimpan = (String) bundle.get("Username");
        }

        TextView welcome = findViewById(R.id.welcome);
        welcome.setText("Welcome, "+namaSimpan);

        ViewPager vp = findViewById(R.id.vp);
        vp.setAdapter(new MyAdapter(getSupportFragmentManager()));

        TabLayout tabsmain = findViewById(R.id.tl);
        tabsmain.setupWithViewPager(vp);

        viewpager=findViewById(R.id.viewpager);
        ImageAdapter imageAdapter = new ImageAdapter(sampleImages);
        viewpager.setAdapter(imageAdapter);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (currentPage == sampleImages.length) {
                            currentPage = 0;
                        }
                        viewpager.setCurrentItem(currentPage++, true);
                    }
                });
            }
        }, DELAY_MS, PERIOD_MS);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Timer timer = new Timer();
        if(timer!=null){
            timer.cancel();
            timer=null;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {

        Intent in = getIntent();
        Bundle bundle = in.getExtras();
        String namaSimpan = (String) bundle.get("Username");
        switch (item.getItemId()) {
            case R.id.items:
                Intent intent1 = new Intent(this, ItemActivity.class);
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
class MyAdapter extends FragmentStatePagerAdapter{

    Fragment[] fragments={
            new TermsFragment(),
            new ConditionFragment()
    };

    private String[] titles={
            "Terms",
            "Conditions"
    };

    public MyAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }
}

