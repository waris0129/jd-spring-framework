package com.cyberteck.interfaces.carpetPrices;

import com.cyberteck.enums.City;

import java.math.BigDecimal;

public interface Carpet { // trying to use BigDecimal, it is class type
    BigDecimal getSqFtPrice(City city);
}
