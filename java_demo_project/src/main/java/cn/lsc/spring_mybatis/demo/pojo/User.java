package cn.lsc.spring_mybatis.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import static com.baomidou.mybatisplus.annotation.IdType.ASSIGN_ID;

@Data
@TableName("`sys_user`")
public class User {
    @TableId(value = "u_id",type = ASSIGN_ID)
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
