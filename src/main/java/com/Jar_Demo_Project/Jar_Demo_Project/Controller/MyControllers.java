package com.Jar_Demo_Project.Jar_Demo_Project.Controller;


import com.Jar_Demo_Project.Jar_Demo_Project.Modules.TransactionAPI;
import com.Jar_Demo_Project.Jar_Demo_Project.Repository.TransactionInterface;
import com.Jar_Demo_Project.Jar_Demo_Project.Services.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Requests")
public class MyControllers {


    @Bean
    public RestClient.Builder restClientBuilder() {
        return RestClient.builder();
    }

    @Autowired
    public TransactionInterface TI;
    @Autowired
    public ConverterService Cs;

    @GetMapping("/getTransactions")
    public ResponseEntity<?> getTransactions() {
        try {
            List<TransactionAPI> transactions = this.TI.findAll();
            return ResponseEntity.ok(transactions);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving transactions"+ e.getMessage());
        }
    }


    @PostMapping("/postData")
    public ResponseEntity<?> addData(@RequestParam String to, @RequestParam String from, @RequestParam Double amount) {
        if (Cs == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ConvertService is not initialized");
        }

        double ConvertAmount;
        try {
            ConvertAmount = Cs.Convert(to, from, amount);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting amount");
        }

        TransactionAPI t2 = new TransactionAPI(to, from, amount, ConvertAmount);
        TransactionAPI t3 = this.TI.save(t2);
        return ResponseEntity.ok("Transaction saved successfully");
    }

}
