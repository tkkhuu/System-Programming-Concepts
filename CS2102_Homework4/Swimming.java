class Swimming extends AbstractIRanked {
 
  Swimming (String name, int ranking){
   super (name, ranking); 
  }
  
  boolean isRankedValid () {
   return this.ranking > 0 ; 
  }
  
  // hasBetterRanking()
 public boolean hasBetterRanking (IRanked contestant){
   return this.ranking < contestant.listRanking();
 }
}