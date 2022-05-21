package com.example.myliblary;

import java.util.ArrayList;

public class Util {
    public static ArrayList<Book> allBooks;
    public static ArrayList<Book> currentlyReadingsBooks;
    public static ArrayList<Book> wantToReadBooks;
    public static ArrayList<Book> alreadyReadeBooks;
    public static int id;
   public Util(){
       if(allBooks == null){
           allBooks = new ArrayList<>();
           initAllBooks();
       }
       if(null == currentlyReadingsBooks){
           currentlyReadingsBooks = new ArrayList<>();
       }
       if( null ==wantToReadBooks){
           wantToReadBooks = new ArrayList<>();
       }
       if( null ==alreadyReadeBooks ){
           alreadyReadeBooks = new ArrayList<>();
       }
       if(null == allBooks){
           allBooks = new ArrayList<>();
       }
   }
   public static ArrayList<Book> getAllBooks(){
       return  allBooks;
   }
    public static ArrayList<Book> getCurrentlyReadingBooks(){
        return  currentlyReadingsBooks;
    }
    public static ArrayList<Book> getWantToReadBooks(){
        return  wantToReadBooks;
    }
    public static ArrayList<Book> getAlreadyReadingBooks(){
        return  alreadyReadeBooks;
    }
    public static boolean addToCurrentsBooks(Book b){

       return currentlyReadingsBooks.add(b);
    }
    public static boolean addToWantedBooks(Book b){
       return wantToReadBooks.add(b);
    }
    public boolean removeFromBooks(Book book){
        return allBooks.remove(book);

    }
    public boolean removeFromCurrentlyReadingBooks(Book book){
        return currentlyReadingsBooks.remove(book);

    }
    public boolean removeFromWntToReadBooks(Book book){
        return wantToReadBooks.remove(book);

    }
    public boolean removeFromAlreadyReadBooks(Book book){
        return alreadyReadeBooks.remove(book);

    }
    public void initAllBooks(){
         String name;
         String author;
         String imageUrl;
         String description;
         int pages;
         id++;
         name = "Molokai";
         author = "Alan Brenner";
         imageUrl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1441920261i/3273.jpg";
         description = "Set in Hawaii more than a century ago, this is the story of Rachel Kalama, a spirited seven-year-old Hawaiian girl, who dreams of visiting far-off lands like her father, a merchant seaman. Then one day a rose-colored mark appears on her skin, and those dreams are stolen from her. Taken from her home and family, Rachel is sent to Kalaupapa, the quarantined leprosy settlement on the island of Molokai. Here her life is supposed to end---but instead she discovers it is only just beginning.";
         pages = 250;
         Book book1 = new Book(id,name,author,imageUrl,description,pages);
         allBooks.add(book1);
         id++;
        name = "The Help";
        author = "Alan Brenner";
        imageUrl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1622355533i/4667024.jpg";
        description = "Twenty-two-year-old Skeeter has just returned home after graduating from Ole Miss. She may have a degree, but it is 1962, Mississippi, and her mother will not be happy till Skeeter has a ring on her finger. Skeeter would normally find solace with her beloved maid Constantine, the woman who raised her, but Constantine has disappeared and no one will tell Skeeter where she has gone.\n";
        pages = 286;
        Book book2 = new Book(id,name,author,imageUrl,description,pages);
        allBooks.add(book2);
        id++;
        name = "Molokai";
        author = "Alan Brenner";
        imageUrl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1441920261i/3273.jpg";
        description = "Set in Hawaii more than a century ago, this is the story of Rachel Kalama, a spirited seven-year-old Hawaiian girl, who dreams of visiting far-off lands like her father, a merchant seaman. Then one day a rose-colored mark appears on her skin, and those dreams are stolen from her. Taken from her home and family, Rachel is sent to Kalaupapa, the quarantined leprosy settlement on the island of Molokai. Here her life is supposed to end---but instead she discovers it is only just beginning.";
        pages = 498;
        Book book3 = new Book(id,name,author,imageUrl,description,pages);
        allBooks.add(book3);
        id++;
        name = "Animals Make Us Human";
        author = "Alan Brenner";
        imageUrl = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1348264535i/4386485.jpg";
        description = "Set in Hawaii more than a century ago, this is the story of Rachel Kalama, a spirited seven-year-old Hawaiian girl, who dreams of visiting far-off lands like her father, a merchant seaman. Then one day a rose-colored mark appears on her skin, and those dreams are stolen from her. Taken from her home and family, Rachel is sent to Kalaupapa, the quarantined leprosy settlement on the island of Molokai. Here her life is supposed to end---but instead she discovers it is only just beginning.";
        pages = 578;
        Book book4 = new Book(id,name,author,imageUrl,description,pages);
        allBooks.add(book4);


    }
}
