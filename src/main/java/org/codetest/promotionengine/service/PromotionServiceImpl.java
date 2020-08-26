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
    public List<Promotion> getAllPromotions(){
        List<Promotion> promotions = new ArrayList<Promotion>();
        promotions.add(new Promotion("3 of A's for 130",130.00,new ArrayList<PromotionItemSKU>(Arrays.asList(new PromotionItemSKU("A",3)))));
        promotions.add(new Promotion("2 of B's for 45",45.00,new ArrayList<PromotionItemSKU>(Arrays.asList(new PromotionItemSKU("B",2)))));
        promotions.add(new Promotion("C and D for 30",30.00,new ArrayList<PromotionItemSKU>(Arrays.asList(new PromotionItemSKU("C",1),new PromotionItemSKU("D",1)))));

        return promotions;
    }

    @Override
    public double applyPromotion(List<PromotionItemSKU> itemOrdered) {
        List<Promotion> promotionsList = getAllPromotions();
        promotionAppliedItems = new HashMap<>();
        return promotionCalcHelper.calculateFinalPrice(promotionsList,itemOrdered,promotionAppliedItems);
    }
}
