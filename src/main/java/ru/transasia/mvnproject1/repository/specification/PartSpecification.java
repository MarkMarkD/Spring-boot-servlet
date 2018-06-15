/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.transasia.mvnproject1.repository.specification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.transasia.mvnproject1.entities.Part;
import ru.transasia.mvnproject1.entities.Part_;

/**
 *
 * @author banashko.dv
 */
@Component
public class PartSpecification {

    public static Specification<Part> hasQtyEqualToOrMoreThan(int qty) {
        return new Specification<Part>() {
            @Override
            public Predicate toPredicate(Root<Part> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return builder.greaterThanOrEqualTo(root.get(Part_.qty), qty);
            }
        };
    }
    
    public static Specification<Part> hasPartNumberLike(String partNumber) {
        return new Specification<Part>() {
            @Override
            public Predicate toPredicate(Root<Part> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return builder.like(root.get(Part_.partNumber), partNumber);
            }
        };
    }
    
    public static Specification<Part> hasPartNameLike(String partName) {
        return new Specification<Part>() {
            @Override
            public Predicate toPredicate(Root<Part> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return builder.like(root.get(Part_.partName), partName);
            }
        };
    }
    
    public static Specification<Part> hasVendorLike(String vendor) {
        
        return new Specification<Part>() {
            @Override
            public Predicate toPredicate(Root<Part> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return builder.like(root.get(Part_.vendor), vendor);
            }
        };
    }
    
//    public static Specification<Part> hasShippedAfter(Date shipped) {
//        return new Specification<Part>() {
//            @Override
//            public Predicate toPredicate(Root<Part> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
//                return builder.greaterThan(root.get(Part_.shipped), shipped);
//                //return builder.greaterThanOrEqualTo(root.get(Part_.qty), qty);
//            }
//        };
//    }
//    
//    public static Specification<Part> hasShippedBefore(Date shipped) {
//        return new Specification<Part>() {
//            @Override
//            public Predicate toPredicate(Root<Part> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
//                return builder.greaterThan(root.get(Part_.shipped), shipped);
//                //return builder.greaterThanOrEqualTo(root.get(Part_.qty), qty);
//            }
//        };
//    }
    
}
