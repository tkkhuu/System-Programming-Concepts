class Hotel extends AbsAttraction implements IRated, Comparable<Hotel>{
 int rating;
 //-------------------------------------------------------------------
 Hotel (String name, Location location, int rating){
  super (name, location);
  this.rating = rating;
 }
 //-------------------------------------------------------------------
 public boolean highlyRated(){
  return rating >= 4; 
 }
 //-------------------------------------------------------------------
 public int compareTo(Hotel hotel){
  return this.name.compareTo(hotel.name); 
 }
 //-------------------------------------------------------------------
 public int hotelGetStreet(){
  return this.location.getStreet(); 
 }
 //-------------------------------------------------------------------
 public boolean accept(ISelect selected){
  return selected.choose(this); 
 }
}