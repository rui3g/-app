package cn.edu.tjrac.booksale.controller;


import cn.edu.tjrac.booksale.service.BookMessageService;
import cn.edu.tjrac.booksale.util.R;
import cn.edu.tjrac.booksale.vo.BookMessageVo;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/BookMessage")
@Api("书籍信息")
public class BookMessageController {

    @Autowired
    private BookMessageService bookMessageService;

    @ApiOperation(value = "查询随机6条数据", notes = "查询", produces = "application/json")
    @RequestMapping(value = "/select", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<BookMessageVo> selectbook(){
        List<BookMessageVo> books= bookMessageService.Sixinfo();
         return books;
    }

    //分类查
    @ApiOperation(value = "查询分类", notes = "查询", produces = "application/json")
    @RequestMapping("/selectSort")
    public List<BookMessageVo> selectSortInfo(HttpServletRequest request){
        String Status=request.getParameter("saleStatus");
        String bookSort=request.getParameter("bookSort");
        int saleStatus=Integer.parseInt(Status);
        System.out.println(saleStatus+"     "+bookSort);
        List<BookMessageVo> list =new ArrayList<BookMessageVo>();
        if (saleStatus==1) {
            if(bookSort.equals("分类")) {
                list=bookMessageService.selectAllInfo();
            }else{
                list=bookMessageService.selectSortinfo(bookSort);
            }
        }else if (saleStatus==0) {
            if(bookSort.equals("分类")) {
                list=bookMessageService.selectSaleinfo(saleStatus);
            }else{
                list=bookMessageService.selectInfo(saleStatus,bookSort);
            }
        }else{
            if(bookSort.equals("分类")) {
                list=bookMessageService.selectSaleinfo(saleStatus);
            }else{
                list=bookMessageService.selectInfo(saleStatus,bookSort);
            }
        }

        return list;

    }
    //按书名查
    @RequestMapping("/selectOne")
    public  BookMessageVo selectOne(HttpServletRequest request){

        String bookName=request.getParameter("bookName");
        return bookMessageService.selectone(bookName);
    }

}
