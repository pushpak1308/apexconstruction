package skode.web.innovations.apexConstruction.innovations.apexConstruction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.Category;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.Project;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByGroup_GroupId(Long group);

    List<Category> findByGroup_GroupIdIn(List<Long> groupIds);
}