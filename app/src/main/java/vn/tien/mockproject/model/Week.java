package vn.tien.mockproject.model;

import java.util.Date;
import java.util.List;

public class Week {
    private Date mStartDate;
    private Date mEndDate;
    private List<LessonSchedule> mLessonSchedules;

    public Week(Date startDate, Date endDate, List<LessonSchedule> lessonSchedules) {
        mStartDate = startDate;
        mEndDate = endDate;
        mLessonSchedules = lessonSchedules;
    }

    public Date getStartDate() {
        return mStartDate;
    }

    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    public Date getEndDate() {
        return mEndDate;
    }

    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }

    public List<LessonSchedule> getLessonSchedules() {
        return mLessonSchedules;
    }

    public void setLessonSchedules(List<LessonSchedule> lessonSchedules) {
        mLessonSchedules = lessonSchedules;
    }

}
