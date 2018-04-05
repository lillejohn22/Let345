/**
 * A collection of utility functions for C style primitive list handling.
 *
 * @author(s)
 * @version 2016-04-19
 */
import java.lang.*;

public class Lists {

	// Instance variables
	// private static ListNode nodeIterator = new ListNode();
	
	
    // Create an empty list (a null terminated list head).
    public static ListNode mkEmpty() {
        return toList("");
    }
    
    // Returns true if l refers to a null terminated list head, false ow.
    public static boolean isEmpty(ListNode l) {
        if ( l == null )
            throw new ListsException("Lists: null passed to isEmpty");
        return l.next == null;
    }
    

    // Two lists are equal if both are empty, or if they have equal lengths
    // and contain pairwise equal elements at the same positions.
    public static boolean equals(ListNode l1,ListNode l2) {
        if ( l1 == null || l2 == null )
            throw new ListsException("null passed to equals");
        if ( isEmpty(l1) && isEmpty(l2) )
            return true;
        else if ( isEmpty(l1) || isEmpty(l2) )
            return false;
        else { // both lists are non-empty
            ListNode p1 = l1.next, p2 = l2.next;
            while ( p1 != null && p2 != null ) {
                char c1 = p1.element, c2 = p2.element;
                if ( p1.element != p2.element )
                    return false;
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1 == null && p2 == null;
        }
    }
    
    // Se f�rel. OH
    public static ListNode toList(String chars) {
        ListNode head, ptr1;     // head always points on the list's head (start point). 
        head = new ListNode();   // Listans head (no data, just a reference to a memory address)
        head.next = null;
        ptr1 = head;             // ptr points to the last node 

        // Make a list of characters 
        for ( int i = 0; i < chars.length(); i++ ) {
            ptr1.next = new ListNode();          // Add a new nod at the end of the list 
            ptr1 = ptr1.next;                    // Move to the freshly made node
            ptr1.element = chars.charAt(i);      // Add the character 
            ptr1.next = null;                    // End the list
        }
        return head;
    }
    
    // See lecture slides
    public static ListNode copy(ListNode l) {
        if ( l == null )
            throw new ListsException("Lists: null passed to copy");
        ListNode head,ptr1,ptr2;
        head = new ListNode();             // The copy (of a pointer)
        head.next = null;
        ptr1 = head;

        ptr2 = l.next;  // First element in the original list (ptr2 points to it) 
        while ( ptr2 != null ) {
            ptr1.next = new ListNode();    // New node in the copy 
            ptr1 = ptr1.next;              // Move to next 
            ptr1.element = ptr2.element;   // Copy character 
            ptr1.next = null;              // End/terminate the list
            ptr2 = ptr2.next;              // Move object forward in the orignal list 
        }
        return head;
    }
    
    // See lecture slides
    public static ListNode removeAll(ListNode l,char c) {
        if ( l == null )
            throw new ListsException("Lists: null passed to removeAll");
        ListNode p = l;
        while ( p.next != null ) {
            ListNode temp = p.next;      // Handle on the next node
            if ( temp.element == c )     // Remove it? 
                p.next = temp.next;      // Link previous and follow nodes together (cutting out the current one)
            else
                p = p.next;              // If not remove --> move to next node
        }
        // * p mustn't be moved if the follow node was removed! (messes with the linking of nodes)
        return l;
     }
    
    // ---------------- Uppgifter ----------------- 
    
    // Testmetod: JunitListTest.testToString()
    public static String toString(ListNode l) {
    	
    	// First check if l is a null reference
    	if (l == null) throw new ListsException("Lists: null passed to toString");
    	
    	// Initiate temporary objects
    	StringBuilder text = new StringBuilder();
    	ListNode nodePointer = new ListNode();
    	
    	// Place nodeIterator at first element in list (header)
    	nodePointer.next = l.next;
    	
    	// If list only contains a header, then element is guaranteed empty character '\0'
    	if (nodePointer.next == null) return "";
    	
    	// If list contains two or more ListNodes, go through this while-loop. Start at header
    	while (nodePointer.next != null) {
    		nodePointer = nodePointer.next; // step to next ListNode
    		text.append(Character.toString(nodePointer.element)); // append that node's character to string
    	}
    	return text.toString();    	
    }
    
    // Testmetod: JunitListTest.testContains()
    // Two alternatives, which to use?
    public static boolean contains(ListNode head, char c) {
    	String text = toString(head);
    	Character chars = c;
    	return text.contains(chars.toString());
    	
//    	ListNode nodeIterator = new ListNode();
//    	
//    	nodeIterator.next = head.next;
//    	
//    	while (nodeIterator.next != null) {
//    		nodeIterator = nodeIterator.next;
//    		if (nodeIterator.element == c)
//    			return true;
//    	}
//    	return false;
    }
    
    // Testmetod: JunitListTest.testCopyUpperCase()
    public static ListNode copyUpperCase(ListNode head) {
        
    	StringBuilder upperCase = new StringBuilder();			// To build a Str for making a the new list
    	ListNode nodePtr = new ListNode();						// Create a pointer 
    	nodePtr.next = head.next;								// nodePtr --> to next object in list
    	
    	while (nodePtr.next != null) {							// unless list is empty do	(ptr points to null)
    		nodePtr = nodePtr.next;								// make nodePtr point at the next node 
    		if ( Character.isUpperCase(nodePtr.element) )		 
    			upperCase.append(nodePtr.element);				// add it to Str upperCase
    	}
    	
        return toList(upperCase.toString());
    }
    
    // Testmetod: JunitListTest.testAddFirst()
    public static ListNode addFirst(ListNode l, char c) {
    	if ( l == null ) throw new ListsException("Lists: null passed to addFirst"); // catches null pointers in argument
    	
    	ListNode newFirstNode = new ListNode(); 	// make new node
    	newFirstNode.next = l.next;					// Make newFirstNode point to first node in l, (l is head of list) 
    	l.next = newFirstNode;						// Now next node in l is newFirstNode 
    	newFirstNode.element = c;					// Add element to newFirstNode 
        return l;
    }
         
    // This is a private utility method.
    private static ListNode getLastNode(ListNode head) {
        ListNode nodePtr = head;			// make nodePtr point to head of list 
        while(nodePtr.next != null)		 
        	nodePtr = nodePtr.next;			// move nodePtr to next node   
        return nodePtr;						// return ptr to last valid node
    }
   
    // Testmetod: JunitListTest.testAddLast() 
    public static ListNode addLast(ListNode l,char c) {  
        ListNode newLastNode = new ListNode(); 
        ListNode LastNode = getLastNode(l); 	// LastNode points to the last element in l
        LastNode.next = newLastNode;			// Make LastNode point to newLastNode
        newLastNode.element = c;				// add the element to newLastNode
        return l;
    }
    
    // Testmetod: JunitListTest.testConcat()
    public static ListNode concat(ListNode l1,ListNode l2) {
    	ListNode nodePtr = new Listnode();
    	nodePtr = l2; 
   	while(nodePtr.next != null) {
    		addLast(l1, nodePtr.next.element);			// l2 is head of list and doesn't have any element. So add element of l2.next to l1
    		removeAll(l2, nodePtr.next.element);		// Remove the copied element and node? 
    		nodePtr = nodePtr.next; 					// Make nodePtr point to next object (so we can iterate through the list) 
    }
   		return l1;
    }
    
    // Testmetod: JunitListTest.testAddAll()
    public static ListNode addAll(ListNode l1,ListNode l2) {
    	if ( l1 == null || l2 == null ) throw new ListsException("Lists: null passed to addFirst");
    	
       	while(l2.next != null)
    		addLast(l1, l2.element);
   		return l1;
    }
      
    // Testmetod: JunitListTest.testReverse()
    public static ListNode reverse(ListNode head) {  
        ListNode reversedL = new ListNode();
        
        while(nodeIterator.next != null) {
        	nodeIterator = head;
        	reversedL = nodeIterator.next;
        	reversedL.element = nodeIterator.element;
        	reversedL.next = nodeIterator;
        }
        return reversedL;
    }
}
