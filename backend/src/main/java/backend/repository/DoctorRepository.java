package backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}