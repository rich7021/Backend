package rifu.demo.mybatisspring.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Qualifier("postgresDataSource")
@MapperScan(basePackages = "rifu.demo.mybatisspring.mapper")
public class MybatisConfig {

    @Value("postgres.jdbc.url")
    private String postgresUrl;
    @Value("postgres.jdbc.Driver")
    private String postgresDriverClassName;
    @Value("postgres.jdbc.username")
    private String postgresUsername;
    @Value("postgres.jdbc.password")
    private String postgresPassword;

    @Bean("postgresDataSource")
    @ConfigurationProperties(prefix = "postgres.jdbc")
    public DataSource getPostgresDataSource() {
//        DataSource dataSource = new DataSource();
////        System.out.println("url: " + dataSource.getUrl());
//        dataSource.setUrl(postgresUrl);
//        dataSource.setDriverClassName(postgresDriverClassName);
//        dataSource.setUsername(postgresUsername);
//        dataSource.setPassword(postgresPassword);
        return new DataSource();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        DataSource ds = getPostgresDataSource();
        System.out.println("url: " + ds.getUrl());
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(ds);
        return bean.getObject();
    }
}
