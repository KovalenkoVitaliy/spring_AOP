package aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("aop")
@PropertySource("classpath:book.properties")
@EnableAspectJAutoProxy
public class MyConfig {
}
