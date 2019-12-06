package com.qce.xiaoshan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan(basePackages= {"com.qce.xiaoshan.Mapper"})
public class XiaoshanApplication {

	public static void main(String[] args) {
		SpringApplication.run(XiaoshanApplication.class, args);
	}

}
