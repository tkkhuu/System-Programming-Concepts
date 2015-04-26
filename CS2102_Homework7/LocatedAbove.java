class LocatedAbove implements ISelect {
  int street;
  
  LocatedAbove (int street){
   this.street = street; 
  }
  
  //-------------------------------------------------------------------
  public boolean choose(Hotel item){
    return item.hotelGetStreet() > this.street;
  }
  
  //-------------------------------------------------------------------
  public boolean choose(Restaurant item){
    return item.restaurantGetStreet() > this.street;
  }
  
  //-------------------------------------------------------------------
   public boolean choose(Museum item){
    return item.museumGetStreet() > this.street;
  }
}