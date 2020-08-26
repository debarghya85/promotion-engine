package org.codetest.promotionengine.service;

import org.codetest.promotionengine.model.Promotion;
import org.codetest.promotionengine.model.PromotionItemSKU;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PromotionCalculatorHelperTest {

    @Autowired
    private PromotionCalculatorHelper promotionCalculatorHelper;

    @Test
    public void calculateFinalPriceScenarioATest(){
        List<Promotion> promotions = Arrays.asList(
                new Promotion("3 of A's for 130",130.00,new ArrayList<PromotionItemSKU>(Arrays.asList(new PromotionItemSKU("A",3)))),
                new Promotion("2 of B's for 45",45.00,new ArrayList<PromotionItemSKU>(Arrays.asList(new PromotionItemSKU("B",2)))),
                new Promotion("C and D for 30",30.00,new ArrayList<PromotionItemSKU>(Arrays.asList(new PromotionItemSKU("C",1),new PromotionItemSKU("D",1)))));

        List<PromotionItemSKU> orderedItem = Arrays.asList(new PromotionItemSKU("A",1),
                new PromotionItemSKU("B",1),
                new PromotionItemSKU("C",1));

        double actual = promotionCalculatorHelper.calculateFinalPrice(promotions,orderedItem,new HashMap<String,Integer>());
        Assert.assertTrue(100.0d == actual);
    }

    @Test
    public void calculateFinalPriceScenarioBTest(){
        List<Promotion> promotions = Arrays.asList(
                new Promotion("3 of A's for 130",130.00,new ArrayList<PromotionItemSKU>(Arrays.asList(new PromotionItemSKU("A",3)))),
                new Promotion("2 of B's for 45",45.00,new ArrayList<PromotionItemSKU>(Arrays.asList(new PromotionItemSKU("B",2)))),
                new Promotion("C and D for 30",30.00,new ArrayList<PromotionItemSKU>(Arrays.asList(new PromotionItemSKU("C",1),new PromotionItemSKU("D",1)))));

        List<PromotionItemSKU> orderedItem = Arrays.asList(new PromotionItemSKU("A",5),
                new PromotionItemSKU("B",5),
                new PromotionItemSKU("C",1));

        double actual = promotionCalculatorHelper.calculateFinalPrice(promotions,orderedItem,new HashMap<String,Integer>());
        Assert.assertTrue(370.0d == actual);
    }

    @Test
    public void calculateFinalPriceScenarioCTest(){
        List<Promotion> promotions = Arrays.asList(
                new Promotion("3 of A's for 130",130.00,new ArrayList<PromotionItemSKU>(Arrays.asList(new PromotionItemSKU("A",3)))),
                new Promotion("2 of B's for 45",45.00,new ArrayList<PromotionItemSKU>(Arrays.asList(new PromotionItemSKU("B",2)))),
                new Promotion("C and D for 30",30.00,new ArrayList<PromotionItemSKU>(Arrays.asList(new PromotionItemSKU("C",1),new PromotionItemSKU("D",1)))));

        List<PromotionItemSKU> orderedItem = Arrays.asList(new PromotionItemSKU("A",3),
                new PromotionItemSKU("B",5),
                new PromotionItemSKU("C",1),
                new PromotionItemSKU("D",1));

        double actual = promotionCalculatorHelper.calculateFinalPrice(promotions,orderedItem,new HashMap<String,Integer>());
        Assert.assertTrue(280.0d == actual);
    }



}
