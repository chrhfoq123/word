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

    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<Word> wordArrayList = new ArrayList<Word>() ;

    // ListViewAdapter의 생성자
    public WordArrayAdapter() {

    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return wordArrayList.size() ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) { //웬지는 모르겠지만 null 처리안해주면 오류걸림 반드시 넣을것
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.my_list_view, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView comment = convertView.findViewById(R.id.comment);
        TextView content = convertView.findViewById(R.id.content);
        TextView category = convertView.findViewById(R.id.category);


        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        Word word = wordArrayList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        comment.setText(word.getComment());
        content.setText(word.getContent());
        category.setText(word.getCategory());

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return wordArrayList.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(String category, String comment, String content) {
        Word word = new Word();

        word.setContent(content);
        word.setComment(comment);
        word.setCategory(category);
        wordArrayList.add(word);
    }
}
