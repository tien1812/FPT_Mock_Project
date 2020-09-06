package vn.tien.mockproject.room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import vn.tien.mockproject.model.Subject;

public class SubjectRepository {
    private SubjectDao mSubjectDao;
    private LiveData<List<Subject>> mSubjects;

    public SubjectRepository(Application application) {
        SubjectRoomDataBase db = SubjectRoomDataBase.getInstance(application);
        mSubjectDao = db.subjectDao();
        mSubjects = mSubjectDao.getAllSubjects();
    }

    public LiveData<List<Subject>> getSubjects(){
        return mSubjects;
    }

    public void insertSubject(Subject subject){
        new InsertSubject(mSubjectDao).execute(subject);
    }

    public void deleteSubject(Subject subject){
        new DeleteSubject(mSubjectDao).execute(subject);
    }


    private static class InsertSubject extends AsyncTask<Subject,Void,Void>{
        private SubjectDao mSubjectDao;

        public InsertSubject(SubjectDao subjectDao) {
            mSubjectDao = subjectDao;
        }

        @Override
        protected Void doInBackground(Subject... subjects) {
            mSubjectDao.insertSubject(subjects[0]);
            return null;
        }
    }

    private static class DeleteSubject extends AsyncTask<Subject,Void,Void>{
        private SubjectDao mSubjectDao;

        public DeleteSubject(SubjectDao subjectDao) {
            mSubjectDao = subjectDao;
        }

        @Override
        protected Void doInBackground(Subject... subjects) {
            mSubjectDao.deteleSubject(subjects[0]);
            return null;
        }
    }
}
