package com.jiacool.service;

import com.jiacool.dao.UserMapper;
import com.jiacool.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ServiceDemo {
    public static void main(String[] args) throws IOException {
/*//        创建dao层对象  手动编写创建
        UserMapper mapper = new UserMapperImpl();
        List<User> list = mapper.findAll();
        System.out.println(list);*/

//        动态代理开发方式
        /**
         * 1) Mapper.xml文件中的namespace与mapper接口的全限定名相同
         * 2) Mapper接口方法名和Mapper.xml中定义的每个statement的id相同
         * 3) Mapper接口方法的输入参数类型和mapper.xml中定义的每个sql的parameterType的类型相同
         * 4) Mapper接口方法的输出参数类型和mapper.xml中定义的每个sql的resultType的类型相同
         */
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.findAll();
        System.out.println(list);

        User user = mapper.findById(1);
        System.out.println(user);


    }
}
