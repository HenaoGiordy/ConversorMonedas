package org.conversor.alura.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.conversor.alura.api.ApiExchange;
import org.conversor.alura.models.Exchange;
import org.conversor.alura.models.ExchangeDTO;
import org.conversor.alura.service.Converter;

import java.io.IOException;
import java.util.Scanner;

public class MainProgram {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void menu(){
        System.out.println("Menu");
        System.out.println("1. Dolar ===> Peso Colombiano");
        System.out.println("2. Peso Colombiano ===> Dolar");
        System.out.println("3. Dolar ===> Peso Argentino");
        System.out.println("4. Peso Argentino ===> Dolar");
        System.out.println("5. Dolar  ===> Reales");
        System.out.println("6. Reales ===> Dolar");
        System.out.println("7. Salir");
        System.out.println("Elige una opción: ");
    }

    public void amountOption(){
        System.out.println("¿Cuánto quieres convertir?");
    }

    private Exchange exchangeData(String currentCurrency, String exchangeCurrency ) throws IOException, InterruptedException {
        ApiExchange apiExchange = new ApiExchange();
        String json = apiExchange.exchangeRate(currentCurrency, exchangeCurrency).body();
        ExchangeDTO exchangeDTO = gson.fromJson(json, ExchangeDTO.class);
        return new Exchange(exchangeDTO);
    }

    private Float convert(Exchange Exchange, Float amount){
        Converter converter = new Converter(amount, Exchange.getConversion_rate());
        return converter.calculateAmount();
    }

    private void resultMessage(Float result, Float amountOption, Exchange data){
        System.out.println("El resultado de convertir " + amountOption + " " +data.getCurrentCurrency()+" a "+data.getCurrencyExchange()+" es: " + + result);
    }

    public void startProgram(){
        boolean finish = true;
        while (finish){
            menu();

            Scanner sc = new Scanner(System.in);
            String option = sc.nextLine();
            if(option.equals("1")){
                try {
                    amountOption();
                    Float amountOption = sc.nextFloat();
                    Exchange data = exchangeData(Monedas.USD.toString(), Monedas.COP.toString());
                    Float converted = convert(data, amountOption);
                    resultMessage(converted, amountOption, data);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }if(option.equals("2")){
                try {
                    amountOption();
                    Float amountOption = sc.nextFloat();
                    Exchange data = exchangeData(Monedas.COP.toString(), Monedas.USD.toString());
                    Float converted = convert(data, amountOption);
                    resultMessage(converted, amountOption, data);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }if(option.equals("3")){
                try {
                    amountOption();
                    Float amountOption = sc.nextFloat();
                    Exchange data = exchangeData(Monedas.USD.toString(), Monedas.ARS.toString());
                    Float converted = convert(data, amountOption);
                    resultMessage(converted, amountOption, data);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }if(option.equals("4")){
                try {
                    amountOption();
                    Float amountOption = sc.nextFloat();
                    Exchange data = exchangeData(Monedas.ARS.toString(), Monedas.USD.toString());
                    Float converted = convert(data, amountOption);
                    resultMessage(converted, amountOption, data);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }if(option.equals("5")){
                try {
                    amountOption();
                    Float amountOption = sc.nextFloat();
                    Exchange data = exchangeData(Monedas.USD.toString(), Monedas.BRL.toString());
                    Float converted = convert(data, amountOption);
                    resultMessage(converted, amountOption, data);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }if(option.equals("6")){
                try {
                    amountOption();
                    Float amountOption = sc.nextFloat();
                    Exchange data = exchangeData(Monedas.BRL.toString(), Monedas.USD.toString());
                    Float converted = convert(data, amountOption);
                    resultMessage(converted, amountOption, data);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }if(option.equals("7")){
                finish = false;
            }
        }
    }
}
