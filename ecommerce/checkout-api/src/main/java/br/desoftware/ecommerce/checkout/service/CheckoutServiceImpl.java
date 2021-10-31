package br.desoftware.ecommerce.checkout.service;

import br.desoftware.ecommerce.checkout.entity.CheckoutEntity;
import br.desoftware.ecommerce.checkout.repository.CheckoutRepository;
import br.desoftware.ecommerce.checkout.resource.checkout.CheckoutRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.rmi.server.UID;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService{

    private final CheckoutRepository checkoutRepository;

    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {
        final CheckoutEntity checkoutEntity = CheckoutEntity.builder()
                .code(UUID.randomUUID().toString())
                .build();

        return Optional.of(checkoutRepository.save(checkoutEntity));
    }
}
