package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PC {
    private String cpu;
    private String memory;
    private String graphicsCard;
    private BigDecimal price  = new BigDecimal("800");

    public PC(String cpu, String memory, String graphicsCard) {
        this.cpu = cpu;
        this.memory = memory;
        this.graphicsCard = graphicsCard;
    }

    public String getCpu() {
        return cpu;
    }

    public String getMemory() {
        return memory;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public BigDecimal getPrice() { //I feel like I was really overthinking this...if I had another 30 minutes...
        if (getCpu().equals("NITEL")) {
            this.price = price.add(new BigDecimal("300"));
        } else if (getCpu().equals("DAM")) {
            this.price = price.add(new BigDecimal("250"));
        }

        if (getMemory().equals("8")) {
            this.price = price.add(new BigDecimal("400"));
        } else if (getMemory().equals("16")) {
            this.price = price.add(new BigDecimal("700"));
        } else if (getMemory().equals("32")) {
            this.price = price.add(new BigDecimal("1000"));
        }

        if (getGraphicsCard().equals("EONRAD")) {
            this.price = price.add(new BigDecimal("350"));
        } else if (getGraphicsCard().equals("FORCEG")) {
            this.price = price.add(new BigDecimal("500"));
        }
        return price;
    }

    public List<PC> readFile() {
        List<PC> list = new ArrayList<>();
        File file = new File("Orders.csv");
        if (!file.exists()) {
            System.out.println("File not found.");
        }
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine().toLowerCase();
                String[] splitLine = line.split(",");
                String cpu = splitLine[0];
                String memory = splitLine[1];
                String graphics = splitLine[2];

                if (cpu.equals("NITEL".toLowerCase())) {
                    list.add(new PC(cpu, memory, graphics));
                } else if (cpu.equals("DAM".toLowerCase())) {
                    list.add(new PC(cpu, memory, graphics));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to read file.");
        }
        return list;
    }

    public boolean offerDiscount(PC pc, boolean saversClub) {
        BigDecimal discountedPrice = new BigDecimal("0");
        if (saversClub && this.price.compareTo(new BigDecimal("2000")) > 0) {
            discountedPrice = this.price.subtract(new BigDecimal("150"));
            System.out.println("Your discounted price is: " + discountedPrice);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "--------------------------------\n" +
                "CPU: " + getCpu() + " | " +
                "Memory: " + getMemory() + "GB | " +
                "Graphics: " + getGraphicsCard() + "\n" +
                "Total Price: " + getPrice() + "\n" +
                "-------------------------------";
    }
}
