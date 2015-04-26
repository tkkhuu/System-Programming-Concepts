class Soccer extends AbstractITeam implements IRanked {
  int ranking;
  
  Soccer (String teamName, int numPlayers, String captain, int ranking){
   super(teamName, numPlayers, captain);
   this.ranking = ranking;
  }
  boolean isRankedValid () {
   return this.ranking > 0; 
  }
  
  // question 3
  // helper function to display the ranking
  public int listRanking() {
   return this.ranking;
 }
  // hasBetterRanking
 public boolean hasBetterRanking (IRanked contestant){
   return this.ranking < contestant.listRanking();
 }
}