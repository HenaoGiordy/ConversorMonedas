package org.conversor.alura.models;

public class Exchange {

    private String currentCurrency;
    private String currencyExchange;
    private Float conversion_rate;

    public Exchange(Float conversion_rate, String currencyExchange, String currentCurrency) {
        this.conversion_rate = conversion_rate;
        this.currencyExchange = currencyExchange;
        this.currentCurrency = currentCurrency;
    }

    public Float getConversion_rate() {
        return conversion_rate;
    }

    public void setConversion_rate(Float conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    public String getCurrencyExchange() {
        return currencyExchange;
    }

    public void setCurrencyExchange(String currencyExchange) {
        this.currencyExchange = currencyExchange;
    }

    public String getCurrentCurrency() {
        return currentCurrency;
    }

    public void setCurrentCurrency(String currentCurrency) {
        this.currentCurrency = currentCurrency;
    }

    @Override
    public String toString() {
        return "Exchange{" +
                "conversion_rate=" + conversion_rate +
                ", currentCurrency='" + currentCurrency + '\'' +
                ", currencyExchange='" + currencyExchange + '\'' +
                '}';
    }

    public Exchange(ExchangeDTO exchangeDTO) {
        this.currentCurrency = exchangeDTO.base_code();
        this.currencyExchange = exchangeDTO.target_code();
        this.conversion_rate = exchangeDTO.conversion_rate();
    }
}
