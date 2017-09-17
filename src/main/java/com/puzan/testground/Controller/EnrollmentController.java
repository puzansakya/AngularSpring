/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puzan.testground.Controller;

import com.puzan.testground.DAO.AmountDAO;
import com.puzan.testground.DAO.EnrollmentDAO;
import com.puzan.testground.DTO.AmountDTO;
import com.puzan.testground.DTO.CourseDTO;
import com.puzan.testground.DTO.DiscountDTO;
import com.puzan.testground.DTO.EnrollmentDTO;
import com.puzan.testground.DTO.StudentDTO;
import com.puzan.testground.DTO.TimeDTO;
import com.puzan.testground.Entities.Enrollment;
import java.rmi.server.RMIClassLoader;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author puzan
 */
@Controller
@RequestMapping(value = "/enrollment")
public class EnrollmentController {
    
    @Autowired
    private EnrollmentDAO ed;
    
    @Autowired
    private AmountDAO ad;
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String index() {
        return "enrollment Index";
    }
    
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<EnrollmentDTO> getAll() {
        List<EnrollmentDTO> enrollmentDTOList = new ArrayList<>();
        
        for (int i = 0; i < ed.getAll().size(); i++) {
            Enrollment enrollment = ed.getAll().get(i);
            ModelMapper mapper = new ModelMapper();
            mapper.map(enrollment.getDiscount(), DiscountDTO.class);
            mapper.map(enrollment.getTime(), TimeDTO.class);
            mapper.map(enrollment.getCourse(), CourseDTO.class);
            mapper.map(enrollment.getStudent(), StudentDTO.class);
            
            EnrollmentDTO enrollmentDTO = mapper.map(enrollment, EnrollmentDTO.class);
            
            AmountDTO amountDTO = ad.getAll().get(i);
            enrollmentDTO.setAmount(amountDTO);
            enrollmentDTOList.add(enrollmentDTO);
            
        }
        return enrollmentDTOList;
    }
    
    @RequestMapping(value = "/getAmount", method = RequestMethod.GET)
    @ResponseBody
    public String getAmount() {
//        return "amount";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ad.getAll().size(); i++) {
            sb.append(ad.getAll().get(i).getEnrollmentId() + " " + ad.getAll().get(i).getAmount() + "\r\n");
        }
        return sb.toString();
    }
}
