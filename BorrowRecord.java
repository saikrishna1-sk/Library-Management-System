package model;

public class BorrowRecord {
    private int recordId;
    private int bookId;
    private int userId;
    private String borrowDate;
    private String returnDate;
    private int fine;
    public BorrowRecord() {

    }
    public BorrowRecord(int recordId, int bookId, int userId,String borrowDate, String returnDate, int fine) {
        this.recordId=recordId;
        this.bookId=bookId;
        this.userId=userId;
        this.borrowDate=borrowDate;
        this.returnDate=returnDate;
        this.fine=fine;
    }
    public void setRecordId(int recordId) {
        this.recordId=recordId;
    }
    public void setBookId(int bookId) {
        this.bookId=bookId;
    }
    public void setUserId(int userId) {
        this.userId=userId;
    }
    public void setBorrowDate(String borrowDate) {
        this.borrowDate=borrowDate;
    }
    public void setReturnDate(String returnDate) {
        this.returnDate=returnDate;
    }
    public void setFine(int fine) {
        this.fine=fine;
    }
    public int getRecordId() {
        return recordId;
    }
    public int getBookId() {
        return bookId;
    }
    public int getUserId() {
        return userId;
    }
    public String getBorrowDate() {
        return borrowDate;
    }
    public String getReturnDate() {
        return returnDate;
    }
    public int getFine() {
        return fine;
    }
    @Override
    public String toString() {
        return "\nRecord ID   : " + recordId +
               "\nBook ID     : " + bookId +
               "\nUser ID     : " + userId +
               "\nBorrow Date : " + borrowDate +
               "\nReturn Date : " + returnDate +
               "\nFine        : " + fine;
    }
}