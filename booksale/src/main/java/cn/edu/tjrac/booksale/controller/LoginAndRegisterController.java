package cn.edu.tjrac.booksale.controller;


import cn.edu.tjrac.booksale.pojo.UserAndPass;
import cn.edu.tjrac.booksale.service.LoginAndRegisterService;
import cn.edu.tjrac.booksale.util.CommonRespUtil;
import cn.edu.tjrac.booksale.util.SHALUtil;
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
        userAndPass.setPassWord(SHALUtil.getSha1(userAndPass.getPassWord()));
        return loginAndRegisterService.login(userAndPass);
    }


    @ApiOperation(value = "注册", notes = "插入", produces = "application/json")
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public  Object register(@RequestBody UserVo userVo){
        //sha1加密
        userVo.setPassWord(SHALUtil.getSha1(userVo.getPassWord()));
        int i =loginAndRegisterService.register(userVo);
        if (i==1){
            return CommonRespUtil.returnMsg(CommonRespUtil.SUCCESS,"注册成功");
        }else {
            return CommonRespUtil.returnMsg(CommonRespUtil.FAILED,"注册失败");
        }

    }

}
