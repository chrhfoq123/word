package org.techtown.word;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.FragmentTransaction;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);

        PagerManager pagerManager = new PagerManager(getSupportFragmentManager());

        WordListFragment wordListFragment = new WordListFragment();
        pagerManager.addItem(wordListFragment);

        MainFragment mainFragment = new MainFragment();
        pagerManager.addItem(mainFragment);

        InsertFragment insertFragment = new InsertFragment();
        pagerManager.addItem(insertFragment);

        pager.setAdapter(pagerManager);
        pager.setCurrentItem(1);

        DAO dao = new DAO(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int curId = item.getItemId();
        switch (curId){
            case R.id.refresh:
                Toast.makeText(this, "새로고침 눌러짐", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}