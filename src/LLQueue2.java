import java.util.*;
public class LLQueue2<T> implements QueueInterface2<T> {
	private class ListNode
	{
		private T data;
		private ListNode link;
		private ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	private ListNode head;
	private ListNode tail;
	private int size;
	public LLQueue2()
	{
		head = tail = null;
		size = 0;
	}
	public void enqueue(T aData)
	{
		ListNode newNode = new ListNode(aData, null);
		if(head == null)
		{
			head = tail = newNode;
			size = 1;
			return;
		}
		tail.link = newNode;
		tail = newNode;//tail.link
		size++;
	}
	public T dequeue()
	{
		if(head == null)
			return null;
		T ret = head.data;
		head = head.link;
		size--;
		return ret;
	}
	public T peek()
	{
		if(head == null)
			return null;
		return head.data;
	}
	public void print()
	{
		for(ListNode temp = head; temp != null;temp = temp.link)
			System.out.println(temp.data);
	}
	public int size()
	{
		return this.size;
	}
	private class ListIterator implements Iterator<T>//nice to have when making a custom class that represents data struct that you would move through in organized fashion
	{
		private ListNode iCurr;
		public ListIterator(ListNode head)
		{
			iCurr = head;
		}
		public boolean hasNext()
		{
			return iCurr != null;
		}

		public T next()
		{
			T ret = iCurr.data;
			iCurr = iCurr.link;
			return ret;
		}
	}
	public Iterator<T> iterator()
	{
		return new ListIterator(head);
	}
}
