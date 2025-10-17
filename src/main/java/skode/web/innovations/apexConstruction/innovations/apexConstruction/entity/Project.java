package skode.web.innovations.apexConstruction.innovations.apexConstruction.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "projects")
@JsonIgnoreProperties({"groups"})  // 👈 Prevent infinite recursion
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    private String projectName;
    private String projectDescription;
    private LocalDate projectStartDate;
    private LocalDate projectEndDate;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProjectGroup> groups;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDate getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(LocalDate projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public LocalDate getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(LocalDate projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public List<ProjectGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<ProjectGroup> groups) {
        this.groups = groups;
    }
}
