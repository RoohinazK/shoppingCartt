package com.mindtree.shooppingCartApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.shooppingCartApplication.entity.Cart;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

}