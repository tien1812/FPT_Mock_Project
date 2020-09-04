package vn.tien.mockproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.tien.mockproject.model.Subject;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.ViewHoder> {
    private List<Subject> mSubjects;

    public void setSubjects(List<Subject> subjects) {
        mSubjects = subjects;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_subject, parent, false);
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        if (holder.getAdapterPosition() == 0) {
            holder.mTextLession1.setText("Lession 1");
            holder.mTextLession2.setText("Lession 2");
            holder.mTextLession3.setText("Lession 3");
            holder.mTextLession4.setText("Lession 4");
            holder.mTextLession5.setText("Lession 5");
            holder.mTextLession6.setText("Lession 6");
        }if (holder.getAdapterPosition() <8){
            switch (holder.getAdapterPosition()){
                case 1:
                    holder.mTextDay.setText("Monday");
                    break;
                case 2:
                    holder.mTextDay.setText("Tuesday");
                    break;
                case 3:
                    holder.mTextDay.setText("Wednesday");
                    break;
                case 4:
                    holder.mTextDay.setText("Thurday");
                    break;
                case 5:
                    holder.mTextDay.setText("Friday");
                    break;
                case 6:
                    holder.mTextDay.setText("Sartuday");
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return mSubjects.size();
    }

    class ViewHoder extends RecyclerView.ViewHolder {
        private TextView mTextLession1;
        private TextView mTextLession2;
        private TextView mTextLession3;
        private TextView mTextLession4;
        private TextView mTextLession5;
        private TextView mTextLession6;
        private TextView mTextDay;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            mTextLession1 = itemView.findViewById(R.id.lession1);
            mTextLession2 = itemView.findViewById(R.id.lession2);
            mTextLession3 = itemView.findViewById(R.id.lession3);
            mTextLession4 = itemView.findViewById(R.id.lession4);
            mTextLession5 = itemView.findViewById(R.id.lession5);
            mTextLession6 = itemView.findViewById(R.id.lession6);
            mTextDay = itemView.findViewById(R.id.text_day);
        }
    }
}
