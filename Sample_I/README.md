Question 1 – Time Converter (Converter.java)
Overview
Accepts times in [H]H:MM (12-hour) format and outputs the English language description of that time.
Rules

Exact multiples of 5 minutes are described precisely (e.g. half past ten, quarter to nine).
Minutes that are not a multiple of 5 are rounded to the nearest 5 and prefixed with about (e.g. 2:12 → about ten past two).
Special cases: o'clock, quarter past, quarter to, half past.

Usage
javac Converter.java
java Converter
Sample I/O
Enter a time or 'quit': 8:00
eight o'clock
Enter a time or 'quit': 5:15
quarter past five
Enter a time or 'quit': 8:45
quarter to nine
Enter a time or 'quit': 12:07
about five past twelve
Enter a time or 'quit': quit
Done

Question 2 – Card Set Checker (Check.java)
Overview
Reads a text file where each line contains three card descriptions and determines whether each set is valid or invalid.
Card Attributes
Each card has three attributes:

Shape: square, circle, or triangle
Colour: blue, red, or green
Pattern: spot, solid, or stripe

Validity Rules
A set of three cards is valid if:

All three cards are completely distinct (no attribute matches across any two cards), OR
All three cards are identical (every attribute matches across all three cards).

Any other combination is invalid.
Input Format
A .txt file where each line contains three space-separated card descriptions, each in the format shape,colour,pattern.
Example (cards.txt):
square,blue,spot circle,red,solid triangle,green,stripe
square,blue,spot circle,red,solid triangle,green,solid
square,blue,spot square,blue,spot square,blue,spot
square,blue,spot square,blue,spot triangle,green,stripe
Usage
javac Check.java
java Check
Sample I/O
Enter the name of the cards file: cards.txt
Processing: square,blue,spot circle,red,solid triangle,green,stripe
Valid
Processing: square,blue,spot circle,red,solid triangle,green,solid
Invalid
Processing: square,blue,spot square,blue,spot square,blue,spot
Valid
Processing: square,blue,spot square,blue,spot triangle,green,stripe
Invalid
Done
