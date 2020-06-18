package cn.edu.tjrac.booksale.vo;

import java.util.Date;

public class OrderSelectInfoVo {
    private Integer bookID;
    private String bookName;
    private String bookImage;
    private String bookAuthor;
    private  Integer id;
    private Long userID;
    private Date saleTime;
    private String orderStatus;
    private Integer bookCount;
    private Double sumSale;

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "OrderSelectInfoVo{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", bookImage='" + bookImage + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", id=" + id +
                ", userID=" + userID +
                ", saleTime=" + saleTime +
                ", orderStatus=" + orderStatus +
                ", bookCount=" + bookCount +
                ", sumSale=" + sumSale +
                '}';
    }

    public Double getSumSale() {
        return sumSale;
    }

    public void setSumSale(Double sumSale) {
        this.sumSale = sumSale;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }
}
