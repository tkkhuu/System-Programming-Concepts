// defining MatchData
// MatchData is (make-match-data String String Score)
// (define-struct match-data (contestant1 contestant2 score))
class MatchData {
  IContestant contestant1;
  IContestant contestant2;
  IScore score;
  
  MatchData (IContestant contestant1, IContestant contestant2, IScore score){
   this.contestant1 = contestant1;
   this.contestant2 = contestant2;
   this.score = score;
  }
  
  String winner() {
    return this.score.winner(this.contestant1, this.contestant2); 
  }
}