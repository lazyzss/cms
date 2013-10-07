package cn.daryu.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


/**
 * CMS中归类的属性信息
 * 
 * @author Day
 * 
 */
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "cms_terms")
public class Term {

	private Long id;
	private String name;
	private String slug;
	private Long termGroup;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "term_id", columnDefinition = "bigint(20) unsigned",nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
	@Column(name = "name", columnDefinition = "varchar(200) DEFAULT ''", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "slug", columnDefinition = "varchar(200) DEFAULT ''", nullable = false)
	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	@Column(name = "term_group", columnDefinition = "bigint(10) DEFAULT '0'", nullable = false)
	public Long getTermGroup() {
		return termGroup;
	}

	public void setTermGroup(Long termGroup) {
		this.termGroup = termGroup;
	}

}
