package model;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String category;
    private int price;
    private int quantity;
    private String status;

    public Book() {

    }

    public Book(int bookId,String bookName,String author,String category,int price,int quantity,String status){
        this.author=author;
        this.bookId=bookId;
        this.bookName=bookName;
        this.category=category;
        this.price=price;
        this.quantity=quantity;
        this.status=status;
    }
    public void setBookId(int bookId){
        this.bookId=bookId;
    }
    public void setBookName(String bookName){
        this.bookName=bookName;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public void setCategory(String category){
        this.category=category;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    public void setStatus(String status){
        this.status=status;
    }
    public int getBookId(){
        return bookId;
    }
    public String getBookName(){
        return bookName;
    }
    public String getAuthor(){
        return author;
    }
    public String getCategory(){
        return category;
    }
    public String getStatus(){
        return status;
    }
    public int getQuantity(){
        return quantity;
    }
    public int getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return "\nBook ID   : " + bookId +
            "\nBook Name : " + bookName +
            "\nAuthor    : " + author +
            "\nCategory  : " + category +
            "\nPrice     : " + price +
            "\nQuantity  : " + quantity +
            "\nStatus    : " + status;
    }
}
