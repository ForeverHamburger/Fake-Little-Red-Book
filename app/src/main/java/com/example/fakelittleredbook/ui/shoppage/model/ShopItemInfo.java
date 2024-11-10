package com.example.fakelittleredbook.ui.shoppage.model;

public class ShopItemInfo {
    private Integer itemPicture;
    private String itemName;
    private String label;
    private String price;
    private String discountedPrice;
    private String salesVolume;
    private String tag;

    public ShopItemInfo(Integer itemPicture, String itemName, String label
            , String price, String discountedPrice, String salesVolume
            , String tag) {
        this.itemPicture = itemPicture;
        this.itemName = itemName;
        this.label = label;
        this.price = price;
        this.discountedPrice = discountedPrice;
        this.salesVolume = salesVolume;
        this.tag = tag;
    }

    public Integer getItemPicture() {
        return itemPicture;
    }

    public void setItemPicture(Integer itemPicture) {
        this.itemPicture = itemPicture;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(String discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(String salesVolume) {
        this.salesVolume = salesVolume;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "ShopItemInfo{" +
                "itemPicture=" + itemPicture +
                ", itemName='" + itemName + '\'' +
                ", label='" + label + '\'' +
                ", price='" + price + '\'' +
                ", discountedPrice='" + discountedPrice + '\'' +
                ", salesVolume='" + salesVolume + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
