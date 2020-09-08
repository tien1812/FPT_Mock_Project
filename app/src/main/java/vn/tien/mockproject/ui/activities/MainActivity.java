package vn.tien.mockproject.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.tien.mockproject.R;
import vn.tien.mockproject.model.LessonSchedule;
import vn.tien.mockproject.ui.adapter.HomeAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRclSubject;
    private HomeAdapter mHomeAdapter;
    private Button mBtnEdit;
    private HomeViewModel mHomeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initViewModel();
    }

    private void initViewModel() {
        mHomeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        mHomeViewModel.getSchedule().observe(this, new Observer<List<LessonSchedule>>() {
            @Override
            public void onChanged(List<LessonSchedule> lessonSchedules) {
                mHomeAdapter.setLessonSchedules(lessonSchedules);
                mHomeAdapter.notifyDataSetChanged();
                mRclSubject.setAdapter(mHomeAdapter);
            }
        });
    }

    private void initView() {
        mRclSubject = findViewById(R.id.rcl_home);
        mRclSubject.setLayoutManager(
                new GridLayoutManager(this, 7, GridLayoutManager.HORIZONTAL,
                        false));
        mRclSubject.setHasFixedSize(true);
        mHomeAdapter = new HomeAdapter();
        mBtnEdit = findViewById(R.id.btn_add);
        mBtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                startActivity(intent);
            }
        });
    }
}
