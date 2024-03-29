package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;

import com.example.customlistview.databinding.ActivityMainBinding;
import com.example.customlistview.listview.ListViewAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ListViewAdapter adapter;
    private List<Integer> imageList;
    private List<String> titleList;
    private List<String> describeList;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBinding();
        
        initialize();

        addListItem();
    }

    /**
     * @DESC: 초기 바인딩
     */
    private void initBinding(){
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    /**
     * @DESC: 초기화
     */
    private void initialize(){
        mContext = MainActivity.this;
        adapter = new ListViewAdapter();
        imageList = new ArrayList<>(Arrays.asList(R.drawable.baknana,R.drawable.djmax_clear_fail
                ,R.drawable.djmax_falling_in_love, R.drawable.mwama,R.drawable.tamtam));
        titleList = new ArrayList<>(Arrays.asList("박나나","클리어,페일","FallingInLove"
                ,"뫄마","탬탬버린"));
        describeList = new ArrayList<>(Arrays.asList("롤 방송자주하는 트위치 스트리머"
                ,"Djmax 캐릭터","Djmax 곡","트위치 스트리머","트위치 스트리머"));
    }

    /**
     * @DESC: 리스트에 아이템 추가
     */
    private void addListItem(){
        binding.listItem.setAdapter(adapter);
        for(int i=0;i<imageList.size();i++){
            adapter.addItem(ContextCompat.getDrawable(mContext,imageList.get(i))
                    ,titleList.get(i),describeList.get(i));
        }

    }
}