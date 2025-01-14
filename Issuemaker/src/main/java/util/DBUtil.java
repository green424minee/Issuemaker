package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import matching.ComLicenseMapper;
import matching.NoticeMapper;
import member.CompanyMapper;
import member.Guest0Mapper;
import member.Guest1Mapper;
import member.LoginMapper;
import member.UserMapper;
import myPage.NoticeListMapper;
import myPage.ResumeMapper;
import myPage.myPageMapper;
import search.IndexMapper;

public class DBUtil {
    private static DataSource dataSource;
    private static SqlSessionFactory sqlSessionFactory;

    static {
        initDataSource();
        initSqlSessionFactory();
    }

    private static void initSqlSessionFactory() {
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(UserMapper.class);
        configuration.addMapper(Guest0Mapper.class);
        configuration.addMapper(CompanyMapper.class);
        configuration.addMapper(Guest1Mapper.class);
        configuration.addMapper(LoginMapper.class);

        configuration.addMapper(myPageMapper.class);
        configuration.addMapper(ResumeMapper.class);
        configuration.addMapper(NoticeListMapper.class);

        configuration.addMapper(NoticeMapper.class);
        configuration.addMapper(ComLicenseMapper.class);
        
        configuration.addMapper(IndexMapper.class);
        
       

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

    private static void initDataSource() {
        BasicDataSource ds = new BasicDataSource();
        Properties properties = new Properties();

        try (InputStream input = DBUtil.class.getClassLoader().getResourceAsStream("config/db.properties")) {
            if (input == null) {
                System.out.println("db.properties 파일을 찾을 수 없습니다.");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl(properties.getProperty("db.url"));
        ds.setUsername(properties.getProperty("db.username"));
        ds.setPassword(properties.getProperty("db.password"));

        ds.setInitialSize(0);
        ds.setMaxTotal(8);
        ds.setMaxIdle(8);
        ds.setMinIdle(0);

        dataSource = ds;
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}

