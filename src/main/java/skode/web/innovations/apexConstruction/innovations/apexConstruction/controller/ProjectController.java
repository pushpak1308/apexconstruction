package skode.web.innovations.apexConstruction.innovations.apexConstruction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.Project;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/add")
    public Project addProject(@RequestBody Project project) {
        return projectService.addProject(project);
    }

    @GetMapping("/all")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return "Project deleted successfully!";
    }
}
