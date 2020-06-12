package com.mindtree.shooppingCartApplication.service.serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.shooppingCartApplication.dto.ProductDto;
import com.mindtree.shooppingCartApplication.entity.Cart;
import com.mindtree.shooppingCartApplication.entity.Product;
import com.mindtree.shooppingCartApplication.exception.serviceException.NoProductFoundException;
import com.mindtree.shooppingCartApplication.exception.serviceException.ServiceException;
import com.mindtree.shooppingCartApplication.repository.CartRepository;
import com.mindtree.shooppingCartApplication.repository.ProductRepository;
import com.mindtree.shooppingCartApplication.repository.UserRepository;
import com.mindtree.shooppingCartApplication.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CartRepository cartRepository;

	ModelMapper model = new ModelMapper();

	public String addProductsToCart(int userId, int productId) {
		String message = "";
		Optional<Cart> cartOptional = cartRepository
				.findById(userRepository.findById(userId).get().getCart().getCardId());
		Cart cart;
		List<Product> productsInCart;
		if (cartOptional.isPresent()) {
			cart = cartOptional.get();
			productsInCart = cart.getProducts();
			message = "product added  to cart successfully!";
		} else {
			productsInCart = new ArrayList<Product>();
			cart = new Cart();
		}
		productsInCart.add(productRepository.getOne(productId));
		cart.setProducts(productsInCart);
		cartRepository.save(cart);
		return message;
	}

	public String UpdateProductsInCart(int userId, int productId, int newProductId) throws ServiceException {
		Cart cart = cartRepository.findById(userRepository.findById(userId).get().getCart().getCardId()).get();
		List<Product> product = cart.getProducts();
		List<Product> updatedList = new ArrayList<>();
		String message = "";
		if (newProductId < 0) {
			throw new NoProductFoundException("the quantity should not be negative");
		} else if (newProductId == 0) {
			updatedList.add(null);
			message = "Cart is Empty!";
		} else {
			for (Product product2 : product) {
				if (product2.getProductId() == productId) {
					updatedList.add(productRepository.findById(newProductId).get());
					message = "new product updated to cart successfully!";
				} else {
					updatedList.add(product2);
				}
			}
		}
		cart.setProducts(updatedList);
		Cart carts = cartRepository.saveAndFlush(cart);
		return message;
	}

	public String deleteProductsFromCart(int userId, int productId) {
		String message = "";
		Optional<Cart> cartOptional = cartRepository
				.findById(userRepository.findById(userId).get().getCart().getCardId());
		Cart cart;
		List<Product> productsInCart;
		List<Product> updatedList = new ArrayList<>();
		if (cartOptional.isPresent()) {
			cart = cartOptional.get();
			productsInCart = cart.getProducts();
		} else {
			productsInCart = new ArrayList<Product>();
			cart = new Cart();
		}
		for (Product product : productsInCart) {
			if (product.getProductId() == productId) {
				message = "deleted successful!";
			} else {
				updatedList.add(product);
			}
		}
		cart.setProducts(updatedList);
		cartRepository.saveAndFlush(cart);
		return message;
	}

	@Override
	public List<ProductDto> getAllProductData() {
		List<Product> productList = productRepository.findAll();
		List<ProductDto> productListDto = new ArrayList<>();

		if (productList.size() > 0) {
			for (Product product : productList) {
				productListDto.add(model.map(product, ProductDto.class));
			}
			Collections.sort(productListDto);
			return productListDto;
		} else {
			return new ArrayList<ProductDto>();
		}
	}
}