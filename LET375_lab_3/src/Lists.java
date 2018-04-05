/**
 * A collection of utility functions for C style primitive list handling.
 *
 * @author(s) Anton Frigard and Johan Nilsson
 * @version 2016-04-19
 */

public class Lists {
	
    /** Create an empty list (a null terminated list head). */
    public static ListNode mkEmpty() {
        return toList("");
    }
    
    /** Returns true if l refers to a null terminated list head/node, false ow. */
    public static boolean isEmpty(ListNode l) {
        if ( l == null )
            throw new ListsException("Lists: null passed to isEmpty");
        return l.next == null;
    }
    
    
    /* Two lists are equal if both are empty, or if they have equal lengths
    	and contain pairwise equal elements at the same positions. */
    
    /**Returns true if both lists have same elements in each node */
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
    
    /** Makes a list out the argument string, see lecture slides 
      	Each node contains one character each from the input string */
    public static ListNode toList(String chars) {
        ListNode head, ptr1;     // head always points on the list's head (start point). 
        head = new ListNode();   // header (no data, just a reference to a memory address)
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
    
    /** Returns a copy of the argument ListNode l, see lecture slides */
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
            ptr2 = ptr2.next;              // Move object forward in the original list 
        }
        return head;
    }
    
    /** Removes all nodes containing char c from ListNode l, see lecture slides */
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
    /** Returns a string made out of the elements in ListNode l*/
    public static String toString(ListNode l) {
    	if (l == null) throw new ListsException("Lists: null passed to toString");
    	
    	// Initiate temporary objects
    	StringBuilder text = new StringBuilder();
    	ListNode pointer = new ListNode();
    	
    	// Let pointer.next reference first ListNode after header
    	pointer.next = l.next;
    	
    	// Step through list and append characters to a string
    	while (pointer.next != null) {
    		pointer = pointer.next; // step to next ListNode
    		text.append(Character.toString(pointer.element)); // append that node's character to string
    	}
    	return text.toString();    	
    }
    
    // Testmetod: JunitListTest.testContains()
    /** returns true if there is a node with char c as element in argument ListNode head */
    public static boolean contains(ListNode head, char c) {
    	if ( head == null ) throw new ListsException("Lists: null passed to contains");
    	
    	ListNode pointer = new ListNode();
    	pointer.next = head.next; // Let pointer.next reference first ListNode after header
    	
    	while (pointer.next != null) {
    		pointer = pointer.next; // Step to next ListNode
    		if (pointer.element == c)
    			return true;
    	}
    	return false;
    }
    
    
    /** SELF CREATED METHOD
     * @Returns copyNode returns a new ListNode that is a copy of the argument ListNode,
     * but sets the next node to null.
     */
    public static ListNode copyNode (ListNode l) {
    	ListNode newNode = new ListNode();
    	newNode.element = l.element;
    	newNode.next = null;
    	return newNode;
    }
    

/* REMOVED since copy(ListNode l) does the same 
 	// SELF CREATED METHOD
    // Returns copyList returns a copy of the argument list

   public static ListNode copyList (ListNode head) {
    	ListNode startNode = new ListNode(); // A new header
    	ListNode pointer = new ListNode();
    	pointer = head;
    	
    	// If list "head" only contains header, return a new header
    	if (pointer.next == null) return startNode;
	
		pointer = pointer.next;
		ListNode newNode = copyNode(pointer);
		startNode.next = newNode;

		while (pointer.next != null) {
			pointer = pointer.next;
			newNode.next = copyNode(pointer); // Let newNode point to a new ListNode
			newNode = newNode.next;
		}
		
    	return startNode;
    }
*/    
    
    // Testmetod: JunitListTest.testCopyUpperCase()
 
    public static ListNode copyUpperCase(ListNode head) { // NEEDS OT BE CHECKED FOR ERRORS
    	if ( head == null ) throw new ListsException("Lists: null passed to copyUpperCase");
    	
    	ListNode sourcePtr = head;				// to iterate through source 
    	ListNode upperCaseList = new ListNode();// new list with upperCase chars
    	ListNode capitalPtr = upperCaseList; 	// to iterate through upperCaseList
    	
    	while ( sourcePtr.next != null ) {
    		sourcePtr = sourcePtr.next;
    		
    		// See copy(ListNode l) for more information on how this adds a node 
    		if ( Character.isUpperCase(sourcePtr.element) ) {
    			capitalPtr.next = new ListNode(); 		// Make a new node for the list
    			capitalPtr = capitalPtr.next;			// move pointer to the new node 
    			capitalPtr.element = sourcePtr.element; // copy element from source to newly made node
    			// capitalPtr.next = null; 				// I don't see why this needs to be done every time? so I do it at the end. 
    		}
    	}
    	capitalPtr.next = null; // terminate list (once it's been made, instead of after each node is added)
    	return upperCaseList;
    }  	
    
