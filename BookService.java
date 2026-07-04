package service;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import model.Book;

public class BookService {
    Scanner sc = new Scanner(System.in);
    public void addBook(){
        try{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into books values(?,?,?,?,?,?,?);");
        System.out.println("Enter Book Id");
        ps.setInt(1, sc.nextInt());
        sc.nextLine();
        System.out.println("Enter Book Name");
        ps.setString(2, sc.nextLine());
        System.out.println("Enter Author Name");
        ps.setString(3, sc.nextLine());
        System.out.println("Enter Book category");
        ps.setString(4, sc.nextLine());
        System.out.println("Enter Book Price");
        ps.setInt(5, sc.nextInt());
        System.out.println("Enter Quantity");
        ps.setInt(6, sc.nextInt());
        sc.nextLine();
        System.out.println("Enter status");
        ps.setString(7, sc.nextLine());
        int rows = ps.executeUpdate();
        ps.close();
        conn.close();

        if (rows > 0) {
            System.out.println("Book Added Successfully.");
        } else {
            System.out.println("Book Not Added.");
        }
    }
    catch(Exception e){
        e.printStackTrace();
    }
    }

    public void displayBooks() {
        try {
            Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from books");
            while (rs.next()) {
                Book book = new Book(
                rs.getInt("bookId"),
                rs.getString("bookName"),
                rs.getString("author"),
                rs.getString("category"),
                rs.getInt("price"),
                rs.getInt("quantity"),
                rs.getString("status")
                );
                System.out.println(book);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void searchBook(){
        try{
            Connection conn = DBConnection.getConnection();
            System.out.println("Enter Book Id to view The book");
            int bookId=sc.nextInt();
            PreparedStatement ps=conn.prepareStatement("select * from books where bookid=?");
            ps.setInt(1,bookId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Book book = new Book(
                rs.getInt("bookId"),
                rs.getString("bookName"),
                rs.getString("author"),
                rs.getString("category"),
                rs.getInt("price"),
                rs.getInt("quantity"),
                rs.getString("status")
                );
                System.out.println(book);
            }
            else{
                System.out.println("Book Not Found");
            }
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void updateBook(){
        try{
            Connection conn = DBConnection.getConnection();
            System.out.println("Enter Book Id to view The book");
            int bookId=sc.nextInt();
            while(true){
                System.out.println("1. Update Book Name");
                System.out.println("2. Update  Author Name");
                System.out.println("3. Update  Category");
                System.out.println("4. Update  Price");
                System.out.println("5. Update  Quantity");
                System.out.println("6. Update  Status");
                System.out.println("7. Exit");
                System.out.println("Enter a choice from above");
                int inp=sc.nextInt();
                sc.nextLine();
                switch(inp){
                    case 1:
                        System.out.println("Enter Book Name to Update");
                        String BookName=sc.nextLine();
                        PreparedStatement ps=conn.prepareStatement("Update books set bookname=? where bookId=?");
                        ps.setString(1, BookName);
                        ps.setInt(2, bookId);
                        int rows=ps.executeUpdate();
                        if(rows>0){
                            System.out.println("Book Name Updated Successfully");
                        }
                        else{
                            System.out.println("Book Not found");
                        }
                        break;
                    case 2:
                        System.out.println("Enter Author Name to Update");
                        String AuthorName=sc.nextLine();
                        ps=conn.prepareStatement("Update books set author=? where bookId=?");
                        ps.setString(1, AuthorName);
                        ps.setInt(2, bookId);
                        rows=ps.executeUpdate();
                        if(rows>0){
                            System.out.println("Book Author Name Updated Successfully");
                        }
                        else{
                            System.out.println("Book Not found");
                        }
                        break;
                    case 3:
                        System.out.println("Enter Category to Update");
                        String category=sc.nextLine();
                        ps=conn.prepareStatement("Update books set category=? where bookId=?");
                        ps.setString(1, category);
                        ps.setInt(2, bookId);
                        rows=ps.executeUpdate();
                        if(rows>0){
                            System.out.println("Book Category Updated Successfully");
                        }
                        else{
                            System.out.println("Book Not found");
                        }
                        break;
                    case 4:
                        System.out.println("Enter Price to Update");
                        int price=sc.nextInt();
                        sc.nextLine();
                        ps=conn.prepareStatement("Update books set price=? where bookId=?");
                        ps.setInt(1, price);
                        ps.setInt(2, bookId);
                        rows=ps.executeUpdate();
                        if(rows>0){
                            System.out.println("Book price Updated Successfully");
                        }
                        else{
                            System.out.println("Book Not found");
                        }
                        break;
                    case 5:
                        System.out.println("Enter Quantity to Update");
                        int Quantity=sc.nextInt();
                        sc.nextLine();
                        ps=conn.prepareStatement("Update books set quantity=? where bookId=?");
                        ps.setInt(1, Quantity);
                        ps.setInt(2, bookId);
                        rows=ps.executeUpdate();
                        if(rows>0){
                            System.out.println("Book Quantity Updated Successfully");
                        }
                        else{
                            System.out.println("Book Not found");
                        }
                        break;
                    case 6:
                        System.out.println("Enter Status to Update");
                        String Status=sc.nextLine();
                        ps=conn.prepareStatement("Update books set status=? where bookId=?");
                        ps.setString(1, Status);
                        ps.setInt(2, bookId);
                        rows=ps.executeUpdate();
                        if(rows>0){
                            System.out.println("Book status Updated Successfully");
                        }
                        else{
                            System.out.println("Book Not found");
                        }
                        break;
                    case 7:
                        System.out.println("Exiting");
                        return;
                    default:
                        System.out.println("Enter a valid choice");
                        break;
                }
            }
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteBook(){
        try {
            Connection conn = DBConnection.getConnection();
            System.out.println("Enter Book Id to Delete The book");
            int bookId=sc.nextInt();
            PreparedStatement ps=conn.prepareStatement("delete from books where bookId=?");
            ps.setInt(1,bookId);
            int rows=ps.executeUpdate();
            if(rows>0){
                System.out.println("Book Deleted Successfully");
            }
            else{
                System.out.println("Book not Found");
            }
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
