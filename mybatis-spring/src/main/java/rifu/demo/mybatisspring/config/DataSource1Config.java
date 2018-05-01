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
public class DataSource1Config {

    @Bean("postgresDataSource")
    @ConfigurationProperties(prefix = "postgres.jdbc")
    public DataSource getPostgresDataSource() {
        return new DataSource();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        DataSource ds = getPostgresDataSource();
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(ds);
        return bean.getObject();
    }
}
