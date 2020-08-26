package org.codetest.promotionengine.service;

import org.codetest.promotionengine.model.Promotion;
import org.codetest.promotionengine.model.PromotionItemSKU;

import java.util.List;

public interface PromotionService {
    List<Promotion> getAllPromotions();

    double applyPromotion(List<PromotionItemSKU> promotionItemSKUs);
}
