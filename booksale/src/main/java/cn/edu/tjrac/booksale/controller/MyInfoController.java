package cn.edu.tjrac.booksale.controller;


import cn.edu.tjrac.booksale.service.MyInfOService;
import cn.edu.tjrac.booksale.vo.MyAddressVo;
import cn.edu.tjrac.booksale.vo.OrderSelectInfoVo;
import cn.edu.tjrac.booksale.vo.OrderVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/my")
@Api("我的")
public class MyInfoController {

    @Autowired
    private MyInfOService myInfOService;


    @ApiOperation(value = "订单查询", notes = "计算", produces = "application/json")
    @RequestMapping(value = "/orderSelect")
    public List<OrderSelectInfoVo> orderSelect(HttpServletRequest request){
        String suserID=request.getParameter("userID");
        Long userID=Long.valueOf(suserID);
        List<OrderSelectInfoVo> list= myInfOService.selectOrder(userID);

        return list;
    }


    @ApiOperation(value = "查询地址", notes = "查询", produces = "application/json")
    @RequestMapping("/selectAddress")
    public List<MyAddressVo> selectAddress(HttpServletRequest request){
        String uid=request.getParameter("userID");
        Long userID=Long.valueOf(uid);
        return myInfOService.selectMyInfo(userID);
    }

    @ApiOperation(value = "下单", notes = "插入", produces = "application/json")
    @RequestMapping(value = "/insertOrder", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public int insertOrder(@RequestBody OrderVo orderVo){

        return myInfOService.insertOrder(orderVo);
    }

    @ApiOperation(value = "付款", notes = "修改", produces = "application/json")
    @RequestMapping("/updateStatus")
    public int updateStatus(HttpServletRequest request){
        String uid=request.getParameter("id");
        int id=Integer.parseInt(uid);
        return myInfOService.updateStatus(id);
    }

    @ApiOperation(value = "地址", notes = "插入", produces = "application/json")
    @RequestMapping(value = "/insertAddress", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public int insertAddress(@RequestBody MyAddressVo myAddressVo){
        return  myInfOService.insertAddress(myAddressVo);
    }
}
