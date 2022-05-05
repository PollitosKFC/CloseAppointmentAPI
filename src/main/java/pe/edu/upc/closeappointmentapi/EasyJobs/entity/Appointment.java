package pe.edu.upc.closeappointmentapi.EasyJobs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="tbl_appointment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Date createdDate;

    @Column(unique = true)
    private Date updateDate;

    @Column(unique = true, length = 200)
    private String status;

    @Column(unique = true)
    private Date startDate;

    @Column(unique = true)
    private boolean delete;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "technician_id",unique = true)
    private Technician technician;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id",unique = true)
    private Customer customer;

    @OneToOne(mappedBy = "appointment",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AppointmentHistory appointment_history;

}