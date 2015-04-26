class SwimmingScore implements IScore {
 double time1;
 double time2;
 
 SwimmingScore (double time1, double time2){
  this.time1 = time1;
  this.time2 = time2;
 }
 
 // question 1: winner() on scores
 public String winner (IContestant contest1, IContestant contest2){
   if (time1 < time2) {
    return contest1.listName(); 
   }
   else if (time2 < time1) {
    return contest2.listName(); 
   }
   else {
    return contest1.listName(); 
   }
 }
}