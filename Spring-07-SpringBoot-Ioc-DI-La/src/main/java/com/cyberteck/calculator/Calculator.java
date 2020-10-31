package com.cyberteck.calculator;

import com.cyberteck.enums.City;
import com.cyberteck.interfaces.carpetPrices.Carpet;
import com.cyberteck.interfaces.floorTypes.Floor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Calculator {

    @Qualifier("carpetTX")
    @Autowired
    private Carpet carpet;


    @Qualifier("bedroom")
    @Autowired
    private Floor floor;

    public String getTotalCarpetCost(City city) {

        BigDecimal cost = carpet.getSqFtPrice(city).multiply(floor.getArea());

        if(cost.compareTo(BigDecimal.ZERO)==0){
            try{
                throw new Exception();
            }catch (Exception e){
                return "this city is not service area.";
            }

        }

        return "Total cost for carpet is $"+cost.to+".";

    }




}
