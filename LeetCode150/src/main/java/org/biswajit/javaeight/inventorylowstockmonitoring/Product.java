package org.biswajit.javaeight.inventorylowstockmonitoring;

public class Product {
    private String productName;
    private String productCategory;
    private int inventory;

    public Product(String productName, String productCategory, int inventory) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.inventory = inventory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
