package cn.edu.tjrac.booksale.vo;

import java.util.Date;

public class ShopInfoVo {
    private Integer bookID;
    private String bookName;
    private String remarkMan;
    private Integer bookStar;
    private String bookRemark;

    @Override
    public String toString() {
        return "ShopInfoVo{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", remarkMan='" + remarkMan + '\'' +
                ", bookStar=" + bookStar +
                ", bookRemark='" + bookRemark + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public String getBookRemark() {
        return bookRemark;
    }

    public void setBookRemark(String bookRemark) {
        this.bookRemark = bookRemark;
    }

    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getRemarkMan() {
        return remarkMan;
    }

    public void setRemarkMan(String remarkMan) {
        this.remarkMan = remarkMan;
    }

    public Integer getBookStar() {
        return bookStar;
    }

    public void setBookStar(Integer bookStar) {
        this.bookStar = bookStar;
    }
}
