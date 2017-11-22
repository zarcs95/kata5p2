
package kata5P2.Vista;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import kata5P2.Modelo.Mail;

/**
 *
 * @author javi
 */
public class DataBaseListMail {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet rs;
    public static List<Mail> read() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/Usuario/Downloads/SQLiteDatabaseBrowserPortable/Data/kata5.db");
        List<Mail> mailList= new ArrayList<>();
        Statement st = (Statement) connection.createStatement();
        ResultSet rs = st.executeQuery("select mail from MAIL2;");
        String query = "select count(*from MAIL2)";
        while(rs.next()) {
            String mail = rs.getString("mail");
            mailList.add(new Mail(mail));
        }
        rs = statement.executeQuery(query);
        while(rs.next()){
            int num = rs.getInt(1);
            System.out.println(num);
        }
        statement.close();
        rs.close();
        return mailList;
    }
}
