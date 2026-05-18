package backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.entity.Patient;
import backend.repository.PatientRepository;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/register")
    public Patient registerPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @GetMapping("/all")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}