class SoccerScore implements IScore {
  int goals1;
  int goals2;
  boolean usedExtraTime;
  
  SoccerScore (int goals1, int goals2, boolean usedExtraTime){
   this.goals1 = goals1;
   this.goals2 = goals2;
   this.usedExtraTime = usedExtraTime;
  }
  
  // question 1: winner() on scores
  public String winner(IContestant contest1, IContestant contest2) {
    if (this.goals1 > this.goals2) {
      return contest1.listName(); 
    }
    else if (this.goals2 > this.goals1) {
      return contest2.listName();
    }
    else {
      return contest1.listName(); 
    }
  }
}