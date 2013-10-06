package cn.daryu.cms.entity;

import java.util.Date;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


/**
 * CMS中文章的扩展属性
 * 
 * @author Day
 * 
 */
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "cms_posts")
public class Post {

	private Long id;
	private User user;
	private Date postDate;
	private String postContent;
	private String postTitle;
	private String postExcerpt; //文章的摘要
	private PostStatus postStatus = PostStatus.PUBLISH; //文章的状态,默认状态是公开的
	private CommentStatus commentStatus = CommentStatus.OPEN; //文章的评论状态，默认是开放评论的
	private String postPassword; //文章修改时候需要的密码
	private Date postModified; //文章修改的时间
	private Post postParent; //上级文章
	private String guid; //这是每篇文章的一个地址。默认是这样的形式: http://your.blog.site/?p=1
	private Long menuOrder; //文章排序的先后顺序值
	private PostType postType = PostType.POST; //文章的类型，默认为文章。
	private String postMimeType; //文章附件的类型。
	private Long commentCount; //文章的评论数量	
	//附加数据集
	private Map<String, Postmeta> postmetas;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", columnDefinition = "bigint(20) unsigned",nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "post_author",columnDefinition = "bigint(20) unsigned DEFAULT '0'", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "post_date", columnDefinition = "datetime DEFAULT '0000-00-00 00:00:00'", nullable = false)
	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	@Column(name = "post_content", columnDefinition = "longtext", nullable = false)
	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	@Column(name = "post_title", columnDefinition = "text", nullable = false)
	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	@Column(name = "post_excerpt", columnDefinition = "text", nullable = false)
	public String getPostExcerpt() {
		return postExcerpt;
	}

	public void setPostExcerpt(String postExcerpt) {
		this.postExcerpt = postExcerpt;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "post_status", columnDefinition = "varchar(20)", nullable = false)
	public PostStatus getPostStatus() {
		return postStatus;
	}

	public void setPostStatus(PostStatus postStatus) {
		this.postStatus = postStatus;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "comment_status", columnDefinition = "varchar(20)", nullable = false)
	public CommentStatus getCommentStatus() {
		return commentStatus;
	}

	public void setCommentStatus(CommentStatus commentStatus) {
		this.commentStatus = commentStatus;
	}

	@Column(name = "post_password", columnDefinition = "varchar(20) DEFAULT ''", nullable = false)
	public String getPostPassword() {
		return postPassword;
	}

	public void setPostPassword(String postPassword) {
		this.postPassword = postPassword;
	}

	@Column(name = "post_modified", columnDefinition = "datetime DEFAULT '0000-00-00 00:00:00'", nullable = false)
	public Date getPostModified() {
		return postModified;
	}

	public void setPostModified(Date postModified) {
		this.postModified = postModified;
	}

	@OneToOne
	@JoinColumn(name = "post_parent",columnDefinition = "bigint(20) unsigned DEFAULT '0'", nullable = false)
	public Post getPostParent() {
		return postParent;
	}

	public void setPostParent(Post postParent) {
		this.postParent = postParent;
	}

	@Column(name = "guid", columnDefinition = "varchar(255) DEFAULT ''", nullable = false)
	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	@Column(name = "menu_order", columnDefinition = "int(11) DEFAULT '0'", nullable = false)
	public Long getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(Long menuOrder) {
		this.menuOrder = menuOrder;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "post_type", columnDefinition = "varchar(20)", nullable = false)
	public PostType getPostType() {
		return postType;
	}

	public void setPostType(PostType postType) {
		this.postType = postType;
	}

	@Column(name = "post_mime_type", columnDefinition = "varchar(100) DEFAULT ''", nullable = false)
	public String getPostMimeType() {
		return postMimeType;
	}

	public void setPostMimeType(String postMimeType) {
		this.postMimeType = postMimeType;
	}

	@Column(name = "comment_count", columnDefinition = "bigint(20) DEFAULT '0'", nullable = false)
	public Long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}

	@OneToMany(targetEntity = Postmeta.class, cascade = CascadeType.ALL,mappedBy = "post")
	@MapKey(name = "metaKey")
	public Map<String, Postmeta> getPostmetas() {
		return postmetas;
	}

	public void setPostmetas(Map<String, Postmeta> postmetas) {
		this.postmetas = postmetas;
	}

	/*
	 * Post中的文章类型的枚举类。
	 *
	 */
	public enum PostType {
		POST, //post表示为已发布的文章
		REVISION, //revision表示为修订版本
		PAGE //page为页面
	}
	
	/*
	 * Post中的文章状态的枚举类。
	 *
	 */
	public enum PostStatus {
		PUBLISH, //publish为已发表
		DRAFT, //draft为草稿
		PRIVATE //private为私有内容(不会被公开)
	}
	
	/*
	 * Post中的是否允许评论的枚举类。
	 *
	 */
	public enum CommentStatus {
		OPEN, //open为允许评论
		CLOSE, //closed为不允许评论
		REGISTERED_ONLY //registered_only为只有注册用户方可评论
	}
}
