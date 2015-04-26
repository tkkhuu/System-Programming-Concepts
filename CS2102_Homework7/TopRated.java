class TopRated implements ISelect{
  TopRated(){}
  //-------------------------------------------------------------------
  // check whether the given hotel has high rating
  public boolean choose(Hotel item){
    return item.highlyRated();
  }
  //-------------------------------------------------------------------
  // returns false for museum because museum is not a rated item 
  public boolean choose(Museum item){
    return false;
  }
  //-------------------------------------------------------------------
  // check whether the given restaurant has high rating
  public boolean choose (Restaurant item){
   return item.highlyRated(); 
  }
}