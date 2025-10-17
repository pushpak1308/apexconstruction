package skode.web.innovations.apexConstruction.innovations.apexConstruction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.*;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getCategoriesByGroup(ProjectGroup group) {
        return categoryRepository.findByGroup_GroupId(group.getGroupId());
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
