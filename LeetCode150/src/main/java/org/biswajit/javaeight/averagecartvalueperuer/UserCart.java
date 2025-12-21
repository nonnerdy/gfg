package org.biswajit.javaeight.averagecartvalueperuer;

public class UserCart {
    private String userName;
    private int price;
    private String cartStatus;

    public UserCart(String userName, int price, String cartStatus) {
        this.userName = userName;
        this.price = price;
        this.cartStatus = cartStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(String cartStatus) {
        this.cartStatus = cartStatus;
    }

    @Override
    public String toString() {
        return "UserCart{" +
                "userName='" + userName + '\'' +
                ", price=" + price +
                ", cartStatus='" + cartStatus + '\'' +
                '}';
    }
}
