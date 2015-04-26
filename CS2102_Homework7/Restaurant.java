class Restaurant extends AbsAttraction implements IRated, Comparable<Restaurant>{
 int rating;
 //-------------------------------------------------------------------
 Restaurant (String name, Location location, int rating){
  super (name, location);
  this.rating = rating;
 }
 //-------------------------------------------------------------------
 
 public boolean highlyRated(){
  return this.rating >= 4; 
 }
 //-------------------------------------------------------------------
 public int compareTo(Restaurant restaurant){
  return this.name.compareTo(restaurant.name); 
 }
 //-------------------------------------------------------------------
 public int restaurantGetStreet(){
  return this.location.getStreet(); 
 }
 //-------------------------------------------------------------------
 public boolean accept(ISelect selected){
  return selected.choose(this); 
 }
}