import java.util.LinkedList;
interface IGraph {
  void newNode(Node n);
  LinkedList<Network> getNetworks();
  void addDirectedEdge(Node from, Node to);
  boolean hasRoute(Node from, Node to);
}