/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puzan.testground.DAO;

import com.puzan.testground.DTO.AmountDTO;
import java.util.List;

/**
 *
 * @author puzan
 */
public interface AmountDAO {

    List<AmountDTO> getAll();

}
