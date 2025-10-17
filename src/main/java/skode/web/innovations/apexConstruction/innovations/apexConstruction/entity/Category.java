package skode.web.innovations.apexConstruction.innovations.apexConstruction.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private ProjectGroup group;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Subcategory> subcategories = new ArrayList<>();

    private Date createdAt = new Date();

    // Getters and Setters
    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public ProjectGroup getGroup() { return group; }
    public void setGroup(ProjectGroup group) { this.group = group; }

    public List<Subcategory> getSubcategories() { return subcategories; }
    public void setSubcategories(List<Subcategory> subcategories) { this.subcategories = subcategories; }
}
