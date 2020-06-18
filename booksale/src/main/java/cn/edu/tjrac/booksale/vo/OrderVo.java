package cn.edu.tjrac.booksale.vo;

import java.util.Date;

public class OrderVo {
    private Integer bookID;
    private  Integer id;
    private Long userID;
    private Date saleTime;
    private Integer orderStatus;
    private Integer bookCount;
    private Double sumSale;

    @Override
    public String toString() {
        return "OrderVo{" +
                "bookID=" + bookID +
                ", id=" + id +
                ", userID=" + userID +
                ", saleTime=" + saleTime +
                ", orderStatus=" + orderStatus +
                ", bookCount=" + bookCount +
                ", sumSale=" + sumSale +
                '}';
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
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

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }

    public Double getSumSale() {
        return sumSale;
    }

    public void setSumSale(Double sumSale) {
        this.sumSale = sumSale;
    }
}
