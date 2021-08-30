package org.techtown.word;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class InsertFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insert, container, false);

        Context context = getActivity().getApplicationContext();
        SQLiteDatabase db = context.openOrCreateDatabase("csm", Context.MODE_PRIVATE, null);

        Button sent = view.findViewById(R.id.button);
        sent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton proverb = view.findViewById(R.id.proverb);
                RadioButton goodword = view.findViewById(R.id.goodword);

                String value = null;

                if(proverb.isChecked()){
                    value = "속담";
                }else if(goodword.isChecked()){
                    value = "명언";
                }

                EditText comment = view.findViewById(R.id.comment);
                String text_comment = comment.getText().toString();

                EditText contents = view.findViewById(R.id.contents);
                String text_contents = contents.getText().toString();

                db.execSQL("Create table if not exists word (category VARCHAR(50), comment VARCHAR(255), content VARCHAR(512))");
                db.execSQL("insert into word (category, comment, content) values ('"+value+"','"+text_comment+"','"+text_contents+"')");

                Cursor cursor = db.rawQuery("Select * From word", null);
                while(cursor.moveToNext()){
                    Log.d("",cursor.getString(0));
                    Log.d("",cursor.getString(1));
                    Log.d("",cursor.getString(2));
                }
            }
        });



        return view;
    }
}