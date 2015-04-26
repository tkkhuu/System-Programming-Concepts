// Tri Khuu: tkkhuu
// Aung Soe: asoe
import tester.*;
class Examples{
  Examples (){}
  
  MenuItem item10 = new MenuItem ("chicken", 10);
  MenuItem item5 = new MenuItem ("fish", 5);
  MenuItem item6 = new MenuItem ("pork", 6);
  MenuItem item7 = new MenuItem ("beef", 7);
  MenuItem item8 = new MenuItem ("carrot", 8);
  MenuItem item9 = new MenuItem ("apple", 9);
  MenuItem item12 = new MenuItem ("orange", 12);
  
  MenuItem item20 = new MenuItem ("chicken", 20);
  MenuItem item21 = new MenuItem ("fish", 21);
  MenuItem item22 = new MenuItem ("pork", 22);
  MenuItem item23 = new MenuItem ("beef", 23);
  MenuItem item24 = new MenuItem ("carrot", 24);
  MenuItem item25 = new MenuItem ("apple", 25);
  
  MtHeap<MenuItem> emptyHeap = new MtHeap<MenuItem>();
  DataHeap<MenuItem> menuHeap = new DataHeap<MenuItem> (item5,
                                                        new DataHeap<MenuItem> (item6,
                                                                                new DataHeap<MenuItem> (item8, new MtHeap<MenuItem>(), new MtHeap<MenuItem>()),
                                                                                new DataHeap<MenuItem> (item9, new MtHeap<MenuItem>(), new MtHeap<MenuItem>())),
                                                        new DataHeap<MenuItem> (item7,
                                                                                new DataHeap<MenuItem> (item10, new MtHeap<MenuItem>(), new MtHeap<MenuItem>()),
                                                                                new MtHeap<MenuItem>())); 
  
  DataHeap<MenuItem> menuHeap2 = new DataHeap<MenuItem> (item20,
                                                        new DataHeap<MenuItem> (item21,
                                                                                new MtHeap<MenuItem>(),
                                                                                new MtHeap<MenuItem>()),
                                                        new DataHeap<MenuItem> (item22,
                                                                                new MtHeap<MenuItem>(),
                                                                                new MtHeap<MenuItem>()));
  
  DataHeap<MenuItem> menuHeap3 = new DataHeap<MenuItem> (item23,
                                                        new DataHeap<MenuItem> (item24,
                                                                                new MtHeap<MenuItem>(),
                                                                                new MtHeap<MenuItem>()),
                                                        new DataHeap<MenuItem> (item25,
                                                                                new MtHeap<MenuItem>(),
                                                                                new MtHeap<MenuItem>()));
  
  //--------------------------------test cases for DataHeap--------------------------------------------------------------------
boolean testAddElt(Tester t) {
      return t.checkExpect(menuHeap.addElt(item12),
                           new DataHeap<MenuItem> (item5,
                                                   new DataHeap<MenuItem> (item6,
                                                                           new DataHeap<MenuItem> (item8, new MtHeap<MenuItem>(), new MtHeap<MenuItem>()),
                                                                           new DataHeap<MenuItem> (item9, new MtHeap<MenuItem>(), new MtHeap<MenuItem>())),
                                                   new DataHeap<MenuItem> (item7,
                                                                           new DataHeap<MenuItem> (item10, new MtHeap<MenuItem>(), new MtHeap<MenuItem>()),
                                                                           new DataHeap<MenuItem> (item12, new MtHeap<MenuItem>(), new MtHeap<MenuItem>())))); 
    }
//----------------------------------------------------------------------------------------------------
boolean testFindMinElt(Tester t) {
  return t.checkExpect(menuHeap.findMinElt(), item5);
}

//----------------------------------------------------------------------------------------------------
boolean testRemoveMinElt(Tester t) {
  return t.checkExpect(menuHeap.removeMinElt(),
                       new DataHeap<MenuItem> (item6,
                                               new DataHeap<MenuItem> (item7,
                                                                       new DataHeap<MenuItem> (item10, new MtHeap<MenuItem>(), new MtHeap<MenuItem>()),
                                                                       new MtHeap<MenuItem>()),
                                               new DataHeap<MenuItem> (item8,
                                                                       new DataHeap<MenuItem> (item9, new MtHeap<MenuItem>(), new MtHeap<MenuItem>()),
                                                                       new MtHeap<MenuItem>()))); 
}
//----------------------------------------------------------------------------------------------------
boolean testHeight(Tester t) {
 return t.checkExpect(menuHeap.height(), 3);
}

//----------------------------------------------------------------------------------------------------
boolean testisBigger(Tester t) {
 return t.checkExpect(menuHeap.isBigger(item6), false);
}
//----------------------------------------------------------------------------------------------------
boolean testMerge(Tester t) {
 return t.checkExpect(menuHeap2.merge(menuHeap3),
                      new DataHeap<MenuItem> (item20,
                                              new DataHeap<MenuItem> (item23,
                                                                      new DataHeap<MenuItem> (item24, new MtHeap<MenuItem>(), new MtHeap<MenuItem>()),
                                                                      new DataHeap<MenuItem> (item25, new MtHeap<MenuItem>(), new MtHeap<MenuItem>())),
                                              new DataHeap<MenuItem> (item21,
                                                                      new DataHeap<MenuItem> (item22, new MtHeap<MenuItem>(), new MtHeap<MenuItem>()),
                                                                      new MtHeap<MenuItem>()))); 
}
//--------------------------------test cases for MtHeap--------------------------------------------------------------------
boolean testAddEltMt(Tester t) {
      return t.checkExpect(emptyHeap.addElt(item12),
                           new DataHeap<MenuItem> (item12,
                                                   new MtHeap<MenuItem>(),
                                                   new MtHeap<MenuItem>()));}
boolean testRemoveEltMt(Tester t) {
      return t.checkExpect(emptyHeap.removeMinElt(),
                           emptyHeap);}

boolean testHeight1(Tester t) {
 return t.checkExpect(emptyHeap.height(), 0);
}   

boolean testMerge2(Tester t) {
 return t.checkExpect(emptyHeap.merge(menuHeap3),
                      new DataHeap<MenuItem> (item23,
                                              new DataHeap<MenuItem> (item24,
                                                                      new MtHeap<MenuItem>(),
                                                                      new MtHeap<MenuItem>()),
                                              new DataHeap<MenuItem> (item25,
                                                                      new MtHeap<MenuItem>(),
                                                                      new MtHeap<MenuItem>())));
  
}

boolean testisBigger2(Tester t) {
  return t.checkExpect(emptyHeap.isBigger(item20), true);
}
}
