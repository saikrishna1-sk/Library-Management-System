package service;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import model.BorrowRecord;

public class BorrowService {
    Scanner sc = new Scanner(System.in);
    Connection conn = DBConnection.getConnection();
    public void borrowBook() {
        System.out.println("Enter Record Id");
        int recordId = sc.nextInt();
        System.out.println("Enter Book ID");
        int bookId = sc.nextInt();
        try {
            PreparedStatement ps = conn.prepareStatement("Select * from books where bookId=?");
            ps.setInt(1, bookId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int quantity = rs.getInt("quantity");
                if (quantity <= 0) {
                    System.out.println("Book out of Stock");
                    return;
                }
                System.out.println("Enter user Id");
                int userId = sc.nextInt();
                ps = conn.prepareStatement("Select * from users where userId=?");
                ps.setInt(1, userId);
                rs = ps.executeQuery();
                if (!rs.next()) {
                    System.out.println("user not found");
                    return;
                }
                ps = conn.prepareStatement("insert into borrowrecords values (?,?,?,?,?,?);");
                ps.setInt(1, recordId);
                ps.setInt(2, bookId);
                ps.setInt(3, userId);
                sc.nextLine();
                System.out.println("Enter Borrow Date (yyyy-mm-dd)");
                String borrowDate = sc.nextLine();
                java.sql.Date date = java.sql.Date.valueOf(borrowDate);
                ps.setDate(4, date);
                ps.setNull(5, java.sql.Types.DATE);
                ps.setInt(6, 0);
                int rows = ps.executeUpdate();
                if (rows > 0) {
                    PreparedStatement ps1 = conn.prepareStatement("UPDATE books SET quantity = quantity - 1 WHERE bookId=?");
                    ps1.setInt(1, bookId);
                    ps1.executeUpdate();

                    PreparedStatement ps2 = conn.prepareStatement("UPDATE users SET borrowedBookCount = borrowedBookCount + 1 WHERE userId=?");
                    ps2.setInt(1, userId);
                    ps2.executeUpdate();
                    System.out.println("Book Borrowed Successfully");

                }
            } else {
                System.out.println("Book Not Found");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayRecords() {
        try {
            PreparedStatement ps = conn.prepareStatement("select * from borrowrecords");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BorrowRecord record = new BorrowRecord(
                        rs.getInt("recordId"),
                        rs.getInt("bookId"),
                        rs.getInt("userId"),
                        rs.getString("borrowDate"),
                        rs.getString("returnDate"),
                        rs.getInt("fine")
                );
                System.out.println(record);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void returnBook() {
        System.out.println("Enter Record ID");
        int recordId = sc.nextInt();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM borrowrecords WHERE recordId=?");
            ps.setInt(1, recordId);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("Record Not Found");
                return;
            }
            int bookId = rs.getInt("bookId");
            int userId = rs.getInt("userId");
            java.sql.Date borrowDate = rs.getDate("borrowDate");
            sc.nextLine();
            System.out.println("Enter Return Date (yyyy-mm-dd)");
            String returnDateStr = sc.nextLine();
            java.sql.Date returnDate = java.sql.Date.valueOf(returnDateStr);
            int fine = calculateFine(borrowDate, returnDate);
            ps = conn.prepareStatement(
                    "UPDATE borrowrecords SET returnDate=?, fine=? WHERE recordId=?");
            ps.setDate(1, returnDate);
            ps.setInt(2, fine);
            ps.setInt(3, recordId);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                PreparedStatement ps1 = conn.prepareStatement(
                        "UPDATE books SET quantity = quantity + 1 WHERE bookId=?");
                ps1.setInt(1, bookId);
                ps1.executeUpdate();

                PreparedStatement ps2 = conn.prepareStatement(
                        "UPDATE users SET borrowedBookCount = borrowedBookCount - 1 WHERE userId=?");
                ps2.setInt(1, userId);
                ps2.executeUpdate();

                System.out.println("Book Returned Successfully");
                System.out.println("Fine : ₹" + fine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void searchRecord() {
        try {
            System.out.println("Enter Record ID");
            int recordId = sc.nextInt();

            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM borrowrecords WHERE recordId=?");
            ps.setInt(1, recordId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                BorrowRecord record = new BorrowRecord(
                        rs.getInt("recordId"),
                        rs.getInt("bookId"),
                        rs.getInt("userId"),
                        rs.getString("borrowDate"),
                        rs.getString("returnDate"),
                        rs.getInt("fine")
                );

                System.out.println(record);
            } else {
                System.out.println("Record Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int calculateFine(java.sql.Date borrowDate, java.sql.Date returnDate) {
        long diff=returnDate.getTime()-borrowDate.getTime();
        long days=diff / (1000 * 60 * 60 * 24);
        if (days<=15) {
            return 0;
        } else {
            return (int) ((days-15)*10);
        }
    }
}
