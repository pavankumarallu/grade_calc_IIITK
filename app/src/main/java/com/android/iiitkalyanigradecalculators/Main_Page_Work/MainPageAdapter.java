package com.android.iiitkalyanigradecalculators.Main_Page_Work;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.iiitkalyanigradecalculators.Credit_page_work.CreditsDisplayActivity;
import com.android.iiitkalyanigradecalculators.R;

import java.util.List;

public class MainPageAdapter extends RecyclerView.Adapter<MainPageAdapter.Viewholder> {
    private List<MainPageModel> mainPageModels;

    public MainPageAdapter(List<MainPageModel> mainPageModel) {
        this.mainPageModels = mainPageModel;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_page_outline,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.setData(mainPageModels.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mainPageModels.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private Button sem_name;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            sem_name = itemView.findViewById(R.id.Sem_name);


        }

        public void setData(final String name) {
            this.sem_name.setText(name);
            sem_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent setIntent = new Intent(itemView.getContext(), CreditsDisplayActivity.class);
                    setIntent.putExtra("Sem_no",name);
                    itemView.getContext().startActivity(setIntent);
                }
            });
        }
    }
}

