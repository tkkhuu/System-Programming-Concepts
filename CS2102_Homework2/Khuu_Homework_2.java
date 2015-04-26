import tester.* ;
// defining data type for Score
// Score is either
// - (make-soccer-score Number Number Boolean)
// - (make-baseball-score Number Number Number)
// (define-struct soccer-score (goals1 goals2 extra-time?))
// (define-struct baseball-score (runs1 runs2 total-innings))
interface IScore {
  boolean isValid();
  String produceWinner(); // helper function to display the winner from scores
}

class SoccerScore implements IScore {
  int goals1;
  int goals2;
  boolean usedExtraTime;
  
  SoccerScore (int goals1, int goals2, boolean usedExtraTime){
   this.goals1 = goals1;
   this.goals2 = goals2;
   this.usedExtraTime = usedExtraTime;
  }
  
  public boolean isValid () {
    if ((this.goals1 == this.goals2) && !this.usedExtraTime) {
     return false;  
    }
    else {
      return true;
    }   
  }
  // helper function to display the winner from scores
  public String produceWinner(){
    if (this.goals1 > this.goals2){
     return  "contestant 1";
    }
    else {
     return "contestant 2"; 
    }
  }
  
}

class BaseballScore implements IScore {
  int runs1;
  int runs2;
  int totalInnings;
  
  BaseballScore (int runs1, int runs2, int totalInnings){
    this.runs1 = runs1;
    this.runs2 = runs2;
    this.totalInnings = totalInnings;
  }
  
  public boolean isValid () {
    if ((this.totalInnings < 9) || (this.runs1 == this.runs2)){
     return false; 
    }
    else {
     return true; 
    }
  }
  // helper function to display the winner from scores
  public String produceWinner(){
    if (this.runs1 > this.runs2){
     return  "contestant 1";
    }
    else {
     return "contestant 2"; 
    }
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
  
  boolean isScoreValid() {
   return this.score.isValid();
 }
  // helper function
  // determine if the name of either contestant 1 or 2 match a given name
  boolean doesNameMatch(String contestant) {
    return (this.contestant1.equals(contestant)) ||
      (this.contestant2.equals(contestant));
  }
  // helper function to display the winner from the score data
  String displayWinner(){
    if (this.score.produceWinner().equals("contestant 1")){
      return contestant1;
    }
    else {
      return contestant2;
    }
    
  }
}

// defining Tournament
// Tournament is either
// - (make-init-match MatchData)
// - (make-advance-match MatchData Tournament Tournament)
// (define-struct init-match (data))
// (define-struct advance-match (data feeder1 feeder2))

interface ITournament {
  boolean allScoresValid();
  int matchesPlayedBy(String contestant);
  boolean winnerAlwaysAdvanced();
  String showWinner(); // helper function to display the winner got from MatchData
}

class InitMatch implements ITournament {
 MatchData data;
 InitMatch (MatchData data){
   this.data = data;
 }
 // helper function
 // determine if the score is valid
 public boolean allScoresValid() {
   return this.data.isScoreValid();
 }
 
 public int matchesPlayedBy(String contestant) {
   if ((this.data.doesNameMatch(contestant))){
     return 1;
   }
   else {
    return 0; 
   }
 }
 public boolean winnerAlwaysAdvanced(){
  return true; 
 }
 
 // helper function to display the winner got from MatchData
 public String showWinner(){
  return this.data.displayWinner(); 
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
 public boolean allScoresValid() {
   return this.data.isScoreValid() &&
     this.feeder1.allScoresValid() &&
     this.feeder2.allScoresValid(); 
 }
 public int matchesPlayedBy(String contestant) {
   if ((this.data.doesNameMatch(contestant))){
     return 1 + (this.feeder1.matchesPlayedBy(contestant)) + (this.feeder2.matchesPlayedBy(contestant));
   }
   else {
    return (this.feeder1.matchesPlayedBy(contestant)) + (this.feeder2.matchesPlayedBy(contestant)); 
   }
 }
 // helper function to display the winner got from MatchData
 public String showWinner(){
  return this.data.displayWinner(); 
 }
 
 public boolean winnerAlwaysAdvanced(){
   return (this.data.doesNameMatch(feeder1.showWinner())) &&
     (this.data.doesNameMatch(feeder2.showWinner()));
 }
}

class Examples {
  Examples () {};
  
  // Example of class SoccerScore
  SoccerScore firstSoccerMatch = new SoccerScore (2, 1, false);
  SoccerScore secondSoccerMatch = new SoccerScore (3, 3, false);
  SoccerScore thirdSoccerMatch = new SoccerScore (4, 3, false);
  
  // Example of class BaseballScore
  BaseballScore firstBaseballMatch = new BaseballScore (4, 6, 7);
  BaseballScore secondBaseballMatch = new BaseballScore (13, 5, 9);
  BaseballScore thirdBaseballMatch = new BaseballScore (13, 13, 9);
  
