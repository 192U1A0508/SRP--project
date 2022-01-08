package com.example.diacare;


import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;

import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;


import java.util.ArrayList;
import java.util.List;


public class SecondActivity extends AppCompatActivity  {
    private ArrayList<ExampleItem> mExampleList;

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button info=(Button) findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),InfoActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        createExampleList();
        buildRecyclerView();

        EditText editText = findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

    }

    private void filter(String text) {
        ArrayList<ExampleItem> filteredList = new ArrayList<>();

        for (ExampleItem item : mExampleList) {
            if (item.getText1().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        mAdapter.filterList(filteredList);
    }

    private void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem(R.drawable.broccoli, "Broccoli", "G.I value=15,Low"));
        mExampleList.add(new ExampleItem(R.drawable.carrot, "Carrot", "G.I value=16,Low"));
        mExampleList.add(new ExampleItem(R.drawable.cauliflower, "Cauliflower", "G.I value=10,Low"));
        mExampleList.add(new ExampleItem(R.drawable.celery, "Celery", "G.I value=15,Low"));
        mExampleList.add(new ExampleItem(R.drawable.cherry, "Cherry", "G.I value=22,Low"));
        mExampleList.add(new ExampleItem(R.drawable.corn, "Corn", "G.I value=52,Low"));
        mExampleList.add(new ExampleItem(R.drawable.eggplant, "Eggplant", "G.I value=10,Low"));
        mExampleList.add(new ExampleItem(R.drawable.grapes, "Grapes", "G.I value=53,Low"));
        mExampleList.add(new ExampleItem(R.drawable.jackfruit, "JackFruit", "G.I value=60,Medium"));
        mExampleList.add(new ExampleItem(R.drawable.kiwi, "Kiwi", "G.I value=50,Low"));
        mExampleList.add(new ExampleItem(R.drawable.mango, "Mango", "G.I value=56,Medium"));
        mExampleList.add(new ExampleItem(R.drawable.melon, "Melon", "G.I value=62,Medium"));
        mExampleList.add(new ExampleItem(R.drawable.mushroom, "Mushroom", "G.I value=15,Low"));
        mExampleList.add(new ExampleItem(R.drawable.oranges, "Oranges", "G.I value=52,Low"));
        mExampleList.add(new ExampleItem(R.drawable.onion, "Onion", "G.I value=10,Low"));
        mExampleList.add(new ExampleItem(R.drawable.papaya, "Papaya", "G.I value=60,Medium"));
        mExampleList.add(new ExampleItem(R.drawable.pea, "Pea", "G.I value=48,Low"));
        mExampleList.add(new ExampleItem(R.drawable.pineapple, "Pineapple", "G.I value=59,Low"));
        mExampleList.add(new ExampleItem(R.drawable.potato, "Potato", "G.I value=82,High"));
        mExampleList.add(new ExampleItem(R.drawable.pumpkin, "Pumpkin", "G.I value=75,High"));
        mExampleList.add(new ExampleItem(R.drawable.redcabbage, "RedCabbage", "G.I value=10,Low"));
        mExampleList.add(new ExampleItem(R.drawable.redonion, "RedOnion", "G.I value=10,Low"));
        mExampleList.add(new ExampleItem(R.drawable.spinach, "Spinach", "G.I value=15,Low"));
        mExampleList.add(new ExampleItem(R.drawable.springonions, "SpringOnions", "G.I value=10,Low"));
        mExampleList.add(new ExampleItem(R.drawable.sprouts, "Sprouts", "G.I value=29,Low"));
        mExampleList.add(new ExampleItem(R.drawable.sweetpotato, "SweetPotato", "G.I value=54,Low"));
        mExampleList.add(new ExampleItem(R.drawable.taro, "Taro", "G.I value=63,Medium"));
        mExampleList.add(new ExampleItem(R.drawable.tomatoes, "Tomato", "G.I value=15,Low"));
        mExampleList.add(new ExampleItem(R.drawable.watermelon, "WaterMelon", "G.I value=80,High"));
        mExampleList.add(new ExampleItem(R.drawable.whitecabbage, "WhiteCabbage", "G.I value=10,Low"));
        mExampleList.add(new ExampleItem(R.drawable.yam, "Yam", "G.I value=51,Low"));
    }

    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void activity(View view) {
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);

    }
}