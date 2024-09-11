package rentcar.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import rentcar.domain.*;
import rentcar.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PoinrIncreased extends AbstractEvent {

    private Long id;

    public PoinrIncreased(Point aggregate) {
        super(aggregate);
    }

    public PoinrIncreased() {
        super();
    }
}
//>>> DDD / Domain Event
