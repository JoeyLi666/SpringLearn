package cn.lsc.spring_mybatis.demo.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class TestDao {

    @NotBlank(message = "name cannot be blank")
    @Size(max = 50, message = "name cannot be longer than 50 characters")
    private String name;

    @NotBlank(message = "text cannot be blank")
    @Size(max = 50, message = "name cannot be longer than 50 characters")
    private String text;

}
