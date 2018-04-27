A.1
Base case:              a(0) = ""
Recursive assumption:   a(n) = n + a(n-1)         
Our solution will recursively work its way to the end of the string (see line 11) and then start printing it from the end and stepping up one level/back one character each time it finishes.

A.2
First two lines are used to nullify the sign of n, which is here considered a counter.
Base case:              a(0) == 0
Recursive assumption:   a(n) = a(n-1) + m
Basically our implementation will recursively do sum(m) n times.  

A.3 
Base case:              a(digit) = 1
Recursive assumption:   a(n) = 1 + a(n/10) 
Is it okay to use the operatores (?, <) ? 

A.4
Base case:              a(null) = null, (empty ListNode) (--> = linked to)
Recursive assumption: 	a(ListNode l) = l --> a(l.next)

A.5
Base case: 				a(l1.next == null) = l1 --> l2
Recursive assumption:	a(l1) = a(l1.next) --> l2
Special case: 			To protect against nullpointers as paramters a special case was made for null parameter inputs.

B.1
Base case: 				a(SIMPLE) = 1
Recursive assumption 	a(COMPOSITE) = 1 + max(a(leftpath), a(rightpath))

B.2
Base case:				a(SIMPLE) = return weight
Recursive assumption:	a(COMPOSITE) = a(leftpathpath) then a(rightpath)
The Recursive assumption is that we can walk down each path until we find a SIMPLE node.
The order the leaves are printed in depends on the order we choose the path, ie. leftpathpath then rightpath or rightpath then leftpathpath.

B.3
Mirror(m)
Base case:				a(SIMPLE) = do nothing
Recursive Case:			a(COMPOSITE) = a(leftpathpath) then a(rightpath) then flip rightpath and leftpathpath values. 

PrettyPrint 
Base case:				a(SIMPLE) = print weight
Recursive Case:			a(COMPOSITE) = print a(leftpathpath) then print a(rightpath)

B.4
Base case:				a(SIMPLE) = compare weights
Recursive Case:			a(COMPOSITE) = if( COMPOSITES are identical) do a(leftpath) then (rightpath) 

B.5
Base case: 				a(SIMPLE) = return copy of weight
Recursive case:			a(COMPOSITE) = return copy of left and right paths. 

C.1
Base case:				a(0) = draw a triangle using three lines.
Recursive case:			a(n) = redraw each line of the triangle according to the generator, see else-clause in code for details.

C.2
Base case:				a(0) = draw a pentagon using 5 lines.
Recursive case:			a(n) = redraw each line of the pentagon according to the generator, see else-clause in code for details.

C.3
Base case:				a(0) = draw a triangle using three lines.
Recursive case:			a(n) = redraw three new triangles according to the generator, see else-clause in code for details.
Show us how this can be solved more nicely. 

