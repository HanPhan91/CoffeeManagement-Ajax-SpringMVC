package com.cg.controller.api;


import com.cg.exception.DataInputException;
import com.cg.model.Drink;
import com.cg.model.Staff;
import com.cg.service.DrinkService;
import com.cg.service.StaffService;
import com.cg.utils.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/staffs")
public class StaffRestController {
    @Autowired
    private StaffService staffService;

    @Autowired
    private AppUtil appUtil;

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getById(@PathVariable Long id) {
        Optional<Staff> staff = staffService.findById(id);
        if (staff.isPresent()) {
            return new ResponseEntity<>(staff.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping("/create")
    public ResponseEntity<?> doCreate(@Validated @RequestBody Staff staff,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return appUtil.mapErrorToResponse(bindingResult);
        } else {
            staff.setId(0L);
            Staff createStaff = staffService.save(staff);
            return new ResponseEntity<>(createStaff, HttpStatus.CREATED);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> doUpdate(@Validated @RequestBody Staff staff,
                                      BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return appUtil.mapErrorToResponse(bindingResult);
        }
        Long id = staff.getId();
        Optional<Staff> optionalStaff = staffService.findById(id);
        if (optionalStaff.isPresent()) {
            staffService.save(staff);
            Optional<Staff> updateStaff = staffService.findById(id);
            return new ResponseEntity<>(updateStaff.get(), HttpStatus.OK);
        } else {
            throw new DataInputException("Staff's not valid");
        }

    }

    @PutMapping("/delete")
    public ResponseEntity<?> doDelete(@RequestBody Staff staff) {
        Optional opStaff = staffService.findById(staff.getId());
        if (opStaff.isPresent()) {
            staffService.deleteDrinkById(staff.getId());
            return new ResponseEntity<>(opStaff.get(), HttpStatus.OK);
        } else {
            throw new DataInputException("Customer's not valid");
        }
    }


}
