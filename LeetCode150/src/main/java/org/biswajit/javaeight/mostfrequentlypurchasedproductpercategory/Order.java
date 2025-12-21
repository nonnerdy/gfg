package org.biswajit.javaeight.mostfrequentlypurchasedproductpercategory;

public class Order {
    private String productId;
    private String productCategory;

    public Order(String productId, String productCategory) {
        this.productId = productId;
        this.productCategory = productCategory;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public String toString() {
        return "Order{" +
                "productId='" + productId + '\'' +
                ", productCategory='" + productCategory + '\'' +
                '}';
    }
}
