package vn.tien.mockproject.roomDb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import vn.tien.mockproject.model.LessonSchedule;

@Database(entities = {LessonSchedule.class}, version = 1)
@TypeConverters({LessonSchedule.Converters.class})
public abstract class LessonScheduleRoom extends RoomDatabase {
    public abstract LessonScheduleDao mLessionScheduleDao();

    private static LessonScheduleRoom sLessonScheduleRoom;

    public static LessonScheduleRoom getInstance(Context context) {
        if (sLessonScheduleRoom == null) {
            synchronized (LessonScheduleRoom.class) {
                sLessonScheduleRoom = Room.databaseBuilder(context.getApplicationContext(),
                        LessonScheduleRoom.class,
                        "Schedule.db")
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return sLessonScheduleRoom;
    }

}
