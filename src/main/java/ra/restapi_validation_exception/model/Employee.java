package ra.restapi_validation_exception.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "Employee")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long id;
    @Column(name = "emp_name",columnDefinition = "varchar(100)",nullable = false)
    private String name;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String phone;
    private String address;
    @CreationTimestamp
    private Date created;
    @Column(name = "emp_status")
    private boolean status;
}
