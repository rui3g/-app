package cn.edu.tjrac.booksale.service;

import cn.edu.tjrac.booksale.vo.BookMessageVo;

import java.util.List;

public interface BookMessageService {

    List<BookMessageVo> Sixinfo();//6本随机

    List<BookMessageVo> selectSaleinfo(int saleStatus);//促销书

    List<BookMessageVo> selectSortinfo(String bookSort);//分类查询

    List<BookMessageVo> selectInfo(int saleStatus,String bookSort);//查促销+分类

    List<BookMessageVo> selectAllInfo();//全部商品

    BookMessageVo selectone(String bookName);//按书名查询

}
