package vn.tien.mockproject.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "subject")
public class Subject {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "subjectName")
    private String mName;


    public Subject(String name) {
        mName = name;
    }

    public Subject() {
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
