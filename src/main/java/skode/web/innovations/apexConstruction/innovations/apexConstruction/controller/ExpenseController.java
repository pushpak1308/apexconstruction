package skode.web.innovations.apexConstruction.innovations.apexConstruction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.dto.ExpenseRequest;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.Expense;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.repository.*;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.dto.ExpenseRequest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "*")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectGroupRepository groupRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @GetMapping("/all")
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @PostMapping(value = "/add", consumes = {"multipart/form-data"})
    public Expense addExpense(@ModelAttribute ExpenseRequest request, @RequestParam(value = "billFile", required = false) MultipartFile billFile) throws IOException {
        Expense expense = new Expense();
        expense.setAmount(request.getAmount());
        expense.setExpenseDate(LocalDate.parse(request.getExpenseDate()));
        expense.setGstIncluded(request.isGstIncluded());
        expense.setGstRequired(request.getGstRequired());


        expense.setPerson(personRepository.findById(request.getPersonId())
                .orElseThrow(() -> new RuntimeException("Person not found")));

        expense.setProject(projectRepository.findById(request.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found")));

        expense.setGroup(groupRepository.findById(request.getGroupId())
                .orElseThrow(() -> new RuntimeException("Group not found")));

        expense.setCategory(categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found")));

        expense.setSubcategory(subcategoryRepository.findById(request.getSubcategoryId())
                .orElseThrow(() -> new RuntimeException("Subcategory not found")));

        expense.setInvoiceNumber(request.getInvoiceNumber());
        expense.setVendor(request.getVendor());
        expense.setDescription(request.getDescription());
        expense.setQuantity(request.getQuantity());
        expense.setTaxPercent(request.getTaxPercent());
        expense.setTaxAmount(request.getTaxAmount());
        expense.setTotalAmount(request.getTotalAmount());
        expense.setPaymentMethod(request.getPaymentMethod());
        expense.setRemarks(request.getRemarks());
        expense.setReconciliationStatus(request.getReconciliationStatus());

        if (billFile != null && !billFile.isEmpty()) {
            String uploadDir = "uploads/bills/";
            Files.createDirectories(Paths.get(uploadDir));
            String filePath = uploadDir + billFile.getOriginalFilename();
            billFile.transferTo(new File(filePath));
            expense.setBillPath(filePath);
        }


        return expenseRepository.save(expense);
    }

    // ✏️ Update an existing expense
    @PutMapping(value = "/update/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<Expense> updateExpense(
            @PathVariable Long id,
            @ModelAttribute ExpenseRequest request, @RequestParam(value = "billFile", required = false) MultipartFile billFile) throws IOException {

        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        expense.setAmount(request.getAmount());
        expense.setGstRequired(request.getGstRequired());
        expense.setExpenseDate(LocalDate.parse(request.getExpenseDate()));
        expense.setInvoiceNumber(request.getInvoiceNumber());
        expense.setVendor(request.getVendor());
        expense.setDescription(request.getDescription());
        expense.setQuantity(request.getQuantity());
        expense.setTaxPercent(request.getTaxPercent());
        expense.setTaxAmount(request.getTaxAmount());
        expense.setTotalAmount(request.getTotalAmount());
        expense.setPaymentMethod(request.getPaymentMethod());
        expense.setRemarks(request.getRemarks());
        expense.setReconciliationStatus(request.getReconciliationStatus());

        expense.setProject(projectRepository.findById(request.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found")));
        expense.setGroup(groupRepository.findById(request.getGroupId())
                .orElseThrow(() -> new RuntimeException("Group not found")));
        expense.setCategory(categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found")));
        expense.setSubcategory(subcategoryRepository.findById(request.getSubcategoryId())
                .orElseThrow(() -> new RuntimeException("Subcategory not found")));
        expense.setPerson(personRepository.findById(request.getPersonId())
                .orElseThrow(() -> new RuntimeException("Person not found")));

        if (billFile != null && !billFile.isEmpty()) {
            String uploadDir = "uploads/bills/";
            Files.createDirectories(Paths.get(uploadDir));
            String filePath = uploadDir + billFile.getOriginalFilename();
            billFile.transferTo(new File(filePath));
            expense.setBillPath(filePath);
        }

        Expense updatedExpense = expenseRepository.save(expense);
        return ResponseEntity.ok(updatedExpense);
    }


    // 🗑️ Delete an expense
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
        if (!expenseRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Expense not found ❌");
        }
        expenseRepository.deleteById(id);
        return ResponseEntity.ok("Expense deleted successfully ✅");
    }


}
