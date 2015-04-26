class MenuItem implements Comparable<MenuItem>{
  String name;
  int price;
  MenuItem(String name, int price) {
    this.name = name;
    this.price = price;
  }

  public int compareTo(MenuItem item){
    return this.price - item.price;
  }
}