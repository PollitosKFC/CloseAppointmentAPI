package pe.edu.upc.closeappointmentapi.EasyJobs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="tbl_appointment_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Date finishDate;

    @Column(unique = true)
    private Integer qualification;

    @Column(unique = true, length = 200)
    private String qualificationComment;

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "appointment_id",unique = true)
    private Appointment appointment;

}
