package cn.edu.tjrac.booksale.controller;


import cn.edu.tjrac.booksale.service.ShoppingCartService;
import cn.edu.tjrac.booksale.vo.CartIDVo;
import cn.edu.tjrac.booksale.vo.ShopInfoVo;
import cn.edu.tjrac.booksale.vo.ShoppingCartVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shoppingCart")
@Api("购物车信息")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;


    @ApiOperation(value = "购物车信息查询", notes = "查询", produces = "application/json")
    @RequestMapping(value = "/selectCart", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ShoppingCartVo> shoppingCart(HttpServletRequest request){
        String uid=request.getParameter("userID");
        Long userID=Long.valueOf(uid);
        List<ShoppingCartVo> list =new ArrayList<>();

        list=shoppingCartService.selectCartinfo(userID);

        return  list;
    }


    @ApiOperation(value = "购物车价格总和", notes = "计算", produces = "application/json")
    @RequestMapping(value = "/selectSum", method = RequestMethod.GET, produces = "application/json")
    public  Double shoppingSum(HttpServletRequest request){
        String uid=request.getParameter("userID");
        Long userID=Long.valueOf(uid);
        Double sum = shoppingCartService.selectSum(userID);
        System.out.println(sum);
        return sum*100;
    }
    @ApiOperation(value = "加减数量删购物车", notes = "计算", produces = "application/json")
    @RequestMapping(value = "/addUpdDel")
    public  int addUpdDel(HttpServletRequest request){
        String info =request.getParameter("info");
        String scartID=request.getParameter("cartID");
        int cartID=Integer.parseInt(scartID);
        if ("-1".equals(info)){
            shoppingCartService.updNum(cartID);
        }else if ("0".equals(info)){
            shoppingCartService.delShopCart(cartID);
        }else if ("1".equals(info)){
            shoppingCartService.addNum(cartID);
        }
        return 1;

    }

    @ApiOperation(value = "加入购物车", notes = "添加", produces = "application/json")
    @RequestMapping(value = "/insertCart", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public  int insertCart(@RequestBody ShoppingCartVo shoppingCartVo){

        return  shoppingCartService.insertCart(shoppingCartVo);
    }

    @ApiOperation(value = "支付后删除", notes = "计算", produces = "application/json")
    @RequestMapping(value = "/paydelShopCart", method = RequestMethod.GET, produces = "application/json")
    public int payDelShopCart(HttpServletRequest request){
        String uid=request.getParameter("userID");
        Long userID=Long.valueOf(uid);
        return shoppingCartService.paydelShopCart(userID);
    }



}
