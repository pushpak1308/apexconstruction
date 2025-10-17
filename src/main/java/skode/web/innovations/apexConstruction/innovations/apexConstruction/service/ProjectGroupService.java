package skode.web.innovations.apexConstruction.innovations.apexConstruction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.*;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.repository.ProjectGroupRepository;

@Service
public class ProjectGroupService {

    @Autowired
    private ProjectGroupRepository groupRepository;

    public ProjectGroup addGroup(ProjectGroup group) {
        return groupRepository.save(group);
    }

    public List<ProjectGroup> getGroupsByProject(Project project) {
        return groupRepository.findByProject_ProjectId(project.getProjectId());
    }

    public List<ProjectGroup> getAllGroups() {
        return groupRepository.findAll();
    }

    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }
}
