package xin.jerome.study.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import xin.jerome.study.mybatis.model.Bank;

/**
 * 简单的crud演示
 *
 * @author JeromeSoar
 * @since 2020年01月10日 11:38
 */
public class SimpleOperationTest {

	private static SqlSessionFactory sqlSessionFactory;

	@Before
	public void beforeTest() throws IOException {
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testInsertBank() {
		Bank bank = new Bank();
		bank.setName("北京银行(万泉路支行)");
		bank.setLocation("北京市海淀区新建宫门路1号");

		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("insertBank", bank);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testSelectBank() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Bank selectBank = sqlSession.selectOne("selectBank", 1);
		System.out.println(selectBank);
		sqlSession.commit();
		sqlSession.close();
	}

}
