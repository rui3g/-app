package cn.edu.tjrac.booksale.dao;

import cn.edu.tjrac.booksale.pojo.UserAndPass;
import cn.edu.tjrac.booksale.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface LoginAndRegisterDao {

    UserVo login(UserAndPass userAndPass);

    int register(UserVo userVo);
}
