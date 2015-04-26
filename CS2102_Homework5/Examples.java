// Aung Heain Soe: asoe
// Tri Khuu: tkkhuu


import java.util.LinkedList;
import tester.* ;
class Examples {
  Examples () {} 
  //----------------------------------------------------------------------------------
  
  LinkedList<DailyWeatherReport> myList = new LinkedList<DailyWeatherReport>();
  void populateList(){
    myList.add(new DailyWeatherReport (new Date (8, 10, 2013), 
                                       new Readings (new Time (15, 20), 30),
                                       new Readings (new Time (12, 30), 28)));
     myList.add(new DailyWeatherReport (new Date (28, 10, 2013), 
                                        new Readings (new Time (14, 20), 36),
                                        new Readings (new Time (12, 30), 35)));
     myList.add(new DailyWeatherReport (new Date (28, 12, 2013), 
                                        new Readings (new Time (14, 20), 38),
                                        new Readings (new Time (12, 30), 35)));
     myList.add(new DailyWeatherReport (new Date (24, 10, 2013), 
                                        new Readings (new Time (1, 20), 40),
                                        new Readings (new Time (12, 30), 32)));
     myList.add(new DailyWeatherReport (new Date (25, 10, 2013), 
                                        new Readings (new Time (1, 20), 45),
                                        new Readings (new Time (12, 30), 40)));
     return;
  }
  
  //-------------------------------------------------------------------------------------
  
  DWRList octoberReport;
  
  Date tenthAugust1997 = new Date (10, 8, 1997);
  Date thirtyfirstSeptember2013 = new Date (31, 9, 2013);
 
  
  Time nineThirtyAM = new Time (9, 30);
  Time fivePM = new Time (17, 0);
  //Time fivePM1 = new Time (27, 0);
  
  Readings tempAtFiveThirtyPM = new Readings (new Time (17, 30), 30);
  Readings tempAtSixAM = new Readings (new Time (6, 0), 26);
  
  DailyWeatherReport tempNinthApril2013 = new DailyWeatherReport (new Date (9, 4, 2013),
                                                                  new Readings (new Time (12, 30), 35),
                                                                  new Readings (new Time (18, 0), 29));
  
  //-------------------------------------------------------------------------------------
  // test cases for isDateValid()
  
  
  boolean test1(Tester t) {
    return t.checkExpect(tenthAugust1997.isDateValid(),
                         true);
  }
  
  boolean test2(Tester t) {
    return t.checkExpect(thirtyfirstSeptember2013.isDateValid(),
                         true);
  }
  
  
  //-------------------------------------------------------------------------------------
  // test cases for isTimeValid()
  
  boolean test4(Tester t) {
    return t.checkExpect(nineThirtyAM.isTimeValid(),
                         true);
  }
  
  boolean test5(Tester t) {
    return t.checkExpect(fivePM.isTimeValid(),
                         true);
  }
  
  
  
  //-------------------------------------------------------------------------------------
  
  boolean test7(Tester t) {
    populateList();
    octoberReport = new DWRList (myList);
    return t.checkExpect(octoberReport.averageHighForMonth(10, 2013),
                         37.75);
  }
  
  boolean test8(Tester t) {
    populateList();
    octoberReport = new DWRList (myList);
    return t.checkExpect(octoberReport.averageLowForMonth(10, 2013),
                         33.75);
  }
}
