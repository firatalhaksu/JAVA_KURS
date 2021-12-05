package com.bilgeadam.threads.restaurant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class RestaurantTest {
    private Restaurant restaurant;
    private static final String [] orderTypes = new String[] {"Pizza", "Hamburger", "Salad"};

    @BeforeEach
    void setUp() {
        restaurant = new Restaurant(7);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,15})
    void acceptOrder(int avgCustomerSize) throws InterruptedException {
        ScheduledExecutorService customer = Executors.newScheduledThreadPool(avgCustomerSize, new CustomThreadFactory("Customer"));

        for (int i = 0; i < avgCustomerSize; i++) {
            customer.scheduleAtFixedRate(() -> restaurant.acceptOrder(getRandomOrder()), i, 10, TimeUnit.MILLISECONDS);
        }
        //customer.shutdown();
        customer.awaitTermination(1500, TimeUnit.MILLISECONDS);

        int res = restaurant.closeShop();
        Assertions.assertFalse(res > 0, String.format("Remaining order size is %d",res));
    }

    private String getRandomOrder(){
        return orderTypes[(int) Math.round(Math.random() * (orderTypes.length - 1))];
    }
}