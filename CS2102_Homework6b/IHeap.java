interface IHeap<T extends Comparable<T>> {
  IHeap<T> addElt(T elt);
  T findMinElt();
//  IHeap removeMinElt();
  int height();
//  
  // merges this heap with the given heap
  IHeap<T> merge (IHeap<T> other);
  
  // get the root of the Heap
  T getRoot();
  
  // get the right sub tree
  IHeap<T> getRight();
  
  // get the left sub tree
  IHeap<T> getLeft();
  
  // to check whether the heap is bigger than another heap
  boolean isBigger(T elt);
}