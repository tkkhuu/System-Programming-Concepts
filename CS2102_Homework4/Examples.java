// Tri Khuu
// tkkhuu

import tester.*;
class Examples {
  Examples () {};
  
  // Examples of contestants
  Baseball teamBaseball1 = new Baseball ("baseball 1", 20, "baseball captain 1");
  Baseball teamBaseball2 = new Baseball ("baseball 2", 22, "baseball captain 2");
  Soccer teamSoccer1 = new Soccer ("soccer 1", 20, "soccer captain 1", 10);
  Soccer teamSoccer2 = new Soccer ("soccer 2", 23, "soccer captain 2", 11);
  Swimming swimmer1 = new Swimming ("swimmer 1", 5);
  Swimming swimmer2 = new Swimming ("swimmer 2", 9);
  
  // Examples of class SoccerScore
  SoccerScore firstSoccerMatch = new SoccerScore (2, 1, false);
  SoccerScore secondSoccerMatch = new SoccerScore (3, 3, false);
  SoccerScore thirdSoccerMatch = new SoccerScore (4, 3, false);
  
  // Examples of class BaseballScore
  BaseballScore firstBaseballMatch = new BaseballScore (4, 6, 7);
  BaseballScore secondBaseballMatch = new BaseballScore (13, 5, 9);
  BaseballScore thirdBaseballMatch = new BaseballScore (13, 13, 9);
  
  // Examples of class SwimmingScore
  SwimmingScore firstSwimmingMatch = new SwimmingScore (3.5, 4);
  
  // Examples of MatchData
  MatchData finalBaseballData = new MatchData (new Baseball ("baseball team a", 20, "baseball captain a"),
                                             new Baseball ("baseball team b", 21, "baseball captain b"),
                                             new BaseballScore (5, 9, 10));
  MatchData finalSoccerData = new MatchData (new Soccer ("soccer team 2", 19, "soccer captain 2", 4), 
                                             new Soccer ("soccer team 3", 19, "soccer captain 3", 3),
                                             new SoccerScore (2, 3, false));
  MatchData finalSwimmingData = new MatchData (new Swimming ("swimmer 2", 8),
                                               new Swimming ("swimmer 4", 7),
                                               new SwimmingScore (2, 9));
  
  //Examples of InitMatch
  InitMatch baseballInitMatch = new InitMatch (new MatchData (new Baseball ("baseball team c", 18, "baseball captain c"),
                                                              new Baseball ("baseball team d", 21, "baseball captain d"),
                                                              new BaseballScore (5, 9, 10)));
  InitMatch soccerInitMatch = new InitMatch (new MatchData (new Soccer ("soccer team 4", 19, "soccer captain 4", 5), 
                                                            new Soccer ("soccer team 5", 19, "soccer captain 5", 6),
                                                            new SoccerScore (2, 3, false)));
  
  // Examples of AdvanceMatch
  AdvanceMatch soccerAdvanceMatch = new AdvanceMatch (new MatchData (new Soccer ("soccer team 6", 19, "soccer captain 6", 5), 
                                                                     new Soccer ("soccer team 7", 17, "soccer captain 7", 6),
                                                                     new SoccerScore (2, 3, false)),
                                                      new AdvanceMatch (new MatchData (new Soccer ("soccer team 6", 19, "soccer captain 6", 5), 
                                                                                       new Soccer ("soccer team 8", 17, "soccer captain 8", 6),
                                                                                       new SoccerScore (2, 3, false)),
                                                                        new InitMatch (new MatchData (new Soccer ("soccer team 6", 19, "soccer captain 6", 5), 
                                                                                                       new Soccer ("soccer team 12", 19, "soccer captain 12", 6),
                                                                                                       new SoccerScore (4, 3, false))),
                                                                        new InitMatch (new MatchData (new Soccer ("soccer team 8", 17, "soccer captain 8", 6), 
                                                                                                       new Soccer ("soccer team 5", 19, "soccer captain 5", 6),
                                                                                                       new SoccerScore (5, 3, false)))),
                                                      new AdvanceMatch (new MatchData (new Soccer ("soccer team 16", 19, "soccer captain 16", 5), 
                                                                                       new Soccer ("soccer team 7", 17, "soccer captain 7", 6),
                                                                                       new SoccerScore (2, 3, false)),
                                                                        new InitMatch (new MatchData (new Soccer ("soccer team 26", 19, "soccer captain 26", 5), 
                                                                                                       new Soccer ("soccer team 7", 17, "soccer captain 7", 6),
                                                                                                       new SoccerScore (1, 3, false))),
                                                                        new InitMatch (new MatchData (new Soccer ("soccer team 16", 19, "soccer captain 16", 5), 
                                                                                                       new Soccer ("soccer team 10", 19, "soccer captain 10", 6),
                                                                                                       new SoccerScore (5, 3, false)))));
  
