package sait.sll.problemdomain;

//import that makes it so class can be serialized
import java.io.Serializable;

//
public class SLL implements LinkedListADT, Serializable{
	
	//attributes
	private Node head;
	private int size;
	
	//constructor
	public SLL() {
		head = null;
		size = 0;
	}
	
	//method that checks if the list is empty
	@Override
	public boolean isEmpty() {
		//
		return size == 0;
	}
	
	//method that clears all elements from the list
	@Override
	public void clear() {
		//
		head = null;
		size = 0;
	}
	
	//method that appends new elements to the bottom of the linked list
	@Override
	public void append(Object data) {
		//creates a new node
		Node newNode = new Node(data);
		
		//if statement that if list is empty, new node becomes head
		if (head == null) {
			//
			head = newNode;
		  //else statement that goes to end of the list and adds the new node
		} else {
			//starts at the first node
			Node current = head;
			//moves to the next node until it reaches the end
			while (current.getNext() != null) {
				//move to next node in the list
				current = current.getNext();
			}
			//connects the new node ot the end of list
			current.setNext(newNode);
		}
		//increases the size of the list by 1
		size++;
	}
	
	//method that prepends, or adds something to the beginning of the list
	@Override
	public void prepend(Object data) {
		//creates new node
		Node newNode = new Node(data);
		
		//link new node to current head
		newNode.setNext(head);
		
		//updates head to make new node the first in the list
		head = newNode;
		
		//increase list size by 1
		size++;
		
	}

	//method that inserts an element at specific position in the list
	@Override
	public void insert(Object data, int index) throws IndexOutOfBoundsException {
		//checks if index is valid
		if (index < 0 || index > size) {
			//
			throw new IndexOutOfBoundsException();
		}
		
		//if statement for inserting data to the start
		if (index == 0) {
			//calls prepend method
			prepend(data);
			//
			return;
		}
		
		//create new node
		Node newNode = new Node(data);
		//starts from first node
		Node current = head;
		
		//for loop that goes to the node before where you want to insert it
		for (int i = 0; i < index - 1; i++) {
			//moves to the next node
            current = current.getNext();
        }
		
		//link new node to next node
        newNode.setNext(current.getNext());
        //link previous node to new node
        current.setNext(newNode);
        //increase list size by 1
        size++;
	}
	
	//method that replaces the specified element with something new
	public void replace(Object data, int index) throws IndexOutOfBoundsException {
		//
		if (index < 0 || index >= size) {
			//
            throw new IndexOutOfBoundsException();
        }
		
		//
        Node current = head;

        // traverse to the node to replace
        for (int i = 0; i < index; i++) {
        	//
            current = current.getNext();
        }
        
        //
        current.setData(data); 
	}

	//method that returns the number of elements in list
	@Override
	public int size() {
		//returns size value, aka number of items in list
		return size;
	}
	
	//method that removes an element from the list
	@Override
	public void delete(int index) throws IndexOutOfBoundsException {
		//
		if (index < 0 || index >= size) {
			//
            throw new IndexOutOfBoundsException();
        }
		
		//
        if (index == 0) {
        	//
            head = head.getNext();
          //
        } else {
        	//
            Node current = head;

            //
            for (int i = 0; i < index - 1; i++) {
            	//
                current = current.getNext();
            }

            // skip the node to delete
            current.setNext(current.getNext().getNext());
        }
        //
        size--; 
	}
	
	
	//method that gets an element at a spefific index
	@Override
    public Object retrieve(int index) throws IndexOutOfBoundsException {
		//
        if (index < 0 || index >= size) {
        	//
            throw new IndexOutOfBoundsException();
        }
        //
        Node current = head;

        // traverse to target node
        for (int i = 0; i < index; i++) {
        	//
            current = current.getNext();
        }
        //return its data
        return current.getData();
    }
	
	//method that returns the index of the first occurrence of the element with the specific data in this list
    public int indexOf(Object data) {
    	//starts from the first node
    	Node current = head;
    	//starts counting index from 0
    	int index = 0;
    	
    	//while loop that goes through each node until the end of list
    	while (current != null) {
    		//
    		if (current.getData().equals(data))
    			//
    			return index;
    	}
    	//
    	return -1;
    }
	
	//method that returns true if the list contains the specified data, false otherwise
	@Override
	public boolean contains(Object data) {
		//
		return indexOf(data) != -1;
	}

}
