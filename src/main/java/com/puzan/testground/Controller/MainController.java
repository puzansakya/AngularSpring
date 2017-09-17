/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puzan.testground.Controller;

import com.puzan.testground.DAO.BookDAO;
import com.puzan.testground.DAO.CategoryDAO;
import com.puzan.testground.DTO.BookDTO;
import com.puzan.testground.DTO.CategoryDTO;
import com.puzan.testground.Entities.Book;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author puzan
 */
@Controller
@RequestMapping(value = "/")
public class MainController {

    @Autowired
    private BookDAO bd;

    @Autowired
    private CategoryDAO cd;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {

        return "index";
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String book(Model model) {
        model.addAttribute(cd.getAll());
        return "book";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<BookDTO> getAll() {
        List<BookDTO> booklist = new ArrayList<>();
        for (Book b : bd.getAll()) {

            ModelMapper mapper = new ModelMapper();
            mapper.map(b.getCategoryId(), CategoryDTO.class);
            BookDTO bookDTO = mapper.map(b, BookDTO.class);

            booklist.add(bookDTO);
        }
        return booklist;
    }

    @RequestMapping(value = "/search/{keyword}", method = RequestMethod.GET)
    @ResponseBody
    public List<BookDTO> search(@PathVariable("keyword") String keyword) {
        List<BookDTO> booklist = new ArrayList<>();
        for (Book b : bd.search(keyword)) {
            ModelMapper mapper = new ModelMapper();
            mapper.map(b.getCategoryId(), CategoryDTO.class);
            BookDTO bookDTO = mapper.map(b, BookDTO.class);

            booklist.add(bookDTO);
        }
        return booklist;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public BookDTO save(@RequestBody BookDTO b) {
        ModelMapper mapper = new ModelMapper();

        //convert BookDTO to book class          
        Book book = mapper.map(b, Book.class);
        book.setCategoryId(cd.getById(b.getCategory().getCategoryId()));

//        if (bd.insert(book) > 0) {
//            return "success";
//        }
//        return "false";
        Book newBook = bd.save(book);

        //convert book to bookDTO class
        mapper.map(newBook.getCategoryId(), CategoryDTO.class);
        BookDTO bookDTO = mapper.map(newBook, BookDTO.class);

        return bookDTO;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(@RequestBody BookDTO b) {
        ModelMapper mapper = new ModelMapper();
        Book book = mapper.map(b, Book.class);
        bd.update(book);
        return "updated successfully";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        bd.delete(id);
        return "deleted";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BookDTO getBook(@PathVariable("id") int id) {
        Book b = bd.getById(id);
        BookDTO book = new BookDTO();
        book.setName(b.getName());
        book.setAuthor(b.getAuthor());
        return book;
    }
}
