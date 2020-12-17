# Bookstore-system-using-OOP

# Bookstore-system-using-OOP
Book store maintains an inventory of books. The store tracks the title and author of each book, plus the book's media. The media is one of hardcover(cloth or leather), paperback, and audio books.

<br/>

The inventory records whether each hardcover book has either a cloth or a leather cover and
how many discs are in each audiobook. Each electronic book has a download URL link that
the store wants to use to let a customer browse the book. The store keeps its inventory in a
formatted file. Each non-empty line represents a book that the store has in stock.

<br/>

Each book entry appears as a single line in the file. For example, here are example file entries
for different versions and editions of the book "Ulysses" by James Joyce:

Ulysses_James Joyce_895 <br/>
Ulysses_James Joyce_3195_leather <br/>
Ulysses_James Joyce_2395_cloth <br/>
Ulysses_James Joyce_0_http://www.amazon.com <br/>
Ulysses_James Joyce_1995_3

<br/>

As you can see, the fields are underscore-separated strings. The fields are the title, author,
cost in cents, and an optional field providing details on the book's media format. If there is
no media format, the entry is a paperback. Leather and cloth are kinds of hardcover books.
The first entry in the example is a paperback, and the last two entries are an electronic book
and an 3 disc audiobook respectively.

<br/>

This short example interaction shows the program printing its inventory list and offering
search options. More detailed sample run is provided in sample_output.txt
<br/>
$ java Store bookList0.txt <br/>
The inventory of Barney's Books 'N' Bytes: <br/>
1. "Ulysses". <br/>
James Joyce. <br/>
Paperback. <br/>
2. "Ulysses". <br/>
James Joyce. <br/>
Hardcover leather. <br/>
3. "Ulysses". <br/>
James Joyce. <br/>
Hardcover cloth. <br/>
4. "Ulysses". <br/>
James Joyce. <br/>
Electronic from http://www.amazon.com <br/>
5. "Designing Object-Oriented Software". <br/>
Rebecca Wirfs-Brock, Brian Wilkerson, Lauren Wiener <br/>
Electronic from http://booksRnotDead.com <br/>
6. "Sometimes a Great Notion". <br/>
Ken Kesey. <br/>
Audio: 3 discs. <br/>

Enter one of these codes (t, a, m)=(title, author, media) and a portion of the 
desired text. Or enter a blank line to quit. (Note: media format is paper, hard,
audio, or electronic). How would you like to search? :
