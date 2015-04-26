/* Tri Khuu: tkkhuu
 * Aung Soe: asoe
 * */
import tester.*;
import java.util.LinkedList;
class Examples {
  
  Examples(){
    initGraph();
    initG2();
    initG3();
    
  }
  /* examples for the given graph
   * **************************************************************************** */
  Node boston = new Node ("Boston");
  Node worcester = new Node ("Worcester");
  Node hartford = new Node ("Hartford");
  Node chicago = new Node ("Chicago");
  Node denver = new Node ("Denver");
  Node phoenix = new Node ("Phoenix");
  Node houston = new Node ("Houston");
  Node tulsa = new Node ("Tulsa");
  
  Graph airline = new Graph();
  
  
  Network net = new Network();
  
  LinkedList<Node> empty1 = new LinkedList<Node>();
  LinkedList<Node> empty2 = new LinkedList<Node>();
  LinkedList<Node> empty3 = new LinkedList<Node>();
  LinkedList<Node> empty4 = new LinkedList<Node>();
  LinkedList<Node> empty5 = new LinkedList<Node>();
  LinkedList<Node> empty6 = new LinkedList<Node>();
  LinkedList<Node> empty7 = new LinkedList<Node>();
  LinkedList<Node> empty8 = new LinkedList<Node>();
  
  
  Network nboston = new Network();
  Network nworcester = new Network();
  Network nhartford = new Network();
  Network nchicago = new Network();
  Network ndenver = new Network();
  Network nphoenix = new Network();
  Network nhouston = new Network();
  Network ntulsa = new Network();
  LinkedList<Network> nairline = new LinkedList<Network>();
  LinkedList<Pair> pairs = new LinkedList<Pair>();
  Pair pair1 = new Pair ("Worcester", "Denver");
  Pair pair2 = new Pair ("Denver", "Tulsa");
  
  /**
   * initialize graph airline
   * @param doesn't take anything
   * @return initialize airline
   * */
  void initGraph (){
    airline.newNode(boston);
    airline.newNode(worcester);
    airline.newNode(hartford);
    airline.newNode(chicago);
    airline.newNode(denver);
    airline.newNode(phoenix);
    airline.newNode(houston);
    airline.newNode(tulsa);
    
    airline.addDirectedEdge (boston, worcester);
    airline.addDirectedEdge (boston, hartford);
    airline.addDirectedEdge (chicago, denver);
    airline.addDirectedEdge (phoenix, houston);
    airline.addDirectedEdge (houston, tulsa);
    
    
    nboston.addNode(worcester);
    nboston.addNode(hartford);
    nboston.addNode(boston);
    
    nworcester.addNode(hartford);
    nworcester.addNode(boston);
    nworcester.addNode(worcester);
    
    nhartford.addNode(worcester);
    nhartford.addNode(boston);
    nhartford.addNode(hartford);
    
    nchicago.addNode(denver);
    nchicago.addNode(chicago);
    
   
    ndenver.addNode(chicago);
    ndenver.addNode(denver);
    
    nphoenix.addNode(tulsa);
    nphoenix.addNode(houston);
    nphoenix.addNode(phoenix);
    
    nhouston.addNode(phoenix);
    nhouston.addNode(houston);
    nhouston.addNode(tulsa);
    
    ntulsa.addNode(phoenix);
    ntulsa.addNode(houston);
    ntulsa.addNode(tulsa);
    
    nairline.add(nboston);
    nairline.add(nchicago);
    nairline.add(nphoenix);
    
    pairs.add(pair1);
    pairs.add(pair2);
  }
  
  /**
   * check networkCities
   * @param t,
   * @return return if the logic for networkCities is correct
   * */
  boolean testNetworkCities(Tester t) {
    
    return t.checkExpect(boston.networkCities(empty1), nboston) &&
      t.checkExpect(worcester.networkCities(empty2), nworcester) &&
      t.checkExpect(hartford.networkCities(empty3), nhartford) &&
      t.checkExpect(chicago.networkCities(empty4), nchicago) &&
      t.checkExpect(denver.networkCities(empty5), ndenver) &&
      t.checkExpect(phoenix.networkCities(empty6), nphoenix)&&
      t.checkExpect(tulsa.networkCities(empty7), ntulsa);
    }
  
  /**
   * check getNetWorks
   * @param t,
   * @return return if the logic for getNetworks is correct
   * */
  boolean testGetNetwork(Tester t){
    return t.checkExpect(airline.getNetworks(), nairline); 
  }
  
  /**
   * check newFlights
   * @param t,
   * @return return if the logic for newFlights is correct
   * */
  boolean testNewFlight(Tester t){
    return t.checkExpect(airline.newFlights(), pairs); 
  }
  
  /**
   * check hasRoute
   * @param t,
   * @return return if the logic for hasRoute is correct
   * */
  boolean testHasRoute(Tester t){
   return t.checkExpect(airline.hasRoute(worcester, boston), true) &&
     t.checkExpect(airline.hasRoute(boston, denver), false) &&
     t.checkExpect(airline.hasRoute(chicago, denver), true) &&
     t.checkExpect(airline.hasRoute(denver, phoenix), false) &&
     t.checkExpect(airline.hasRoute(denver, denver), true);
     
  }
  
