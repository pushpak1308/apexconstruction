package skode.web.innovations.apexConstruction.innovations.apexConstruction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.Project;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.ProjectGroup;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.repository.ProjectGroupRepository;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.repository.ProjectRepository;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.dto.ProjectGroupRequest;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@CrossOrigin(origins = "*")
public class ProjectGroupController {

    @Autowired
    private ProjectGroupRepository projectGroupRepository;

    @Autowired
    private ProjectRepository projectRepository;

    // ✅ Get all groups for a project
    @GetMapping("/byProject/{projectId}")
    public List<ProjectGroup> getGroupsByProject(@PathVariable Long projectId) {
        return projectGroupRepository.findByProject_ProjectId(projectId);
    }

    // ✅ Add new group
    @PostMapping("/add")
    public ProjectGroup addGroup(@RequestBody ProjectGroupRequest request) {
        if (request.getProjectId() == null) {
            throw new IllegalArgumentException("Project ID cannot be null for a group");
        }

        Project project = projectRepository.findById(request.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found"));

        ProjectGroup group = new ProjectGroup();
        group.setGroupName(request.getGroupName());
        group.setProject(project);

        return projectGroupRepository.save(group);
    }
}
