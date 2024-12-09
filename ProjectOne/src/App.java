import java.sql.*;
public class App {
    public static void main(String[] args) throws ClassNotFoundException{
        String url = "jdbc:mysql://127.0.0.1:3306/abc";
        String username = "root";
        String password = "1234";
        String query = "UPDATE students SET MARKS= 20 WHERE Roll_No = 3;";
        try {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Drivers loaded successfully!!!");
        }catch (ClassNotFoundException e) {
        System.out.println(e.getMessage());
        }
        try{
        Connection con = DriverManager.getConnection(url, username, password);



           Statement stmt = con.createStatement();        // statement created 
            int rowseffected = stmt.executeUpdate(query);               //insert data- executerUpdate()(updated value can be printed),   retriving data - executeQuery() (only effected rows are shown)
            
            if(rowseffected > 0){
                System.out.println("Insert successfull " + rowseffected + "row(s)");
            }
            else{
                System.out.println("Failed! ");
            }


           /*  ResultSet rs = stmt.executeQuery(query);              // query executed 
          while(rs.next()){                                     // running this quesry till thee is data in table
            int  Roll_No= rs.getInt("Roll_No");
            String Name = rs.getString("Name");
            int Class = rs. getInt("Class");
            String Grade = rs.getString("Grade");
            int Marks = rs.getInt("MARKS");
            System.out.println("----------------------------------------------------------");
            System.out.println("Roll No " +Roll_No);
            System.out.println("Name "+ Name);
            System.out.println("Class" + Class);
            System.out.println("Section "+ Grade);
            */

          

stmt.close();
con.close();


    }
        catch (SQLException e) {
        System.out.println(e.getMessage());
        }}}