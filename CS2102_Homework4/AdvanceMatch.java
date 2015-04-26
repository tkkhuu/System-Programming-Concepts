class AdvanceMatch implements ITournament {
 MatchData data;
 ITournament feeder1;
 ITournament feeder2;
 AdvanceMatch (MatchData data, ITournament feeder1, ITournament feeder2){
   this.data = data;
   this.feeder1 = feeder1;
   this.feeder2 = feeder2;
 }
 
 public int size () {
   return 1 + this.feeder1.size() + this.feeder2.size();
 }
 
 public boolean isBalanced () {
   return (feeder1.size() == feeder2.size()) && 
     feeder1.isBalanced() && feeder2.isBalanced();
 }
}

