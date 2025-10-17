package skode.web.innovations.apexConstruction.innovations.apexConstruction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.Category;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.Project;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.ProjectGroup;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.repository.CategoryRepository;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.repository.ProjectGroupRepository;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.dto.CategoryRequest;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.repository.ProjectRepository;

import java.util.List;


@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProjectGroupRepository groupRepository;
    @Autowired
    private ProjectRepository projectRepo;

    @PostMapping("/add")
    public Category addCategory(@RequestBody CategoryRequest request) {
        ProjectGroup group = groupRepository.findById(request.getGroupId())
                .orElseThrow(() -> new RuntimeException("Group not found"));

        Category category = new Category();
        category.setCategoryName(request.getCategoryName());
        category.setGroup(group);
        return categoryRepository.save(category);
    }

    // Get categories for a specific group
    @GetMapping("/byGroup/{groupId}")
    public List<Category> getCategoriesByGroup(@PathVariable Long groupId) {
        return categoryRepository.findByGroup_GroupId(groupId);
    }

    // Get categories for a specific project (across all its groups)
    @GetMapping("/byProject/{projectId}")
    public List<Category> getCategoriesByProject(@PathVariable Long projectId) {
        List<ProjectGroup> groups = groupRepository.findByProject_ProjectId(projectId);
        if (groups.isEmpty()) return List.of();
        List<Long> groupIds = groups.stream().map(ProjectGroup::getGroupId).toList();
        return categoryRepository.findByGroup_GroupIdIn(groupIds);
    }
}

