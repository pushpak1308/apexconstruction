package skode.web.innovations.apexConstruction.innovations.apexConstruction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.*;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.repository.SubcategoryRepository;

@Service
public class SubcategoryService {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    public Subcategory addSubcategory(Subcategory subcategory) {
        return subcategoryRepository.save(subcategory);
    }

    public List<Subcategory> getSubcategoriesByCategory(Category category) {
        return subcategoryRepository.findByCategory_CategoryId(category.getCategoryId());
    }

    public List<Subcategory> getAllSubcategories() {
        return subcategoryRepository.findAll();
    }

    public void deleteSubcategory(Long id) {
        subcategoryRepository.deleteById(id);
    }
}
