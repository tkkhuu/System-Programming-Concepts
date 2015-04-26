// Tri Khuu tkkhuu@wpi.edu
// Aung Soe asoe@wpi.edu
import tester.* ;
class ExamplesADT {
  ExamplesADT () {};
  
  //----------------------------------------------------------------------
  
  Queue myQueue = new Queue();
  Stack myStack = new Stack();
  
  //----------------------------------------------------------------------
  IQueue populateQueue(){
    return myQueue.enqueue(7).enqueue(8).enqueue(9).enqueue(10);
  }
  
  IStack populateStack(){
    return myStack.push(7).push(8).push(9).push(10);
  }
  
  //----------------------tests for queue------------------------------------
  
  // use front() to test for enqueue(), this test will test both front() and enqueue()
  
  boolean testQueue1(Tester t) {
    populateQueue().enqueue(11);
    return t.checkExpect(myQueue.front(),
                         7);
  }
  
  // use front() to test for dequeue()
  boolean testQueue2(Tester t) {
    populateQueue().dequeue();
    return t.checkExpect(myQueue.front(),
                         8);
  }
  
  //----------------------tests for stack------------------------------------
  
  // use top() to test for push(), this test will test for both method push() and top()
  boolean testStack1(Tester t) {
    populateStack();
    return t.checkExpect(myStack.top(),
                         10);
  }
  
  
  boolean testStack2(Tester t) {
    myStack.push(11).push(12).push(13);
  return t.checkExpect(myStack.top(),
                         13);
  }
  
  // use top() to test for pop(), this test will test for both method pop() and top()
  boolean testStack3(Tester t) {
    populateStack().pop();
    return t.checkExpect(myStack.top(),
                         9);
  }
  
  boolean testStack4(Tester t) {
    myStack.push(1).push(4).push(12).pop();
    return t.checkExpect(myStack.top(),
                         4);
  }
  
  
  
}
  
