package cn.edu.tjrac.booksale.dao;


import cn.edu.tjrac.booksale.vo.MyAddressVo;
import cn.edu.tjrac.booksale.vo.OrderSelectInfoVo;
import cn.edu.tjrac.booksale.vo.OrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MyInfoDao {

 List<OrderSelectInfoVo> selectOrder(Long userID);

 List<MyAddressVo> selectMyInfo(Long userID);

 int insertOrder(OrderVo orderVo);

 int updateStatus(int id);

 int insertAddress(MyAddressVo myAddressVo);
}

