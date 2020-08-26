package org.codetest.promotionengine.model;

import java.util.ArrayList;
import java.util.List;

public class Promotion {
    private String name;
    private double promotionalPrice;
    private List<PromotionItemSKU> promotionItemSKUs = new ArrayList<>();

    public Promotion() {
    }

    public Promotion(String name, double promotionalPrice, List<PromotionItemSKU> promotionItemSKUs) {
        this.name = name;
        this.promotionalPrice = promotionalPrice;
        this.promotionItemSKUs = promotionItemSKUs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPromotionalPrice() {
        return promotionalPrice;
    }

    public void setPromotionalPrice(double promotionalPrice) {
        this.promotionalPrice = promotionalPrice;
    }

    public List<PromotionItemSKU> getPromotionItemSKUs() {
        return promotionItemSKUs;
    }

    public void setPromotionItemSKUs(List<PromotionItemSKU> promotionItemSKUs) {
        this.promotionItemSKUs = promotionItemSKUs;
    }
}
