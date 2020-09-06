package vn.tien.mockproject.ui.edit;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import vn.tien.mockproject.model.Subject;
import vn.tien.mockproject.room.SubjectRepository;

public class EditViewModel extends AndroidViewModel {
    private SubjectRepository mRepository;
    private LiveData<List<Subject>> mSubjects;

    public EditViewModel(@NonNull Application application) {
        super(application);
        mRepository = new SubjectRepository(application);
        mSubjects =mRepository.getSubjects();
    }

    public LiveData<List<Subject>> getSubjects(){
        return mSubjects;
    }

    public void insertSubject(Subject subject){
        mRepository.insertSubject(subject);
    }

    public void deleteSubject(Subject subject){
        mRepository.deleteSubject(subject);
    }
}
