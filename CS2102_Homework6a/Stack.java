class Stack implements IStack {
  Stack(){}
  public IStack push(int elt) {return this;}
  public IStack pop() {return this;}
  public int top() {return 0;}
  public boolean isEmpty() {return true; }
}