class DailyWeatherReport {
  private Date date;
  private Readings hightemp;
  private Readings lowtemp;
  
  public DailyWeatherReport (Date date, Readings hightemp, Readings lowtemp){
   this.date = date;
   this.hightemp = hightemp;
   this.lowtemp = lowtemp;
  }
  
  // --------------------------------------------
  public int getHighTemp () {
    return this.hightemp.getTemp();
  }
  
  //---------------------------------------------
  public int getLowTemp () {
   return this.lowtemp.getTemp(); 
  }
  
  //----------------------------------------------
  public int getMonthFromDate(){
    return this.date.getMonth();
  }
  
  // ------------------------------------------------
  public int getYearFromDate(){
    return this.date.getYear();
  }
}


