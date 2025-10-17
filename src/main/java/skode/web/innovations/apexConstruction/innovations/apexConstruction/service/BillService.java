package skode.web.innovations.apexConstruction.innovations.apexConstruction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.entity.*;
import skode.web.innovations.apexConstruction.innovations.apexConstruction.repository.BillRepository;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public Bill addBill(Bill bill) {
        return billRepository.save(bill);
    }

    public List<Bill> getBillsByExpense(Expense expense) {
        return billRepository.findByExpense(expense);
    }

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public void deleteBill(Long id) {
        billRepository.deleteById(id);
    }
}
