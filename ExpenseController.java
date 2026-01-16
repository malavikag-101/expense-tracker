package com.example.expensetracker.controller;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    
    public String list(Model model) {
        model.addAttribute("expenses", service.getAllExpenses());
        model.addAttribute("total", service.getTotalAmount());
        return "list";
    }

    
    public String addForm(Model model) {
        model.addAttribute("expense", new Expense());
        return "add";
    }

    
    public String save( Expense expense) {
        service.saveExpense(expense);
        return "redirect:/";
    }

    
    public String delete(Long id) {
        service.deleteExpense(id);
        return "redirect:/";
    }
}
