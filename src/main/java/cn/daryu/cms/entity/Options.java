package cn.daryu.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * CMS全局配置变量表
 * 
 * @author Day
 * 
 */
@Entity
@Table(name = "cms_options", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"blog_id", "option_name" },name="option_blog_id_name") })
public class Options {

	private Long id;
	private Long blogId;
	private String optionName;
	private String optionValue;
	
	/*
	 * 默认值设置成 OptionsAutoload.YES
	 */
	private OptionsAutoload autoload = OptionsAutoload.YES;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "option_id", nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "blog_id", nullable = false)
	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	@Column(name = "option_name", columnDefinition = "varchar(64) DEFAULT ''", nullable = false)
	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	@Column(name = "option_value", columnDefinition = "longtext", nullable = false)
	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "autoload",columnDefinition = "varchar(20)")
	public OptionsAutoload getAutoload() {
		return autoload;
	}

	public void setAutoload(OptionsAutoload autoload) {
		this.autoload = autoload;
	}
}
