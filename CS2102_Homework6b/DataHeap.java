//                            root
//                             /\
//                            /  \
//                           /    \
//                          /      \
//                         /        \
//                      left        right


class DataHeap <T extends Comparable<T>> implements IHeap<T> {
  T root;
  IHeap<T> left;
  IHeap<T> right;
  //--------------------------------------------------------------------
  DataHeap (T root, IHeap<T> left, IHeap<T> right){
   this.root = root;
   this.left = left;
   this.right = right;
  }
  //--------------------------------------------------------------------
  public IHeap<T> addElt(T elt){
    return this.merge(new DataHeap<T> (elt, new MtHeap<T>(), new MtHeap<T>()));
  }
  //--------------------------------------------------------------------
  public T findMinElt(){
    return this.root;
  }
  //--------------------------------------------------------------------
  public IHeap removeMinElt(){
    return this.left.merge(right); 
  }
  //--------------------------------------------------------------------
  public int height(){
   int leftheight = 1 + this.left.height();
   int rightheight = 1 + this.right.height();
   if (leftheight > rightheight){
    return leftheight; 
   }
   else return rightheight;
  }
  
  //--------------------------------------------------------------------
  public T getRoot(){
   return this.root; 
  }
  
  // get the right sub tree
  public IHeap<T> getRight(){
   return this.right; 
  }
  
  // get the left sub tree
  public IHeap<T> getLeft(){
   return this.left; 
  }
  
  //---------------------------isBigger()-------------------------------
  // to check whether a Heap is bigger than an empty heap
  public boolean isBigger(T elt){
   return this.root.compareTo(elt) >0; 
  }
  //---------------------------------------------------------------------------
  public IHeap<T> merge (IHeap<T> other){
    
    T newroot;
    IHeap<T> sub1;
    IHeap<T> sub2;
    IHeap<T> sub3;
    //-------------------------------------------------------------------------
    if(other.isBigger(this.root)){ //  < other.getRoot()){
     newroot = this.root;
     sub1 = this.left;
     sub2 = this.right;
     sub3 = other;
    }
    else {
     newroot = other.getRoot(); 
     sub1 = other.getLeft();
     sub2 = other.getRight();
     sub3 = new DataHeap<T> (this.root, this.left, this.right);
    }
    //---------------------------------
    if (sub1.height() >= sub2.height() && sub1.height() >= sub3.height()){
      return new DataHeap<T> (newroot, sub1, sub2.merge(sub3));
    }
     else if (sub2.height() >= sub1.height() && sub2.height() >= sub3.height()){
      return new DataHeap<T> (newroot, sub2, sub1.merge(sub3)); 
     }
     else {
       return new DataHeap<T> (newroot, sub3, sub1.merge(sub2));
     }
  }
} 
