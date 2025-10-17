package skode.web.innovations.apexConstruction.innovations.apexConstruction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.Project;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.repository.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
