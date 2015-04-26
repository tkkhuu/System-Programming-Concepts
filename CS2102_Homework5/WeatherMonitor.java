import java.util.LinkedList;
//                               DailyWeatherReport
//                                        /\
//                                       /  \
//                                      /    \
//                                     /      \
//                                          Readings
//                                            /\
//                                           /  \
//                                          /    \
//                                         /      \
//                                       Time    temp


class WeatherMonitor {
 IDailyWeatherReport idwr;
 
 WeatherMonitor (IDailyWeatherReport idwr){
   this.idwr = idwr;
 }
 //------------------------------------------------------------
 public double averageHighForMonth(int month, int year){
  return this.idwr.averageHighForMonth(month, year); 
 }
 //------------------------------------------------------------
 public double averageLowForMonth(int month, int year){
  return this.idwr.averageLowForMonth(month, year); 
 }
 
 //------------------------------------------------------------
 
 void addDailyReport(Date date, LinkedList<Readings> readings){
   this.idwr.addDailyReport(date, readings); 
 }
}
 





  


 
