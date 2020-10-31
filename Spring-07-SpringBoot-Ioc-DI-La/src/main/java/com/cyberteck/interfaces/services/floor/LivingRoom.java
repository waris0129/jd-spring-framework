package com.cyberteck.interfaces.services.floor;

import com.cyberteck.interfaces.floorTypes.Floor;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

public class LivingRoom implements Floor {

    @Value("${length}")
    BigDecimal length;

    @Value("${width}")
    BigDecimal width;

    @Override
    public BigDecimal getArea() {
        return length.multiply(width);
    }
}
