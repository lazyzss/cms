package cn.daryu.cms.repository;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * OptionsDao的测试用例
 * 
 * @author Day
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class OptionsDaoTest extends AbstractJUnit4SpringContextTests  {

	@Resource
	private OptionsDao optionsDao;

	 @Test
     public void testSave() {
         
		 fail("保存为未实现");
     }
}
