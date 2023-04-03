package cn.lsc.springboot_mybatis_plus.handler;

import cn.lsc.springboot_mybatis_plus.utlis.DateUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;


@Slf4j//对日志依赖的引用
@Component//一定不要忘记把处理器增加到IOC容器中！
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill......");
        this.setFieldValByName("createTime", DateUtil.formatByDateTimeFormatter(new Date()),metaObject);
        //MetaObject[反射对象类]是Mybatis的工具类，通过MetaObject获取和设置对象的属性值。
        this.setFieldValByName("updateTime",DateUtil.formatByDateTimeFormatter(new Date()),metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill.....");
        this.setFieldValByName("updateTime",DateUtil.formatByDateTimeFormatter(new Date()),metaObject);
    }
}
