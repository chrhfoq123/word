package org.techtown.word;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class WordArrayAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Word> list;

    WordArrayAdapter(Context context, ArrayList<Word> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(this.context).inflate(R.layout.my_list_view, null);
        TextView category = view.findViewById(R.id.category);
        TextView comment = view.findViewById(R.id.comment);
        TextView content = view.findViewById(R.id.content);

        Word word = this.list.get(position);
        category.setText(word.getCategory());
        comment.setText(word.getComment());
        content.setText(word.getContent());


        return view;
    }
}