  AdvanceMatch baseballAdvanceMatch = new AdvanceMatch (new MatchData (new Baseball ("baseball team 12", 18, "baseball captain 12"),
                                                                       new Baseball ("baseball team 13", 21, "baseball captain 13"),
                                                                       new BaseballScore (5, 9, 10)),
                                                        new InitMatch (new MatchData (new Baseball ("baseball team 12", 18, "baseball captain 12"),
                                                                                      new Baseball ("baseball team 14", 21, "baseball captain 14"),
                                                                                      new BaseballScore (13, 9, 10))),
                                                        new InitMatch (new MatchData (new Baseball ("baseball team 15", 18, "baseball captain 15"),
                                                                                      new Baseball ("baseball team 13", 21, "baseball captain 13"),
                                                                                      new BaseballScore (13, 16, 13))));
  AdvanceMatch swimmingAdvanceMatch = new AdvanceMatch (new MatchData (new Swimming ("swimmer 6", 5), 
                                                                     new Swimming ("swimmer 19", 17),
                                                                     new SwimmingScore (2, 3)),
                                                      new AdvanceMatch (new MatchData (new Swimming ("swimmer 17", 19), 
                                                                                       new Swimming ("swimmer 15", 17),
                                                                                       new SwimmingScore (2, 3)),
                                                                        new InitMatch (new MatchData (new Swimming ("swimmer 12", 6), 
                                                                                                       new Swimming ("swimer 24", 19),
                                                                                                       new SwimmingScore (4, 3))),
                                                                        new InitMatch (new MatchData (new Swimming ("swimmer 15", 17), 
                                                                                                       new Swimming ("swimmer", 19),
                                                                                                       new SwimmingScore (5, 3)))),
                                                      new InitMatch (new MatchData (new Swimming ("swimmer 30", 25), 
                                                                                       new Swimming ("swimmer 25", 6),
                                                                                       new SwimmingScore (2, 3))));
  
  // question 1 test cases: winner(IContestant, IContestant)
  
  boolean testWinner1(Tester t) {
      return t.checkExpect(firstSoccerMatch.winner(teamSoccer1, teamSoccer2),
                           "soccer 1");
    }
  boolean testWinner2(Tester t) {
      return t.checkExpect(firstBaseballMatch.winner(teamBaseball1, teamBaseball2),
                           "baseball 2");
    }
   boolean testWinner3(Tester t) {
      return t.checkExpect(firstSwimmingMatch.winner(swimmer1, swimmer2),
                           "swimmer 1");
    }
   
   // question 2 test cases: winner()
   boolean testWinner4(Tester t) {
      return t.checkExpect(finalBaseballData.winner(),
                           "baseball team b");
    }
   boolean testWinner5(Tester t) {
      return t.checkExpect(finalSoccerData.winner(),
                           "soccer team 3");
    }
   boolean testWinner6(Tester t) {
      return t.checkExpect(finalSwimmingData.winner(),
                           "swimmer 2");
    }
   
   // question 3 test cases: hasBetterRanking()
   boolean testHasBetterRanking1(Tester t) {
      return t.checkExpect(swimmer1.hasBetterRanking(swimmer2),
                           true);
    }
   boolean testHasBetterRanking2(Tester t) {
      return t.checkExpect(swimmer2.hasBetterRanking(swimmer1),
                           false);
    }
   boolean testHasBetterRanking3(Tester t) {
      return t.checkExpect(teamSoccer1.hasBetterRanking(teamSoccer2),
                           true);
    }
   boolean testHasBetterRanking4(Tester t) {
      return t.checkExpect(teamSoccer2.hasBetterRanking(teamSoccer1),
                           false);
    }
   
   // question 4 test cases: isBalanced()
   boolean testIsBalanced1(Tester t) {
      return t.checkExpect(soccerAdvanceMatch.isBalanced(),
                           true);
    }
   boolean testIsBalanced2(Tester t) {
      return t.checkExpect(swimmingAdvanceMatch.isBalanced(),
                           false);
    }
   boolean testIsBalanced3(Tester t) {
      return t.checkExpect(baseballAdvanceMatch.isBalanced(),
                           true);
    }
   boolean testIsBalanced4(Tester t) {
      return t.checkExpect(baseballInitMatch.isBalanced(),
                           true);
    }
                                                   
}