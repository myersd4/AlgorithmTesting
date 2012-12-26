/*Queue1.java - This class defines the queue ADT to be used with RadixSort1.java
 * This was mostly taken from the CSC 364 blackboard site.
 * Dan Myers
 * CSC 364 - 001
 */
class Queue1
{
	private int maxSize;	//Max size of the queue
	private Student[] queArray;	//Array used to hold the objects in the queue
	private int front;	//Beginning of the queue
	private int rear;	//Back of the queue
	private int nItems; //Number of items in the queue

	public Queue1(int s) // constructor
	{
		maxSize = s;
		queArray = new Student[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	public void insert(Student item) // put item at rear of queue
	{
		if(rear == maxSize-1) // deal with wraparound
			rear = -1;
		queArray[++rear] = item; // increment rear and
		nItems++; // one more item
	}

	public Student remove() // take item from front of queue
	{
		Student temp = queArray[front++]; // get value and incr front
		if(front == maxSize) // deal with wraparound
			front = 0;
		nItems--; // one less item
		return temp;
	}

	public Student peekFront() // peek at front of queue
	{
		return queArray[front];
	}

	public boolean isEmpty() // true if queue is empty
	{
		return (nItems==0);
	}

	public boolean isFull() // true if queue is full
	{
		return (nItems==maxSize);
	}

	public int size() // number of items in queue
	{
		return nItems;
	}

} // end class Queue