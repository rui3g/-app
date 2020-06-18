package cn.edu.tjrac.booksale.vo;

public class BookMessageVo {
    private Integer bookID;
    private String bookName;
    private Double bookPrice;
    private String bookImage;
    private String bookAuthor;
    private String bookSort;
    private Double bookSale;
    private Integer saleStatus;

    @Override
    public String toString() {
        return "BookMessageVo{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookImage='" + bookImage + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookSort='" + bookSort + '\'' +
                ", bookSale=" + bookSale +
                ", saleStatus=" + saleStatus +
                '}';
    }

    public Integer getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Integer saleStatus) {
        this.saleStatus = saleStatus;
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

    public String getBookSort() {
        return bookSort;
    }

    public void setBookSort(String bookSort) {
        this.bookSort = bookSort;
    }

    public Double getBookSale() {
        return bookSale;
    }

    public void setBookSale(Double bookSale) {
        this.bookSale = bookSale;
    }
}
