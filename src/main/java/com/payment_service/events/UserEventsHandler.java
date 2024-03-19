package com.payment_service.events;

import com.core.model.PaymentDetails;
import com.core.model.User;
import com.core.query.FetchUserPaymentDetailsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class UserEventsHandler {

    @QueryHandler
    public User getUserPaymentDetails(FetchUserPaymentDetailsQuery fetchUserPaymentDetailsQuery){
        User userRest = User.builder()
                .firstName("Sergey")
                .lastName("Kargopolov")
                .userId(fetchUserPaymentDetailsQuery.getUserId())
                .paymentDetails(PaymentDetails.builder()
                        .cardNumber("123Card")
                        .cvv("123")
                        .name("SERGEY KARGOPOLOV")
                        .validUntilMonth(12)
                        .validUntilYear(2030)
                        .build())
                .build();
        return userRest;
    }
}
