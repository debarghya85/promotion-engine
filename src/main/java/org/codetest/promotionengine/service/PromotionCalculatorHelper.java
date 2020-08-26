package org.codetest.promotionengine.service;

import org.codetest.promotionengine.model.Promotion;
import org.codetest.promotionengine.model.PromotionItemSKU;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Component
public class PromotionCalculatorHelper {
    private Map<String,Double> itemSkuDefaultPrices = new HashMap<>();

    public PromotionCalculatorHelper() {
        itemSkuDefaultPrices.put("A",50.0);
        itemSkuDefaultPrices.put("B",30.0);
        itemSkuDefaultPrices.put("C",20.0);
        itemSkuDefaultPrices.put("D",15.0);
    }


    public double calculateFinalPrice(List<Promotion> promotions,List<PromotionItemSKU> itemsOrdered,Map<String,Integer> promotionAppliedItems){
        AtomicReference<Double> finalPrice = new AtomicReference<>((double) 0);
        Map<String,Integer> itemPriceCalculated = new HashMap<String,Integer>();
        Map<String, Integer> orderedItems = new HashMap<>();
        itemsOrdered.stream().forEach(item->orderedItems.put(item.getSku(),item.getQuantity()));
        final Map<String, Integer>[] promotionalItems = new Map[]{new HashMap<>()};
        final Map<String, Integer>[] remainingItems = new Map[]{new HashMap<>()};
        promotions.stream().forEach(promotion ->{
            remainingItems[0] = new HashMap<>();
            promotionalItems[0] = new HashMap<>();
            if(isPromotionEligible(promotion,itemsOrdered,promotionAppliedItems)){

                final int[] promotionApplicableTimes = {0};
                promotion.getPromotionItemSKUs().stream().forEach(promoItem->{
                    if(promotionApplicableTimes[0]==0) {
                        promotionApplicableTimes[0] = orderedItems.get(promoItem.getSku()) / promoItem.getQuantity();
                    }
                    promotionalItems[0].put(promoItem.getSku(),(promoItem.getQuantity()* promotionApplicableTimes[0]));
                    promotionAppliedItems.put(promoItem.getSku(),(promoItem.getQuantity()* promotionApplicableTimes[0]));
                });

                orderedItems.entrySet().stream().forEach(itemEntry->{
                    if(promotionalItems[0].containsKey(itemEntry.getKey()) )
                        remainingItems[0].put(itemEntry.getKey(),(itemEntry.getValue() - promotionalItems[0].get(itemEntry.getKey())));
                });

                finalPrice.updateAndGet(v -> new Double((double) (v + promotion.getPromotionalPrice()*promotionApplicableTimes[0])));
                remainingItems[0].entrySet().stream().forEach(remainingEntry->{
                    if(!itemPriceCalculated.containsKey(remainingEntry.getKey())) {
                        finalPrice.updateAndGet(v -> new Double((double) (v + (remainingEntry.getValue() * itemSkuDefaultPrices.get(remainingEntry.getKey())))));
                        itemPriceCalculated.put(remainingEntry.getKey(),remainingEntry.getValue());
                    }
                });
            }
        });

        orderedItems.entrySet().stream().forEach(itemEntry->{
            if(!promotionalItems[0].containsKey(itemEntry.getKey()) && !itemPriceCalculated.containsKey(itemEntry.getKey())) {
                finalPrice.updateAndGet(v -> new Double((double) (v + (itemEntry.getValue() * itemSkuDefaultPrices.get(itemEntry.getKey())))));
            }
        });


        return finalPrice.get();
    }


    private boolean isPromotionMutualExclusive(Promotion promotion, Map<String,Integer> promotionAppliedItems){
        boolean isPossible = true;

        return isPossible;
    }

    public boolean isPromotionEligible(Promotion promotion,List<PromotionItemSKU> itemOrdered,Map<String,Integer> promotionAppliedItems){
        boolean isEligible = true;

        return isEligible;
    }


}
