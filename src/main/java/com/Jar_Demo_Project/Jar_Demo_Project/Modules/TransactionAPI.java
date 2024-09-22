package com.Jar_Demo_Project.Jar_Demo_Project.Modules;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.*;

@Document(collection="Transactions")
public class TransactionAPI {

    public String getTocurrency() {
        return toCurrency;
    }

    public Double AllAmount(){
        return Amount;
    }


    @Field("Tocurrency")
    private String toCurrency;

    @Field("FromCurrency")
    private String fromCurrency;

    @Field("Amount")
    private Double Amount;

    @Field("Converted_Amount")
    private Double Converted_Amount;

    public TransactionAPI(String toCurrency,String fromCurrency,Double Amount, Double Converted_Amount) {
        this.toCurrency = toCurrency;
        this.fromCurrency=fromCurrency;
        this.Amount=Amount;
        this.Converted_Amount=Converted_Amount;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }

    public Double getConverted_Amount() {
        return Converted_Amount;
    }

    public void setConverted_Amount(Double converted_Amount) {
        Converted_Amount = converted_Amount;
    }

}
