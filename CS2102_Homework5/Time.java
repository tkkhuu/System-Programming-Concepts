class Time {
 private int hour;
 private int minutes;
 
 Time (int hour, int minutes){
  this.hour = hour; // 0 - 23
  this.minutes = minutes; // 0 - 59
if (!isTimeValid()){
 throw new RuntimeException ("time not valid");
 }
 }
 
 public boolean isTimeValid (){
   return this.hour > 0 && this.hour <= 23 && this.minutes >= 0 && this.minutes <= 59;
     
 }
}