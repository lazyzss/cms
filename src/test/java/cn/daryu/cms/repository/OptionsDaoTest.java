package cn.daryu.cms.repository;

import static org.junit.Assert.*;

import org.hibernate.type.YesNoType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.NotTransactional;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cn.daryu.cms.entity.Option;
import cn.daryu.cms.entity.Option.OptionsAutoload;

/**
 * OptionsDao的测试用例
 * 
 * @author Day
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "development")
@ContextConfiguration(locations = { "/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
//@Transactional
public class OptionsDaoTest {

	@Autowired
	private OptionDao optionsDao;

	@Before
	public void setUp() {
		//清空数据库
		optionsDao.deleteAll();
		//插入基本测试数据
		
		Option opTest2 = new Option();
		opTest2.setBlogId(1L);
		opTest2.setOptionName("测试");
		opTest2.setAutoload(OptionsAutoload.YES);
		opTest2.setOptionValue("测试数据2");
		optionsDao.save(opTest2);
		
		Option opTest1 = new Option();
		opTest1.setBlogId(0L);
		opTest1.setOptionName("测试");
		opTest1.setAutoload(OptionsAutoload.YES);
		opTest1.setOptionValue("测试数据1");
		optionsDao.save(opTest1);
		
		Option opTest3 = new Option();
		opTest3.setBlogId(0L);
		opTest3.setOptionName("测试3");
		opTest3.setAutoload(OptionsAutoload.NO);
		opTest3.setOptionValue("测试数据3");
		optionsDao.save(opTest3);
		System.out.println("执行了");
	}
	
	
	/*
	 * 测试基本的保存
	 */
	@Test
	@Rollback(true)
	@Transactional
	public void testSave() {

		Option op1 = new Option();
		op1.setBlogId(0L);
		op1.setAutoload(OptionsAutoload.YES);
		op1.setOptionName("test");
		op1.setOptionValue("111111");
		optionsDao.save(op1);
	}
	
	/*
	 * 测试建表的时候设置的默认值是否都生效
	 */
	@Test(expected = DataAccessException.class)
	@Rollback(true)
	@Transactional
	public void testUnique1() {
		//看看能否检测到冲突		
		Option op1 = new Option();
		op1.setBlogId(0L);
		op1.setAutoload(OptionsAutoload.YES);
		op1.setOptionName("test");
		op1.setOptionValue("111111");
		optionsDao.save(op1);
		
		Option op2 = new Option();
		op2.setBlogId(0L);
		op2.setAutoload(OptionsAutoload.NO);
		op2.setOptionName("test");
		op2.setOptionValue("111111222");
		optionsDao.save(op2);
	}
	
	/*
	 * 测试不冲突的情况
	 */
	@Test
	@Rollback(true)
	@Transactional
	public void testUnique2() {
		//看看能否检测到冲突		
		Option op1 = new Option();
		op1.setBlogId(0L);
		op1.setAutoload(OptionsAutoload.YES);
		op1.setOptionName("test");
		op1.setOptionValue("111111");
		optionsDao.save(op1);
		//BlogId不一样
		Option op2 = new Option();
		op2.setBlogId(1L);
		op2.setAutoload(OptionsAutoload.NO);
		op2.setOptionName("test");
		op2.setOptionValue("111111222");
		optionsDao.save(op2);
		//name不一样
		Option op3 = new Option();
		op3.setBlogId(1L);
		op3.setAutoload(OptionsAutoload.NO);
		op3.setOptionName("test2");
		op3.setOptionValue("111111222");
		optionsDao.save(op3);
	}
	
	
	/*
	 * 测试按名字查询
	 */
	@Test
	public void testFindByOptionName() {
		//看看能否检测到冲突		
		Option op1 = optionsDao.findByOptionName("测试");
		assertTrue("按名字查询不到应该有的结构", op1.getOptionValue().equals("测试数据1"));
	}
}
