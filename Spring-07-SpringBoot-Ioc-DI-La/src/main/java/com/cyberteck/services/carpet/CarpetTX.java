package com.cyberteck.services.carpet;

import com.cyberteck.enums.City;
import com.cyberteck.interfaces.carpetPrices.Carpet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class CarpetTX implements Carpet {

    private static final Map<City, BigDecimal> sqPriceCity = new HashMap<>();

    static {
        sqPriceCity.put(City.AUSTIN,BigDecimal.valueOf(2.58));
        sqPriceCity.put(City.DALLAS,BigDecimal.valueOf(3.456));
        sqPriceCity.put(City.SAN_ANTONIO,BigDecimal.valueOf(9));

    }


    @Override
    public BigDecimal getSqFtPrice(City city) {

        //entrySet() --> convert into stream


        BigDecimal defaultValue = BigDecimal.ZERO;

        // way one to stream Map
        //sqPriceCity.entrySet().stream().filter(p->p.getKey().equals(city)).findFirst().get().getValue();


        // way 2 to stream Map// Option way is perfer to use
        /*  Prefer Stream method:
            Second way to use Optional
            because if there is exception, it would said "there is no value in object"
         */
        Optional<Map.Entry<City,BigDecimal>>obj=
        sqPriceCity.entrySet().stream().filter(p->p.getKey()==city).findFirst();


        return obj.isPresent() ? obj.get().getValue():defaultValue;
    }
}
