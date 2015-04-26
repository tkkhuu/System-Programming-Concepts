interface IQueue {
  IQueue enqueue(int elt);
  IQueue dequeue();
  int front();
  boolean isEmpty();
}