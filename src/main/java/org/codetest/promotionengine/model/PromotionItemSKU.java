package org.codetest.promotionengine.model;

import java.io.Serializable;

public class PromotionItemSKU implements Comparable<PromotionItemSKU> {
    private String sku;
    private int quantity;


    public PromotionItemSKU() {
    }

    public PromotionItemSKU(String sku, int quantity) {
        this.sku = sku;
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }




    @Override
    public int compareTo(PromotionItemSKU o2) {
        if(this.getQuantity()>o2.getQuantity())
            return 1;
        else if(this.getQuantity()<o2.getQuantity())
            return -1;
        else
            return 0;
    }
}
