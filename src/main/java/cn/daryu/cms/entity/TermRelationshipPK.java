package cn.daryu.cms.entity;

import java.io.Serializable;


/**
 * CMS中cms_term_relationships表的主键类型
 * 
 * @author Day
 * 
 */
public class TermRelationshipPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long objectId;
	private Long termTaxonomyId;
	
	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public Long getTermTaxonomyId() {
		return termTaxonomyId;
	}

	public void setTermTaxonomyId(Long termTaxonomyId) {
		this.termTaxonomyId = termTaxonomyId;
	}

}
