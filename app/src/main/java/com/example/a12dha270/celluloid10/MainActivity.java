package com.example.a12dha270.celluloid10;

import android.content.Intent;
import android.graphics.Movie;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.a12dha270.celluloid10.MoviePackage.Documentary;
import com.example.a12dha270.celluloid10.MoviePackage.FullLength;
import com.example.a12dha270.celluloid10.MoviePackage.MovieClass;
import com.example.a12dha270.celluloid10.MoviePackage.MovieListAdapter;
import com.example.a12dha270.celluloid10.MoviePackage.ShortFilm;
import com.example.a12dha270.celluloid10.Preference.LoginPreferences;
import com.example.a12dha270.celluloid10.database.MovieDatabaseHelper;

public class MainActivity extends AppCompatActivity implements MovieListAdapter.OnItemClickedListener{
    private TabLayout tabLayout;
    ViewPager tabViewPager;
    private MovieDatabaseHelper databaseHelper;
    private LoginPreferences loginPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginPreferences=new LoginPreferences(this);
        databaseHelper=new MovieDatabaseHelper(this);

        tabLayout=findViewById(R.id.tabLayout);
        tabViewPager=findViewById(R.id.tabViewPager);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.fulllength));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.documentary));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.shortfilm));

        MoviePageAdapter adapter=new MoviePageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        tabViewPager.setAdapter(adapter);

        tabViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

/*
    public void addItem(View view) {
        Intent intent=new Intent(MainActivity.this, FoodItemAddActivity.class);
        startActivity(intent);
    }
*/

    @Override
    public void onItemClick(int position,MovieClass employee) {
        Intent intent = new Intent(MainActivity.this,MovieDetails.class);
        //intent.putExtra("msg", (Serializable) employee);
        startActivity(intent);
    }


    //this adapter will help to set the fragment according to tab
    private class MoviePageAdapter extends FragmentPagerAdapter {
        private int tabCount;

        public MoviePageAdapter(FragmentManager fm, int tabCount) {
            super(fm);
            this.tabCount=tabCount;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new FullLength();
                case 1:
                    return  new Documentary();
                case 2:
                    return new ShortFilm();
            }
            return null;
        }

        @Override
        public int getCount() {
            return tabCount;
        }
    }

    ///////////////////////Menu Option
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_add:
                startActivity(new Intent(MainActivity.this,MovieEntryForm.class));
                break;
            case R.id.item_logout:
                loginPreferences.setStatus(false);
                startActivity(new Intent(MainActivity.this,AdminLogin.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}