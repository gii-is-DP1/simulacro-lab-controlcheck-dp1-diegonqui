package org.springframework.samples.petclinic.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    
    private static final String VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
		this.productService = productService;
	}
    
    @GetMapping(value = "/create")
	public String initCreationForm(ModelMap model) {
		Product product = new Product();
        model.put("product", product);
		return VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping(value = "/create")
	public String processCreationForm(@Valid Product product, BindingResult result, ModelMap model) {		
		if (result.hasErrors()) {
			model.put("product", product);
			return VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM;
		}
		else {
            this.productService.save(product);
            return "welcome";
		}
	}

}
