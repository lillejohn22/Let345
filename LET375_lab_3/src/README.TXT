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