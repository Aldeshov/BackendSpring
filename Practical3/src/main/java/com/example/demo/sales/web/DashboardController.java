package com.example.demo.sales.web;


import com.example.demo.models.PlantInventoryEntry;
import com.example.demo.models.dto.CatalogQueryDTO;
import com.example.demo.models.dto.PurchaseOrderDTO;
import com.example.demo.models.enums.POStatus;
import com.example.demo.repositories.PlantInventoryEntryRepository;
import com.example.demo.repositories.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    PlantInventoryEntryRepository plantInventoryEntryRepository;

    @GetMapping("/catalog/form")
    public String getQueryForm(Model model) {
        model.addAttribute("catalogQuery", new CatalogQueryDTO());
        return "dashboard/catalog/query-form";
    }

    @PostMapping(value = "/catalog/query")
    public String getQueryResult(Model model, CatalogQueryDTO catalogQueryDTO) {
        List<PlantInventoryEntry> plants = plantInventoryEntryRepository.findByNameContaining(catalogQueryDTO.getName());
        PurchaseOrderDTO po = new PurchaseOrderDTO();
        po.setRentalPeriod(catalogQueryDTO.getRentalPeriod());
        model.addAttribute("plants", plants);
        model.addAttribute("po", po);
        return "dashboard/catalog/query-result";
    }

    @PostMapping(value = "/orders")
    public String createPO(Model model, PurchaseOrderDTO po) {
        PlantInventoryEntry plant = plantInventoryEntryRepository.findOne(po.getPlant().getId());
        int days = (int) ChronoUnit.DAYS.between(po.getRentalPeriod().getStartDate(), po.getRentalPeriod().getEndDate());
        po.setTotal(BigDecimal.valueOf((long) plant.getPrice().intValue() * (days + 1)));
        po.setStatus(POStatus.OPEN);

        model.addAttribute("po", po);
        return "dashboard/catalog/query-order";
    }
}