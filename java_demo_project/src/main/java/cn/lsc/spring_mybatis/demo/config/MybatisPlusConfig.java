package cn.lsc.spring_mybatis.demo.config;

import cn.lsc.spring_mybatis.demo.sqlInjector.MySqlInjector;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {
    @Bean
    public MySqlInjector sqlInjector() {
        return new MySqlInjector();
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor pageInterceptor = new PaginationInnerInterceptor(DbType.POSTGRE_SQL);
        pageInterceptor.setOverflow(false);
        pageInterceptor.setMaxLimit(1L);
        mybatisPlusInterceptor.addInnerInterceptor(pageInterceptor);
        return mybatisPlusInterceptor;
    }

}
