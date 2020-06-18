package cn.edu.tjrac.booksale.dao;


import cn.edu.tjrac.booksale.vo.BookMessageVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BookMessageDao {

   List<BookMessageVo> Sixinfo();//随机6条

   List<BookMessageVo> selectSaleinfo(int saleStatus);//促销书

   List<BookMessageVo> selectSortinfo(String bookSort);//分类查询

   List<BookMessageVo> selectInfo(int saleStatus,String bookSort);//查促销+分类

   List<BookMessageVo> selectAllInfo();//全部商品

   BookMessageVo selectone(String bookName);//按书名查询
}
