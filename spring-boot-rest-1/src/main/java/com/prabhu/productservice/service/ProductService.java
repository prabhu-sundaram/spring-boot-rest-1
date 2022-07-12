package com.prabhu.productservice.service;


import java.util.Collection;
import com.prabhu.productservice.business.bean.ProductBean;
public interface ProductService {
    Collection<ProductBean> getAllProduct();
    ProductBean getProductDetailsById(int id);
    Integer addProduct(ProductBean product);
    ProductBean updateProduct(ProductBean product);
    void removeProduct(int id);
}
