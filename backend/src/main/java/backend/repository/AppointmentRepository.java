package backend.repository;

import backend.entity.Appointment;
import backend.entity.Doctor;
import backend.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository
        extends JpaRepository<Appointment, Long> {

    List<Appointment> findByDoctor(Doctor doctor);

    List<Appointment> findByPatient(Patient patient);

    List<Appointment> findByAppointmentTimeBetween(
            LocalDateTime start,
            LocalDateTime end
    );
}