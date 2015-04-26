class Museum extends AbsAttraction implements Comparable<Museum>{
 double fee;
  //-------------------------------------------------------------------
 Museum (String name, Location location, int fee){
  super (name, location);
  this.fee = fee;
 }
 //-------------------------------------------------------------------
 public int compareTo(Museum museum){
  return this.name.compareTo(museum.name); 
 }
 //-------------------------------------------------------------------
 public int museumGetStreet(){
  return this.location.getStreet(); 
 }
 //-------------------------------------------------------------------
 public boolean accept(ISelect selected){
  return selected.choose(this); 
 }
}