package rentcar.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import rentcar.config.kafka.KafkaProcessor;
import rentcar.domain.*;

@Service
public class MyPagesViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MyPagesRepository myPagesRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserved_then_CREATE_1(@Payload Reserved reserved) {
        try {
            if (!reserved.validate()) return;

            // view 객체 생성
            MyPages myPages = new MyPages();
            // view 객체에 이벤트의 Value 를 set 함
            // view 레파지 토리에 save
            myPagesRepository.save(myPages);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
