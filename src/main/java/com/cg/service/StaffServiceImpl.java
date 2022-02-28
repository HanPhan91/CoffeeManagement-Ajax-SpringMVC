package com.cg.service;

import com.cg.model.Staff;
import com.cg.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffRepository staffRepository;


    @Override
    public List<Staff> findAll() {
        return null;
    }

    @Override
    public Optional<Staff> findById(Long id) {
        return staffRepository.findById(id);
    }

    @Override
    public Staff getById(Long id) {
        return null;
    }

    @Override
    public Staff save(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void deleteDrinkById(Long id) {
        staffRepository.deleteDrinkById(id);
    }

    @Override
    public List<Staff> findAllNotDeleted() {
        return staffRepository.findAllNotDeleted();
    }

    @Override
    public Integer countStaff() {
        return staffRepository.countStaff();
    }

    @Override
    public List<Staff> findAllDeleted() {
        return staffRepository.findAllDeleted();
    }
}
