// defining Tournament
// Tournament is either
// - (make-init-match MatchData)
// - (make-advance-match MatchData Tournament Tournament)
// (define-struct init-match (data))
// (define-struct advance-match (data feeder1 feeder2))

interface ITournament {
  int size(); // helper function to get the size of a ITournament
  boolean isBalanced();
}