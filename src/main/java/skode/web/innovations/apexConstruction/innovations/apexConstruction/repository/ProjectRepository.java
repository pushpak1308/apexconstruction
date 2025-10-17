package skode.web.innovations.apexConstruction.innovations.apexConstruction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
