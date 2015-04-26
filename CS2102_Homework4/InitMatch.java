class InitMatch implements ITournament {
 MatchData data;
 InitMatch (MatchData data){
   this.data = data;
 }
 
 public int size() {
  return 1; 
 }
 
 public boolean isBalanced(){
   return true;
 }
}