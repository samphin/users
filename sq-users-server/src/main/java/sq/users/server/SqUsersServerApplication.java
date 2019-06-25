package sq.users.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//@EnableDiscoveryClient
public class SqUsersServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqUsersServerApplication.class, args);
	}

	@Configuration
	@MapperScan({"cn.sq.users.core.mapper"})
	static class MapperConfig {
	}

	@Configuration
	@ComponentScan({"cn.sq.users.core.service"})
	@EnableTransactionManagement
	static class ServiceConfig {
	}

}
