package com.bhram.shayaranapk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;

import com.bhram.shayaranapk.Adapter.DemoAdapter;
import com.bhram.shayaranapk.Models.MediaObjects;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private List<MediaObjects> mediaObjectList = new ArrayList<>();
    private DemoAdapter demoAdapter;
    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        SnapHelper mSnapHelper = new PagerSnapHelper();
        mSnapHelper.attachToRecyclerView(recyclerView);

        mediaObjectList.add(new MediaObjects("" ,"","","","","","","", "",""));
        mediaObjectList.add(new MediaObjects("" ,"","","","","","","", "",""));
        mediaObjectList.add(new MediaObjects("" ,"","","","","","","", "",""));
        mediaObjectList.add(new MediaObjects("" ,"","","","","","","", "",""));
        mediaObjectList.add(new MediaObjects("" ,"","","","","","","", "",""));
        mediaObjectList.add(new MediaObjects("" ,"","","","","","","", "",""));
        mediaObjectList.add(new MediaObjects("" ,"","","","","","","", "",""));
        mediaObjectList.add(new MediaObjects("" ,"","","","","","","", "",""));
        mediaObjectList.add(new MediaObjects("" ,"","","","","","","", "",""));
        mediaObjectList.add(new MediaObjects("" ,"","","","","","","", "",""));

        demoAdapter = new DemoAdapter(mediaObjectList,getApplicationContext());
        recyclerView.setAdapter(demoAdapter);
        demoAdapter.notifyDataSetChanged();


    }
}