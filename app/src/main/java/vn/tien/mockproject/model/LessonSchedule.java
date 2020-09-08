package vn.tien.mockproject.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import java.util.Date;

@Entity(tableName = "schedule")
public class LessonSchedule {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "day")
    private int mDay;
    @Embedded
    private Lesson mLesson;
    private Date mStartDay;
    private Date mEndDay;

    public LessonSchedule() {
    }

    public LessonSchedule(Lesson lesson, int day, Date startDay, Date endDay) {
        mLesson = lesson;
        mDay = day;
        mStartDay = startDay;
        mEndDay = endDay;
    }

    public Lesson getLesson() {
        return mLesson;
    }

    public void setLesson(Lesson lesson) {
        mLesson = lesson;
    }

    public int getDay() {
        return mDay;
    }

    public void setDay(int day) {
        mDay = day;
    }

    public Date getStartDay() {
        return mStartDay;
    }

    public void setStartDay(Date startDay) {
        mStartDay = startDay;
    }

    public Date getEndDay() {
        return mEndDay;
    }

    public void setEndDay(Date endDay) {
        mEndDay = endDay;
    }

    public static class Converters {
        @TypeConverter
        public Date fromTimestamp(Long value) {
            return value == null ? null : new Date(value);
        }

        @TypeConverter
        public Long dateToTimestamp(Date date) {
            if (date == null) {
                return null;
            } else {
                return date.getTime();
            }
        }
    }
}
