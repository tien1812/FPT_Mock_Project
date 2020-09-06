package vn.tien.mockproject.model;

public class Week {
    private Day mMonday;
    private Day mTuesday;
    private Day mWednesday;
    private Day mThursday;
    private Day mFriday;
    private Day mSaturday;

    public Week(Day monday, Day tuesday, Day wednesday, Day thursday, Day friday, Day saturday) {
        mMonday = monday;
        mTuesday = tuesday;
        mWednesday = wednesday;
        mThursday = thursday;
        mFriday = friday;
        mSaturday = saturday;
    }

    public Week() {
    }

    public Day getMonday() {
        return mMonday;
    }

    public void setMonday(Day monday) {
        mMonday = monday;
    }

    public Day getTuesday() {
        return mTuesday;
    }

    public void setTuesday(Day tuesday) {
        mTuesday = tuesday;
    }

    public Day getWednesday() {
        return mWednesday;
    }

    public void setWednesday(Day wednesday) {
        mWednesday = wednesday;
    }

    public Day getThursday() {
        return mThursday;
    }

    public void setThursday(Day thursday) {
        mThursday = thursday;
    }

    public Day getFriday() {
        return mFriday;
    }

    public void setFriday(Day friday) {
        mFriday = friday;
    }

    public Day getSaturday() {
        return mSaturday;
    }

    public void setSaturday(Day saturday) {
        mSaturday = saturday;
    }
}
