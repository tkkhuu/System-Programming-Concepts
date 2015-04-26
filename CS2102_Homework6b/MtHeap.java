class MtHeap <T extends Comparable<T>> implements IHeap<T>{
  MtHeap (){}
  //--------------------------------------------------------------------
  public IHeap<T> addElt(T elt){
    return new DataHeap<T> (elt, new MtHeap<T>(), new MtHeap<T>());
  }
  //--------------------------------------------------------------------
  public T findMinElt(){
   throw new RuntimeException ("an MtHeap doesn't contain any element"); 
  }
  //--------------------------------------------------------------------
  public IHeap<T> removeMinElt(){
    return this;
  }
  //--------------------------------------------------------------------
  public int height(){
   return 0; 
  }
  //--------------------------------------------------------------------
  
  public T getRoot(){
    throw new RuntimeException ("this method is in valid for MtHeap"); 
  }
  
  // get the right sub tree
  public IHeap<T> getRight(){
   throw new RuntimeException ("this method is in valid for MtHeap"); 
  }
  
  // get the left sub tree
  public IHeap<T> getLeft(){
   throw new RuntimeException ("this method is in valid for MtHeap"); 
  }
  
  //--------------------------------------------------------------------
  public IHeap<T> merge (IHeap<T> other){
    return other;
  }
  
  //---------------------------isBigger()-------------------------------
  // to check whether a Heap is bigger than an empty heap
  public boolean isBigger(T elt){
   return true; 
  }
}