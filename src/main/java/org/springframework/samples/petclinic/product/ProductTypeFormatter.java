package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{

    private final ProductService productService;

    @Autowired
    public ProductTypeFormatter(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String print(ProductType productType, Locale locale) {
        return productType.getName();
    }

    @Override
    public ProductType parse(String typeName, Locale locale) throws ParseException {
        ProductType findProductType = this.productService.getProductType(typeName);
        if(findProductType != null){
            return findProductType;
        }
        throw new ParseException("Product type not found: " + typeName, 0);
    }
    
}
