package skode.web.innovations.apexConstruction.innovations.apexConstruction.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    private String personName;
    private String personType;
    private String contactNumber;
    private String email;
    private String gstNumber;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Expense> expenses = new ArrayList<>();

    // Getters and Setters
    public Long getPersonId() { return personId; }
    public void setPersonId(Long personId) { this.personId = personId; }

    public String getPersonName() { return personName; }
    public void setPersonName(String personName) { this.personName = personName; }

    public String getPersonType() { return personType; }
    public void setPersonType(String personType) { this.personType = personType; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getGstNumber() { return gstNumber; }
    public void setGstNumber(String gstNumber) { this.gstNumber = gstNumber; }

    public List<Expense> getExpenses() { return expenses; }
    public void setExpenses(List<Expense> expenses) { this.expenses = expenses; }
}
