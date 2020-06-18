package cn.edu.tjrac.booksale.dao;


import cn.edu.tjrac.booksale.vo.ShopInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ShopInfoDao {

    List<ShopInfoVo> selectEvaluate(int bookID);
}
