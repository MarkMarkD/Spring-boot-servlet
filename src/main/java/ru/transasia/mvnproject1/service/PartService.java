/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.transasia.mvnproject1.service;

import java.util.List;
import ru.transasia.mvnproject1.entities.Part;

/**
 *
 * @author banashko.dv
 */
public interface PartService {
    
    Part findById(Integer id);
    Part insert(Part part);
    void deleteById(Integer id);
    List<Part> findAll();
    List<Part> findAll(Boolean sortingOrder, String sortBy);
    List<Part> findByVendor(String vendor);
    List<Part> findAllByFilter(String partNumber, String partName, String vendor, int qty, String sortBy, String sortingOrder);
    
}
