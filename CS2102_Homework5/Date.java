// definition of class Date
class Date {
 private int date;
 private int month; 
 private int year;  
 
 Date (int date, int month, int year){
  this.date = date;
  this.month = month;
  this.year = year;
  if (isDateValid ()){
   //else throw new RuntimeException ("Date not valid");
  }
 }
 
 public int getMonth () {
  return this.month; 
 }
 
 public int getYear () {
  return this.year; 
 }
 // check whether the date is valid: date 1 -> 31
 public boolean isDateValid () {
  return (0 < this.date && this.date < 32) &&
    (0 < this.month && this.month < 13);
 }
}
 
