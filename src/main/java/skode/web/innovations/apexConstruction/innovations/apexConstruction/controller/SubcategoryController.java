package skode.web.innovations.apexConstruction.innovations.apexConstruction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.dto.SubcategoryRequest;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.Subcategory;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.Category;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.repository.SubcategoryRepository;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.repository.CategoryRepository;

import java.util.List;

@RestController
@RequestMapping("/api/subcategories")
@CrossOrigin(origins = "*")
public class SubcategoryController {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // ✅ Add new subcategory
    @PostMapping("/add")
    public Subcategory addSubcategory(@RequestBody SubcategoryRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Subcategory subcategory = new Subcategory();
        subcategory.setSubcategoryName(request.getSubcategoryName());
        subcategory.setCategory(category);

        return subcategoryRepository.save(subcategory);
    }

    // ✅ Get subcategories by category
    @GetMapping("/byCategory/{categoryId}")
    public List<Subcategory> getSubcategoriesByCategory(@PathVariable Long categoryId) {
        return subcategoryRepository.findByCategory_CategoryId(categoryId);
    }
}
