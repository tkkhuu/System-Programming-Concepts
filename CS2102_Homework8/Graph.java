import java.util.LinkedList;
class Graph implements IGraph {
  private LinkedList<Node> nodes;
  
  public Graph () {
   this.nodes = new LinkedList<Node>(); 
  }
  /**
   * add a node into the graph
   * @param n given node
   * @return add a new node into the graph
   */
  public void newNode(Node n){
    this.nodes.add(n);
  }
  /**
   * add a round tripp between two node
   * @param from to ,
   * @return add a round way route from the from node to the to node
   */
  public void addDirectedEdge(Node from, Node to){
   from.addEdge(to);
   to.addEdge(from);
  }
  
  /**
   * check whether there's a route from this city to another city
   * @param from to
   * @return check return true if there's a route from the from node to the to node
   */
  public boolean hasRoute(Node from, Node to){
   return from.hasRoute(to, new LinkedList<Node>()); 
  }
  /**
   * return a list of network in the graph from an empty visted list
   * @param doesn't take any thing
   * @return return a list of network of the graph
   * */
  public LinkedList<Network> getNetworks (){
   return getNetworks (new LinkedList<Node>()); 
  }
  
  /**
   * return a list of network in the graph
   * @param visisted, to check whether the node has been checked
   * @return a list of network of this graph
   * */
  public LinkedList<Network> getNetworks (LinkedList<Node> visited){
   LinkedList<Network> listofnetwork = new LinkedList<Network>();
    for (Node n: nodes){
      if (!visited.contains(n)){
        listofnetwork.add(n.networkCities(visited));
      }
    }
    return listofnetwork;
  }
  
  /**
   * returns a pair of networks that make network becomes a single graph
   * @param doesn't take any input
   * @return return a list of pair that makes multiple network becomes one single network
   * */
  public LinkedList<Pair> newFlights(){
    LinkedList<Pair> listofpair = new LinkedList<Pair>();
    LinkedList<Network> networks = this.getNetworks(new LinkedList<Node>());
    if (networks.size() > 1){
      for (int i = 0; i < (networks.size() - 1); i++){
        Network net1 = networks.get(i);
        Network net2 = networks.get(i+1);
        listofpair.add(new Pair (net1.get(0), net2.get(0))); 
      }
    }
    return listofpair;
  }
}