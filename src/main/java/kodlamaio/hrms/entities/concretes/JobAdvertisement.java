package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "job_advertisement")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "job_detail")
    private String jobDetail;

    //@Column(name = "employer_id")
    //private int employerId;

    @Column(name = "number_of_open_positions")
    private int numberOfOpenPositions;

    @Column(name = "min_salary")
    private String minSalary;

    @Column(name = "max_salary")
    private String maxSalary;

    @Column(name = "created_date")
    private Date createdDate;

    //@Column(name = "job_position_id")
    //private int jobPositionId;

    //@Column(name = "city_id")
    //private int cityId;

    @Column(name = "status")
    private boolean status;

    @Column(name = "application_deadline")
    private Date applicationDeadline;

    @ManyToOne()
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;
}
