package com.commerz.dvadnyvtahu.ai.repository;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class CategoryRepository {

    private static final Map<String, String> CATEGORY_PROMOPT_MAP = Map.ofEntries(
        new AbstractMap.SimpleEntry<>("vacation",
            "give me 5 most favourite vacation destinations in CSV format without numbers")
    );

    public String getCategoryPrompt() {
        return CATEGORY_PROMOPT_MAP.get("vacation");
    }

}
