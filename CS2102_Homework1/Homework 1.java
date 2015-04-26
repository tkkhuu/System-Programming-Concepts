// defining data type for Score
// Score is either
// - (make-soccer-score Number Number Boolean)
// - (make-baseball-score Number Number Number)
// (define-struct soccer-score (goals1 goals2 extra-time?))
// (define-struct baseball-score (runs1 runs2 total-innings))
interface IScore {}
class Soccer implements IScore {
  int goals1;
  int goals2;
  boolean isExtraTime;
  Soccer (int goals1, int goals2, boolean isExtraTime){
   this.goals1 = goals1;
   this.goals2 = goals2;
   this.isExtraTime = isExtraTime;
  }
}

class Baseball implements IScore {
  int runs1;
  int runs2;
  int totalInnings;
  Baseball (int runs1, int runs2, int totalInnings){
    this.runs1 = runs1;
    this.runs2 = runs2;
    this.totalInnings = totalInnings;
  }
}
// defining MatchData
// MatchData is (make-match-data String String Score)
// (define-struct match-data (contestant1 contestant2 score))
class MatchData {
  String contestant1;
  String contestant2;
  IScore score;
  MatchData (String contestant1, String contestant2, IScore score){
   this.contestant1 = contestant1;
   this.contestant2 = contestant2;
   this.score = score;
  }
}

// defining Tournament
// Tournament is either
// - (make-init-match MatchData)
// - (make-advance-match MatchData Tournament Tournament)
// (define-struct init-match (data))
// (define-struct advance-match (data feeder1 feeder2))

interface ITournament {}

class InitialMatch implements ITournament {
 MatchData data;
 InitialMatch (MatchData data){
   this.data = data;
 }
}

class AdvanceMatch implements ITournament {
 MatchData data;
 ITournament feeder1;
 ITournament feeder2;
 AdvanceMatch (MatchData data, ITournament feeder1, ITournament feeder2){
   this.data = data;
   this.feeder1 = feeder1;
   this.feeder2 = feeder2;
 }
}








