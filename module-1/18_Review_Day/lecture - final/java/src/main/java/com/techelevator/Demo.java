package com.techelevator;

import com.techelevator.models.Chocolate;
import com.techelevator.models.CreamStick;
import com.techelevator.models.Donut;
import com.techelevator.models.Sprinkled;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args){
        List<Donut> donutList = new ArrayList<>();
        donutList.add(new Chocolate(new BigDecimal("1.19")));

        BigDecimal creamStickPrice = new BigDecimal("1.89");
        CreamStick creamStick = new CreamStick(creamStickPrice);
        donutList.add(creamStick);

        donutList.add(new Sprinkled(new BigDecimal("1.19")));

        for (Donut donut : donutList){
            System.out.printf("%-15s $%8.2f\n", donut.getType(), donut.getPrice());
        }

    }
}
