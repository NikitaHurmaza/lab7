package lab7;

import java.util.*;

public class Logic {
    public List<Book> fillList() {

        List<Book> books = new ArrayList<>();
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "J. B. Lippincott & Co.", 1960, 281, 9.99));
        books.add(new Book("Achu", "Harper Lee", "J. B. Lippincott & Co.", 1950, 221, 10.99));

        books.add(new Book("1984", "George Orwell", "Secker & Warburg", 1949, 328, 8.99));
        books.add(new Book("One Hundred Years of Solitude", "Gabriel García Márquez", "Editorial Sudamericana", 1967, 417, 12.99));
        books.add(new Book("The Catcher in the Rye", "J. D. Salinger", "Little, Brown and Company", 1951, 234, 7.99));
        books.add(new Book("Pride and Prejudice", "Jane Austen", "T. Egerton, Whitehall", 1813, 279, 5.99));
        books.add(new Book("Wuthering Heights", "Emily Bronte", "Thomas Cautley Newby", 1847, 315, 6.99));
        return books;
    }
    public List<Book> AddToList(List<Book>books, String addBook, String addAuthor, String addPublisher, int addYearOfPublishing, int addNumberOfPages, double addPrice){
        books.add(new Book(addBook,addAuthor,addPublisher,addYearOfPublishing,addNumberOfPages,addPrice));
        return books;
    }
    public List <Book> remove(List<Book>books, int index) {
        boolean remove = books.removeIf(book -> book.getId() == index);
        return books;
    }

    // Список книг заданого автора в порядку зростання року видання
    public List<Book> getBooksByAuthor(List<Book> books, String author) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                booksByAuthor.add(book);
            }
        }
        Collections.sort(booksByAuthor, Comparator.comparing(Book::getYearOfPublishing));
        return booksByAuthor;
    }


//Cписок книг, що видані заданим видавництвом
    public List<Book> getBooksByPublisher (List<Book>books, String publisher){
        List<Book> booksByPublisher = new ArrayList<>();
        for(Book book : books){
            if(book.getPublisher().equals(publisher)){
            booksByPublisher.add(book);
        }}
   return booksByPublisher;
    }

    //список книг, що випущені після заданого року
    public List<Book> getBooksAfterYear (List<Book>books, int yearOfPublishing ){
        List<Book> booksAfterYear = new ArrayList<>();
        for(Book book :books){
            if(book.getYearOfPublishing()>yearOfPublishing){
                booksAfterYear.add(book);
            }
        }
        return booksAfterYear;
    }
    // Список авторів в алфавітному порядку
public List<String> sort(List<Book>books) {
    List<String> authors = new ArrayList<>();
    for (Book book : books) {
        String author = book.getAuthor();
        if (!authors.contains(author)) {
            authors.add(author);
        }
    }
    Collections.sort(authors);
    return authors;
}
//список видавництв, книги яких зареєстровані в системі без повторів
public HashSet<String> getPublishers(List<Book>books) {
    HashSet<String> publishersList = new HashSet<String>();
    for(Book book: books){
        publishersList.add(book.publisher);
    }
 return publishersList;
    }
//для кожного видавництва визначити список книг, виданих ним
public Map<String, List<Book>> getBooksByPublisherMap(List<Book>books) {
    Map<String, List<Book>> booksByPublisher = new HashMap<>();
    for (Book book : books) {
        String publisher = book.getPublisher();
        List<Book> publisherBooks = booksByPublisher.get(publisher);
        if (publisherBooks == null) {
            publisherBooks = new ArrayList<>();
            booksByPublisher.put(publisher, publisherBooks);
        }

        publisherBooks.add(book);
    }
    return booksByPublisher;
}
}

