package com.tln.todoapptemplate.util;

import org.apache.commons.lang3.RandomStringUtils;

public class DataGenerator {

    public static String generateTodoName() {
        return RandomStringUtils.randomAlphanumeric(5);
    }
}
