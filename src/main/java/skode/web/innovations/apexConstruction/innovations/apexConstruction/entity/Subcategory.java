package skode.web.innovations.apexConstruction.innovations.apexConstruction.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "subcategories")
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subcategoryId;

    private String subcategoryName;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "subcategory", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Expense> expenses = new ArrayList<>();

    private Date createdAt = new Date();

    // Getters and Setters
    public Long getSubcategoryId() { return subcategoryId; }
    public void setSubcategoryId(Long subcategoryId) { this.subcategoryId = subcategoryId; }

    public String getSubcategoryName() { return subcategoryName; }
    public void setSubcategoryName(String subcategoryName) { this.subcategoryName = subcategoryName; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public List<Expense> getExpenses() { return expenses; }
    public void setExpenses(List<Expense> expenses) { this.expenses = expenses; }
}
