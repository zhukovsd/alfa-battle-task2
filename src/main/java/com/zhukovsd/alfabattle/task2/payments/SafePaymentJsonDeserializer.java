package com.zhukovsd.alfabattle.task2.payments;

import com.zhukovsd.alfabattle.task2.payments.model.Payment;
import org.apache.kafka.common.header.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

class SafePaymentJsonDeserializer extends JsonDeserializer<Payment> {

    private Logger logger = LoggerFactory.getLogger(KafkaConsumerConfig.class);

    @Override
    public Payment deserialize(String topic, byte[] data) {
        try {
            return super.deserialize(topic, data);
        } catch (Exception e) {
            this.logger.error(String.format("Failed to deserialize, data = %s", new String(data)));

            return null;
        }
    }

    @Override
    public Payment deserialize(String topic, Headers headers, byte[] data) {
        try {
            return super.deserialize(topic, headers, data);
        } catch (Exception e) {
            this.logger.error(String.format("Failed to deserialize, data = %s", new String(data)));

            return null;
        }
    }
}
