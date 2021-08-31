package org.techtown.word;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class WordListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_word_list, container, false);
        ListView list = view.findViewById(R.id.list);

        DAO dao = new DAO(getContext().getApplicationContext());
        Cursor cursor = dao.getDb().rawQuery("SELECT * FROM word", null);
        ArrayList<Word> word_list = new ArrayList<Word>();

        while(cursor.moveToNext()){
            Word word = new Word();
            word.setCategory(cursor.getString(0));
            word.setComment(cursor.getString(1));
            word.setContent(cursor.getString(2));
            word_list.add(word);
        }

        for(Word word : word_list){
            Log.d("여기에요", word.getComment());
        }


        WordArrayAdapter adapter = new WordArrayAdapter(getContext().getApplicationContext(), word_list);
        list.setAdapter(adapter);
        return view;
    }
}