package com.cyberteck.interfaces.carpetPrices;

import com.cyberteck.enums.City;

public interface Carpet { // trying to use BigDecimal, it is class type
    double getSqFtPrice(City city);
}
