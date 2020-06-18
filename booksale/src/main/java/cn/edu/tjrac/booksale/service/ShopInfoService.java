package cn.edu.tjrac.booksale.service;

import cn.edu.tjrac.booksale.vo.ShopInfoVo;

import java.util.List;

public interface ShopInfoService {

    List<ShopInfoVo> selectEvaluate(int bookID);
}
