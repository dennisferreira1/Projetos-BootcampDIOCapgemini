package br.desoftware.ecommerce.checkout.service;

import br.desoftware.ecommerce.checkout.entity.CheckoutEntity;
import br.desoftware.ecommerce.checkout.resource.checkout.CheckoutRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface CheckoutService {

   Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);
}
