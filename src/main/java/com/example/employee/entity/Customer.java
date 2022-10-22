package com.example.employee.entity;


        import lombok.*;

        import javax.persistence.Entity;
        import javax.persistence.GeneratedValue;
        import javax.persistence.GenerationType;
        import javax.persistence.Id;
        import java.util.Date;

@ToString
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long empId;
    private String firstName;
    private String lastName;



}