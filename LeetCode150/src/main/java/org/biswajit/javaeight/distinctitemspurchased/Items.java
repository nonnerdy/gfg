package org.biswajit.javaeight.distinctitemspurchased;

public class Items {
    private String itemName;

    public Items(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemName='" + itemName + '\'' +
                '}';
    }
}

