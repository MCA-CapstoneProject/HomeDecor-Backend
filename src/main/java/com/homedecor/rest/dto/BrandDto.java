package com.homedecor.rest.dto;

import java.util.Date;

public class BrandDto {
	
	private Integer id;
	private String brandName;
	private Boolean status;
	private String logo;
	private Integer sortOrder;
	private String website;
	private Date createdOn;
	private Date modifiedOn;
	private String userByModifiedBy;
	private String userByCreatedBy;
	private Boolean brandTypeExists;
	
	public BrandDto(){
		
		
	}

	
	public BrandDto(Integer id, String brandName, Boolean status, String logo) {
		
		this.id = id;
		this.brandName = brandName;
		this.status = status;
		this.logo = logo;
	}

	public BrandDto(Integer id, String brandName, Boolean status, String logo,
					Integer sortOrder, String website, Date createdOn, Date modifiedOn,
					String userByModifiedBy, String userByCreatedBy) {
		this.id = id;
		this.brandName = brandName;
		this.status = status;
		this.logo = logo;
		this.sortOrder = sortOrder;
		this.website = website;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
		this.userByModifiedBy = userByModifiedBy;
		this.userByCreatedBy = userByCreatedBy;
	}




	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserByModifiedBy() {
		return userByModifiedBy;
	}
	public void setUserByModifiedBy(String userByModifiedBy) {
		this.userByModifiedBy = userByModifiedBy;
	}
	public String getUserByCreatedBy() {
		return userByCreatedBy;
	}
	public void setUserByCreatedBy(String userByCreatedBy) {
		this.userByCreatedBy = userByCreatedBy;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}


	public Boolean getBrandTypeExists() {
		return brandTypeExists;
	}


	public void setBrandTypeExists(Boolean brandTypeExists) {
		this.brandTypeExists = brandTypeExists;
	}

	
}
