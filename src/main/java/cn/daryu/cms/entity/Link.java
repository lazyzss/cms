package cn.daryu.cms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


/**
 * CMS中链接的实例表
 * 
 * @author Day
 * 
 */
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "cms_links")
public class Link {

	private Long id;
	private String linkUrl;
	private String linkName;
	private String linkImage;
	private LinkTarget linkTarget = LinkTarget.NONE; //链接打开的方式，是否新建窗口什么的
	private String linkDescription;
	private LinkVisible linkVisible = LinkVisible.YES; //链接是否可见，默认可见
	private User user; //链接的所有者
	private Long linkRating; //评分等级，一般用来分类什么的
	private Date linkUpdated;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "link_id", columnDefinition = "bigint(20) unsigned",nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "link_url", columnDefinition = "varchar(255) DEFAULT ''", nullable = false)
	public String getLinkUrl() {
		return linkUrl;
	}
	
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	@Column(name = "link_name", columnDefinition = "varchar(255) DEFAULT ''", nullable = false)
	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	@Column(name = "link_image", columnDefinition = "varchar(255) DEFAULT ''", nullable = false)
	public String getLinkImage() {
		return linkImage;
	}

	public void setLinkImage(String linkImage) {
		this.linkImage = linkImage;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "link_target", columnDefinition = "varchar(25) DEFAULT ''", nullable = false)
	public LinkTarget getLinkTarget() {
		return linkTarget;
	}

	public void setLinkTarget(LinkTarget linkTarget) {
		this.linkTarget = linkTarget;
	}

	@Column(name = "link_description", columnDefinition = "varchar(255) DEFAULT ''", nullable = false)
	public String getLinkDescription() {
		return linkDescription;
	}

	public void setLinkDescription(String linkDescription) {
		this.linkDescription = linkDescription;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "link_visible", columnDefinition = "varchar(20) DEFAULT ''", nullable = false)
	public LinkVisible getLinkVisible() {
		return linkVisible;
	}

	public void setLinkVisible(LinkVisible linkVisible) {
		this.linkVisible = linkVisible;
	}

	@ManyToOne
	@JoinColumn(name = "link_owner",columnDefinition = "bigint(20) unsigned DEFAULT '1'", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "link_rating", columnDefinition = "int(11) NOT NULL DEFAULT '0'", nullable = false)
	public Long getLinkRating() {
		return linkRating;
	}

	public void setLinkRating(Long linkRating) {
		this.linkRating = linkRating;
	}

	@Column(name = "link_updated", columnDefinition = "datetime DEFAULT '0000-00-00 00:00:00'", nullable = false)
	public Date getLinkUpdated() {
		return linkUpdated;
	}

	public void setLinkUpdated(Date linkUpdated) {
		this.linkUpdated = linkUpdated;
	}

	/*
	 * Link中链接打开的类型
	 *
	 */
	public enum LinkTarget {
		_BLANK, //_blank为以新窗口打开
		_TOP, //_top为就在本窗口中打开并在最上一级
		NONE //none为不选择，会在本窗口中打开。
	}

	/*
	 * Link中是否可见的枚举类。
	 *
	 */
	public enum LinkVisible {
		YES, //可见
		NO //不可见
	}

	

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}	
//
//	@Index(name = "comment_id")
//	@ManyToOne
//	@JoinColumn(name = "comment_id",columnDefinition = "bigint(20) unsigned DEFAULT '0'", nullable = false)
//	public Comment getComment() {
//		return comment;
//	}
//
//	public void setComment(Comment comment) {
//		this.comment = comment;
//	}
//
//	@Index(name = "meta_key")
//	@Column(name = "meta_key", columnDefinition = "varchar(255)", nullable = false)
//	public String getMetaKey() {
//		return metaKey;
//	}
//
//	public void setMetaKey(String metaKey) {
//		this.metaKey = metaKey;
//	}
//	
//	@Column(name = "meta_value", columnDefinition = "longtext", nullable = false)
//	public String getMetaValue() {
//		return metaValue;
//	}
//
//	public void setMetaValue(String metaValue) {
//		this.metaValue = metaValue;
//	}

}
