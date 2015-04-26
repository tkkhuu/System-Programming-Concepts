abstract class AbstractIRanked implements IRanked{
 String name;
 int ranking;
 
 AbstractIRanked (String name, int ranking){
  this.name = name;
  this.ranking = ranking;
 }
 
 // helper function to list the name of the contestant
 public String listName() {
  return this.name; 
 }
 
 // question 3:
 // helper function to list ranking
 public int listRanking() {
   return this.ranking;
 }
} 