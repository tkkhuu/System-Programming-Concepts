class Readings {
 private Time time;
 private int temperature; // Fahrenheit
 
 public Readings (Time time, int temperature){
   this.time = time;
   this.temperature = temperature;
 }
 
 public int getTemp (){
  return this.temperature; 
 }
 
 public Time getTime(){
   return this.time;
 }
}