package org.alan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
@MapperScan("org.alan.learn.testuser.mapper")
//@EnableScheduling
public class LearnMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnMybatisPlusApplication.class, args);
    }

//    @PostConstruct
//    public void initLearnData(){
//
//        System.out.println("################# PostConstruct #####################");
//    }
    
    /**
     * @Author AlanMa
     * @Description 乐观锁
     * @Date 2019/5/15
     * @Param []
     * @return com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor
     */
//    @Bean
//    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
//        return new OptimisticLockerInterceptor();
//    }
}
