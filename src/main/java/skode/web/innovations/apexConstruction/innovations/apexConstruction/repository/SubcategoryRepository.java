package skode.web.innovations.apexConstruction.innovations.apexConstruction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.Subcategory;

import java.util.List;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    List<Subcategory> findByCategory_CategoryId(Long category);
}
