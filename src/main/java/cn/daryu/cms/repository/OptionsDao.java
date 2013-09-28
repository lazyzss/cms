package cn.daryu.cms.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import cn.daryu.cms.entity.Options;

public interface OptionsDao extends Repository<OptionsDao, Long>{

	public Options save(Options options); 

	
	/**
	 * 根据名称与id号查询值
	 * 
	 * @param name 变量名
	 * @param id 博客id号
	 * @return
	 */
	public Options findByOptionNameAndBlogId(String name,Long id);
	
	/**
	 * 如果只根据变量名字查询值，那么默认查找blogid为0的值
	 * 
	 * @param name
	 * @return
	 */
	@Query("select op from Options op where op.optionName = ?1 and op.blogId = 0")
	public Options findByOptionName(String name);
	
}
