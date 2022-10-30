package com.meher.yazlab.controller;


import com.meher.yazlab.model.Product;
import com.meher.yazlab.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {

    private final ProductServiceImpl productService;

    static int delete=0;



    @GetMapping("all")
    public String listProducts(Model model){
        model.addAttribute("products", productService.getAllProducts());

        return "products";

    }

    @GetMapping("inline")
    public String inlineProduct(Model model){

        model.addAttribute("products", productService.getinlineAllProducts());

        return "products";

    }
    @GetMapping("line")
    public String lineProduct(Model model){

        model.addAttribute("products", productService.getlineAllProducts());

        return "products";

    }
    @GetMapping("inlineSkor")
    public String lineSkorProduct(Model model){

        model.addAttribute("products", productService.getinlineSkorAllProducts());

        return "products";

    }
    @GetMapping("lineSkor")
    public String inlineSkorProduct(Model model){

        model.addAttribute("products", productService.getlineSkorAllProducts());

        return "products";

    }

    @GetMapping("new")
    public String createProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "createStudent";

    }

    @PostMapping()
    public String saveProduct(@ModelAttribute("product") Product product,Model model) {
        int temp=productService.getAllProducts().size();
        product.set_id(temp+1+delete);
        productService.saveProduct(product);
        model.addAttribute("products", productService.getAllProducts());
        return "products";

    }

    @GetMapping("/edit/{_id}")
    public String editProductForm(@PathVariable int _id, Model model) {
        model.addAttribute("product", productService.getProductById(_id));
        return "editProducts";
    }

    @PostMapping("/edit/{_id}")
    public String updateProduct(@PathVariable int _id,
                                @ModelAttribute("product") Product product,
                                Model model) {

        Product existingProduct = productService.getProductById(_id);
        existingProduct.setMarka(product.getMarka());
        existingProduct.setModelName(product.getModelName());
        existingProduct.setModelNo(product.getModelNo());
        existingProduct.setOS(product.getOS());
        existingProduct.setProcessorType(product.getProcessorType());
        existingProduct.setProcessorGeneration(product.getProcessorGeneration());
        existingProduct.setRam(product.getRam());
        existingProduct.setSsdDiscSize(product.getSsdDiscSize());
        existingProduct.setHardDiscSize(product.getHardDiscSize());
        existingProduct.setDiscType(product.getDiscType());
        existingProduct.setScreenSize(product.getScreenSize());
        existingProduct.setSkor(product.getSkor());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setSiteName(product.getSiteName());
        existingProduct.setImageUrl(product.getImageUrl());
        existingProduct.setTitle(product.getTitle());

        productService.updateProduct(existingProduct);

        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }
    @GetMapping("/information/{_id}")
    public String informationProduct(@PathVariable int _id,
                                @ModelAttribute("product") Product product,
                                Model model) {

        model.addAttribute("product", productService.getProductById(_id));
        return "informationProduct";
    }


    @GetMapping("/{_id}")
    public String deleteProduct(@PathVariable int _id,Model model) {
        productService.deleteProductById(_id);
    delete++;
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @GetMapping("login")
    public String loginAdmin(Model model) {
        Product admin = new Product();
        model.addAttribute("admin", admin);
        model.addAttribute("products", productService.getAllProducts());
        return "adminProductsSite.html";

     }
    @GetMapping("acer")
    public String Acer_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Acer";
    }
    @GetMapping("apple")
    public String Apple_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Apple";
    }

    @GetMapping("asus")
    public String Asus_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Asus";
    }

    @GetMapping("dell")
    public String Dell_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Dell";
    }

    @GetMapping("hometech")
    public String Hometech_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Hometech";
    }

    @GetMapping("hp")
    public String Hp_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "HP";
    }

    @GetMapping("lenovo")
    public String Lenovo_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Lenovo";
    }

    @GetMapping("monster")
    public String Monster_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Monster";
    }

    @GetMapping("msi")
    public String MSI_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "MSI";
    }

    @GetMapping("ram4")
    public String ram_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Ram4";
    }

    @GetMapping("ram8")
    public String ramb_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Ram8";
    }

    @GetMapping("ram16")
    public String rambb_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Ram16";
    }

    @GetMapping("ram32")
    public String rambbb_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Ram32";
    }

    @GetMapping("ram64")
    public String rambbbb_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Ram64";
    }
    @GetMapping("ssd64")
    public String ssd_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Ssd64";
    }

    @GetMapping("ssd128")
    public String ssdd_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Ssd128";
    }

    @GetMapping("ssd256")
    public String ssddd_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Ssd256";
    }

    @GetMapping("ssd500")
    public String ssdddd_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Ssd500";
    }

    @GetMapping("ssd512")
    public String ssddddd_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Ssd512";
    }

    @GetMapping("ssd1")
    public String ssdddddd_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Ssd1";
    }

    @GetMapping("ssd2")
    public String ssddddddd_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Ssd2";
    }
    @GetMapping("hepsiburada")
    public String hepsiburada_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Hepsiburada";
    }

    @GetMapping("trendyol")
    public String trendyol_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Trendyol";
    }

    @GetMapping("n11")
    public String n11_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "N11";
    }

    }





