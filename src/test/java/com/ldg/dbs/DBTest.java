package com.ldg.dbs;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ldg.dbs.dto.BoardVO;
import com.ldg.dbs.mapper.BoardMapper;


//junit 4.12 spring-test 같이 있어야 java test실행 가능!
@RunWith(SpringJUnit4ClassRunner.class)
//root-context.xml 환경설정을 사용한다.
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DBTest {
	
	//root-context.xml에서 만든 SqlSessionFactory값을 주입받는다.
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Inject
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		List<BoardVO> list = mapper.getList();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	
	
	//test라는 것을 알려줘야한다.
	@Test
	public void testFactory() {
		System.out.println("sqlFactory: " +sqlFactory);
	}
	
	@Test
	public void testSession() throws Exception{
		try(SqlSession session = sqlFactory.openSession()){
				System.out.println(">>>>>>> session : " +session+"\n");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
	
}
