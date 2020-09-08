package vn.tien.mockproject.roomDb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import vn.tien.mockproject.model.Lesson;
import vn.tien.mockproject.model.LessonSchedule;

@Dao
public interface LessonScheduleDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(LessonSchedule lesson);

    @Query("SELECT * from schedule ORDER BY day ASC")
    LiveData<List<LessonSchedule>> getAllLession();

    @Delete
    void deteleSubject(LessonSchedule lesson);

    @Query("SELECT * from schedule LIMIT 1")
    Lesson[] getAnyLession();
}
