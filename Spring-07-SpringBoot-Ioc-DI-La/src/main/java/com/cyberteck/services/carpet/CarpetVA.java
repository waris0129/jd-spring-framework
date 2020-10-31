package com.cyberteck.services.carpet;

import com.cyberteck.enums.City;
import com.cyberteck.interfaces.carpetPrices.Carpet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class CarpetVA implements Carpet {
    private static final Map<City, BigDecimal> sqPriceCity = new HashMap<>();

    static {
        sqPriceCity.put(City.MCLEAN,BigDecimal.valueOf(4.32));
        sqPriceCity.put(City.ARLINGTON,BigDecimal.valueOf(5));
        sqPriceCity.put(City.FAIRFAX,BigDecimal.valueOf(8));

    }


    @Override
    public BigDecimal getSqFtPrice(City city) {

        BigDecimal defaultPrice = BigDecimal.ZERO;

         Optional<Map.Entry<City,BigDecimal>> obj = sqPriceCity.entrySet().stream().filter(p->p.getKey()==city).findFirst();

        return obj.isPresent()?obj.get().getValue():defaultPrice;
    }
}
