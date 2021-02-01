package com.android.iiitkalyanigradecalculators.Main_Page_Work;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.android.iiitkalyanigradecalculators.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Main_page_Activity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myref;
    private Dialog loadingdialog;
    private List<MainPageModel> list;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page_);
        recyclerView = findViewById(R.id.rv);

        loadingdialog = new Dialog(this);
        loadingdialog.setContentView(R.layout.loading);
        loadingdialog.getWindow().setLayout(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        loadingdialog.setCancelable(false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        database = FirebaseDatabase.getInstance();
        myref = database.getReference();
        list = new ArrayList<>();
        final MainPageAdapter adapter = new MainPageAdapter(list);
        recyclerView.setAdapter(adapter);
        loadingdialog.show();
        myref.child("semesters").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    list.add(dataSnapshot1.getValue(MainPageModel.class));
                }
                adapter.notifyDataSetChanged();
                loadingdialog.dismiss();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                loadingdialog.dismiss();
                finish();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}