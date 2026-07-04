package main;
import java.util.Scanner;

import service.BookService;
import service.BorrowService;
import service.UserService;

public class Library{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BookService bs=new BookService();
        BorrowService brs=new BorrowService();
        UserService us=new UserService();

        while(true){
            System.out.println("1. Book Service");
            System.out.println("2. User Service");
            System.out.println("3. Borrow Service");
            System.out.println("4. Exit");
            System.out.println("Enter Your Choice");
            int inp=sc.nextInt();
            switch(inp){
                case 1:
                    while(true){
                    System.out.println("1. Add Book");
                    System.out.println("2. Display Books");
                    System.out.println("3. Search Book");
                    System.out.println("4. Update Book");
                    System.out.println("5. Delete Book");
                    System.out.println("6. Exit()");
                    System.out.println("Enter choice");
                    int ch=sc.nextInt();
                    switch(ch){
                        case 1:
                            bs.addBook();
                            break;
                        case 2:
                            bs.displayBooks();
                            break;
                        case 3:
                            bs.searchBook();
                            break;
                        case 4:
                            bs.updateBook();
                            break;
                        case 5:
                            bs.deleteBook();
                            break;
                        case 6:
                            System.out.println("Exiting");
                            break;
                        default:
                            System.out.println("Enter from given options");
                        }
                        if(ch==6){
                            break;
                        }
                    }
                    break;
                case 2:
                    while(true){
                    System.out.println("1. Add user");
                    System.out.println("2. Display user");
                    System.out.println("3. Search user");
                    System.out.println("4. Update user");
                    System.out.println("5. Delete user");
                    System.out.println("6. Exit()");
                    System.out.println("Enter choice");
                    int ch=sc.nextInt();
                    switch(ch){
                        
                        case 1:
                            us.addUser();
                            break;
                        case 2:
                            us.displayUsers();
                            break;
                        case 3:
                            us.searchUser();
                            break;
                        case 4:
                            us.updateUser();
                            break;
                        case 5:
                            us.deleteUser();
                            break;
                        case 6:
                            System.out.println("Exiting");
                            break;
                        default:
                            System.out.println("Enter from given options");
                        }
                        if(ch==6){
                            break;
                        }
                    }
                    break;
                case 3:
                    while(true){
                    System.out.println("1. Borrow book");
                    System.out.println("2. Display records");
                    System.out.println("3. Return book");
                    System.out.println("4. Exit()");
                    System.out.println("Enter choice");
                    int ch=sc.nextInt();
                    switch(ch){
                        case 1:
                            brs.borrowBook();
                            break;
                        case 2:
                            brs.displayRecords();
                            break;
                        case 3:
                            brs.returnBook();
                            break;
                        case 4:
                            System.out.println("Exiting");
                            break;
                        default:
                            System.out.println("Enter from given options");
                        }
                        if(ch==4){
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting");
                    return;
                default:
                    System.out.println("Enter from given options");
            }
        }
    }
}