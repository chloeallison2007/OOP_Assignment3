package sait.sll.problemdomain;

//
import java.io.Serializable;

//Node class, has all the getters and setters
public class Node {
	
	//attributes
	private Object data;
	private Node next;
	
	//constructor
	public Node(Object data) {
		this.data = data;
		this.next = null;
	}
	
	//Getters
	public Object getData() { return data; } //
	public Node getNext() { return next; } //
	
	//Setters
	public void setData(Object data) { this.data = data; } //
	public void setNext(Node next) { this.next = next; } //

}
