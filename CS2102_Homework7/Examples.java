import tester.* ;
class Examples {
  Examples () {} ;
  
  // examples of hotel
  Hotel hotel1 = new Hotel ("O",
                            new Location (12, 34),
                            3);
  Hotel hotel2 = new Hotel ("hotel 2",
                            new Location (34, 184),
                            4);
   
  // examples of museum
  Museum museum1 = new Museum ("museum 1",
                               new Location (45, 32),
                               5);
  Museum museum2 = new Museum ("museum 2",
                               new Location (45, 32),
                               12);
  
  // examples of restaurant
  Restaurant res1 = new Restaurant ("restaurant 1",
                                    new Location (87, 109),
                                    2);
  Restaurant res2 = new Restaurant ("restaurant 2",
                                    new Location (12, 89),
                                    5);
  
  // examples of LocatedAbove
  LocatedAbove loc1 = new LocatedAbove (12);
  LocatedAbove loc2 = new LocatedAbove (1200);
  LocatedAbove loc3 = new LocatedAbove (1);
  
  // example of a DataAttraction
  DataAttraction data1 = new DataAttraction (new Hotel ("P", 
                                                        new Location (23, 71),
                                                        4),
                                             new DataAttraction (new Museum ("N",
                                                                             new Location (45, 31),
                                                                             13),
                                                                 new DataAttraction (new Restaurant ("M",
                                                                                                     new Location (45, 32),
                                                                                                     5),
                                                                                     new MtAttraction(),
                                                                                     new MtAttraction()),
                                                                 new MtAttraction()),
                                              new DataAttraction (new Restaurant ("R",
                                                                                  new Location (5, 2),
                                                                                  3),
                                                                  new DataAttraction (new Hotel ("Q",
                                                                                                 new Location (4, 32),
                                                                                                 5),
                                                                                      new MtAttraction(),
                                                                                      new MtAttraction()),
                                                                  new DataAttraction (new Restaurant ("S",
                                                                                                      new Location (4, 32),
                                                                                                      5),
                                                                                      new MtAttraction(),
                                                                                      new MtAttraction())));
  
  MtAttraction emptyAttr = new MtAttraction();
  
  // tester for addElt
  
  boolean testaddElt(Tester t) {
      return t.checkExpect(data1.addElt(hotel1),
                           new DataAttraction (new Hotel ("P", 
                                                        new Location (23, 71),
                                                        4),
                                             new DataAttraction (new Museum ("N",
                                                                             new Location (45, 31),
                                                                             13),
                                                                 new DataAttraction (new Restaurant ("M",
                                                                                                     new Location (45, 32),
                                                                                                     5),
                                                                                     new MtAttraction(),
                                                                                     new MtAttraction()),
                                                                 new DataAttraction (hotel1, new MtAttraction(), new MtAttraction())),
                                              new DataAttraction (new Restaurant ("R",
                                                                                  new Location (5, 2),
                                                                                  3),
                                                                  new DataAttraction (new Hotel ("Q",
                                                                                                 new Location (4, 32),
                                                                                                 5),
                                                                                      new MtAttraction(),
                                                                                      new MtAttraction()),
                                                                  new DataAttraction (new Restaurant ("S",
                                                                                                      new Location (4, 32),
                                                                                                      5),
                                                                                      new MtAttraction(),
                                                                                      new MtAttraction())))) ;
  }
  
  // tests for containsAny()
  boolean testContainsAny1(Tester t) {
      return t.checkExpect(data1.containsAny(loc1),
                           true) ;
    }
  boolean testContainsAny2(Tester t) {
      return t.checkExpect(data1.containsAny(loc2),
                           false) ;
    }
  
  // tests for allAre()
  boolean testAllAre1(Tester t) {
      return t.checkExpect(data1.allAre(loc1),
                           false) ;
    } 
  boolean testAllAre2(Tester t) {
      return t.checkExpect(data1.allAre(loc3),
                           true) ;
    } 
                                                                    
                                               
                                                                 
  
}