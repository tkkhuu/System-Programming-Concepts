import java.util.LinkedList;
class DataAttraction implements IBST{
  //-------------------------------------------------------------------
  AbsAttraction data;
  IBST left;
  IBST right;
  //-------------------------------------------------------------------
  DataAttraction (AbsAttraction data, IBST left, IBST right){
    this.data = data;
    this.left = left;
    this.right = right;
  }
  //-------------------------------------------------------------------
  public IBST addElt (AbsAttraction elt){
    if (this.data.getName().compareTo(elt.getName()) == 0){
      return this; 
    }
    else if (this.data.getName().compareTo(elt.getName()) > 0){
      return new DataAttraction (this.data,
                                 this.left.addElt(elt),
                                 this.right);
    }
    else {
      return new DataAttraction (this.data,
                                 this.left,
                                 this.right.addElt(elt));
    }   
  }
  //-------------------------------------------------------------------
  // does this BST contain any attractions that satisfy the given criteria?
  public boolean containsAny(ISelect s){
    return this.data.accept(s) ||
      this.left.containsAny(s) ||
      this.right.containsAny(s);
  }
  //-------------------------------------------------------------------
  // do all of the attractions in this BST satisfy the given criteria?
  public boolean allAre(ISelect s){
    return this.data.accept(s) &&
      this.left.allAre(s) &&
      this.right.allAre(s);
  }
  //-------------------------------------------------------------------
  // filter this BST of attractions, returning a list of attractions that
  // satisfy the given criteria
  public LinkedList <AbsAttraction> filter(ISelect s){
    LinkedList <AbsAttraction> filteredList = new LinkedList <AbsAttraction>();
    if (this.data.accept(s)){
      filteredList.addFirst(this.data);
      this.left.filter(s);
      this.right.filter(s);
    }
    else {
      this.left.filter(s);
      this.right.filter(s);
    }
    return filteredList;
  }
}