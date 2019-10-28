package com.neuedu.crm.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * user
 * 
 * @author
 */
public class User implements Serializable {
	private Integer id;

	private Integer roleId;

	private String name;

	private String hashCode;

	private String salt;

	private String gender;

	private String phoneNum;

	private Integer status;

	private Integer userId;

	private String email;

	private Date lastLogin;

	private static final long serialVersionUID = 1L;

	/**
	 * 新增的变量
	 * @return
	 */
	private Integer num;
	private String roleName;
	private String accountStatus;
	private String lastLoginTime;
	private String superior;
	
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
	

	public String getSuperior() {
		return superior;
	}

	public void setSuperior(String superior) {
		this.superior = superior;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHashCode() {
		return hashCode;
	}

	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		User other = (User) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
				&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
				&& (this.getHashCode() == null ? other.getHashCode() == null
						: this.getHashCode().equals(other.getHashCode()))
				&& (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()))
				&& (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
				&& (this.getPhoneNum() == null ? other.getPhoneNum() == null
						: this.getPhoneNum().equals(other.getPhoneNum()))
				&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
				&& (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
				&& (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
				&& (this.getLastLogin() == null ? other.getLastLogin() == null
						: this.getLastLogin().equals(other.getLastLogin()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getHashCode() == null) ? 0 : getHashCode().hashCode());
		result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
		result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
		result = prime * result + ((getPhoneNum() == null) ? 0 : getPhoneNum().hashCode());
		result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
		result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
		result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
		result = prime * result + ((getLastLogin() == null) ? 0 : getLastLogin().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", roleId=").append(roleId);
		sb.append(", name=").append(name);
		sb.append(", hashCode=").append(hashCode);
		sb.append(", salt=").append(salt);
		sb.append(", gender=").append(gender);
		sb.append(", phoneNum=").append(phoneNum);
		sb.append(", status=").append(status);
		sb.append(", userId=").append(userId);
		sb.append(", email=").append(email);
		sb.append(", lastLogin=").append(lastLogin);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}