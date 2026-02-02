package org.biswajit.javaeight.inventoryshortagedetectionacrosswarehouses;

public class Inventory {
    private String product;
    private String warehouses;
    private int quantity;

    public Inventory(String product, String warehouses, int quantity) {
        this.product = product;
        this.warehouses = warehouses;
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(String warehouses) {
        this.warehouses = warehouses;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "product='" + product + '\'' +
                ", warehouses='" + warehouses + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
