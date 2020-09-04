package vn.tien.mockproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.tien.mockproject.model.Subject;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRclSubject;
    private SubjectAdapter mSubjectAdapter;
    private List<Subject> mSubjects;
    private Spinner mSpinner;
    private Button mBtnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        mSubjects = new ArrayList<>();
        mSubjects.add(new Subject(1, ""));
        mSubjects.add(new Subject(1, "Lession1"));
        mSubjects.add(new Subject(2, "Lession2"));
        mSubjects.add(new Subject(3, "Lession3"));
        mSubjects.add(new Subject(4, "Lession4"));
        mSubjects.add(new Subject(5, "Lession5"));
        mSubjects.add(new Subject(6, "Lession6"));
    }

    private void initView() {
        List<String> mWeeks = new ArrayList<>();
        mWeeks.add("07-13/09/2020");
        mWeeks.add("14-20/09/2020");
        mWeeks.add("21-27/09/2020");
        mWeeks.add("28-04/10/2020");
        mWeeks.add("07-13/09/2020");
        mWeeks.add("07-13/09/2020");
        mWeeks.add("07-13/09/2020");
        mSpinner = findViewById(R.id.spinner);
        ArrayAdapter mSpinnerAdapter = new ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item, mWeeks);
        mSpinner.setAdapter(mSpinnerAdapter);
        mRclSubject = findViewById(R.id.rcl_home);
        mRclSubject.setLayoutManager(
                new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL,
                        false));
        mSubjectAdapter = new SubjectAdapter();
        mSubjectAdapter.setSubjects(mSubjects);
        mRclSubject.setAdapter(mSubjectAdapter);
        mBtnEdit = findViewById(R.id.btn_edit);
        mBtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,EditActivity.class);
                startActivity(intent);
            }
        });
    }
}
