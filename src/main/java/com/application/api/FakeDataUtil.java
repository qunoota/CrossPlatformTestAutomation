package com.application.api;
import com.github.javafaker.Faker;
import java.util.concurrent.atomic.AtomicInteger;

public class FakeDataUtil {
    private static final Faker faker = new Faker();
    private static final AtomicInteger idCounter = new AtomicInteger();

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static int getUniqueId() {
        return idCounter.incrementAndGet();
    }
}
