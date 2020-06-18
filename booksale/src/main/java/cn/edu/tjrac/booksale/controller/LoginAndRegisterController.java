package cn.edu.tjrac.booksale.controller;


import cn.edu.tjrac.booksale.pojo.UserAndPass;
import cn.edu.tjrac.booksale.service.LoginAndRegisterService;
import cn.edu.tjrac.booksale.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/loginAndres")
@Api("登录注册")
public class LoginAndRegisterController {

    @Autowired
    private LoginAndRegisterService loginAndRegisterService;


    @ApiOperation(value = "登录", notes = "查询", produces = "application/json")
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public UserVo login(@RequestBody UserAndPass userAndPass) {
        return loginAndRegisterService.login(userAndPass);
    }

    @ApiOperation(value = "注册", notes = "插入", produces = "application/json")
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public  int register(@RequestBody UserVo userVo){
        loginAndRegisterService.register(userVo);
        return 1;
    }

}
