package vn.tien.mockproject.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "lession")
public class Lesson {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "lessionName")
    private String mName;


    public Lesson(String name) {
        mName = name;
    }

    public Lesson() {
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
