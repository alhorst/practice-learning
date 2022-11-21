package com.techelevator;

import java.util.List;

public class Mod1Assessment {

    public static void main(String[] args) {

        PC pc1 = new PC("NITEL", "8", "EONRAD");
        PC pc2 = new PC("DAM", "16", "FORCEG");

        System.out.println(pc1.toString());
        System.out.println(pc2.toString());

        PC.readFile();
        
    }

}
