package com.prabhu.productservice.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prabhu.productservice.business.bean.ProductBean;
import com.prabhu.productservice.dao.ProductDAOWrapper;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAOWrapper productDAOWrapper;
    public Collection<ProductBean> getAllProduct(){
        return productDAOWrapper.findAll();         
    }
    public ProductBean getProductDetailsById(int id){
        return productDAOWrapper.findOne(id);
    }
    public Integer addProduct(ProductBean product){
        return productDAOWrapper.saveProduct(product);
    }
    public ProductBean updateProduct (ProductBean product){
        return productDAOWrapper.updateProduct(product);
    }
    public void removeProduct (int id){
        productDAOWrapper.delete(id);
    }
}