/*		Old code 
    	if (head.next == null) return new ListNode();
    	
    	ListNode headNode = copy(head);
    	ListNode pointer = headNode;     	
    	ListNode capitalPointer = headNode;

    	while (pointer.next != null) {
    		if (Character.isUpperCase(pointer.next.element)) {
    			// CASE 1
    			pointer = pointer.next;
    			capitalPointer = capitalPointer.next;    			
    		}
    		else {
    			if ( pointer.next.next != null ) {
    				// CASE 2
    				pointer = pointer.next;
    				capitalPointer.next = pointer.next;
    			}
    			else {
    				// CASE 3
    				pointer = pointer.next;
    				capitalPointer.next = null;
    				break;
    			}
    		}
    	}
    	return headNode;
    }
*/
 
    // Testmetod: JunitListTest.testAddFirst()
    /** Adds a node with the element c in front of ListNode l */
    public static ListNode addFirst(ListNode l, char c) {
    	if ( l == null ) throw new ListsException("Lists: null passed to addFirst");
    	
    	ListNode newNode = new ListNode();
    	newNode.next = l.next;
    	l.next = newNode;
    	newNode.element = c;
        return l;
    }
         
    // This is a private utility method.
    /** returns reference to last node in ListNode head */
    private static ListNode getLastNode(ListNode head) {
        ListNode nodePtr = head; 
        while(nodePtr.next != null)		 
        	nodePtr = nodePtr.next;   
        return nodePtr;
    }
   
    // Testmetod: JunitListTest.testAddLast() 
    public static ListNode addLast(ListNode l,char c) {
    	if ( l == null ) throw new ListsException("Lists: null passed to addLast");
    	
        ListNode newLastNode = new ListNode();
        ListNode LastNode = getLastNode(l);
        LastNode.next = newLastNode;
        newLastNode.element = c;
        return l;
    }
    
    
    // Testmetod: JunitListTest.testConcat()
    /** Relinks nodes from l2 to end of l1 (by rewriting the pointer' values)*/
    public static ListNode concat(ListNode l1,ListNode l2) { 
    	if ( l1 == null || l2 == null ) throw new ListsException("Lists: null passed to concat");
    	
    	ListNode l2Pointer = new ListNode();
    	ListNode l1Pointer = new ListNode();
    	
    	l2Pointer = l2; 
    	l1Pointer = getLastNode(l1);
    	
	   	while(l2Pointer.next != null) {
    		l2Pointer = l2Pointer.next;
    		l1Pointer.next = l2Pointer;
    		l1Pointer = l1Pointer.next;
	    }
	   	
   		l2.next = null;
   		return l1;
	    }
    
    
    // Testmetod: JunitListTest.testAddAll()
    /** Copies elements from ListNode l2 to ListNode l1*/ 
    public static ListNode addAll(ListNode l1,ListNode l2) {
    	if ( l1 == null || l2 == null ) throw new ListsException("Lists: null passed to addAll");
    	
    	ListNode nodePtr = new ListNode();
    	nodePtr = l2;
    	
       	while(nodePtr.next != null) {
       		nodePtr = nodePtr.next;
       		addLast(l1, nodePtr.element);
       	}
   		return l1;
    }
     
    /** Returns a reverse ordered copy of ListNode head */ 
    public static ListNode reverse(ListNode head) {
    	if ( head == null) throw new ListsException("Lists: null passed to reverse");
    	
        ListNode reversedHead = new ListNode();	// head of new list to be reversed
        ListNode nodePtr = new ListNode();
        nodePtr = head;
        
        while(nodePtr.next != null) {
        	nodePtr = nodePtr.next;
        	reversedHead = addFirst(reversedHead, nodePtr.element); 
        }
        return reversedHead;
    }
}
