import java.util.LinkedList;
class MtAttraction implements IBST{
  MtAttraction(){}
  //-------------------------------------------------------------------
  public IBST addElt (AbsAttraction elt){
   return new DataAttraction (elt, new MtAttraction(), new MtAttraction()); 
  }
  //-------------------------------------------------------------------
  // does this BST contain any attractions that satisfy the given criteria?
  public boolean containsAny(ISelect s){
    return false;
  }
  //-------------------------------------------------------------------
  // do all of the attractions in this BST satisfy the given criteria?
  public boolean allAre(ISelect s){
   return true; 
  }
  //-------------------------------------------------------------------
  // filter this BST of attractions, returning a list of attractions that
  // satisfy the given criteria
  public LinkedList <AbsAttraction> filter(ISelect s){
   return new LinkedList <AbsAttraction>(); 
  }
  
}