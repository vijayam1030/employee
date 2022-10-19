package com.example.employee.entity;


        import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.Setter;

        import javax.persistence.Entity;
        import javax.persistence.GeneratedValue;
        import javax.persistence.GenerationType;
        import javax.persistence.Id;
        import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long empId;
    private String firstName;
    private String lastName;

    private String depId;
    private Date joiningDate;
    private int salary;

    protected Customer() {}


    @Override
    public String toString() {
        return "Customer{" +
                "empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", depId='" + depId + '\'' +
                ", joiningDate=" + joiningDate +
                ", salary='" + salary + '\'' +
                '}';
    }
}