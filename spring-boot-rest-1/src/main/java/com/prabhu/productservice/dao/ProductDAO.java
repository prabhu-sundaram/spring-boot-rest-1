package com.prabhu.productservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prabhu.productservice.entity.ProductEntity;
public interface ProductDAO extends JpaRepository<ProductEntity, Integer>
{
}