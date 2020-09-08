package vn.tien.mockproject.roomDb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import vn.tien.mockproject.model.Lesson;

@Dao
public interface LessonDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertSubject(Lesson lesson);

    @Query("SELECT * from lession ORDER BY lessionName ASC")
    LiveData<List<Lesson>> getAllLession();

    @Delete
    void deteleSubject(Lesson lesson);

    @Query("SELECT * from lession LIMIT 1")
    Lesson[] getAnyLession();
}
