package com.mindtree.shooppingCartApplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.shooppingCartApplication.dto.ProductDto;
import com.mindtree.shooppingCartApplication.exception.serviceException.ServiceException;

@Service
public interface ProductService {

	/**
	 * @param userId
	 * @param productId
	 * @return
	 */
	public String addProductsToCart(int userId, int productId);

	/**
	 * @param userId
	 * @param productId
	 * @param newProductId
	 * @return
	 * @throws ServiceException
	 */
	public String UpdateProductsInCart(int userId, int productId, int newProductId) throws ServiceException;

	/**
	 * @param userId
	 * @param productId
	 * @return
	 */
	public String deleteProductsFromCart(int userId, int productId);

	/**
	 * @return
	 */
	public List<ProductDto> getAllProductData();

}
