package vn.tien.mockproject.ui.edit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.tien.mockproject.R;
import vn.tien.mockproject.model.Subject;

public class EditActivity extends AppCompatActivity implements View.OnClickListener,
        DialogFragment.NoticeDialogListener {
    private RecyclerView mRclSubject;
    private EditAdapter mAdapter;
    private EditViewModel mEditViewModel;
    private Button mBtnAdd, mBtnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        initView();
        initRclSubject();
        initViewModel();
    }

    private void initView() {
        mRclSubject = findViewById(R.id.rcl_subject);
        mBtnAdd = findViewById(R.id.btn_add);
        mBtnAdd.setOnClickListener(this);
        mBtnCancel = findViewById(R.id.btn_cancel);
        mBtnCancel.setOnClickListener(this);
    }

    private void initRclSubject() {
        mAdapter = new EditAdapter();
        mRclSubject.setLayoutManager(new GridLayoutManager(this,
                3, GridLayoutManager.VERTICAL, false));
        mRclSubject.setHasFixedSize(true);
    }

    private void initViewModel() {
        mEditViewModel = ViewModelProviders.of(this).get(EditViewModel.class);
        mEditViewModel.getSubjects().observe(this, new Observer<List<Subject>>() {
            @Override
            public void onChanged(List<Subject> subjects) {
                mAdapter.setSubjects(subjects);
                mRclSubject.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                showDialog();
                break;
            case R.id.btn_cancel:
                finish();
                break;
            default:
                break;
        }
    }

    private void showDialog() {
        if (mEditViewModel.getSubjects().getValue().size() > 15) {
            Toast.makeText(this, "Not Add More", Toast.LENGTH_SHORT).show();
        } else {
            DialogFragment dialogFragment = new DialogFragment();
            dialogFragment.show(getSupportFragmentManager(), "Dialog Fragment");
        }
    }

    @Override
    public void onDialogPositiveClick(String s) {
        mEditViewModel.insertSubject(new Subject(s));
    }
}