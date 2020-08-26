package org.codetest.promotionengine.service;

import org.codetest.promotionengine.model.Promotion;
import org.codetest.promotionengine.model.PromotionItemSKU;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PromotionServiceImpl implements PromotionService {

    private Map<String,Integer> promotionAppliedItems;

    @Autowired
    private PromotionCalculatorHelper promotionCalcHelper;


    @Override
    public List<Promotion> getAllPromotions() {
        return null;
    }

    @Override
    public double applyPromotion(List<PromotionItemSKU> promotionItemSKUs) {
        return 0;
    }
}
