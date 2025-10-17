package skode.web.innovations.apexConstruction.innovations.apexConstruction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.*;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.service.BillService;

@RestController
@RequestMapping("/api/bills")
@CrossOrigin(origins = "*")
public class BillController {

    @Autowired
    private BillService billService;

    private static final String UPLOAD_DIR = "uploads/";

    @PostMapping("/upload/{expenseId}")
    public Bill uploadBill(@PathVariable Long expenseId, @RequestParam("file") MultipartFile file) throws IOException {
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
        Files.write(path, file.getBytes());

        Expense expense = new Expense();
        expense.setExpenseId(expenseId);

        Bill bill = new Bill();
        bill.setFileName(file.getOriginalFilename());
        bill.setFilePath(path.toString());
        bill.setExpense(expense);

        return billService.addBill(bill);
    }

    @GetMapping("/all")
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }

    @GetMapping("/byExpense/{expenseId}")
    public List<Bill> getBillsByExpense(@PathVariable Long expenseId) {
        Expense expense = new Expense();
        expense.setExpenseId(expenseId);
        return billService.getBillsByExpense(expense);
    }

    @DeleteMapping("/{id}")
    public String deleteBill(@PathVariable Long id) {
        billService.deleteBill(id);
        return "Bill deleted successfully!";
    }
}
