package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/product/list")
    public ModelAndView showListProduct() {
        List<Product> products = productService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }
    @GetMapping("/product/create")
    public ModelAndView createProductForm(){
       ModelAndView modelAndView=new ModelAndView("/create");
       modelAndView.addObject("product",new Product());
       return modelAndView;
    }
    @PostMapping("/product/save")
    public ModelAndView saveProduct(@ModelAttribute(name="product")Product product){
        ModelAndView modelAndView=new ModelAndView("/create");
        modelAndView.addObject("product",new Product());
        productService.create(product);
        return modelAndView;
    }
    @GetMapping("/product/{id}/edit")
    public ModelAndView editProduct(@PathVariable int id){
        ModelAndView modelAndView=new ModelAndView("/edit");
        modelAndView.addObject("product",productService.findById(id));
        return modelAndView;
    }
    @PostMapping("/product/update")
    public ModelAndView updateProduct(Product product){
       ModelAndView modelAndView=new ModelAndView("/edit");
       modelAndView.addObject("product",productService.update(product.getId(), product));
       return modelAndView;
    }
    @GetMapping("/product/{id}/delete")
    public String removeProduct(@PathVariable int id){
       productService.remove(id);
       return"redirect:/product/list";
    }
    @GetMapping("/product/{id}/view")
    public ModelAndView viewProduct(@PathVariable int id){
        ModelAndView modelAndView=new ModelAndView("/view");
        Product product=productService.findById(id);
        modelAndView.addObject("product",product);
        return modelAndView;
    }
}

