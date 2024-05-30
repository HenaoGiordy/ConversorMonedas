package org.conversor.alura.service;

public class Converter {

    private Float amount = 0.0F;
    private Float exchange_rate = 0.0F;

    public Converter(Float amount, Float exchange_rate) {
        this.amount = amount;
        this.exchange_rate = exchange_rate;
    }
    public Float getAmount() {
        return amount;
    }
    public Float getExchangeRate() {
        return exchange_rate;
    }

    public Float calculateAmount() {
        return amount * exchange_rate;
    }

}
