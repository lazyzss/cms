package cn.daryu.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


/**
 * CMS中归类与文章或链接的关系表
 * 
 * @author Day
 * 
 */
@Entity
@DynamicUpdate
@DynamicInsert
@IdClass(TermRelationshipPK.class)
@Table(name = "cms_term_relationships")
public class TermRelationship {

	private Long objectId;
	private Long termTaxonomyId;
	private Long termOrder;
	
	@Id
	@Column(name = "object_id", columnDefinition = "bigint(20) unsigned DEFAULT '0'",nullable = false)
	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	@Id
	@Column(name = "term_taxonomy_id", columnDefinition = "bigint(20) unsigned DEFAULT '0'",nullable = false)
	public Long getTermTaxonomyId() {
		return termTaxonomyId;
	}

	public void setTermTaxonomyId(Long termTaxonomyId) {
		this.termTaxonomyId = termTaxonomyId;
	}

	@Column(name = "term_order", columnDefinition = "int(11) unsigned DEFAULT '0'",nullable = false)
	public Long getTermOrder() {
		return termOrder;
	}

	public void setTermOrder(Long termOrder) {
		this.termOrder = termOrder;
	}
}
