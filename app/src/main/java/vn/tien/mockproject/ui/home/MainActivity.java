package vn.tien.mockproject.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.tien.mockproject.ui.edit.EditActivity;
import vn.tien.mockproject.R;
import vn.tien.mockproject.model.Day;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRclSubject;
    private DayAdapter mDayAdapter;
    private List<Day> mDays;
    private Button mBtnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        mDays = new ArrayList<>();
        mDays.add(new Day());
        mDays.add(new Day());
        mDays.add(new Day());
        mDays.add(new Day());
        mDays.add(new Day());
        mDays.add(new Day());
        mDays.add(new Day());
    }

    private void initView() {
        mRclSubject = findViewById(R.id.rcl_home);
        mRclSubject.setLayoutManager(
                new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL,
                        false));
        mRclSubject.setHasFixedSize(true);
        mDayAdapter = new DayAdapter();
        mDayAdapter.setDays(mDays);
        mRclSubject.setAdapter(mDayAdapter);
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
