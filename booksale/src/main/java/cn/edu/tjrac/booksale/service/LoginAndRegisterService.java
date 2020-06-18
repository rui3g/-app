package cn.edu.tjrac.booksale.service;

import cn.edu.tjrac.booksale.pojo.UserAndPass;
import cn.edu.tjrac.booksale.vo.UserVo;

public interface LoginAndRegisterService {

    UserVo login(UserAndPass userAndPass);

    int register(UserVo userVo);
}
