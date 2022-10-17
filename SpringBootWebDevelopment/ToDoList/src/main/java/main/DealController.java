package main;

import main.model.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.model.Deal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DealController {

    @Autowired
    private DealRepository dealRepository;

    @GetMapping("/deals/")
    public List<Deal> list() {

        Iterable<Deal> dealIterable = dealRepository.findAll();
        ArrayList<Deal> deals = new ArrayList<>();
        for (Deal deal : dealIterable) {
            deals.add(deal);
        }
        return deals;
    }

    @GetMapping("/deals/{id}")
    public ResponseEntity get(@PathVariable int id) {

        Optional<Deal> optionalDeal = dealRepository.findById(id);
        if (!optionalDeal.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(optionalDeal.get(), HttpStatus.OK);
    }

    @PostMapping("/deals/")
    public int add(Deal deal) {
        Deal newDeal = dealRepository.save(deal);
        return newDeal.getId();
    }

    @PostMapping("/deals/{id}")
    public ResponseEntity add(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
    }

    @PutMapping("/deals/")
    public ResponseEntity replaceList(List<Deal> deals) {
        if (deals == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        for (Deal deal : deals) {
            Optional<Deal> optionalDeal = dealRepository.findById(deal.getId());
            if (!optionalDeal.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            Deal updateDeal = optionalDeal.get();
            updateDeal.setName(deal.getName());
            updateDeal.setLastDate(deal.getLastDate());
            updateDeal.setNumberSheets(deal.getNumberSheets());
            dealRepository.save(updateDeal);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/deals/{dealId}")
    public ResponseEntity replaceDeal(@PathVariable int dealId, Deal newDeal) {
        Optional<Deal> optionalDeal = dealRepository.findById(dealId);
        if (!optionalDeal.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Deal deal = optionalDeal.get();
        deal.setName(newDeal.getName());
        deal.setLastDate(newDeal.getLastDate());
        deal.setNumberSheets(newDeal.getNumberSheets());
        dealRepository.save(deal);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deals/")
    public void removeDeals() {
        dealRepository.deleteAll();
    }

    @DeleteMapping("/deals/{id}")
    public ResponseEntity removeDeal(@PathVariable int id) {

        Optional<Deal> optionalDeal = dealRepository.findById(id);
        if (!optionalDeal.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        dealRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
