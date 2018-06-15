/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.transasia.mvnproject1.service.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import ru.transasia.mvnproject1.entities.Part;
import ru.transasia.mvnproject1.repository.PartRepository;
import ru.transasia.mvnproject1.repository.specification.PartSpecification;
import ru.transasia.mvnproject1.service.PartService;

/**
 *
 * @author banashko.dv
 */
@Service
public class PartServiceImpl implements PartService {
    
    @Autowired
    protected PartRepository partRepository;
    
    @Autowired
    PartSpecification partSpecification;
    
    @Override
    public Part findById(Integer id) {
        Part part = partRepository.getOne(id);
        return part;
    }

    @Override
    public Part insert(Part part) {
        return partRepository.save(part);
    }

    @Override
    public void deleteById(Integer id) {
        partRepository.deleteById(id);
    }

    @Override
    public List<Part> findAll(Boolean sortingOrder, String sortByColumn) {
        String sortingOrderAsString;
        
        if (!sortingOrder) sortingOrderAsString = "ASC";
        else sortingOrderAsString = "DESC";
        return partRepository.findAll(new Sort(Sort.Direction.fromString(sortingOrderAsString), sortByColumn));
    }

    @Override
    public List<Part> findAll() {
        return partRepository.findAll();
    }

    @Override
    public List<Part> findAllByFilter(String partNumber, String partName, String vendor, int qty, String sortBy, String sortingOrder) {
        
        return partRepository.findAll(Specification
                .where(partSpecification.hasQtyEqualToOrMoreThan(qty))
                .and(partSpecification.hasPartNumberLike("%"+partNumber+"%"))
                .and(partSpecification.hasPartNameLike("%"+partName+"%"))
                .and(partSpecification.hasVendorLike("%"+vendor+"%")), new Sort(Sort.Direction.fromString(sortingOrder), sortBy));
        
    }

    @Override
    public List<Part> findByVendor(String vendor) {
        return partRepository.findByVendor(vendor);
    }
    
    
}
