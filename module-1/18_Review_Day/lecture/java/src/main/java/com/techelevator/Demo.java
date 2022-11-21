package com.techelevator;

import com.techelevator.models.BostonCreme;
import com.techelevator.models.ChocolateSprinkle;
import com.techelevator.models.Donut;
import com.techelevator.models.FilledStick;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<Donut> donutList = new ArrayList<>();

        BostonCreme bostonCreme = new BostonCreme(new BigDecimal("1.50"));
        ChocolateSprinkle chocolateSprinkle = new ChocolateSprinkle(new BigDecimal("10.00"));
        FilledStick filledStick = new FilledStick(new BigDecimal("2.00"));

        donutList.add(bostonCreme);
        donutList.add(chocolateSprinkle);
        donutList.add(filledStick);

        for (Donut donut : donutList) {
            System.out.printf("%-15s $%8.2f\n", donut.getType(), donut.getPrice());
        }
    }
}

