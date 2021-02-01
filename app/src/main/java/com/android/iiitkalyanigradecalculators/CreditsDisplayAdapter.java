package com.android.iiitkalyanigradecalculators;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.iiitkalyanigradecalculators.Main_Page_Work.MainPageAdapter;

import org.w3c.dom.Text;

import java.util.List;

public class CreditsDisplayAdapter extends RecyclerView.Adapter<CreditsDisplayAdapter.Viewholder>  {
    private List<CreditDisplayModel> creditDisplayModels;

    public CreditsDisplayAdapter(List<CreditDisplayModel> creditDisplayModels) {
        this.creditDisplayModels = creditDisplayModels;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.credit_page_outline,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.setData(creditDisplayModels.get(position).getSubject(),creditDisplayModels.get(position).getLecturer(),creditDisplayModels.get(position).getCredits());
    }

    @Override
    public int getItemCount() {
        return creditDisplayModels.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView course_code;
        private TextView lecturers;
        private TextView credit;
        private Button calculate;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            course_code = itemView.findViewById(R.id.cource_code);
            lecturers = itemView.findViewById(R.id.lecturer);
            credit = itemView.findViewById(R.id.credits);
            calculate = itemView.findViewById(R.id.calculate);
        }

        public void setData(String subject, String lecturer, String credits) {
            course_code.setText(subject);
            lecturers.setText(lecturer);
            credit.setText(credits);
        }
    }
}
