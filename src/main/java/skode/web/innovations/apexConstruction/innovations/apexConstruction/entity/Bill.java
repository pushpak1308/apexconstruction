package skode.web.innovations.apexConstruction.innovations.apexConstruction.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    private String fileName;
    private String filePath;
    private LocalDate uploadDate = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "expense_id")
    private Expense expense;

    // Getters and Setters
    public Long getBillId() { return billId; }
    public void setBillId(Long billId) { this.billId = billId; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }

    public LocalDate getUploadDate() { return uploadDate; }
    public void setUploadDate(LocalDate uploadDate) { this.uploadDate = uploadDate; }

    public Expense getExpense() { return expense; }
    public void setExpense(Expense expense) { this.expense = expense; }
}
