LET375 LAB 2 GENERIC CLASSES AND METHODS

Task 1: Generic single object buffer
We created an interactive test in which the user may put or get objects from a singlebuffer. The user
may only input strings.


Task 2: Generic printing method
Iterators are used since we wanted to learn how to use them, as well as being told to use the standard library
to as great an extent as possible. 

----------------------------------------------------------------------------------------------
Task 3: Generic class method reverse
Implemented with SingleBuffer class and iterators. See steps below for rough method description.

Step 1:
// iterator1.nextIndex() points to first object in List. Buffer is empty to begin with
buffer = null

[obj1] <-- iterator1.nextIndex()
[obj2]
.
.
.
[objN-1]
[objN] <-- iterator2.previousIndex()

Step 2:
// object 1 is put in the buffer. iterator1 is incremented by method next()
buffer = obj1

[obj1] <-- iterator1.previousIndex()
[obj2] <-- iterator1.nextIndex()
.
.
.
[objN-1]
[objN] <-- iterator2.previousIndex()

Step 3:
// List.set() method writes over first element with last element 
buffer = obj1

[objN]
[obj2] <-- iterator1.nextIndex()
.
.
.
[objN-1] <-- iterator2.previousIndex()
[objN] <-- iterator2.nextIndex()

Step 4:
//  Buffer object is retrieved and put in last place.
buffer = null

[objN]
[obj2] <-- iterator1.nextIndex()
.
.
.
[objN-1] <-- iterator2.previousIndex()
[obj1] <-- iterator2.nextIndex()

Step 5:
// The system is in a state to re-engage with step 1.
buffer = null

[objN]
[obj2] <-- iterator1.nextIndex()
.
.
.
[objN-1] <-- iterator2.previousIndex()
[obj1]

----------------------------------------------------------------------------------------------

Task 4: Generic compare class method
The task description did not explain how strings were to be compared, so we decided to compare
them according to number of characters. This would also have the same results as the example in the
description.

The argument comparator is used to compare elements within the two individual argument collections to obtain
the maximum and minimum elements. Then the argument comparator is used once more to compare the maximum element
from collection c1 with the minimium element from collection c2.

For comparing both integers and strings, we use the standard compare() method from the Integer class.


Task 5: A generic filter method
IsEven class implements Predicate interface and needs to implement the test() method. In this method, the isEven()
method is called and the return value of that method is also what is returned by the test() method.

The filter() method is called in main with a list containing both odd and even integers as elements, as well as
with an instance of the IsEven class. Thus, a list containing only the even integers will be returned by the filter()
method.

Task 6: Lambda expressions
Filter() method is used to obtain a list consisting of only women that are older than 65. Map() method is used
to obtain the email addresses from these women, and print() method is used to print them out.
 






