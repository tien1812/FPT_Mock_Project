package vn.tien.mockproject.ui.activities;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import vn.tien.mockproject.model.Lesson;
import vn.tien.mockproject.repository.LessonRepository;

public class EditViewModel extends AndroidViewModel {
    private LessonRepository mRepository;
    private LiveData<List<Lesson>> mSubjects;

    public EditViewModel(@NonNull Application application) {
        super(application);
        mRepository = new LessonRepository(application);
        mSubjects =mRepository.getLessions();
    }

    public LiveData<List<Lesson>> getSubjects(){
        return mSubjects;
    }

    public void insertSubject(Lesson lesson){
        mRepository.insertSubject(lesson);
    }

    public void deleteSubject(Lesson lesson){
        mRepository.deleteSubject(lesson);
    }
}
