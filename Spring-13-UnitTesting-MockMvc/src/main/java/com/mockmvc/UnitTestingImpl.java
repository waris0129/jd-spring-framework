package com.mockmvc;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class UnitTestingImpl {

    private DataRepository dataRepository;

    public UnitTestingImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public UnitTestingImpl() {

    }

    public int calculateSum(int[] date){
        int sum =0;
        return Arrays.stream(date).sum();
    }

    public int calculateSumUsingDataService(){
        int sum =0;
        return Arrays.stream(dataRepository.findAll()).sum();
    }


    public int calculateSumUsingDataService_Parameter(){
        return Arrays.stream(dataRepository.findById(2)).sum();
    }


}
