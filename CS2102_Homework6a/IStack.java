interface IStack {
  IStack push(int elt);
  IStack pop();
  int top();
  boolean isEmpty();
}