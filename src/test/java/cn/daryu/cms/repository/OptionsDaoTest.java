package cn.daryu.cms.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cn.daryu.cms.entity.Options;

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
@Transactional
public class OptionsDaoTest {

	@Autowired
	private OptionsDao optionsDao;

	//TODO 测试用例暂时没有写完
	@Test
	public void testSave() {

		Options op1 = new Options();
		op1.setBlogId(0L);
//		op1.setAutoload(OptionsAutoload.YES);
		op1.setOptionName("test");
		op1.setOptionValue("111111");
		optionsDao.save(op1);
	}
}
