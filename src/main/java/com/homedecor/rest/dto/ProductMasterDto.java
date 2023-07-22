package com.homedecor.rest.dto;

import java.util.Date;
import java.util.List;

public class ProductMasterDto {


    private Long productMasterId;
    private String productName;
    private String productCode;
    private Long categoryId;
    private Double reatilPrice;
    private Integer brandId;
    private Date productCreatedOn;
    private Integer companyId;
    private Boolean productStatus;
    private String description;
    private String stylistNote;
    private Long stockStautsId;
    private Integer productPoints;
    private Integer minimumThreshold;
    private Integer sortOrder;
    private Integer logicalCategoryId;
    private Long rackId;
    private Long binId;
    private Integer deliveryId;
    private List<ImageDto> images;


    public ProductMasterDto() {


    }

    public ProductMasterDto(Long productMasterId, String productName,
                            String productCode, Long categoryId, Double reatilPrice,
                            Integer brandId, Date productCreatedOn, Integer companyId,
                            Boolean productStatus, String description, String stylistNote,
                            Integer productPoints,
                            Integer minimumThreshold, Integer sortOrder,
                            Integer logicalCategoryId, Integer deliveryId) {
        super();
        this.productMasterId = productMasterId;
        this.productName = productName;
        this.productCode = productCode;
        this.categoryId = categoryId;
        this.reatilPrice = reatilPrice;
        this.brandId = brandId;
        this.productCreatedOn = productCreatedOn;
        this.companyId = companyId;
        this.productStatus = productStatus;
        this.description = description;
        this.stylistNote = stylistNote;
        this.productPoints = productPoints;
        this.minimumThreshold = minimumThreshold;
        this.sortOrder = sortOrder;
        this.logicalCategoryId = logicalCategoryId;
        this.deliveryId = deliveryId;

    }

    public ProductMasterDto(Long productMasterId, String productName,
                            String productCode, Long categoryId, Double reatilPrice,
                            Integer brandId, Date productCreatedOn, Integer companyId,
                            Boolean productStatus, String description, String stylistNote,
                            Integer productPoints,
                            Integer minimumThreshold, Integer sortOrder,
                            Integer logicalCategoryId) {
        super();
        this.productMasterId = productMasterId;
        this.productName = productName;
        this.productCode = productCode;
        this.categoryId = categoryId;
        this.reatilPrice = reatilPrice;
        this.brandId = brandId;
        this.productCreatedOn = productCreatedOn;
        this.companyId = companyId;
        this.productStatus = productStatus;
        this.description = description;
        this.stylistNote = stylistNote;
        this.productPoints = productPoints;
        this.minimumThreshold = minimumThreshold;
        this.sortOrder = sortOrder;
        this.logicalCategoryId = logicalCategoryId;

    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Double getReatilPrice() {
        return reatilPrice;
    }

    public void setReatilPrice(Double reatilPrice) {
        this.reatilPrice = reatilPrice;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Date getProductCreatedOn() {
        return productCreatedOn;
    }

    public void setProductCreatedOn(Date productCreatedOn) {
        this.productCreatedOn = productCreatedOn;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Boolean getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Boolean productStatus) {
        this.productStatus = productStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStylistNote() {
        return stylistNote;
    }

    public void setStylistNote(String stylistNote) {
        this.stylistNote = stylistNote;
    }

    public Long getStockStautsId() {
        return stockStautsId;
    }

    public void setStockStautsId(Long stockStautsId) {
        this.stockStautsId = stockStautsId;
    }

    public Integer getProductPoints() {
        return productPoints;
    }

    public void setProductPoints(Integer productPoints) {
        this.productPoints = productPoints;
    }

    public Integer getMinimumThreshold() {
        return minimumThreshold;
    }

    public void setMinimumThreshold(Integer minimumThreshold) {
        this.minimumThreshold = minimumThreshold;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getLogicalCategoryId() {
        return logicalCategoryId;
    }

    public void setLogicalCategoryId(Integer logicalCategoryId) {
        this.logicalCategoryId = logicalCategoryId;
    }

    public Long getRackId() {
        return rackId;
    }

    public void setRackId(Long rackId) {
        this.rackId = rackId;
    }

    public Long getBinId() {
        return binId;
    }

    public void setBinId(Long binId) {
        this.binId = binId;
    }

    public Long getProductMasterId() {
        return productMasterId;
    }

    public void setProductMasterId(Long productMasterId) {
        this.productMasterId = productMasterId;
    }

    public List<ImageDto> getImages() {
        return images;
    }

    public void setImages(List<ImageDto> images) {
        this.images = images;
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }


}
