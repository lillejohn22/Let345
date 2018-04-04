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
        ListNode head, ptr1;     // head pekar alltid p� listans huvud
        head = new ListNode();   // Listans huvud (inneh�ller ej data)
        head.next = null;
        ptr1 = head;             // ptr pekar p� sista noden

        // Bygg en lista av tecken
        for ( int i = 0; i < chars.length(); i++ ) {
            ptr1.next = new ListNode();          // Addera en ny nod sist
            ptr1 = ptr1.next;                    // Flytta fram till den nya noden
            ptr1.element = chars.charAt(i);      // S�tt in tecknet
            ptr1.next = null;                    // Avsluta listan
        }
        return head;
    }
    
    // Se f�rel. OH
    public static ListNode copy(ListNode l) {
        if ( l == null )
            throw new ListsException("Lists: null passed to copy");
        ListNode head,ptr1,ptr2;
        head = new ListNode();             // Kopian
        head.next = null;
        ptr1 = head;

        ptr2 = l.next;  // f�rsta listelementet i originallistan
        while ( ptr2 != null ) {
            ptr1.next = new ListNode();    // Ny nod i kopian
            ptr1 = ptr1.next;              // Flytta fram
            ptr1.element = ptr2.element;   // Kopiera tecknet
            ptr1.next = null;              // Avsluta
            ptr2 = ptr2.next;              // Flytta fram i originallistan
        }
        return head;
    }
    
    // Se f�rel. OH
    public static ListNode removeAll(ListNode l,char c) {
        if ( l == null )
            throw new ListsException("Lists: null passed to removeAll");
        ListNode p = l;
        while ( p.next != null ) {
            ListNode temp = p.next;      // Handtag p� n�sta nod
            if ( temp.element == c )     // Skall den tas bort?
                p.next = temp.next;      // L�nka f�rbi
            else
                p = p.next;              // Nej, g� vidare *
        }
        // * p f�r ej flyttas om den efterf�ljande noden togs bort!
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
        
    	StringBuilder upperCase = new StringBuilder();
    	nodeIterator.next = head.next;
    	
    	while (nodeIterator.next != null) {
    		nodeIterator = nodeIterator.next;
    		if ( Character.isUpperCase(nodeIterator.element) )
    			upperCase.append(nodeIterator.element);
    	}
    	
        return toList(upperCase.toString());
    }
    
    // Testmetod: JunitListTest.testAddFirst()
    public static ListNode addFirst(ListNode l, char c) {
    	if ( l == null ) throw new ListsException("Lists: null passed to addFirst");
    	
    	ListNode node = new ListNode();
    	node.next = l.next;
    	l.next = node;
    	node.element = c;
        return l;
    }
         
    // This is a private utility method.
    private static ListNode getLastNode(ListNode head) {
        ListNode nodeIterator = head;
        while(nodeIterator.next != null)
        	nodeIterator = nodeIterator.next;
        return nodeIterator;
    }
   
    // Testmetod: JunitListTest.testAddLast() 
    public static ListNode addLast(ListNode l,char c) {  
        ListNode newLastNode = new ListNode(); 
        ListNode LastNode = getLastNode(l); // points to the last element in l.I can't use nodeIterator here right?
        LastNode.next = newLastNode;
        newLastNode.element = c;
        return l;
    }
    
    // Testmetod: JunitListTest.testConcat()
    public static ListNode concat(ListNode l1,ListNode l2) { 
   	while(l2.next != null) {
    		addLast(l1, l2.element);
    		removeAll(l2, l2.element);
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
