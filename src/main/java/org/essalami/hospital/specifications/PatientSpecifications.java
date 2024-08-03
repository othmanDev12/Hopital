package org.essalami.hospital.specifications;

import org.essalami.hospital.entities.Patient;
import org.springframework.data.jpa.domain.Specification;

public class PatientSpecifications {
    public static Specification<Patient> scoreBetween(double min, double max) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.between(root.get("score"), min, max);
    }
}
