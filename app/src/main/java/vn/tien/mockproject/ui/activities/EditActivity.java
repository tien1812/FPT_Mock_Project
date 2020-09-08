package vn.tien.mockproject.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.tien.mockproject.R;
import vn.tien.mockproject.listener.ItemLongClick;
import vn.tien.mockproject.model.Lesson;
import vn.tien.mockproject.ui.adapter.EditAdapter;
import vn.tien.mockproject.ui.adapter.HomeAdapter;
import vn.tien.mockproject.ui.dialog.DialogFragment;

public class EditActivity extends AppCompatActivity implements View.OnClickListener,
        DialogFragment.NoticeDialogListener {
    private RecyclerView mRclLesson;
    private RecyclerView mRclTimeTable;
    private EditAdapter mEditAdapter;
    private HomeAdapter mHomeAdapter;
    private EditViewModel mEditViewModel;
    private Button mBtnAdd, mBtnCancel;
    private TextView mTextDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        initView();
        initRclLession();
        initViewModel();
        listenerItemLession();
        initRclTimeTable();
    }

    private void initRclTimeTable() {
        mHomeAdapter = new HomeAdapter();
        mRclTimeTable.setLayoutManager(new GridLayoutManager(this, 7,
                GridLayoutManager.HORIZONTAL, false));
        mRclTimeTable.setHasFixedSize(true);
        mRclTimeTable.setAdapter(mHomeAdapter);
    }

    private void initView() {
        mRclLesson = findViewById(R.id.rcl_lesson);
        mRclTimeTable = findViewById(R.id.rcl_edit);
        mBtnAdd = findViewById(R.id.btn_add);
        mTextDate = findViewById(R.id.text_date);
        mBtnAdd.setOnClickListener(this);
        mBtnCancel = findViewById(R.id.btn_cancel);
        mBtnCancel.setOnClickListener(this);
        mTextDate.setOnClickListener(this);
    }

    private void initRclLession() {
        mEditAdapter = new EditAdapter();
        mRclLesson.setLayoutManager(new GridLayoutManager(this,
                3, GridLayoutManager.VERTICAL, false));
        mRclLesson.setHasFixedSize(true);
    }

    private void initViewModel() {
        mEditViewModel = ViewModelProviders.of(this).get(EditViewModel.class);
        mEditViewModel.getSubjects().observe(this, new Observer<List<Lesson>>() {
            @Override
            public void onChanged(List<Lesson> lessons) {
                mEditAdapter.setLessons(lessons);
                mRclLesson.setAdapter(mEditAdapter);
                mEditAdapter.notifyDataSetChanged();
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
            case R.id.text_date:
                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");
                startActivity(intent);
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
        mEditViewModel.insertSubject(new Lesson(s));
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }

    private void listenerItemLession() {
        mEditAdapter.setHoldClick(new ItemLongClick() {
            @Override
            public void holdClick(Lesson lesson) {
                mEditViewModel.deleteSubject(lesson);
                Toast.makeText(EditActivity.this, "Delete Success", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}