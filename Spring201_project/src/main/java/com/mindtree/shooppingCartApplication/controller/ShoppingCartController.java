package com.mindtree.shooppingCartApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.shooppingCartApplication.dto.ProductDto;
import com.mindtree.shooppingCartApplication.dto.UserDto;
import com.mindtree.shooppingCartApplication.exception.serviceException.ServiceException;
import com.mindtree.shooppingCartApplication.service.CartService;
import com.mindtree.shooppingCartApplication.service.ProductService;
import com.mindtree.shooppingCartApplication.service.UserService;

@RestController
public class ShoppingCartController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CartService cartService;
 
	/**
	 * @param user
	 * @return user
	 */
	@PostMapping("/adduser")
	public UserDto addUser(@RequestBody UserDto user) {
		UserDto users = userService.addUser(user);
		return users;
	}

	/**
	 * @param userId
	 * @param productId
	 * @return carts
	 */
	@RequestMapping("/addproduct/{userId}/{productId}")
	public String addProductsToCart(@PathVariable int userId, @PathVariable int productId) {
		String message = productService.addProductsToCart(userId, productId);
		return message;
	}

	
	/**
	 * @param userId
	 * @param productId
	 * @param newProductId
	 * @return
	 * @throws ServiceException
	 */
	@PutMapping("/addproduct/{userId}/{oldProductId}/{newProductId}")
	public String UpdateProductsInCart(@PathVariable int userId, @PathVariable int OldProductId,
			@PathVariable int newProductId) throws ServiceException {
		String message;

		try {
			message = productService.UpdateProductsInCart(userId, OldProductId, newProductId);
		} catch (ServiceException e) {
			throw new ServiceException(e.getMessage());
		}

		return message;
	}

	/**
	 * @param userId
	 * @param productId
	 * @return " Deleted Successfullyy..!!"
	 */
	@DeleteMapping("/removeproduct/{userId}/{productId}")
	public String deleteProductsFromCart(@PathVariable int userId, @PathVariable int productId) {
		String message  = productService.deleteProductsFromCart(userId, productId);
		return message;
	}

	/**
	 * @param userId
	 * @return List of productss
	 * @throws ServiceException
	 */
	@GetMapping("/getproduct/{userId}")
	public List<ProductDto> getProductsOfCartByUserId(@PathVariable int userId) throws ServiceException {
		List<ProductDto> productsList;
		try {
			productsList = cartService.getProductsOfCartByUserId(userId);
		} catch (ServiceException e) {
			throw new ServiceException(e.getMessage());
		}
		return productsList;
	}

	/**
	 * @param userId
	 * @return the price 
	 */
	@GetMapping("/getprice/{userId}")
	public int getTotalCartPriceByUserId(@PathVariable int userId) {
		int price;
		price = cartService.getTotalCartPriceByUserId(userId);
		return price;
	}

	/**
	 * @return list of all the products
	 */
	@GetMapping("/getproducts")
	public List<ProductDto> getAllProductData() {
		List<ProductDto> productsList = productService.getAllProductData();
		return productsList;
	}
}