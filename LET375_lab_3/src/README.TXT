LET375 Lab 3 Anton Frigard & Johan Nilsson

METHOD: copyUpperCase
The pointer sourcePtr is used to iterate over the argument list. If the node that sourcePtr points to
contains an upper case char, a copy of the node is created and appended to the list containing upper
case chars only (upperCaseList). capitalPtr is the pointer that points to nodes in upperCaseList and
serves as the tool for the appending. (We reused the method in 

METHOD: concat
Link together ListNode that l1Pointer points to with the ListNode that l2Pointer points to.
l1Pointer always points to the last node in the list l1. 

QUESTION: Why do you explicitly set a new node's next reference to null when it's already null?
		EX: 
Line 76		ptr1.next = new ListNode();    // New node in the copy 
Line 77 	ptr1 = ptr1.next;              // Move to next 
Line 78 	ptr1.element = ptr2.element;   // Copy character 
Line 79 	ptr1.next = null;              // End/terminate the list
Line 80		ptr2 = ptr2.next;              // Move object forward in the original list    