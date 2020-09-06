package vn.tien.mockproject.room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import vn.tien.mockproject.model.Subject;

@Database(entities = {Subject.class}, version = 1)
public abstract class SubjectRoomDataBase extends RoomDatabase {
    public abstract SubjectDao subjectDao();

    private static SubjectRoomDataBase sSubjectRoomDataBase;

    private static RoomDatabase.Callback sCallback = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new InitDataAsync(sSubjectRoomDataBase).execute();
        }
    };

    public static SubjectRoomDataBase getInstance(Context context) {
        if (sSubjectRoomDataBase == null) {
            synchronized (SubjectRoomDataBase.class) {
                sSubjectRoomDataBase = Room.databaseBuilder(context.getApplicationContext(),
                        SubjectRoomDataBase.class,
                        "Subject.db")
                        .fallbackToDestructiveMigration()
                        .addCallback(sCallback)
                        .build();
            }
        }
        return sSubjectRoomDataBase;
    }

    private static class InitDataAsync extends AsyncTask<Void, Void, Void> {
        private SubjectDao mSubjectDao;
        private String[] subjects = {"Math", "Geogrephy", "It", "Physycal"};

        public InitDataAsync(SubjectRoomDataBase db) {
            mSubjectDao = db.subjectDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            if (mSubjectDao.getAnySubject().length == 0) {
                for (int i = 0; i < subjects.length; i++) {
                    Subject subject = new Subject(subjects[i]);
                    mSubjectDao.insertSubject(subject);
                }
            }
            return null;
        }
    }

}
