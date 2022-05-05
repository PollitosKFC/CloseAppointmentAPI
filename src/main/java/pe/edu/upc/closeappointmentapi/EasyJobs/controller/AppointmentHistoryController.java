package pe.edu.upc.closeappointmentapi.EasyJobs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.closeappointmentapi.EasyJobs.entity.AppointmentHistory;
import pe.edu.upc.closeappointmentapi.EasyJobs.service.AppointmentCloseService;

import java.util.List;

@Slf4j
@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3306")
@RequestMapping(value ="/AppointmentHistory")
public class AppointmentHistoryController {

    @Autowired
    private AppointmentCloseService appointmentCloseService;

    @PostMapping("/createAppointmentHistory")
    public ResponseEntity<AppointmentHistory> createAppointmentHistory(@RequestBody AppointmentHistory appointmentHistory,
                                                                       @RequestParam(name = "appointmentId" ,required = false) Long appointmentId) {
        AppointmentHistory appointmentCreated = appointmentCloseService.createAppointmentHistory(appointmentHistory, appointmentId);
        return ResponseEntity.ok(appointmentCreated);
    }

    @GetMapping("/listAppointmentHistoryByAppointmentId")
    public ResponseEntity<List<AppointmentHistory>> ListAppointmentHistoriesByAppointmentId(@RequestParam(name = "appointmentId",required = false) Long appointmentId) {
        List<AppointmentHistory> appointmentHistories = appointmentCloseService.findAppointmentHistoriesByAppointmentId(appointmentId);
        if (appointmentHistories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(appointmentHistories);
    }

    @GetMapping("/listAppointmentHistoryByAppointmentIdAndStatus")
    public ResponseEntity<List<AppointmentHistory>> LisAppointmentHistoriesByTechnicianId (
            @RequestParam(name = "technicianId",required = false) Long technicianId) {
        List<AppointmentHistory> appointmentHistories = appointmentCloseService.findAppointmentHistoriesByTechnicianId(technicianId);
        if (appointmentHistories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(appointmentHistories);
    }

    @GetMapping("/listAppointmentHistoryByTechnicianId")
    public ResponseEntity<List<AppointmentHistory>> ListAppointmentHistoriesByCustomerId (
            @RequestParam(name = "customerId",required = false) Long customerId) {
        List<AppointmentHistory> appointmentHistories = appointmentCloseService.findAppointmentHistoriesByCustomerId(customerId);
        if (appointmentHistories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(appointmentHistories);
    }

    @GetMapping("/listAppointmentHistoryByTechnicianIdAndCustomerId")
    public ResponseEntity<List<AppointmentHistory>> ListAppointmentHistoriesByTechnicianIdAndCustomerId (
            @RequestParam(name = "technicianId",required = false) Long technicianId,
            @RequestParam(name = "customerId",required = false) Long customerId) {
        List<AppointmentHistory> appointmentHistories = appointmentCloseService.findAppointmentHistoriesByTechnicianIdAndCustomerId(technicianId, customerId);
        if (appointmentHistories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(appointmentHistories);
    }

    @GetMapping("/listAppointmentHistory")
    public ResponseEntity<AppointmentHistory> ListAppointmentHistoryById (
            @RequestParam(name = "id",required = false) Long id) {
        AppointmentHistory appointmentHistory = appointmentCloseService.findAppointmentHistoryById(id);
        if (appointmentHistory == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(appointmentHistory);
    }

    @GetMapping("/listAllAppointmentHistories")
    public ResponseEntity<List<AppointmentHistory>> ListAllAppointmentHistories () {
        List<AppointmentHistory> appointmentHistories = appointmentCloseService.findAllAppointmentHistories();
        if (appointmentHistories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(appointmentHistories);
    }

}
