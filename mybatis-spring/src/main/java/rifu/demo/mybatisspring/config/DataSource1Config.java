package rifu.demo.mybatisspring.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
public class DataSource1Config {

    @Primary
    @Bean(name = "dataSource1")
    @ConfigurationProperties(prefix = "postgres.jdbc")
    public DataSource getPostgresDataSource() {
        return new DataSource();
    }

    @Bean(name = "dataSource1SqlSessionFactory")
    public SqlSessionTemplate sqlSessionFactoryBean(@Qualifier("dataSource1") DataSource ds) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(ds);
        return new SqlSessionTemplate(bean.getObject());
    }

    @Bean(name = "dataSource1MapperScannerConfigurer")
    public MapperScannerConfigurer msc() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("rifu.demo.mybatisspring.mapper.ds1");
        msc.setSqlSessionTemplateBeanName("dataSource1SqlSessionFactory");
        return msc;
    }
}
