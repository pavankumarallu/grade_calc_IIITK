package com.android.iiitkalyanigradecalculators;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.iiitkalyanigradecalculators.Credit_page_work.CreditDisplayModel;
import com.android.iiitkalyanigradecalculators.Credit_page_work.CreditsDisplayAdapter;
import com.android.iiitkalyanigradecalculators.Main_Page_Work.MainPageAdapter;

import java.util.List;

public class Calculate_gpa_Adapter extends RecyclerView.Adapter<Calculate_gpa_Adapter.Viewholder>  {

    private List<CreditDisplayModel> creditDisplayModels;

    public Calculate_gpa_Adapter(List<CreditDisplayModel> creditDisplayModels) {
        this.creditDisplayModels = creditDisplayModels;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calculator_gpa_outline,parent,false);
        return new Calculate_gpa_Adapter.Viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.setData(creditDisplayModels.get(position).getSubject(),creditDisplayModels.get(position).getLecturer(), String.valueOf(creditDisplayModels.get(position).getCredits()));
    }

    @Override
    public int getItemCount() {
        return creditDisplayModels.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView Courceid;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            Courceid = itemView.findViewById(R.id.courceid);
        }

        public void setData(String subject, String lecturer, String valueOf) {
            Courceid.setText(subject);

        }
    }
}
