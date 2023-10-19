package com.commerz.dvadnyvtahu.ai.service;

import com.commerz.dvadnyvtahu.ai.domain.Test;
import com.commerz.dvadnyvtahu.ai.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SomethingService {

    @Autowired
    private TestRepository testRep;

    static List<Test> tests = new ArrayList<Test>();
    static long id = 0;

    public List<Test> findAll() {
        return testRep.findAll();
    }

    public Test save(Test test) {
        return testRep.save(test);
    }
}