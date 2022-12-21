package QLCH;

public class productInCart {
    private String productId;
    private String productName;
    private int productQuantity;
    private int productPrice;
    public productInCart() {
        this.productId = null;
        this.productName = null;
        this.productQuantity = 0;
        this.productPrice = 0;
    }
    public productInCart(String id,String name,int quantity, int price) {
        this.productId = id;
        this.productName = name;
        this.productQuantity = quantity;
        this.productPrice = price;

    }

    public String getProductId() {
        return this.productId;
    }
    public String getProductName() {
        return this.productName;
    }
    public int getProductQuantity() {
        return this.productQuantity;
    }
    public int getProductPrice() {
        return this.productPrice;
    }


    public void setProductId(String id) {
        this.productId = id;
    }
    public void setProductName(String name) {
        this.productName = name;
    }
    public void setProductQuantity(int quantity) {
        this.productQuantity = quantity;
    }
    public void setProductPricec(int price) {
        this.productPrice = price;
    }

    @Override public String toString() {
        return productId + "," + productName + "," + productQuantity + "," + productPrice;
    }
}
