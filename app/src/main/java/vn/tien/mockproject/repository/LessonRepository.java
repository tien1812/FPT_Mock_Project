package vn.tien.mockproject.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import vn.tien.mockproject.model.Lesson;
import vn.tien.mockproject.roomDb.LessonDao;
import vn.tien.mockproject.roomDb.LessonRoomDB;

public class LessonRepository {
    private LessonDao mLessonDao;
    private LiveData<List<Lesson>> mLessions;

    public LessonRepository(Application application) {
        LessonRoomDB db = LessonRoomDB.getInstance(application);
        mLessonDao = db.lessionDao();
        mLessions = mLessonDao.getAllLession();
    }

    public LiveData<List<Lesson>> getLessions(){
        return mLessions;
    }

    public void insertSubject(Lesson lesson){
        new InsertSubject(mLessonDao).execute(lesson);
    }

    public void deleteSubject(Lesson lesson){
        new DeleteSubject(mLessonDao).execute(lesson);
    }


    private static class InsertSubject extends AsyncTask<Lesson,Void,Void>{
        private LessonDao mLessonDao;

        public InsertSubject(LessonDao lessonDao) {
            mLessonDao = lessonDao;
        }

        @Override
        protected Void doInBackground(Lesson... lessons) {
            mLessonDao.insertSubject(lessons[0]);
            return null;
        }
    }

    private static class DeleteSubject extends AsyncTask<Lesson,Void,Void>{
        private LessonDao mLessonDao;

        public DeleteSubject(LessonDao lessonDao) {
            mLessonDao = lessonDao;
        }

        @Override
        protected Void doInBackground(Lesson... lessons) {
            mLessonDao.deteleSubject(lessons[0]);
            return null;
        }
    }
}
