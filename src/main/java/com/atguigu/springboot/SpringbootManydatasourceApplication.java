package com.atguigu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *  在完成了引入AOP依赖包后，一般来说并不需要去做其他配置。也许在Spring中使用过注解配置方式的人
 *  会问是否需要在程序主类中增加@EnableAspectJAutoProxy来启用，实际并不需要。
 *
 *  可以看下面关于AOP的默认配置属性，其中spring.aop.auto属性默认是开启的，也就是说只要引入了AOP依赖后，
 *  默认已经增加了@EnableAspectJAutoProxy。
 */
@SpringBootApplication
//@EnableCaching//启用缓存注解
@EnableScheduling//
@EnableAsync
public class SpringbootManydatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootManydatasourceApplication.class, args);
    }

}

