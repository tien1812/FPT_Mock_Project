package vn.tien.mockproject.model;

public class Day {
    private Subject mLession1;
    private Subject mLession2;
    private Subject mLession3;
    private Subject mLession4;
    private Subject mLession5;
    private Subject mLession6;

   public Day() {
   }

   public Day(Subject lession1,
              Subject lession2, Subject lession3,
              Subject lession4, Subject lession5,
              Subject lession6) {
      mLession1 = lession1;
      mLession2 = lession2;
      mLession3 = lession3;
      mLession4 = lession4;
      mLession5 = lession5;
      mLession6 = lession6;
   }

   public Subject getLession1() {
      return mLession1;
   }

   public void setLession1(Subject lession1) {
      mLession1 = lession1;
   }

   public Subject getLession2() {
      return mLession2;
   }

   public void setLession2(Subject lession2) {
      mLession2 = lession2;
   }

   public Subject getLession3() {
      return mLession3;
   }

   public void setLession3(Subject lession3) {
      mLession3 = lession3;
   }

   public Subject getLession4() {
      return mLession4;
   }

   public void setLession4(Subject lession4) {
      mLession4 = lession4;
   }

   public Subject getLession5() {
      return mLession5;
   }

   public void setLession5(Subject lession5) {
      mLession5 = lession5;
   }

   public Subject getLession6() {
      return mLession6;
   }

   public void setLession6(Subject lession6) {
      mLession6 = lession6;
   }
}
