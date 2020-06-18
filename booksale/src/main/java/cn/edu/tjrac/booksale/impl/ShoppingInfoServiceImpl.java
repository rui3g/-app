package cn.edu.tjrac.booksale.impl;

import cn.edu.tjrac.booksale.dao.ShopInfoDao;
import cn.edu.tjrac.booksale.service.ShopInfoService;
import cn.edu.tjrac.booksale.vo.ShopInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ShoppingInfoServiceImpl implements ShopInfoService {

    @Autowired
    private ShopInfoDao shopInfoDao;

    @Override
    public List<ShopInfoVo> selectEvaluate(int bookID) {
        return shopInfoDao.selectEvaluate(bookID);
    }
}
