package rentcar.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import rentcar.PointApplication;
import rentcar.domain.PoinrIncreased;
import rentcar.domain.PointDecreased;

@Entity
@Table(name = "Point_table")
@Data
//<<< DDD / Aggregate Root
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @PostPersist
    public void onPostPersist() {
        PoinrIncreased poinrIncreased = new PoinrIncreased(this);
        poinrIncreased.publishAfterCommit();

        PointDecreased pointDecreased = new PointDecreased(this);
        pointDecreased.publishAfterCommit();
    }

    public static PointRepository repository() {
        PointRepository pointRepository = PointApplication.applicationContext.getBean(
            PointRepository.class
        );
        return pointRepository;
    }

    //<<< Clean Arch / Port Method
    public static void increasePoint(Reserved reserved) {
        //implement business logic here:

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        PoinrIncreased poinrIncreased = new PoinrIncreased(point);
        poinrIncreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(reserved.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);

            PoinrIncreased poinrIncreased = new PoinrIncreased(point);
            poinrIncreased.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
