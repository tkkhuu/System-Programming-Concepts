import java.util.LinkedList;
class DWRList implements IDailyWeatherReport {
 LinkedList<DailyWeatherReport> dailyreports;
 
 public DWRList (LinkedList<DailyWeatherReport> dailyreports){
  this.dailyreports = dailyreports; 
 }
 
 //----------------------------------------------------------------------
 
 public double averageHighForMonth (int month, int year){
   if (month >=1 && month <= 12 && year > 0){
   int sumofhightemp;
   double numberofelt;
   
   numberofelt = 0;
   sumofhightemp = 0;
   for (DailyWeatherReport dwr:dailyreports){
     if (dwr.getMonthFromDate() == month && dwr.getYearFromDate() == year){
       sumofhightemp = sumofhightemp + dwr.getHighTemp();
       numberofelt = numberofelt + 1;
     }
   }
   return sumofhightemp/numberofelt;
   }
   else throw new RuntimeException ("date not valid");
 }
 



// --------------------------------------------------------------------
public double averageLowForMonth (int month, int year){
  if (month >=1 && month <= 12 && year >0){
   int sumoflowtemp;
   double numberofelt;
   numberofelt = 0;
   sumoflowtemp = 0;
   for (DailyWeatherReport dwr:dailyreports){
     if (dwr.getMonthFromDate() == month && dwr.getYearFromDate() == year){
     sumoflowtemp = sumoflowtemp + dwr.getLowTemp();
     numberofelt = numberofelt + 1;
     }
   }
   return sumoflowtemp/numberofelt;
  }
  else throw new RuntimeException ("date not valid");
}

// --------------------------------------------------------------------

public void addDailyReport (Date date, LinkedList<Readings> readings){
 int lowest = readings.getFirst().getTemp();
 int highest = readings.getFirst().getTemp();
 Readings lowestReading = readings.getFirst();
 Readings highestReading = readings.getFirst();
 
  for (Readings x: readings) {
   if (x.getTemp() < lowest) {
    lowest = x.getTemp();
    lowestReading = x;
   }
   if (x.getTemp() > highest) {
    highest = x.getTemp();
    highestReading = x;
  }
  dailyreports.add(new DailyWeatherReport(date, highestReading, lowestReading));
  }
}
}

 
