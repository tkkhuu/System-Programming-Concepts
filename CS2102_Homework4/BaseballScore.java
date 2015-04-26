class BaseballScore implements IScore {
  int runs1;
  int runs2;
  int totalInnings;
  
  BaseballScore (int runs1, int runs2, int totalInnings){
    this.runs1 = runs1;
    this.runs2 = runs2;
    this.totalInnings = totalInnings;
  }
  
  // question 1: winner() on scores
  public String winner(IContestant contest1, IContestant contest2) {
    if (this.runs1 > this.runs2) {
      return contest1.listName();
    }
    else if (this.runs2 > this.runs1) {
      return contest2.listName(); 
    }
    else {
     return contest1.listName();
    }
  }
}