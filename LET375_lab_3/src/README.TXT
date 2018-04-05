LET375 Lab 3 Anton Frigard & Johan Nilsson

METHOD: copyUpperCase
For this method we needed two new methods; copyList and copyNode.

capitalPointer always points to the latest ListNode with upper case char. It
is needed since there may be multiple subsequent nodes containing lower case
chars, which we need to step over. Thus, capitalPointer is only incremented
when there is a new ListNode with uppercase. Note however that capitalPointer.next
needs to be updated continuously!

As long as there are subsequent nodes in the list, there are three possible cases:
CASE 1) The next node contains upper case char. Here we don't need to explicitly
check for the presence of subsequent nodes, it will be taken care of by the
outer else-clause and while-loop.

CASE 2) The next node contains lower case char but IS NOT the last node in the list.
Thus, we "step over" this node (sort of removes it from the list)
 
CASE 3) The next node contains lower case char and IS the last node in the list.
Thus, we need to end the list by letting the latest upper case node reference
null and break the while-loop.


METHOD: copyList
Start by creating a header (startNode) and append copies of nodes (newNode is copy)
from argument list. Return start of list startNode.

METHOD: concat
Link together ListNode that l1Pointer points to with the ListNode that l2Pointer points to.
Both iterates from beginning to end, but l1Pointer starts at end of l1.


GENERAL COMMENTS



l1: XabIdRXA7pX
l2: XabIdRXA7pX
l2: SabIdRA7pP
l1: XabIdRXA7pX
true
false
13: SIRAP
l4: PARIS
l3: SIRAP-i-PARIS
l4: 
l3: SIRAP-i-PARIS-palindrom
l5: -palindrom

 