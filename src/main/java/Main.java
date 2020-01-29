import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        BookDao bookDao = new BookDao(ConnectionUtils.openConnection());
        bookDao.readAll();

        List<Book> listOfBooks = new ArrayList();
        listOfBooks.add(new Book("Lord of the Rings", "Tolkien", "fantasy"));
        listOfBooks.add(new Book("God as an illusion", "Dokins", "science"));
        listOfBooks.add(new Book("Call of Cthulhu", "Lawkraft", "horror"));
        listOfBooks.add(new Book("Kobzar", "Shewchenko", "poetry"));

            //ADD BOOK
//        listOfBooks.forEach(book-> {
//            try {
//                bookDao.addBook(book);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        });
//        bookDao.readAll();

            //REMOVE BOOK
//        bookDao.removeBookById(2);
//        bookDao.readAll();

            //UPDATE BY ID
//        Book book = new Book("Math", "Unknown", "Science");
//        bookDao.updateById(3, book);
//        bookDao.readAll();
    }
}
