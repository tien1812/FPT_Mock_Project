package vn.tien.mockproject.ui.adapter;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.tien.mockproject.R;
import vn.tien.mockproject.model.LessonSchedule;

import static vn.tien.mockproject.R.color.colorWhite;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHoder> {
    private List<LessonSchedule> mLessonSchedules = new ArrayList<>();
    private int[] index = {1, 2, 3, 4, 5, 6, 7, 14, 21, 28, 35, 42};
    private String[] titleRow = {"Lesson 1", "Lesson 2", "Lesson 3", "Lesson4", "Lesson5", "Lesson6"
            , "Monday", "TuesDay", "Wednesday", "Thurday", "Friday", "Saturday"};

    public void setLessonSchedules(List<LessonSchedule> lessonSchedules) {
        mLessonSchedules = lessonSchedules;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_subject, parent,
                false);
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        for (int j = 0; j < index.length; j++) {
            if (position == index[j]) {
                holder.mTextLession.setText(titleRow[j]);
                holder.itemView.setBackgroundResource(R.color.colorAccent);
            }
        }
    }

    @Override
    public int getItemCount() {
        if (mLessonSchedules == null){
            for (int i = 0; i < 49; i++) {
                mLessonSchedules.add(new LessonSchedule());
            }
        }
        return mLessonSchedules == null ? 0 : 49;
    }

    class ViewHoder extends RecyclerView.ViewHolder {
        private TextView mTextLession;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            mTextLession = itemView.findViewById(R.id.text_lession);
        }
    }
}
