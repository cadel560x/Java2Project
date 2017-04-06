README.txt

Javier Mantilla
G00329649

This text parser analyses text files and web sites.
It can reads web sites using the standard protocols 'http' and 'https' on their default ports.

Structure:
This application was built using Object Oriented concepts like:
Inheritance using abstract classes
Composition
Exception Handling
Packaging
Static instance variables and static methods

Instructions:
The entry point for execution is at the public static void main(String[] args) method in the abstract class 'Menu'.
Execution should be performed from there.

The program asks the user to enter the name of the text source directly, the program at some point can determine if the source is a text file or a web site.
If the user desires to exit, he/she just can press 'Enter' and the program finishes.

If everything wentThen a 'Parse Menu' shows up as follows:
Parse Menu
==========
Please select an option:
1. Show text
2. Statistics options
3. Search word
4. Delete options
Choice (Press 'Enter' to go back): 

The user can choose one option entering the number that is most left of any menu-item label or can go back just pressing 'Enter'
The same logic is followed in the subsequent menus.

If the user is asked to input some data, pressing 'Enter' defaults back to the previous menu.

Features:
This program can show the text sourced in a Java array fashion and perform tasks in the following areas:
Statistics
- Show the amount of words
- Show the average word size in letters
- Show the most common word
Search
- Determine if the word exists in the text
- Show its first position
- Show its last position
- Show its positions in the text
Deletion
- Delete a word
- Delete a word by its position