package com.zhukovsd.alfabattle.task2.payments;

import com.zhukovsd.alfabattle.task2.analytics.UsersAnalytics;
import com.zhukovsd.alfabattle.task2.payments.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentsKafkaConsumer {

    @Autowired
    UsersAnalytics analytics;

    @KafkaListener(
            topicPartitions = @TopicPartition(
                    topic = "RAW_PAYMENTS", partitionOffsets = {@PartitionOffset(partition = "0", initialOffset = "0")}
            ), groupId = "foo",
            containerFactory = "paymentKafkaListenerContainerFactory"
    )
    public void paymentsListener(List<Payment> payments) throws InterruptedException {
        System.out.println(payments.size() + " items read");

//        payments.forEach(payment -> analytics.processPayment(payment));

        for (Payment payment : payments) {
            if (payment != null) {
                analytics.processPayment(payment);
            } else {
                System.out.println("null");
            }
        }

        System.out.println("Payments processed");

//        Thread.sleep(10000);

//        items.addAll(greetings);
//
//        lock.countDown();


//        System.out.println("Async received greeting message: " + greeting);
    }

}
