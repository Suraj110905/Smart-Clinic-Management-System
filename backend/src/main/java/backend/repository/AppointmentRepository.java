package backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}