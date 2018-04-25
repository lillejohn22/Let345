TASK 1
			 N		N log N  N^2	N^3
1000		13.00	15.50	64.00	1071.46
10000		10.31	10.58	92.53	1007.28
100000		9.87	10.78	100.44		-	
1000000		9.93	10.76	107.47		-

Time ratio for different input lengths, as described by task 1.
In column one (N) we see that a tenfold increase in datasize yields a tenfolded increase in computation time.
In column two (N log N) we see that the program performces better than expected, 
this is attributed to it breaking the loop more oftenly. 
In column three (N^2) we see roughly a hundredfolded increase as expected.
The same pattern can be seen for column four (N^3).  


TASK 2.
The brute force algorithm fails to solve size 128 within the time limit.


TASK 5.1. Estimated time complexity of each method:
readPuzzle = O(N^2) or O(N) ??
	comments: The while loop on line 174
	
readWords = O(M)
	comments: The while loop on line 201. The words in the dictionary are almost the same length, hence reading
			  a line takes constant time.

solvePuzzle = O(N^2)*T_{solveDirection}(M,N)
	comments: For loops on 60 and 61 take quadratic time together, for loops on 62 and 63 take constant time.
			  The total time depends on solveDirection.
	
solveDirection = O(N)*T_{searchAlg}(M,N)	
	comments: The for loop on line 85. In worst case we start in the corner of the puzzle and move
			  to the diagonal corner, which takes sqrt(2*N^2) = O(N). The total time depends on the
			  search algorithm being used, which depend on some combination of M and N.
			  
linearSearch = O(M)
binarySearch = O(log M)

Combining all of the above yields the total time
T_{linear} = O(N^2) + O(M) + O(N^2)*O(N)*O(M) = O(N^3 * M)
T_{binary} = O(N^2) + O(M) + O(N^2)*O(N)*O(log M) = O(N^3 * log M)
The binary worst case time represents both without and with prefix testing.


TASK 5.2.
Doubling the puzzle size should result in a processing time eight times longer. This is the case for linear search.  
The measured process time for binary search increased by a factor of 4 which is better than the worst case time. 
Here it seems the theoretical worst case time complexity is a pretty big overestimate. Using prefix testing
further lowered the running time remarkably, due to meaningless iterations being reduced.