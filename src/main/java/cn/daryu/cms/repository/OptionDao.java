package cn.daryu.cms.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.daryu.cms.entity.Option;

/**
 * 与Options实例有关的dao
 * 
 * @author Day
 *
 */
public interface OptionDao extends CrudRepository<Option, Long>{

	/**
	 * 根据名称与id号查询值
	 * 
	 * @param name 变量名
	 * @param id 博客id号
	 * @return
	 */
	public Option findByOptionNameAndBlogId(String name,Long id);
	
	/**
	 * 如果只根据变量名字查询值，那么默认查找blogid为0的值
	 * 
	 * @param name
	 * @return
	 */
	@Query("select op from Options op where op.optionName = ?1 and op.blogId = 0")
	public Option findByOptionName(String name);
	
}
