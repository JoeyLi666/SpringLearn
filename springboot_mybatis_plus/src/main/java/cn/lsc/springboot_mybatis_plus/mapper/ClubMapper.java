package cn.lsc.springboot_mybatis_plus.mapper;

import cn.lsc.springboot_mybatis_plus.dao.ClubPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClubMapper extends BaseMapper<ClubPo> {

    @Select("select * from t_club")
    List<ClubPo> getAllUser();

    @Insert("insert into t_club(id,name,money,nick_name,birthday,create_time,update_time)\n" +
            "    values\n" +
            "    (#{id},\n" +
            "    #{name},\n" +
            "    #{money},\n" +
            "    #{nickName},\n" +
            "    #{birthday},\n" +
            "    #{createTime},\n" +
            "    #{updateTime}\n" +
            "    )\n" +
            "    on conflict(id) do nothing")
    int upsert(ClubPo clubPo);

}
