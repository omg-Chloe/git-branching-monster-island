
public class QueueTester {

	public static void main(String[] args) {
		QueueInterface<Integer> iQ;
//		iQ = new QueueInterface<Integer>();
//		iQ = new ArrayQueue<Integer>();
//		iQ = new ArrayQueueCirc<Integer>();
		iQ = new LLQueue<Integer>();
		for(int i=0; i<10;i++)
			iQ.enqueue(i);
		System.out.println("queue");
		iQ.print();
		System.out.println("queue after dequeue once");
		iQ.dequeue();
		iQ.print();
		System.out.println("queue after dequeue twice");
		iQ.dequeue();
		iQ.print();
		System.out.println("queue after enqueue once aData=20");
		iQ.enqueue(20);
		iQ.print();
		System.out.println("queue after peek once not sure what peek does");
		iQ.peek();
		iQ.print();

	}

}
