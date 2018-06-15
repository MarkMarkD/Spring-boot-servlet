/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.transasia.mvnproject1.servlets;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.transasia.mvnproject1.entities.FilterValues;
import ru.transasia.mvnproject1.entities.Part;
import ru.transasia.mvnproject1.repository.PartRepository;
import ru.transasia.mvnproject1.service.impl.PartServiceImpl;

/**
 *
 * @author banashko.dv
 */
@Controller
//@RequestMapping(value = "/")    //"/listController")
public class ListController {
    
    private final Logger logger = LoggerFactory.getLogger(ListController.class);
    
    @Autowired
    PartServiceImpl partServiceImpl;
    
    @Autowired
    PartRepository repository;
    
    private List<Part> parts = null;
    private String lastSortBy;                 //last sorting by column
    private boolean newSortingOrder = false;
    private Map<String, String> parameterMap = new HashMap<>();
    
    private String partNumber="";
    private String partName="";
    private String vendor="";
    private String quantity="";
    private String shpdAfter="";
    private String shpdBefore="";
    private String rcvdAfter="";
    private String rcvdBefore="";
    private String sortingOrder="ASC";
    private String sortByColumn="1";
    
    //TODO
    //Add REST Controller to return Part in JSON
    //Done - Add a method that returns ResponseBody just like RestController does 
    //Add custom JSON serializer that outputs only certain fields
    
    //Use <form:form> for getting Part instead of separate fields
    //Add logging
    
    //redirect to index.jsp page
    @RequestMapping("/index") 
    public String home(){
        logger.info("index.jsp requested");
        return "index"; 
    }  
    
    //redirect to addPart.jsp page
    @RequestMapping("/addPart") 
    @Secured("ROLE_ADMIN")
    public String addPage(){
        return "addPart"; 
    }  
    
    //returns all parts in JSON in ResponseBody
    @RequestMapping(value="/parts1", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody 
    public List<Part> getResponseBody() {
        logger.info("REST request to GET list of parts in JSON");
        return partServiceImpl.findAll();
    }
    
    //returns all parts in JSON in Response Entity
    @RequestMapping(value="/parts2", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <List<Part>> getResponseEntity() {
        //return ResponseEntity.accepted().body(getListOfPartsFromModel());
        return new ResponseEntity<>(partServiceImpl.findAll(), HttpStatus.OK);
    }
    
    //show all parts
    @RequestMapping(value="/list", method=RequestMethod.GET)
    @Secured("ROLE_USER")
    public ModelAndView listParts() { //@RequestParam(value = "sortByColumn", required=false) String sortByColumn) {
        logger.info("Request to show list of parts");
        ModelAndView mav = new ModelAndView("new-list");
        List<Part> partList;
        partList = partServiceImpl.findAll();
        
        fillParameterMap();
        mav.addObject("parameterMap", parameterMap);
        mav.addObject("parts", partList);
        return mav;
    }
    
    //delete part by id
    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deletePart(@PathVariable Integer id,
                    final RedirectAttributes redirectAttributes) {

        ModelAndView mav = new ModelAndView();		

        partServiceImpl.deleteById(id);

        mav.setViewName("redirect:/list");
        return mav;
    }
    
    //add new part
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ModelAndView createNewPart(@ModelAttribute @DateTimeFormat(pattern="yyyy-MM-dd") Part part,
            BindingResult result,
            final RedirectAttributes redirectAttributes) {

        ModelAndView mav = new ModelAndView();
        String message = "New part " + part.getPname() + " was successfully created.";

        partServiceImpl.insert(part);
        mav.setViewName("redirect:/list");

        
        redirectAttributes.addFlashAttribute("message", message);	
        return mav;		
    }
    
    //returns filtered parts
    @RequestMapping(value = "/filtered", method=RequestMethod.POST)
    public String filterItems(@ModelAttribute FilterValues filterValues,
//        can also be like this : 
//        @RequestParam(value = "pnumber", required=false) String partNumber,
//        @RequestParam(value = "pname", required=false) String partName,
//        @RequestParam(value = "vendor", required=false) String vendor,
//        @RequestParam(value = "qty", required=false) String quantity,
//        @RequestParam(value = "shippedAfter", required=false) String shpdAfter,
//        @RequestParam(value = "shippedBefore", required=false) String shpdBefore,
//        @RequestParam(value = "receivedAfter", required=false) String rcvdAfter,
//        @RequestParam(value = "receivedBefore", required=false) String rcvdBefore,
        Model m) {
        
        this.partNumber = filterValues.getPartNumber();
        this.partName = filterValues.getPartName();
        this.vendor = filterValues.getVendor();
        this.quantity = filterValues.getQuantity();
        this.shpdAfter = filterValues.getShippedAfter();
        this.shpdBefore = filterValues.getShippedBefore();
        this.rcvdAfter = filterValues.getReceivedAfter();
        this.rcvdBefore = filterValues.getReceivedBefore();
        this.sortByColumn = filterValues.getSortByColumn();
        
        //m.addAttribute("message", "MyTestMessage");
        int qty = 0;
        try {
            qty = Integer.parseInt(quantity);
        } catch (Exception ex) {
            System.out.println("unsuccessful parsing Integer.parseInt");
        }
        String sortByColumnAsString = defineSorting(sortByColumn);
        parts = partServiceImpl.findAllByFilter(partNumber, partName, vendor, qty, sortByColumnAsString, sortingOrder);
        
        fillParameterMap();
        m.addAttribute("parts", parts);
        m.addAttribute("parameterMap", parameterMap);
        
        return "new-list";
    }

    public String defineSorting(String sortByColumn) {
        if (sortByColumn != null) {
            if (sortByColumn.equals(lastSortBy) && newSortingOrder == false) {
                newSortingOrder = true;
                sortingOrder = "DESC";
            }
            else if (sortByColumn.equals(lastSortBy) && newSortingOrder == true) {
                newSortingOrder = false;
                sortingOrder = "ASC";
            }
            else if (!sortByColumn.equals(lastSortBy)){
                newSortingOrder = false;
                sortingOrder = "ASC";
                lastSortBy = sortByColumn;
            }
            switch (sortByColumn) {
                case "1":
                    sortByColumn = "partNumber";
                    break;
                case "2":
                    sortByColumn = "partName";
                    break;
                case "3":
                    sortByColumn = "vendor";
                    break;
                case "4":
                    sortByColumn = "qty";
                    break;
                case "5":
                    sortByColumn = "shipped";
                    break;
                case "6":
                    sortByColumn = "received";
                    break;
                
            }
            return sortByColumn;
        } else
            return null;
    }

    public void fillParameterMap() {
        parameterMap.put("partNumber", partNumber);
        parameterMap.put("partName", partName);
        parameterMap.put("vendor", vendor);
        parameterMap.put("quantity", quantity);
        parameterMap.put("shpdAfter", shpdAfter);
        parameterMap.put("shpdBefore", shpdBefore);
        parameterMap.put("rcvdAfter", rcvdAfter);
        parameterMap.put("rcvdBefore", rcvdBefore);
    }
}