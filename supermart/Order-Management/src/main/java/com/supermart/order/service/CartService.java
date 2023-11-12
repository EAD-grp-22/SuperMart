package com.supermart.order.service;

import com.supermart.order.dto.CartRequest;
import com.supermart.order.dto.CartResponse;

public interface CartService {
    CartResponse getCartByCustomerId(Integer customerId);
    String addItemsToCart(CartRequest cartRequest);
    String removeItemsFromCart(CartRequest cartRequest);
    String clearCart(Integer customerId);
    String checkOutCart(Integer customerId,String shippingAddress);


}
