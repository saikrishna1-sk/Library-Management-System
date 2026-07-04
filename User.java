package model;

public class User{
    private int userId;
    private String userName;
    private long  phoneNumber;
    private String email;
    private int borrowedBookCount;

    public User(){

    }

    public User(int userId,String userName,long phoneNumber,String email,int borrowedBookCount){
        this.userId=userId;
        this.borrowedBookCount=borrowedBookCount;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.userName=userName;
    }
    public void setUserId(int userId){
        this.userId=userId;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }
    public void setPhoneNumber(long phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setBorrowedBookCount(int borrowedBookCount){
        this.borrowedBookCount=borrowedBookCount;
    }
    public int getUserId(){
       return userId;
    }
    public String getUserName(){
        return userName;
    }
    public long getPhoneNumber(){
        return phoneNumber;
    }
    public String getEmail(){
        return email;
    }
    public int getBorrowedBookCount(){
        return borrowedBookCount;
    }
    @Override
    public String toString() {
    return "\nUser ID         : " + userId +
           "\nUser Name       : " + userName +
           "\nPhone Number    : " + phoneNumber +
           "\nEmail           : " + email +
           "\nBorrowed Books  : " + borrowedBookCount;
    }
}