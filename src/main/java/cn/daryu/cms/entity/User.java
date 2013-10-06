package cn.daryu.cms.entity;

import java.util.Date;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Index;


/**
 * CMS中的用户表
 * 
 * @author Day
 * 
 */
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "cms_user")
public class User {

	private Long id;
	private String userEmail;
	private String userPass;
	private String userNicename;
	private String userUrl;
	private String userActivationKey; //用户激活码,一般不怎么用
	private Long userStatus;
	private Date userRegistered;
	//附加表的映射MAP
	private Map<String, Usermeta> usermetas;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", columnDefinition = "bigint(20) unsigned",nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
	@Index(name = "user_login_key")
	@Column(name = "user_email", columnDefinition = "varchar(100) DEFAULT ''", nullable = false)
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "user_pass", columnDefinition = "varchar(64) DEFAULT ''", nullable = false)
	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	@Index(name = "user_nicename")
	@Column(name = "user_nicename", columnDefinition = "varchar(50) DEFAULT ''", nullable = false)
	public String getUserNicename() {
		return userNicename;
	}

	public void setUserNicename(String userNicename) {
		this.userNicename = userNicename;
	}

	@Column(name = "user_url", columnDefinition = "varchar(100) DEFAULT ''", nullable = false)
	public String getUserUrl() {
		return userUrl;
	}

	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}

	@Column(name = "user_activation_key", columnDefinition = "varchar(60) DEFAULT ''", nullable = false)
	public String getUserActivationKey() {
		return userActivationKey;
	}

	public void setUserActivationKey(String userActivationKey) {
		this.userActivationKey = userActivationKey;
	}

	@Column(name = "user_status", columnDefinition = "int(11) DEFAULT '0'", nullable = false)
	public Long getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Long userStatus) {
		this.userStatus = userStatus;
	}

	@Column(name = "user_registered", columnDefinition = "datetime DEFAULT '0000-00-00 00:00:00'", nullable = false)
	public Date getUserRegistered() {
		return userRegistered;
	}

	public void setUserRegistered(Date userRegistered) {
		this.userRegistered = userRegistered;
	}

	@OneToMany(targetEntity = Usermeta.class, cascade = CascadeType.ALL,mappedBy = "user")
	@MapKey(name = "metaKey")
	public Map<String, Usermeta> getUsermetas() {
		return usermetas;
	}

	public void setUsermetas(Map<String, Usermeta> usermetas) {
		this.usermetas = usermetas;
	}

}
