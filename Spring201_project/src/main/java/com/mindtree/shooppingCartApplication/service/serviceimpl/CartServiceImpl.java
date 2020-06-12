package com.mindtree.shooppingCartApplication.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.shooppingCartApplication.dto.ProductDto;
import com.mindtree.shooppingCartApplication.entity.Cart;
import com.mindtree.shooppingCartApplication.entity.Product;
import com.mindtree.shooppingCartApplication.entity.User;
import com.mindtree.shooppingCartApplication.exception.serviceException.ServiceException;
import com.mindtree.shooppingCartApplication.exception.serviceException.UserNotPresentException;
import com.mindtree.shooppingCartApplication.repository.CartRepository;
import com.mindtree.shooppingCartApplication.repository.ProductRepository;
import com.mindtree.shooppingCartApplication.repository.UserRepository;
import com.mindtree.shooppingCartApplication.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CartRepository cartRepository;

	ModelMapper model = new ModelMapper();

	@Override
	public List<ProductDto> getProductsOfCartByUserId(int userId) throws ServiceException {

		Optional<Cart> cartOptional = cartRepository
				.findById(userRepository.findById(userId).get().getCart().getCardId());
		Cart cart;
		List<Product> productsInCart;
		List<ProductDto> productDtoList = new ArrayList<>();
		if (cartOptional.isPresent()) {
			cart = cartOptional.get();
			productsInCart = cart.getProducts();
			for (Product product : productsInCart) {
				productDtoList.add(model.map(product, ProductDto.class));
			}
		} else {
			throw new UserNotPresentException("user not present with paticular id");
		}
		return productDtoList;
	}

	@Override
	public int getTotalCartPriceByUserId(int userId) {
		User user = userRepository.findById(userId).get();
		float totalCost = 0;
		Cart cart = cartRepository.findById(userRepository.findById(userId).get().getCart().getCardId()).get();
		List<Product> product = cart.getProducts();

		for (Product product1 : product) {
			totalCost = totalCost + product1.getPrice();
		}
		return (int) (totalCost);
	}
}
