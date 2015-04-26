interface IRanked extends IContestant{
  boolean hasBetterRanking(IRanked contestant);
  int listRanking();
}