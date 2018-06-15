/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.transasia.mvnproject1.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 *
 * @author banashko.dv
 */
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class FilterValues {
    static int counter = 0;
    
    
    
    private String partNumber="";
    private String partName="";
    private String vendor="";
    private String quantity="";
    private String shippedBefore="";
    private String shippedAfter="";
    private String receivedBefore="";
    private String receivedAfter="";
    private String sortByColumn="1";

    public FilterValues (String partName, String partNumber, String vendor, String quantity, String shippedBefore, String shippedAfter, String receivedBefore, String receivedAfter, String sortByColumn) {
        this.partName = partName;
        this.partNumber = partNumber;
        this.vendor = vendor;
        this.quantity = quantity;
        this.shippedBefore = shippedBefore;
        this.shippedAfter = shippedAfter;
        this.receivedBefore = receivedBefore;
        this.receivedAfter = receivedAfter;
        this.sortByColumn = sortByColumn;
    }

    public FilterValues() {
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        FilterValues.counter = counter;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getShippedBefore() {
        return shippedBefore;
    }

    public void setShippedBefore(String shippedBefore) {
        this.shippedBefore = shippedBefore;
    }

    public String getShippedAfter() {
        return shippedAfter;
    }

    public void setShippedAfter(String shippedAfter) {
        this.shippedAfter = shippedAfter;
    }

    public String getReceivedBefore() {
        return receivedBefore;
    }

    public void setReceivedBefore(String receivedBefore) {
        this.receivedBefore = receivedBefore;
    }

    public String getReceivedAfter() {
        return receivedAfter;
    }

    public void setReceivedAfter(String receivedAfter) {
        this.receivedAfter = receivedAfter;
    }

    public String getSortByColumn() {
        return sortByColumn;
    }

    public void setSortByColumn(String sortByColumn) {
        this.sortByColumn = sortByColumn;
    }
    
}