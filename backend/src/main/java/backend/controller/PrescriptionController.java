package backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    @PostMapping("/save")
    public ResponseEntity<?> savePrescription(
            @RequestHeader("token") String token,
            @RequestBody String prescription
    ) {

        if (token == null || token.isEmpty()) {

            return ResponseEntity.badRequest()
                    .body("Invalid token");
        }

        return ResponseEntity.ok(
                "Prescription saved successfully"
        );
    }
}