
package com.homedecor.rest.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "product_images")
public class ProductImages implements java.io.Serializable {

    private Long productImagesId;
    private ProductMaster productMaster;
    private String imageName;
    private String imagePath;
    private String label;
    private Integer sortOrder;
    private Boolean status;

    public ProductImages() {
    }

    public ProductImages(ProductMaster productMaster, String imageName,
                         String imagePath, String label, Integer sortOrder, Boolean status) {
        this.productMaster = productMaster;
        this.imageName = imageName;
        this.imagePath = imagePath;
        this.label = label;
        this.sortOrder = sortOrder;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "productImagesId", unique = true, nullable = false)
    public Long getProductImagesId() {
        return this.productImagesId;
    }

    public void setProductImagesId(Long productImagesId) {
        this.productImagesId = productImagesId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    public ProductMaster getProductMaster() {
        return this.productMaster;
    }

    public void setProductMaster(ProductMaster productMaster) {
        this.productMaster = productMaster;
    }

    @Column(name = "image_name", length = 125)
    public String getImageName() {
        return this.imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Lob
    @Column(name = "image_path", columnDefinition = "BOLB")
    public String getImagePath() {
        return this.imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Column(name = "label", length = 125)
    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Column(name = "sort_order")
    public Integer getSortOrder() {
        return this.sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Column(name = "status")
    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}

