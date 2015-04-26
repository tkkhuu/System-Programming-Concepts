class Queue implements IQueue {
  Queue(){
    
  }
  public IQueue enqueue(int elt) { return this; }
  public IQueue dequeue() { return this; }
  public int front() { return 0; }
  public boolean isEmpty() {return true; }
}