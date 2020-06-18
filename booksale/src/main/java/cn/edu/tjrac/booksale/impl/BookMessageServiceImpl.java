package cn.edu.tjrac.booksale.impl;

import cn.edu.tjrac.booksale.dao.BookMessageDao;
import cn.edu.tjrac.booksale.service.BookMessageService;
import cn.edu.tjrac.booksale.vo.BookMessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookMessageServiceImpl implements BookMessageService {

    @Autowired
    private BookMessageDao bookMessageDao;

    @Override
    public List<BookMessageVo> Sixinfo() {

        return  bookMessageDao.Sixinfo();
    }

    //促销
    @Override
    public List<BookMessageVo> selectSaleinfo(int saleStatus) {
        return bookMessageDao.selectSaleinfo(saleStatus);
    }

    //分类查
    @Override
    public List<BookMessageVo> selectSortinfo(String bookSort) {
        return bookMessageDao.selectSortinfo(bookSort);
    }

    //促销+分类
    @Override
    public List<BookMessageVo> selectInfo(int saleStatus,String bookSort) {
        return bookMessageDao.selectInfo(saleStatus,bookSort);
    }

    @Override
    public List<BookMessageVo> selectAllInfo() {
        return bookMessageDao.selectAllInfo();
    }

    @Override
    public BookMessageVo selectone(String bookName) {
        return bookMessageDao.selectone(bookName);
    }

}
