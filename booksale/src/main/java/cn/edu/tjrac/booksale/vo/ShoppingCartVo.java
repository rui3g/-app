package cn.edu.tjrac.booksale.vo;

public class ShoppingCartVo {
    private Integer bookID;
    private String bookName;
    private Double bookPrice;
    private String bookImage;
    private String bookAuthor;
    private Double bookSale;
    private Integer cartID;
    private Integer bookNumber;
    private Long userID;

    @Override
    public String toString() {
        return "ShoppingCartVo{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookImage='" + bookImage + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookSale=" + bookSale +
                ", cartID=" + cartID +
                ", bookNumber=" + bookNumber +
                ", userID=" + userID +
                '}';
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
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

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
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

    public Double getBookSale() {
        return bookSale;
    }

    public void setBookSale(Double bookSale) {
        this.bookSale = bookSale;
    }

    public Integer getCartID() {
        return cartID;
    }

    public void setCartID(Integer cartID) {
        this.cartID = cartID;
    }

    public Integer getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(Integer bookNumber) {
        this.bookNumber = bookNumber;
    }
}
