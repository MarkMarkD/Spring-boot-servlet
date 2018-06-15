/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.transasia.mvnproject1.entities;


import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author banashko.dv
 */
@Entity
@Table(name = "listofparts")
public class Part {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
    private Integer id;
    
    @Column(name = "pname")
    protected String partName;
    
    @Column(name = "pnumber")
    protected String partNumber;
    
    @Column(name = "vendor")
    protected String vendor;
    
    @Column(name = "qty")
    protected int qty;
    
    //@DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "shipped")
    private Date shipped;
    
    //@DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "received")
    private Date received;

    public Part (String partName, String partNumber, String vendor, int qty, Date shipped, Date received) {
        this.partName = partName;
        this.partNumber = partNumber;
        this.vendor = vendor;
        this.qty = qty;
        this.shipped = shipped;
        this.received = received;
    }

    public Part() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getPname() {
        return partName;
    }

    public void setPname(String partName) {
        this.partName = partName;
    }

    public String getPnumber() {
        return partNumber;
    }

    public void setPnumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Date getShipped() {
        return shipped;
    }

    public void setShipped(Date shipped) {
        this.shipped = shipped;
    }

    public Date getReceived() {
        return received;
    }

    public void setReceived(Date received) {
        this.received = received;
    }
    
}
