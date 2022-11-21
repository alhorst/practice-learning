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

    public BigDecimal getPrice() {
        BigDecimal price = new BigDecimal("800");
        if (cpu.equals("NITEL")) {
            price = price.add(new BigDecimal("300"));
        } else if (cpu.equals("DAM")) {
            price = price.add(new BigDecimal("250"));
        }

        if (this.memory.equals("8")) {
            price = price.add(new BigDecimal("400"));
        } else if (this.memory.equals("16")) {
            price = price.add(new BigDecimal("700"));
        } else if (this.memory.equals("32")) {
            price = price.add(new BigDecimal("1000"));
        }

        if (this.graphicsCard.equals("EONRAD")) {
            price = price.add(new BigDecimal("350"));
        } else if (this.graphicsCard.equals("FORCEG")) {
            price = price.add(new BigDecimal("500"));
        }
        return price;
    }

    public static List<PC> readFile() {
        List<PC> pcs = new ArrayList<>();
        BigDecimal total = new BigDecimal("0");
        File file = new File("Orders.csv");
        if (!file.exists()) {
            System.out.println("File not found.");
            System.exit(0);
        }
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine().toUpperCase();
                String[] splitLine = line.split(",");
                String cpu = splitLine[0];
                String memory = splitLine[1];
                String graphics = splitLine[2];
                pcs.add(new PC(cpu, memory, graphics));
            }
            for (PC pc : pcs) {
                total = total.add(pc.getPrice());
            }
            System.out.println(total);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to read file.");
            System.exit(0);
        }
        return pcs;
    }
    public boolean offerDiscount(PC pc, boolean saversClub) {
        if (saversClub && pc.getPrice().compareTo(new BigDecimal("2000")) > 0) {
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
