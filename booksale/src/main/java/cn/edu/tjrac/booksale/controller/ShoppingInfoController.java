package cn.edu.tjrac.booksale.controller;


import cn.edu.tjrac.booksale.service.ShopInfoService;
import cn.edu.tjrac.booksale.vo.ShopInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/shoppingInfo")
@Api("商品详情")
public class ShoppingInfoController {

    @Autowired
    private ShopInfoService shopInfoService;

    @ApiOperation(value = "查询评价", notes = "查询", produces = "application/json")
    @RequestMapping(value = "/selectEvaluate")
    public List<ShopInfoVo> selectEvaluate(HttpServletRequest request){
        String bID = request.getParameter("bookID");
        int bookID = 0;
        try {
            bookID = Integer.parseInt(bID);
        } catch (NumberFormatException e) {

        } finally {

            return shopInfoService.selectEvaluate(bookID);
        }

    }
}
