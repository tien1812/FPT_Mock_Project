package vn.tien.mockproject.ui.edit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.tien.mockproject.R;
import vn.tien.mockproject.model.Subject;

public class EditAdapter extends RecyclerView.Adapter<EditAdapter.EditHolder> {
    private List<Subject> mSubjects;

    public void setSubjects(List<Subject> subjects) {
        mSubjects = subjects;
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
        Subject subject = mSubjects.get(position);
        holder.mSubjectName.setText(subject.getName());
    }

    @Override
    public int getItemCount() {
        if (mSubjects.size()>15){
            return 15;
        }else
            return mSubjects == null ? 0 : mSubjects.size();
    }

    class EditHolder extends RecyclerView.ViewHolder {
        private TextView mSubjectName;

        public EditHolder(@NonNull View itemView) {
            super(itemView);
            mSubjectName = itemView.findViewById(R.id.text_subject);
        }
    }
}
