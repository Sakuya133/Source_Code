
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;



public class BelajarJavaMysql {

   
    static final String JDBC_DRIVER = "";
    static final String DB_URL = "";
    static final String USER = "root";
    static final String PASS = "";

    
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    public static void main(String[] args) {

        
        try {
           
            Class.forName(JDBC_DRIVER);

            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

           
            stmt = conn.createStatement();

            
            String sql = "SELECT * FROM buku";

           
            rs = stmt.executeQuery(sql);

           
            while (rs.next()) {
                System.out.println("ID Buku   : " + rs.getInt("id_buku"));
                System.out.println("Judul     : " + rs.getString("judul"));
                System.out.println("Pengarang : " + rs.getString("pengarang"));
                System.out.println("-----------------------------------");
            }

            /
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("--- TERJADI KESALAHAN KONEKSI ---");
            
            e.printStackTrace();
        }
        
    }
}