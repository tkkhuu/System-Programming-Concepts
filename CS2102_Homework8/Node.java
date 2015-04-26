import java.util.LinkedList;
class Node {
 private String city;
 private LinkedList <Node> getsTo;
 
 
 public Node(String city) {
   this.city = city;
   this.getsTo = new LinkedList<Node>();
   
 }
 
 /**
  * getter for city
  * @param doesn't take anything
  * @return return the name of the city of this node
  */
 public String getCity(){
   return this.city;
 }
 /**
  * add an edge from this node to a given node
  * @param toNode, input a given node
  * @return add an edge between the given node and this  node
  */
 public void addEdge(Node toNode){
   this.getsTo.add(toNode);
 }
 
 /**
  * check to see whether there's an available route from this node to a given node
  * @param to visited, input a given node and a visited list
  * return true or false whether there's an available route from this node to a given node
  * */
 boolean hasRoute(Node to, LinkedList<Node> visited) {
   if (this.equals(to))
     return true;
   else if (visited.contains(this))
     return false;
   else {
     visited.add(this);
     for (Node c : this.getsTo) {
       if (c.hasRoute(to,visited)) {
         return true;
       }
     }
     return false;
   }
 }
 
 /**
  * add the cities that are connected to a network
  * logic:
  * initialize an empty network
  * starting from this node, add this node into the network if this node is not in the network
  * start checking the list getsTo using a for-each loop and add all the elements of the getsTo list into the network
  * recursively check for the getsTo list of each element of this getsTo list
  * the function will return a network with all connected node
  * @param visited, input a list to keepp track of the visited node
  * @return return a network of all the cities connected to this city
  * */ 
 public Network networkCities (LinkedList<Node> visited){
   Network net = new Network();
   if (!visited.contains(this)){
     visited.add(this);
     for (Node n: this.getsTo){
       net.merge(n.networkCities(visited));
     } 
    net.addNode(this);
   }
   return net;
 }
}