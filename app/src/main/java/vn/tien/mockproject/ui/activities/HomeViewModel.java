package vn.tien.mockproject.ui.activities;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import vn.tien.mockproject.model.LessonSchedule;
import vn.tien.mockproject.repository.LessonScheduleRepository;

public class HomeViewModel extends AndroidViewModel {
    private LessonScheduleRepository mScheduleRepository;
    private LiveData<List<LessonSchedule>> mSchedule;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        mScheduleRepository = new LessonScheduleRepository(application);
        mSchedule = mScheduleRepository.getLessions();
    }

    public LiveData<List<LessonSchedule>> getSchedule(){
        return mSchedule;
    }

    public void insert(LessonSchedule lessonSchedule){
        mScheduleRepository.insert(lessonSchedule);
    }

    public void delete(LessonSchedule lessonSchedule){
        mScheduleRepository.delete(lessonSchedule);
    }
}
