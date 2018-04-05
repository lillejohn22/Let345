/**
 * A collection of utility functions for C style primitive list handling.
 *
 * @author(s)
 * @version 2016-04-19
 */

public class Lists {
	
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
    
    // see lecture slides
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
    public static String toString(ListNode l) { // COMPLETE
    	
    	// First check if l is a null reference
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
    public static boolean contains(ListNode head, char c) { // COMPLETE
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
    
    
    /* SELF CREATED METHOD
     * Return a new ListNode whose element is identical to the ListNode that
     * needs to be copied. However, the "nodetoBeCopied.next" reference is not
     * copied; newNode.next always reference null
     */
    public static ListNode copyNode (ListNode nodeToBeCopied) { // COMPLETE
    	 ListNode newNode = new ListNode();
    	 newNode.element = nodeToBeCopied.element;
    	 
    	return newNode;
    }
    
    /* SELF CREATED METHOD
     * Returns a copy of the entire argument linked list,
     * without manipulating argument list
     */
    public static ListNode copyList (ListNode head) { // COMPLETE
    
    	ListNode startNode = new ListNode(); // A new header
    	ListNode pointer = new ListNode();
    	pointer = head;
    	
    	// If list "head" only contains header, return a new header
    	if (pointer.next == null) return startNode;
	
		/* If there is at least one ListNode (not including header),
		 * make a copy of that ListNode and append it to the header (startNode).
		 * This needs only be done once.
		 */
		pointer = pointer.next;
		ListNode newNode = copyNode(pointer);
		startNode.next = newNode;
		
		/* If there are subsequent ListNodes, append copies of these to the new list.
		 * Note that pointer is pointing at the original list with header "head".
		 */
		while (pointer.next != null) {
			pointer = pointer.next;
			newNode.next = copyNode(pointer); // Let newNode point to a new ListNode
			newNode = newNode.next;
		}
		
    	return startNode;
    }
    
    
    // Testmetod: JunitListTest.testCopyUpperCase()
    /* NOTE!!
     * I do not think we may use the the StringBuilder strategy (the code that is commented out),
     * since we were told not to shortcut by using string operations. I propose a pointer strategy
     * using a copy of the argument list (since we may not manipulate it) and two pointers (in
     * order for the particular strategy two work). This strategy is quite complex and hard to
     * understand though.
     */
    public static ListNode copyUpperCase(ListNode head) {
    	if ( head == null ) throw new ListsException("Lists: null passed to copyUpperCase");
    	if (head.next == null) return new ListNode();
    	
    	// *******STRINGBUILDER STRATEGY*******
//    	StringBuilder upperCase = new StringBuilder();
//    	ListNode pointer = new ListNode();
//    	pointer.next = head.next;
//    	
//    	while (pointer.next != null) {
//    		pointer = pointer.next; // point to next node in list
//    		if (Character.isUpperCase(pointer.element)) // Save if capital letter
//    			upperCase.append(pointer.element);
//    	}
//        return toList(upperCase.toString());

    	// ********TWO-POINTER STRATEGY********
    	ListNode headNode = copyList(head); // Make a copy of the argument linked list. Will be manipulated.
    	ListNode pointer = headNode; // Start by pointing at header
    	
    	/* capitalPointer always points to the latest ListNode with upper case char. It
    	 * is needed since there may be multiple subsequent nodes containing lower case
    	 * chars, which we need to step over.
    	 * Thus, capitalPointer is only incremented when there is a new ListNode with upper
    	 * case. Note however that capitalPointer.next needs to be updated continuously!
    	 */
    	ListNode capitalPointer = headNode;
    	
    	/* As long as there are subsequent nodes in the list, there are three possible cases:
    	 * 	1) The next node contains lower case char but IS NOT the last node in the list.
    	 * 	Thus, we "step over" this node (sort of removes it from the list)
    	 * 	
    	 * 	2) The next node contains lower case char and IS the last node in the list.
    	 * 	Thus, we need to end the list by letting the latest upper case node reference
    	 * 	null and break the while-loop.
    	 * 	
    	 * 	3) The next node contains upper case char. Here we don't need to explicitly
    	 * 	check for the presence of subsequent nodes, it will be taken care of by the
    	 * 	outer else-clause and while-loop.
    	 */
    	while (pointer.next != null) {
    		if ( Character.isLowerCase(pointer.next.element) ) {
    			if ( pointer.next.next != null ) {
    				// CASE 1)
    				pointer = pointer.next;
    				capitalPointer.next = pointer.next;
    			}
    			else {
    				// CASE 2)
    				pointer = pointer.next;
    				capitalPointer.next = null;
    				break;
    			}
    		}
    		else {
    			// CASE 3
    			pointer = pointer.next;
    			capitalPointer = capitalPointer.next;
    		}
    	}
    	return headNode;
    }
    

    // Testmetod: JunitListTest.testAddFirst()
    public static ListNode addFirst(ListNode l, char c) { // COMPLETE
    	if ( l == null ) throw new ListsException("Lists: null passed to addFirst");
    	
    	ListNode newNode = new ListNode();
    	newNode.next = l.next; // next node is second ListNode, reference this by newNode.next
    	l.next = newNode; // Reference newNode instead of previously second ListNode. newNode is now at correct place
    	newNode.element = c;
        return l;
    }
         
    // This is a private utility method.
    private static ListNode getLastNode(ListNode head) { // COMPLETE
        ListNode nodePtr = head;			// make nodePtr point to head of list 
        while(nodePtr.next != null)		 
        	nodePtr = nodePtr.next;			// move nodePtr to next node   
        return nodePtr;						// return ptr to last valid node
    }
   
    // Testmetod: JunitListTest.testAddLast() 
    public static ListNode addLast(ListNode l,char c) {  // COMPLETE
    	if ( l == null ) throw new ListsException("Lists: null passed to addLast");
    	
        ListNode newLastNode = new ListNode(); 
        ListNode LastNode = getLastNode(l); 	// LastNode points to the last element in l
        LastNode.next = newLastNode;			// Make LastNode point to newLastNode
        newLastNode.element = c;				// add the element to newLastNode
        return l;
    }
    
    
    // Testmetod: JunitListTest.testConcat()
    public static ListNode concat(ListNode l1,ListNode l2) { // COMPLETE
    	if ( l1 == null || l2 == null ) throw new ListsException("Lists: null passed to concat");
    	
    	ListNode l2Pointer = new ListNode();
    	ListNode l1Pointer = new ListNode();
    	
    	l2Pointer = l2; 
    	l1Pointer = getLastNode(l1);
    	
	   	while(l2Pointer.next != null) {
  	    		l2Pointer = l2Pointer.next; 		// Make nodePtr point to next object (so we can iterate through the list)
  	    		l1Pointer.next = l2Pointer;
  	    		l1Pointer = l1Pointer.next;
	    }
	   	
   		l2.next = null;
   		return l1;
	    }
    
    
    
    // Testmetod: JunitListTest.testAddAll()
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
     
    
    public static ListNode reverse(ListNode head) {
    	if ( head == null) throw new ListsException("Lists: null passed to reverse");
    	
        ListNode reversedHead = new ListNode();	// head of new list to be reversed
        ListNode nodePtr = new ListNode(); 		// nodePtr that can iterate one list
        nodePtr = head;
        
        while(nodePtr.next != null) {
        	nodePtr = nodePtr.next; 			// Mode nodePtr to next node
        	reversedHead = addFirst(reversedHead, nodePtr.element); // 
        }
        return reversedHead;
    }
}
