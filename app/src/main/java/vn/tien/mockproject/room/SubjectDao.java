package vn.tien.mockproject.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import vn.tien.mockproject.model.Subject;

@Dao
public interface SubjectDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertSubject(Subject subject);

    @Query("SELECT * from subject ORDER BY subjectName ASC")
    LiveData<List<Subject>> getAllSubjects();

    @Delete
    void deteleSubject(Subject subject);

    @Query("SELECT * from subject LIMIT 1")
    Subject[] getAnySubject();
}
