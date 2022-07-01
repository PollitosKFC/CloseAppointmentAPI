package pe.edu.upc.closeappointmentapi.EasyJobs.unit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.AppointmentHistory;
import pe.edu.upc.closeappointmentapi.EasyJobs.repository.AppointmentHistoryRepository;
import pe.edu.upc.closeappointmentapi.EasyJobs.repository.AppointmentRepository;
import pe.edu.upc.closeappointmentapi.EasyJobs.service.AppointmentCloseService;
import pe.edu.upc.closeappointmentapi.EasyJobs.service.AppointmentCloseServiceImpl;

import javax.validation.constraints.Null;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class AppointmentCloseServiceImplTest {
    @MockBean
    private AppointmentHistoryRepository appointmentHistoryRepository;
    @MockBean
    private AppointmentCloseService appointmentCloseService;
    @MockBean
    private AppointmentRepository appointmentRepository;

    @TestConfiguration
    class AppointmentCloseServiceImplTestConfiguration {
        @Bean
        public AppointmentCloseService appointmentCloseService(){return new AppointmentCloseServiceImpl(appointmentRepository,appointmentHistoryRepository);}
    }

    @Test
    @DisplayName("When created AppointmentClose with valid data then return AppointmentClose")
    public void WhenCreatedCustomerWithValidDataThenReturnCustomer() {
        // Arrange
        AppointmentHistory appointmentClose = new AppointmentHistory();
        appointmentClose.setId(1L);
        appointmentClose.setFinishDate(null);
        appointmentClose.setQualification(1.5);
        appointmentClose.setQualificationComment("QualificationComment");
        long appointmentId = 1;
        when(appointmentHistoryRepository.save(appointmentClose)).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        AppointmentHistory appointmentResult = appointmentCloseService.createAppointmentHistory(appointmentClose,appointmentId);

        // Assert
        assertThat(appointmentResult).isEqualTo(appointmentHistoryRepository.getById(1L));
    }
    @Test
    @DisplayName("When Delete AppointmentClose With Valid AppointmentClose")
    public void WhenDeleteTechnicianWithValidTechnician() {
        // Arrange
        AppointmentHistory appointmentClose = new AppointmentHistory();
        appointmentClose.setId(1L);
        appointmentClose.setFinishDate(null);
        appointmentClose.setQualification(1.5);
        appointmentClose.setQualificationComment("QualificationComment");

        when(appointmentHistoryRepository.save(appointmentClose)).thenAnswer(invocation -> invocation.getArgument(0));
        appointmentHistoryRepository.deleteById(1L);
        // Act
        AppointmentHistory appointmentCloseResult = null;
        // Assert
        assertThat(appointmentCloseResult).isEqualTo(appointmentHistoryRepository.getById(1L));
    }
}
