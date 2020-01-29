import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private static String READ_ALL = "select * from books";
    private static String ADD_BOOK = "insert into books(`title`, `author`, `genre`) values (?, ?, ?)";
    private static String REMOVE_BOOK_BY_ID = "delete from books where id = ?";
    private static String UPDATE_BY_ID = "update books set title=?, author = ?, genre = ? where id = ?";

    private Connection connection;
    private PreparedStatement preparedStatement;

    public BookDao(Connection connection) {
        this.connection = connection;
    }

    public void readAll () throws SQLException {
        List<Book> listOfBooks = new ArrayList();
        preparedStatement = connection.prepareStatement(READ_ALL);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()){
            listOfBooks.add(BookMapper.map(result));
        }

        for (int i = 0; i <listOfBooks.size() ; i++) {
            System.out.println(listOfBooks.get(i));
        }
    }

    public void addBook (Book book) throws SQLException {
        preparedStatement = connection.prepareStatement(ADD_BOOK);
        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.setString(3, book.getGenre());
        preparedStatement.executeUpdate();
    }

    public void removeBookById (int id) throws SQLException {
        preparedStatement = connection.prepareStatement(REMOVE_BOOK_BY_ID);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public void updateById (int id, Book book) throws SQLException {
        preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
        preparedStatement.setInt(4, id);
        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.setString(3, book.getGenre());
        preparedStatement.executeUpdate();
    }
}
