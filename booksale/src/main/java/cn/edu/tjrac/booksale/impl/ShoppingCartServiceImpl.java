package cn.edu.tjrac.booksale.impl;

import cn.edu.tjrac.booksale.dao.ShoppingCartDao;
import cn.edu.tjrac.booksale.service.ShoppingCartService;
import cn.edu.tjrac.booksale.vo.CartIDVo;
import cn.edu.tjrac.booksale.vo.ShoppingCartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {


    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Override
    public List<ShoppingCartVo> selectCartinfo(Long userID) {
        return shoppingCartDao.selectCartinfo(userID);
    }

    @Override
    public ShoppingCartVo selectSumPrice(int cartID) {
        return shoppingCartDao.selectSumPrice(cartID);
    }

    @Override
    public ShoppingCartVo selectSumSale(int cartID) {
        return shoppingCartDao.selectSumSale(cartID);
    }

    @Override
    public Double selectSum(Long userID) {
        List<CartIDVo> list=  selectCartID(userID);
        double sum=0.00;
        double sumprice=0.00;
        int num=0;
            for (CartIDVo sp: list){
                try {
                    double sale=selectSumSale(sp.getCartID()).getBookSale();
                    num=selectSumSale(sp.getCartID()).getBookNumber();
                    sum+=sale*num;
                } catch (Exception e) {
                    double price=selectSumPrice(sp.getCartID()).getBookPrice();
                    num=selectSumPrice(sp.getCartID()).getBookNumber();
                    sumprice+=price*num;
                }
            }
            sum+=sumprice;
            return sum;
    }

    @Override
    public List<CartIDVo> selectCartID(Long userID) {
        return shoppingCartDao.selectCartID(userID);
    }

    @Override
    public int addNum(int cartID) {
        return shoppingCartDao.addNum(cartID);
    }

    @Override
    public int updNum(int cartID) {
        return shoppingCartDao.updNum(cartID);
    }

    @Override
    public int delShopCart(int cartID) {
        return shoppingCartDao.delShopCart(cartID);
    }

    @Override
    public int insertCart(ShoppingCartVo shoppingCartVo) {
        return shoppingCartDao.insertCart(shoppingCartVo);
    }

    @Override
    public int paydelShopCart(Long userID) {
        return shoppingCartDao.paydelShopCart(userID);
    }


}