  /********************************************************************************************/
  /********************************test empty graph********************************************/
  Graph g1 = new Graph();
  
  /**
   * check getNetworks
   * @param t,
   * @return return if the logic for getNetworks is correct on an empty graph
   * */
  boolean testGetNetwork1(Tester t){
    return t.checkExpect(g1.getNetworks(), new LinkedList<Network>()); 
  }
  
  boolean testNewFlight1(Tester t){
    return t.checkExpect(g1.newFlights(), new LinkedList<Pair>()); 
  }
  
  
  /********************************************************************************************/
  /********************************test graph with one node********************************************/
  Graph g2 = new Graph();
  Node city1 = new Node ("City1");
  Network net1 = new Network();
  LinkedList<Network> nets1= new LinkedList<Network>();
  /**
   * initialize graph g2
   * @param doesn't tae anything,
   * @return initialize g2
   * */
  void initG2(){
    g2.newNode(city1);
    net1.addNode(city1);
    nets1.add(net1);
  }
  
  /**
   * check hasRoute
   * @param t,
   * @return return if the logic for hasRoute is correct on a graph with one node
   * */
  boolean testHasRoute1(Tester t){
    return t.checkExpect(g1.hasRoute(city1, city1), true);
  }
  
  /**
   * check getNetworks
   * @param t,
   * @return return if the logic for getNetworks is correct on a graph with one node
   * */
  boolean testGetNetwork2(Tester t){
    return t.checkExpect(g2.getNetworks(), nets1); 
  }
  
  /**
   * check newFlights
   * @param t,
   * @return return if the logic for newFlights is correct on a graph with one node
   * */
  boolean testNewFlight2(Tester t){
    return t.checkExpect(g2.newFlights(), new LinkedList<Pair>()); 
  }
  
  /********************************************************************************************/
  /********************************test graph with one node that connect to two different nodes********************************************/
  Graph g3 = new Graph();
  Node city2 = new Node("City2");
  Node city3 = new Node("City3");
  Node city4 = new Node("City4");
  Node city5 = new Node("City5");
  Node city6 = new Node("City6");
  Node city7 = new Node("City7");
  
  Node city8 = new Node("City8");
  Node city9= new Node("City9");
  Node city10 = new Node ("City10");
  
  Network twoToseven = new Network();
  Network eightToten = new Network();
  LinkedList<Network> netG3 = new LinkedList<Network>();
  LinkedList<Network> nets3 = new LinkedList<Network>();
  Pair pair3 = new Pair ("City4", "City10");
  LinkedList<Pair> pairs2 = new LinkedList<Pair>();
  /**
   * initialize graph g3
   * @param doesn't tae anything,
   * @return initialize g3
   * */
  void initG3(){
    g3.newNode(city2);
    g3.newNode(city3);
    g3.newNode(city4);
    g3.newNode(city5);
    g3.newNode(city6);
    g3.newNode(city7);
    
    g3.newNode(city8);
    g3.newNode(city9);
    g3.newNode(city10);
    
    g3.addDirectedEdge(city2, city3);
    g3.addDirectedEdge(city3, city4);
    g3.addDirectedEdge(city3, city5);
    g3.addDirectedEdge(city5, city6);
    g3.addDirectedEdge(city5, city7);
    
    g3.addDirectedEdge(city8, city9);
    g3.addDirectedEdge(city9, city10);
    
    twoToseven.addNode(city4);
    twoToseven.addNode(city6);
    twoToseven.addNode(city7);
    twoToseven.addNode(city5);
    twoToseven.addNode(city3);
    twoToseven.addNode(city2);
    
    eightToten.addNode(city10);
    eightToten.addNode(city9);
    eightToten.addNode(city8);
    
    netG3.add(twoToseven);
    netG3.add(eightToten);
    
    pairs2.add(pair3);
  }
  /**
   * check hasRoute
   * @param t,
   * @return return if the logic for hasRoute is correct on a graph with one node that connect to two different nodes
   * */
  boolean testHasRoute2(Tester t){
    return t.checkExpect(g3.hasRoute(city2, city3), true)&&
      t.checkExpect(g3.hasRoute(city2, city6), true) &&
      t.checkExpect(g3.hasRoute(city5, city5), true) &&
      t.checkExpect(g3.hasRoute(city4, city7), true) &&
      t.checkExpect(g3.hasRoute(city6, city10), false) &&
      t.checkExpect(g3.hasRoute(city9, city3), false);
  }
  
  /**
   * check getNetworks
   * @param t,
   * @return return if the logic for getNetworks is correct on a graph with one node that connect to two different nodes
   * */
  boolean testGetNetWorks(Tester t){
    return t.checkExpect(g3.getNetworks(), netG3); 
  }
  
  /**
   * check newFlights
   * @param t,
   * @return return if the logic for newFlights is correct on a graph with one node that connect to two different nodes
   * */
  boolean testNewFlights(Tester t){
   return t.checkExpect(g3.newFlights(), pairs2); 
  }
  
}