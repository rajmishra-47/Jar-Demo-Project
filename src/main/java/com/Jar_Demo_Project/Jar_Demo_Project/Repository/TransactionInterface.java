package com.Jar_Demo_Project.Jar_Demo_Project.Repository;

import com.Jar_Demo_Project.Jar_Demo_Project.Modules.TransactionAPI;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionInterface extends MongoRepository<TransactionAPI,String> {

}
