LET375 Lab 3 Anton Frigard & Johan Nilsson

METHOD: copyUpperCase
The pointer sourcePtr is used to iterate over the argument list. If the node that sourcePtr points to
contains an upper case char, a copy of the node is created and appended to the list containing upper
case chars only (upperCaseList). capitalPtr is the pointer that points to nodes in upperCaseList and
serves at the tool for the appending.

METHOD: concat
Link together ListNode that l1Pointer points to with the ListNode that l2Pointer points to.
l1Pointer always points to the last node in the list l1. 