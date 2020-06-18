package cn.edu.tjrac.booksale.service;

import cn.edu.tjrac.booksale.vo.MyAddressVo;
import cn.edu.tjrac.booksale.vo.OrderSelectInfoVo;
import cn.edu.tjrac.booksale.vo.OrderVo;

import java.util.List;

public interface MyInfOService {

    List<OrderSelectInfoVo> selectOrder(Long userID);

    List<MyAddressVo> selectMyInfo(Long userID);

    int insertOrder(OrderVo orderVo);

    int updateStatus(int id);

    int insertAddress(MyAddressVo myAddressVo);
}
