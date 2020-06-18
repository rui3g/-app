package cn.edu.tjrac.booksale.impl;

import cn.edu.tjrac.booksale.dao.MyInfoDao;
import cn.edu.tjrac.booksale.service.MyInfOService;
import cn.edu.tjrac.booksale.vo.MyAddressVo;
import cn.edu.tjrac.booksale.vo.OrderSelectInfoVo;
import cn.edu.tjrac.booksale.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class MyInfOServiceImpl implements MyInfOService {

    @Autowired
    private MyInfoDao myInfoDao;

    @Override
    public List<OrderSelectInfoVo> selectOrder(Long userID) {
        return myInfoDao.selectOrder(userID);
    }

    @Override
    public List<MyAddressVo> selectMyInfo(Long userID) {
        return myInfoDao.selectMyInfo(userID);
    }

    @Override
    public int insertOrder(OrderVo orderVo) {
        return myInfoDao.insertOrder(orderVo);
    }

    @Override
    public int updateStatus(int id) {
        return myInfoDao.updateStatus(id);
    }

    @Override
    public int insertAddress(MyAddressVo myAddressVo) {
        return myInfoDao.insertAddress(myAddressVo);
    }
}
