package cn.edu.tjrac.booksale.dao;

import cn.edu.tjrac.booksale.vo.CartIDVo;
import cn.edu.tjrac.booksale.vo.ShopInfoVo;
import cn.edu.tjrac.booksale.vo.ShoppingCartVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ShoppingCartDao {

    List<ShoppingCartVo> selectCartinfo(Long userID);

    ShoppingCartVo selectSumPrice(int cartID);

    ShoppingCartVo selectSumSale(int cartID);

    List<CartIDVo> selectCartID(Long userID);

      int addNum(int cartID);

      int updNum(int cartID);

      int delShopCart(int cartID);

      int insertCart(ShoppingCartVo shoppingCartVo);

      int paydelShopCart(Long userID);
}
