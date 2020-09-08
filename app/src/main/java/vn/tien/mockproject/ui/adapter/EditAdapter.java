package vn.tien.mockproject.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.tien.mockproject.R;
import vn.tien.mockproject.listener.ItemLongClick;
import vn.tien.mockproject.model.Lesson;

public class EditAdapter extends RecyclerView.Adapter<EditAdapter.EditHolder> {
    private List<Lesson> mLessons;
    private ItemLongClick mHoldClick;

    public void setHoldClick(ItemLongClick holdClick) {
        mHoldClick = holdClick;
    }

    public void setLessons(List<Lesson> lessons) {
        mLessons = lessons;
    }

    @NonNull
    @Override
    public EditHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_subject,
                parent, false);
        return new EditHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EditHolder holder, int position) {
        Lesson lesson = mLessons.get(position);
        holder.mLessionName.setText(lesson.getName());
    }

    @Override
    public int getItemCount() {
        if (mLessons.size() > 15) {
            return 15;
        } else
            return mLessons == null ? 0 : mLessons.size();
    }

    class EditHolder extends RecyclerView.ViewHolder {
        private TextView mLessionName;

        public EditHolder(@NonNull View itemView) {
            super(itemView);
            mLessionName = itemView.findViewById(R.id.text_lession);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mHoldClick.holdClick(mLessons.get(getAdapterPosition()));
                    return true;
                }
            });
        }
    }
}
