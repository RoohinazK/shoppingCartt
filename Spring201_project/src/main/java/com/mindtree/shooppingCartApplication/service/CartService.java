package com.mindtree.shooppingCartApplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.shooppingCartApplication.dto.ProductDto;
import com.mindtree.shooppingCartApplication.exception.serviceException.ServiceException;


@Service
public interface CartService {

	/**
	 * @param userId
	 * @return
	 * @throws ServiceException
	 */
	public List<ProductDto> getProductsOfCartByUserId(int userId) throws ServiceException;

	/**
	 * @param userId
	 * @return
	 */
	public int getTotalCartPriceByUserId(int userId);

}