package cn.edu.tjrac.booksale.util;

import cn.edu.tjrac.booksale.vo.BookMessageVo;
import cn.edu.tjrac.booksale.vo.UserVo;

import java.util.List;

public class R {
    private  Integer code; //1成功，2失败，
    private String desc;//信息
    private  List<BookMessageVo> result;

    public List<BookMessageVo> getResult() {
        return result;
    }

    public void setResult(List<BookMessageVo> result) {
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
