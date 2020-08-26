package org.codetest.promotionengine.controller;

import org.codetest.promotionengine.model.Promotion;
import org.codetest.promotionengine.model.PromotionItemSKU;
import org.codetest.promotionengine.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PromotionController {

    @Autowired
    private PromotionService promotionService;


    @RequestMapping(value = "/promotion",method = RequestMethod.GET)
    public List<Promotion> getAllPromotions(){
        return promotionService.getAllPromotions();
    }


    @RequestMapping(value = "/applypromotion",method = RequestMethod.POST)
    public String applyPromotionOnCart(@RequestBody ArrayList<PromotionItemSKU> itemOrdered){
        return "Promotion Applied, Final price is: "+promotionService.applyPromotion(itemOrdered);
    }


}
