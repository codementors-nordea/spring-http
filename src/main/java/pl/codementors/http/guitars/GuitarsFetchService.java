package pl.codementors.http.guitars;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.codementors.http.guitars.client.Guitar;
import pl.codementors.http.guitars.client.GuitarShopClient;
import pl.codementors.http.guitars.model.AvailableGuitar;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GuitarsFetchService {

    private final GuitarShopClient guitarShopClient;

    public List<AvailableGuitar> fetchAllGuitars() {
        return guitarShopClient.getGuitars()
                .stream()
                .filter(Guitar::isAvailable)
                .map(AvailableGuitar::fromGuitar)
                .sorted(Comparator.comparing(AvailableGuitar::getStock).reversed())
                .collect(Collectors.toList());
    }
}
