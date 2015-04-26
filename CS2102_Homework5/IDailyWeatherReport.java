import java.util.LinkedList;
interface IDailyWeatherReport{
  double averageHighForMonth(int month, int year);
  double averageLowForMonth(int month, int year);
  void addDailyReport(Date date, LinkedList<Readings> readings);
}