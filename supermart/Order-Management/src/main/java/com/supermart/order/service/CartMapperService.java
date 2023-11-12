package com.supermart.order.service;

import com.supermart.order.dto.CartItemRequest;
import com.supermart.order.dto.CartItemResponse;
import com.supermart.order.dto.CartResponse;
import com.supermart.order.dto.OrderItemRequest;
import com.supermart.order.model.Cart;
import com.supermart.order.model.CartItem;

public interface CartMapperService {
    CartResponse mapToCartResponse(Cart cart);
    CartItem mapRequestToCartItem(CartItemRequest cartItemRequest);
    CartItem mapResponseToCartItem(CartItemResponse cartItemResponse);
    CartItemResponse mapToCartItemResponse(CartItem cartItem);
    CartItemRequest mapToCartItemRequest(CartItem cartItem);
    OrderItemRequest mapToOrderItemRequest(CartItem cartItem);

}
