package com.atguigu.springboot.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration//表示这是一个配置类
@MapperScan(basePackages = "com.atguigu.springboot.mapper.datasource1", sqlSessionFactoryRef="sqlSessionFactory01")
public class DataSource1Config {

    /**
     * 配置DataSource
     * @return
     */
    @Bean(name = "dataSource01")
    @Primary
    public DataSource dataSource (@Qualifier("dbConfig1") DBConfig1 dbConfig1) throws SQLException {
        //return DataSourceBuilder.create().build();//使用单数据源只需要写这么一句话就可以
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(dbConfig1.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(dbConfig1.getPassword());
        mysqlXaDataSource.setUser(dbConfig1.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("dataSource01");

        xaDataSource.setMinPoolSize(dbConfig1.getMinPoolSize());
        xaDataSource.setMaxPoolSize(dbConfig1.getMaxPoolSize());
        xaDataSource.setMaxLifetime(dbConfig1.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(dbConfig1.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(dbConfig1.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(dbConfig1.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(dbConfig1.getMaxIdleTime());
        xaDataSource.setTestQuery(dbConfig1.getTestQuery());
        return xaDataSource;
    }

    /**
     * 配置sessionFactory
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "sqlSessionFactory01")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource01") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/datasource1/*.xml"));
        return factoryBean.getObject();
    }

    /**
     * 单数据源配置manage，使用jta-atomikos之后是不能配置manage的，必须使用jta-atomikos中的manage
     * @param dataSource
     * @return
     */
//    @Bean(name = "transactionManager01")
//    @Primary
//    public DataSourceTransactionManager transactionManager(@Qualifier("dataSource01") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

}
