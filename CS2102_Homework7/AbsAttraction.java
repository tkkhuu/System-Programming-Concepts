abstract class AbsAttraction{
  String name;
  Location location;
  //-------------------------------------------------------------------
  AbsAttraction (String name, Location location){
    this.name = name;
    this.location = location;
  }
  //-------------------------------------------------------------------
  public String getName(){
    return this.name; 
  }
  //-------------------------------------------------------------------
  abstract boolean accept(ISelect selected);
  
}