  // Example of MatchData
  MatchData finalSoccerData = new MatchData ("soccer team 1", "soccer team 5", 
                                             new SoccerScore (2, 3, false));
  MatchData finalBaseballData = new MatchData ("baseball team 2", "baseball team 6", 
                                               new BaseballScore (10, 9, 9));
  
  //Example of InitMatch
  InitMatch soccerInitMatch = new InitMatch (new MatchData ("soccer team 1", "soccer team 2", 
                                                            new SoccerScore (2, 2, false)));
  InitMatch baseballInitMatch = new InitMatch (new MatchData ("baseball team 1", "baseball team 2", 
                                                              new BaseballScore (10, 5, 6)));
  
  // Example of AdvanceMatch
  AdvanceMatch soccerAdvanceMatch = new AdvanceMatch (new MatchData ("soccer team 2", "soccer team 12", 
                                                            new SoccerScore (2, 2, true)),
                                                      new AdvanceMatch (new MatchData ("soccer team 12", "soccer team 4",
                                                                                  new SoccerScore (3, 1, false)),
                                                                   new InitMatch (new MatchData ("soccer team 1", "soccer team 12", new SoccerScore (2, 1, false))),
                                                                   new InitMatch (new MatchData ("soccer team 12", "soccer team 16", new SoccerScore (1, 2, false)))),
                                                      new InitMatch (new MatchData ("soccer team 2", "soccer team 14", new SoccerScore (2, 1, false))));
  
  AdvanceMatch baseballAdvanceMatch = new AdvanceMatch (new MatchData ("baseball team 2", "baseball team 12", 
                                                            new BaseballScore (2, 3, 9)),
                                                        new AdvanceMatch (new MatchData ("baseball team 4", "baseball team 6",
                                                                                  new BaseballScore (3, 1, 10)),
                                                                   new InitMatch (new MatchData ("baseball team 1", "baseball team 7", new BaseballScore (2, 3, 8))),
                                                                   new InitMatch (new MatchData ("baseball team 13", "baseball team 6", new BaseballScore (1, 2, 12)))),
                                                        new InitMatch (new MatchData ("baseball team 6", "baseball team 7", new BaseballScore (10, 1, 9))));
  
  // Test cases for isValid() 
  boolean testSoccerValid1(Tester t) {
      return t.checkExpect(firstSoccerMatch.isValid(),
                           true) ;
    }
  boolean testSoccerValid2(Tester t) {
      return t.checkExpect(secondSoccerMatch.isValid(),
                           false) ;
    }
  boolean testSoccerValid3(Tester t) {
      return t.checkExpect(thirdSoccerMatch.isValid(),
                           true) ;
    }
  boolean testBaseballValid1(Tester t) {
      return t.checkExpect(firstBaseballMatch.isValid(),
                           false) ;
    }
  boolean testBaseballValid2(Tester t) {
      return t.checkExpect(secondBaseballMatch.isValid(),
                           true) ;
    }
  boolean testBaseballValid3(Tester t) {
      return t.checkExpect(thirdBaseballMatch.isValid(),
                           false) ;
    }
  
  // Test cases for allScoresValid()
  boolean testAllScore1(Tester t) {
      return t.checkExpect(soccerInitMatch.allScoresValid(),
                           false) ;
    }
  boolean testAllScore2(Tester t) {
      return t.checkExpect(baseballInitMatch.allScoresValid(),
                           false) ;
    }
  boolean testAllScore3(Tester t) {
      return t.checkExpect(soccerAdvanceMatch.allScoresValid(),
                           true) ;
    }
  boolean testAllScore4(Tester t) {
      return t.checkExpect(baseballAdvanceMatch.allScoresValid(),
                           false) ;
    }
  
  // Test cases for allScoresValid()
  boolean testmatchPlayedBy1(Tester t) {
      return t.checkExpect(soccerInitMatch.matchesPlayedBy("soccer team 1"), 1);
    }
  boolean testmatchPlayedBy2(Tester t) {
      return t.checkExpect(soccerAdvanceMatch.matchesPlayedBy("soccer team 12"), 4);
    }
  boolean testmatchPlayedBy3(Tester t) {
      return t.checkExpect(baseballAdvanceMatch.matchesPlayedBy("baseball team 6"), 3);
    }
  boolean testmatchPlayedBy4(Tester t) {
      return t.checkExpect(baseballAdvanceMatch.matchesPlayedBy("baseball team 3"), 0);
    }
  
  // Test cases for winnerAlwaysAdvanced()
  boolean testWinner1(Tester t) {
      return t.checkExpect(soccerInitMatch.winnerAlwaysAdvanced(), true);
    }
  boolean testWinner2(Tester t) {
      return t.checkExpect(soccerAdvanceMatch.winnerAlwaysAdvanced(), true);
    }
  boolean testWinner3(Tester t) {
      return t.checkExpect(baseballAdvanceMatch.winnerAlwaysAdvanced(), false);
    }
}


                                                 
                                             
  
  
  






