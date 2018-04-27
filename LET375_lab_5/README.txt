 */
public class LinearRecursion {
A.1
Base case:              a(0) = ""
Recursive assumption:   a(n) = n + a(n-1)          (Should it be a(n) = n + A(n+1) since it works backwards)
Our solution will recursively work its way to the end of the string and then start printing it from the end and stepping up one level/back one character each time it finishes.

A.2
First two lines are used to nullify the sign of n, which is here considered a counter.
Base case:              a(0) == 0
Recursive assumption:   a(n) = a(n-1) + m
Basically our impelmentation will recursively do sum(m) n times.  

A.3 
Base case:              a(0) = 1
Recursive assumption:   a(n) = 1 + a(n/10) 
Is it okay to use the operatores (?, <) ? 

A.4
Base case:              a(0) = ListNode == null
Recursive assumption:   
public static ListNode copy( ListNode l ) {
	 // First assignment is base case (l == null), second is recursive case
	 return (l == null ) ? null : cons(l.element, copy(l.next));
 }