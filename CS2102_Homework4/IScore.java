// defining data type for Score
// Score is either
// - (make-soccer-score Number Number Boolean)
// - (make-baseball-score Number Number Number)
// (define-struct soccer-score (goals1 goals2 extra-time?))
// (define-struct baseball-score (runs1 runs2 total-innings))
interface IScore {
  String winner(IContestant contest1, IContestant contest2);
}