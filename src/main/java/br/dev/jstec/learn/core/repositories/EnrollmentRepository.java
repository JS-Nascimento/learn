package br.dev.jstec.learn.core.repositories;

import br.dev.jstec.learn.core.model.Enrollment;
import br.dev.jstec.learn.core.model.pk.EnrollmentPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPK> {
}
