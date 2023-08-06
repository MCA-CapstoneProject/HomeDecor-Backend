package com.homedecor.rest.dto;

import com.homedecor.rest.entity.ProductMaster;
import com.homedecor.rest.entity.User;

public class ProductImagesDto {

	private Long productImagesId;
	private ProductMasterDto productMasterDto;
	private String imageName;
	private String imagePath;
	private String label;
	private Integer sortOrder;
	private Boolean status;

	public Long getProductImagesId() {
		return productImagesId;
	}

	public void setProductImagesId(Long productImagesId) {
		this.productImagesId = productImagesId;
	}

	public ProductMasterDto getProductMasterDto() {
		return productMasterDto;
	}

	public void setProductMasterDto(ProductMasterDto productMasterDto) {
		this.productMasterDto = productMasterDto;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
