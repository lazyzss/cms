package cn.daryu.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


/**
 * CMS中归类的基本信息
 * 
 * @author Day
 * 
 */
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "cms_term_taxonomy")
public class TermTaxonomy {

	private Long id;
	private Term term;
	private Taxonomy taxonomy = Taxonomy.CATEGORY; //标签组什么的分类，默认是分类。
	private String description;
	private TermTaxonomy parent;
	private Long count;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "term_taxonomy_id", columnDefinition = "bigint(20) unsigned",nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
	@ManyToOne
	@JoinColumn(name = "term_id",columnDefinition = "bigint(20) unsigned DEFAULT '0'", nullable = false)
	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "taxonomy", columnDefinition = "varchar(32) DEFAULT ''", nullable = false)
	public Taxonomy getTaxonomy() {
		return taxonomy;
	}

	public void setTaxonomy(Taxonomy taxonomy) {
		this.taxonomy = taxonomy;
	}

	@Column(name = "description", columnDefinition = "longtext", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToOne
	@JoinColumn(name = "parent",columnDefinition = "bigint(20) unsigned DEFAULT '0'", nullable = false)
	public TermTaxonomy getParent() {
		return parent;
	}

	public void setParent(TermTaxonomy parent) {
		this.parent = parent;
	}

	@Column(name = "count", columnDefinition = "bigint(20) DEFAULT '0'", nullable = false)
	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	/*
	 * TermTaxonomy中的分类类型的枚举类。
	 *
	 */
	public enum Taxonomy {
		CATEGORY, //'category' 类别分类，让你一起把它们整理成各种类别组文章。这些类别，然后可以在网站上看到，使用'/分类/名称'类型的URL。分类往往是预先定义的，范围广泛。
		POST_TAG, //'post_tag 标签类别相似，但更多的自由形式。可以由标签上的苍蝇，只需键入他们进来，他们在网站上'/标签/名称类型的URL，可以看出。帖子往往有众多的标签，他们一般都靠近职位或标签云的形式显示。
		LINK_CATEGORY //'link_category'让你的链接进行分类。这些往往只在内部使用的，组织的原因，而不是通常暴露在网站上本身。用于定义要显示在侧边栏和类似的链接组，它们是很方便的。
	}

}
