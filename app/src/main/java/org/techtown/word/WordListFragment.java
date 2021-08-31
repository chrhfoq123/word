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
        ArrayList<String> arrayList = new ArrayList<String>();

        while(cursor.moveToNext()){
            arrayList.add(cursor.getString(1));
        }

        ArrayAdapter adapter = new ArrayAdapter(getContext().getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);

        list.setAdapter(adapter);
        return view;
    }
}