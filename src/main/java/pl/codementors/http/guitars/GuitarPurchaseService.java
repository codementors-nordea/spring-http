package pl.codementors.http.guitars;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.codementors.http.guitars.client.AddGuitarRequest;
import pl.codementors.http.guitars.client.Guitar;
import pl.codementors.http.guitars.client.GuitarShopClient;

@Component
@RequiredArgsConstructor
public class GuitarPurchaseService {

    private final GuitarShopClient guitarShopClient;

    public void purchase(String id) {
        var guitar = guitarShopClient.getGuitars()
                .stream()
                .filter(g -> g.getId().equals(id))
                .findFirst()
                .filter(Guitar::isAvailable)
                .orElseThrow(() -> new GuitarNotAvailableException(id));

        var cart = guitarShopClient.createCart();
        guitarShopClient.addGuitarToCart(cart.getId(), new AddGuitarRequest(guitar.getId(), 1));
        guitarShopClient.purchaseCart(cart.getId());
    }
}
