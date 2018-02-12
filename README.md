# HadoopMapReduce
 Consider an input file with the following example input.
John Back, 23, B, CSC366
Bob Wilson, 11, B, CS201
John Back, 23, A, CSC369
In general, the input file will contain the student name, the student ID number, grade, and course. You need to write a Map/Reduce program that prints the student name, student id, and the list of classes for that student. The output should be sorted by name and then sorted by grade for each name. Here is example output. 
Bob Wilson, 11, (B, CS201) 
John Back, 23, (A, CSC369), (B, CSC366) // sorted by name and then be grade


