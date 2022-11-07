Use this file to record your reflection on this assignment.

Which methods did you decide to overload, and why?
**House**
[1] I overloaded the constructor in House.java so that default houses with no elevator and no dining room could be created with no parameters passed in.

[2] I overloaded the moveIn() method so that it takes an int n and adds "Student 1, Student 2, ... , and Student n" to the House. This would be useful for adding a specific number of anonymized students to a House or for reserving spots in a House with a specified number of placeholder students. To improve the code, a method which removes placeholder students would be a useful feature to add in the future.


**Library**
[1] I overloaded the Library constructor so that a default Library can be created with one parameter: an int which indicates the number of floors the Library should have. I chose to make that parameter required since the number of floors present in Libraries are generally more variable than the number of floors in other types of Buildings.

[2] I overloaded the printCollection() method so that if a string equal to "csv" is entered as a parameter, the collection will be printed in .csv format. This would be helpful for displaying the collection in a less readable, but more compact way, or for exporting the titles and availability information of library items to an Excel file


**Cafe**
[1] I overloaded the Cafe constructor so that a default Cafe could be created with no parameters. The default Cafe has the value of all of its inventory attributes set equal to 0, since a newly built Cafe would by default have an empty inventory 
[2] I overloaded the sellCoffee() method so that it can also take in no parameters, and then sell a 
default order of coffee and restock the exact number of ingredients and the cup used to make that order. 


What worked, what didn't, what advice would you give someone taking this course in the future?


**COLLABORATION**
I did not collaborate with anyone else on this assignment 

 **REFERENCES** in-line citations look like: //Source [n]
[1] Found code for iterating through a Hashtable. 
https://www.geeksforgeeks.org/how-to-iterate-through-hashtable-in-java/