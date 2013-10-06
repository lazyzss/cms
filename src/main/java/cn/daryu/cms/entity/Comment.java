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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Index;


/**
 * CMS中文章的扩展属性
 * 
 * @author Day
 * 
 */
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "cms_comments")
public class Comment {

	private Long id;
	private Post post;
	private User user;
	private String commentAuthorIP;
	private Date commentDate;
	private String commentContent;
	private CommentApproved commentApproved = CommentApproved.YES;  //评论是否被允许,默认是通过审核的
	private String commentAgent; //每个评论的评论者的客户端信息，主要包括其浏览器和操作系统的类型、版本等资料。
	private CommentType commentType = CommentType.COMMENT; //评论类型，默认是普通评论
	private Comment commentParent; //父评论	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "comment_ID", columnDefinition = "bigint(20) unsigned",nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Index(name = "comment_post_ID")
	@ManyToOne
	@JoinColumn(name = "comment_post_ID",columnDefinition = "bigint(20) unsigned DEFAULT '0'", nullable = false)
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	@ManyToOne
	@JoinColumn(name = "user_id",columnDefinition = "bigint(20) unsigned DEFAULT '0'", nullable = false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Column(name = "comment_author_IP", columnDefinition = "varchar(100) DEFAULT ''", nullable = false)
	public String getCommentAuthorIP() {
		return commentAuthorIP;
	}
	public void setCommentAuthorIP(String commentAuthorIP) {
		this.commentAuthorIP = commentAuthorIP;
	}
	
	@Column(name = "comment_date", columnDefinition = "datetime DEFAULT '0000-00-00 00:00:00'", nullable = false)
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	@Column(name = "comment_content", columnDefinition = "text", nullable = false)
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "comment_approved", columnDefinition = "varchar(20)", nullable = false)
	public CommentApproved getCommentApproved() {
		return commentApproved;
	}
	public void setCommentApproved(CommentApproved commentApproved) {
		this.commentApproved = commentApproved;
	}
	
	@Column(name = "comment_agent", columnDefinition = "varchar(255) DEFAULT ''", nullable = false)
	public String getCommentAgent() {
		return commentAgent;
	}
	public void setCommentAgent(String commentAgent) {
		this.commentAgent = commentAgent;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "comment_type", columnDefinition = "varchar(20) DEFAULT ''", nullable = false)
	public CommentType getCommentType() {
		return commentType;
	}
	public void setCommentType(CommentType commentType) {
		this.commentType = commentType;
	}
	
	@OneToOne
	@JoinColumn(name = "comment_parent",columnDefinition = "bigint(20) unsigned DEFAULT '0'", nullable = false)
	public Comment getCommentParent() {
		return commentParent;
	}
	public void setCommentParent(Comment commentParent) {
		this.commentParent = commentParent;
	}
	
	/*
	 * Comment中的评论类型的枚举类。
	 *
	 */
	public enum CommentType {
		COMMENT //如果是wordpress可能存在以下三种评论：'comment', 'trackback', 'pingback'，目前这个系统中只有一种
	}
	
	/*
	 * Comment中的审核状态的枚举类。
	 *
	 */
	public enum CommentApproved {
		NO, //未经过审核
		YES, //经过审核
		SPAM //垃圾评论
	}

}
