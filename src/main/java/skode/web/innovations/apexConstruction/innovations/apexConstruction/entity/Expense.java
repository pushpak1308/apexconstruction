package skode.web.innovations.apexConstruction.innovations.apexConstruction.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity

@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;

    private String billPath; // store uploaded file path

    public String getBillPath() {
        return billPath;
    }

    public void setBillPath(String billPath) {
        this.billPath = billPath;
    }

    public String getGstRequired() {
        return gstRequired;
    }

    public void setGstRequired(String gstRequired) {
        this.gstRequired = gstRequired;
    }

    private String gstRequired;


    private double amount;
    private boolean gstIncluded;

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(Double taxPercent) {
        this.taxPercent = taxPercent;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getReconciliationStatus() {
        return reconciliationStatus;
    }

    public void setReconciliationStatus(String reconciliationStatus) {
        this.reconciliationStatus = reconciliationStatus;
    }

    private String invoiceNumber;
    private String vendor;
    @Column(length = 1000)
    private String description;
    private Integer quantity;
    private Double taxPercent;
    private Double taxAmount;
    private Double totalAmount;
    private String paymentMethod;
    @Column(length = 500)
    private String remarks;
    private String reconciliationStatus;

    public Long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isGstIncluded() {
        return gstIncluded;
    }

    public void setGstIncluded(boolean gstIncluded) {
        this.gstIncluded = gstIncluded;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public ProjectGroup getGroup() {
        return group;
    }

    public void setGroup(ProjectGroup group) {
        this.group = group;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    private LocalDate expenseDate;

    // ✅ Relationship to Person
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    // ✅ Relationship to Subcategory
    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;

    // ✅ Relationship to Category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // ✅ Relationship to Group
    @ManyToOne
    @JoinColumn(name = "group_id")
    private ProjectGroup group;

    // ✅ Relationship to Project
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    // ✅ Optional: linked bill
    @OneToOne(mappedBy = "expense", cascade = CascadeType.ALL)
    private Bill bill;
}
