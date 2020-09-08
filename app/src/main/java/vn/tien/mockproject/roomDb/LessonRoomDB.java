package vn.tien.mockproject.roomDb;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import vn.tien.mockproject.model.Lesson;

@Database(entities = {Lesson.class}, version = 1)
public abstract class LessonRoomDB extends RoomDatabase {
    public abstract LessonDao lessionDao();

    private static LessonRoomDB sLessonRoomDB;

    private static RoomDatabase.Callback sCallback = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new InitDataAsync(sLessonRoomDB).execute();
        }
    };

    public static LessonRoomDB getInstance(Context context) {
        if (sLessonRoomDB == null) {
            synchronized (LessonRoomDB.class) {
                sLessonRoomDB = Room.databaseBuilder(context.getApplicationContext(),
                        LessonRoomDB.class,
                        "Lession.db")
                        .fallbackToDestructiveMigration()
                        .addCallback(sCallback)
                        .build();
            }
        }
        return sLessonRoomDB;
    }

    private static class InitDataAsync extends AsyncTask<Void, Void, Void> {
        private LessonDao mLessonDao;
        private String[] lessions = {"Math", "Geogrephy", "It", "Physycal"};

        public InitDataAsync(LessonRoomDB db) {
            mLessonDao = db.lessionDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            if (mLessonDao.getAnyLession().length == 0) {
                for (int i = 0; i < lessions.length; i++) {
                    Lesson lesson = new Lesson(lessions[i]);
                    mLessonDao.insertSubject(lesson);
                }
            }
            return null;
        }
    }

}
