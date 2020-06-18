package cn.edu.tjrac.booksale.service;

import cn.edu.tjrac.booksale.vo.CartIDVo;
import cn.edu.tjrac.booksale.vo.ShoppingCartVo;


import java.util.List;


public interface ShoppingCartService {

    List<ShoppingCartVo> selectCartinfo(Long userID);

    ShoppingCartVo selectSumPrice(int cartID);

    ShoppingCartVo selectSumSale(int cartID);

    Double selectSum(Long userID);

    List<CartIDVo> selectCartID(Long userID);

    int addNum(int cartID);

    int updNum(int cartID);

    int delShopCart(int cartID);

    int insertCart(ShoppingCartVo shoppingCartVo);

    int paydelShopCart(Long userID);
}
