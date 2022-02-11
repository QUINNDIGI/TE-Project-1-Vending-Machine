package com.techelevator;

import java.nio.channels.FileChannel;

public class CoinNames {

    private int PENNY = 1;
    private int NICKEL = 5;
    private int DIME = 10;
    private int QUARTER = 25;
    private int DOLLAR = 100;
    private int TWO_DOLLARS = 200;
    private int FIVE_DOLLARS = 500;
    private int TEN_DOLLARS = 1000;
    private int balance = 0;


    public CoinNames(int PENNY, int NICKEL, int DIME, int QUARTER, int DOLLAR, int TWO_DOLLARS, int FIVE_DOLLARS, int TEN_DOLLARS) {
        this.PENNY = PENNY;
        this.NICKEL = NICKEL;
        this.DIME = NICKEL;
        this.QUARTER = QUARTER;
        this.DOLLAR = DOLLAR;
        this.TWO_DOLLARS = TWO_DOLLARS;
        this.FIVE_DOLLARS = FIVE_DOLLARS;
        this.TEN_DOLLARS = TEN_DOLLARS;
    }


        public int getPENNY() {
        return PENNY;
    }

    public int getNICKEL() {
        return NICKEL;
    }

    public int getDIME() {
        return DIME;
    }

    public int getQUARTER() {
        return QUARTER;
    }

    public int getDOLLAR() {
        return DOLLAR;
    }

    public int getTWO_DOLLARS() {
        return TWO_DOLLARS;
    }

    public int getFIVE_DOLLARS() {
        return FIVE_DOLLARS;
    }

    public int getTEN_DOLLARS() {
        return TEN_DOLLARS;
    }


    public int increaseBalance() {
        balance += CoinNames();
    }









}
