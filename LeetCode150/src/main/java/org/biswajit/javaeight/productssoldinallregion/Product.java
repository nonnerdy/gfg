package org.biswajit.javaeight.productssoldinallregion;

public class Product {
    private String productId;
    private String region;

    public Product(String productId, String region) {
        this.productId = productId;
        this.region = region;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
