package com.app.springmvc.controllers;

import com.app.springmvc.domain.Product;
import com.app.springmvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by IntelliJ IDEA.
 * User: in708bhugad
 * Date: 05-01-2020
 * Time: 14:02
 * inside the package - com.app.springmvc.controllers
 * To change this template use File | Settings | File and Code Templates.
 */

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.listAllProducts());
        return "products";
    }

    @RequestMapping("/product/{id}")
    public String getProductById(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product";
    }

    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "productform";
    }

    @RequestMapping("/product/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "productform";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(Product product) {
        Product savedProduct = productService.saveOrUpdateProduct(product);
        return "redirect:/product/" + savedProduct.getId();
    }

    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable Integer id){
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
