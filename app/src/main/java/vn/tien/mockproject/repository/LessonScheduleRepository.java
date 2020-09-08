package vn.tien.mockproject.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import vn.tien.mockproject.model.LessonSchedule;
import vn.tien.mockproject.roomDb.LessonScheduleDao;
import vn.tien.mockproject.roomDb.LessonScheduleRoom;

public class LessonScheduleRepository {
    private LessonScheduleDao mLessonScheduleDao;
    private LiveData<List<LessonSchedule>> mLessions;

    public LessonScheduleRepository(Application application) {
        LessonScheduleRoom db = LessonScheduleRoom.getInstance(application);
        mLessonScheduleDao = db.mLessionScheduleDao();
        mLessions = mLessonScheduleDao.getAllLession();
    }

    public LiveData<List<LessonSchedule>> getLessions() {
        return mLessions;
    }

    public void insert(LessonSchedule lesson) {
        new Insert(mLessonScheduleDao).execute(lesson);
    }

    public void delete(LessonSchedule lesson) {
        new Delete(mLessonScheduleDao).execute(lesson);
    }


    private static class Insert extends AsyncTask<LessonSchedule, Void, Void> {
        private LessonScheduleDao mLessonDao;

        public Insert(LessonScheduleDao lessonDao) {
            mLessonDao = lessonDao;
        }

        @Override
        protected Void doInBackground(LessonSchedule... lessonSchedules) {
            mLessonDao.insert(lessonSchedules[0]);
            return null;
        }
    }

    private static class Delete extends AsyncTask<LessonSchedule, Void, Void> {
        private LessonScheduleDao mLessonDao;

        public Delete(LessonScheduleDao lessonDao) {
            mLessonDao = lessonDao;
        }

        @Override
        protected Void doInBackground(LessonSchedule... lessonSchedules) {
            mLessonDao.deteleSubject(lessonSchedules[0]);
            return null;
        }
    }
}
