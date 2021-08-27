package org.techtown.word;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

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
    }
}