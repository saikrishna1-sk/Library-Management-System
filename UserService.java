package service;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import model.User;

public class UserService {
    Scanner sc = new Scanner(System.in);

    public void addUser() {
        try{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into users values(?,?,?,?,?);");
        System.out.println("Enter User Id");
        ps.setInt(1, sc.nextInt());
        sc.nextLine();
        System.out.println("Enter User Name");
        ps.setString(2, sc.nextLine());
        System.out.println("Enter Phone Number Name");
        ps.setLong(3, sc.nextLong());
        sc.nextLine();
        System.out.println("Enter user Email");
        ps.setString(4, sc.nextLine());
        System.out.println("Enter Borrowed Book Count");
        ps.setInt(5, sc.nextInt());
        int rows = ps.executeUpdate();
        ps.close();
        conn.close();

        if (rows > 0) {
            System.out.println("user Added Successfully.");
        } else {
            System.out.println("user Not Added.");
        }
    }
    catch(Exception e){
        e.printStackTrace();
    }
    }

    public void displayUsers() {
        try {
            Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from users");
            while (rs.next()) {
                User user = new User(
                    rs.getInt("userId"),
                    rs.getString("userName"),
                    rs.getLong("phoneNumber"),
                    rs.getString("email"),
                    rs.getInt("borrowedBookCount")
                );
                System.out.println(user);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void searchUser(){
        try{
            Connection conn = DBConnection.getConnection();
            System.out.println("Enter User Id to view The user");
            int userId=sc.nextInt();
            PreparedStatement ps=conn.prepareStatement("select * from users where userid=?");
            ps.setInt(1,userId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                User user = new User(
                    rs.getInt("userId"),
                    rs.getString("userName"),
                    rs.getLong("phoneNumber"),
                    rs.getString("email"),
                    rs.getInt("borrowedBookCount")
                );
                System.out.println(user);
            }
            else{
                System.out.println("user Not Found");
            }
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void updateUser(){
        try{
            Connection conn = DBConnection.getConnection();
            System.out.println("Enter user Id");
            int userId=sc.nextInt();
            while(true){
                System.out.println("1. Update User Name");
                System.out.println("2. Update  Phone Number");
                System.out.println("3. Update  Email");
                System.out.println("4. Update  Borrowd Book Count");
                System.out.println("5. Exit");
                System.out.println("Enter a choice from above");
                int inp=sc.nextInt();
                sc.nextLine();
                switch(inp){
                    case 1:
                        System.out.println("Enter User Name to Update");
                        String userName=sc.nextLine();
                        PreparedStatement ps=conn.prepareStatement("Update users set username=? where userId=?");
                        ps.setString(1, userName);
                        ps.setInt(2, userId);
                        int rows=ps.executeUpdate();
                        if(rows>0){
                            System.out.println("user Name Updated Successfully");
                        }
                        else{
                            System.out.println("user Not found");
                        }
                        break;
                    case 2:
                        System.out.println("Enter Phone Number to Update");
                        Long phoneNumber=sc.nextLong();
                        sc.nextLine();
                        ps=conn.prepareStatement("Update users set PhoneNumber=? where userId=?");
                        ps.setLong(1, phoneNumber);
                        ps.setInt(2, userId);
                        rows=ps.executeUpdate();
                        if(rows>0){
                            System.out.println("User Phone Number Updated Successfully");
                        }
                        else{
                            System.out.println("user Not found");
                        }
                        break;
                    case 3:
                        System.out.println("Enter Email to Update");
                        String email=sc.nextLine();
                        ps=conn.prepareStatement("Update users set Email=? where userId=?");
                        ps.setString(1, email);
                        ps.setInt(2, userId);
                        rows=ps.executeUpdate();
                        if(rows>0){
                            System.out.println("user Email Updated Successfully");
                        }
                        else{
                            System.out.println("user Not found");
                        }
                        break;
                    case 4:
                        System.out.println("Enter Borrowed Book Count to Update");
                        int borrowedBookCount=sc.nextInt();
                        sc.nextLine();
                        ps=conn.prepareStatement("Update users set borrowedBookCount=? where userId=?");
                        ps.setInt(1, borrowedBookCount);
                        ps.setInt(2, userId);
                        rows=ps.executeUpdate();
                        if(rows>0){
                            System.out.println("user Borrowed Book Count Updated Successfully");
                        }
                        else{
                            System.out.println("user Not found");
                        }
                        break;
                    case 5:
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
    public void deleteUser(){
        try {
            Connection conn = DBConnection.getConnection();
            System.out.println("Enter User Id to Delete The user");
            int userId=sc.nextInt();
            PreparedStatement ps=conn.prepareStatement("delete from users where userId=?");
            ps.setInt(1,userId);
            int rows=ps.executeUpdate();
            if(rows>0){
                System.out.println("user Deleted Successfully");
            }
            else{
                System.out.println("user not Found");
            }
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
