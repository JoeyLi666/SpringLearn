package cn.lsc.spring_mybatis.demo.excel.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class Person {
    @ExcelProperty(index = 0)
    private String name;

    @ExcelProperty(index = 1)
    private Integer age;

    @ExcelProperty(index = 2)
    private String email;

    // 构造方法、getter 和 setter 省略
}
