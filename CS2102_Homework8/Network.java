import java.util.LinkedList;
class Network {
  LinkedList <String> citynames;
 
 public Network (){
  this.citynames = new LinkedList<String>(); 
 }
 
 public Network(LinkedList <String> citynames){
   this.citynames = citynames;
 }
 
 /**
  * add a node into this network
  * @param n, input a node
  * @return add the given node into the network
  * */
 public void addNode (Node n){
  this.citynames.add(n.getCity()); 
 }
 
 /**
  * merge two network together
  * @param net, input a network
  * merge this network with the given network
  * */
 public void merge(Network net){
   this.citynames.addAll(net.citynames);
 }
 
 /**
  * get an element from the network
  * @param i, the index of the element in the network
  * @return return the element with the given index
  * */
 public String get(int i){
   return this.citynames.get(i);
 }
}