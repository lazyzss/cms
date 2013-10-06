package cn.daryu.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Index;


/**
 * CMS中评论的扩展属性
 * 
 * @author Day
 * 
 */
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "cms_commentmeta")
public class Commentmeta {

	private Long id;
	private Comment comment;
	private String metaKey;
	private String metaValue;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "meta_id", columnDefinition = "bigint(20) unsigned",nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	

	@Index(name = "comment_id")
	@ManyToOne
	@JoinColumn(name = "comment_id",columnDefinition = "bigint(20) unsigned DEFAULT '0'", nullable = false)
	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	@Index(name = "meta_key")
	@Column(name = "meta_key", columnDefinition = "varchar(255)", nullable = false)
	public String getMetaKey() {
		return metaKey;
	}

	public void setMetaKey(String metaKey) {
		this.metaKey = metaKey;
	}
	
	@Column(name = "meta_value", columnDefinition = "longtext", nullable = false)
	public String getMetaValue() {
		return metaValue;
	}

	public void setMetaValue(String metaValue) {
		this.metaValue = metaValue;
	}

}
