package cn.edu.tjrac.booksale.impl;

import cn.edu.tjrac.booksale.dao.LoginAndRegisterDao;
import cn.edu.tjrac.booksale.pojo.UserAndPass;
import cn.edu.tjrac.booksale.service.LoginAndRegisterService;
import cn.edu.tjrac.booksale.util.R;
import cn.edu.tjrac.booksale.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginAndRegisterServiceImpl implements LoginAndRegisterService {

    @Autowired
    private LoginAndRegisterDao loginAndRegisterDao;

    @Override
    public UserVo login(UserAndPass userAndPass) {

        return loginAndRegisterDao.login(userAndPass);
    }

    @Override
    public int register(UserVo userVo) {
            return loginAndRegisterDao.register(userVo);
    }
}
