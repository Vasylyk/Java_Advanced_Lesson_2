import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper {

    public static Book map(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String title = result.getString("title");
        String author = result.getString("author");
        String genre = result.getString("genre");
        return new Book(id, title, author, genre);
    }
}
