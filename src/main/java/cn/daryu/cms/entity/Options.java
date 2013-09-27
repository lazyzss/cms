package cn.daryu.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CMS全局配置变量表
 * 
 * @author Day
 *
 */
@Entity
@Table(name = "cms_options")
public class Options {
	
	private Long id;
	private Long blogId;
	private String optionName;
	private String optionValue;
	private String autoload;
	
	@Id
	@Column(name = "option_id", columnDefinition="id号") 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "blog_id",columnDefinition="博客ID，用于多用户博客，默认0") 
	public Long getBlogId() {
		return blogId;
	}
	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}
	
	@Column(name = "option_name",columnDefinition="键名") 
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	
	@Column(name = "option_value",columnDefinition="键值") 
	public String getOptionValue() {
		return optionValue;
	}
	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}
	
	@Column(name = "autoload",columnDefinition="在CMS载入时自动载入yes/no") 
	public String getAutoload() {
		return autoload;
	}
	public void setAutoload(String autoload) {
		this.autoload = autoload;
	}
}
