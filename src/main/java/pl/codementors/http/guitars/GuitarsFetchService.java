package pl.codementors.http.guitars;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.codementors.http.guitars.model.AvailableGuitar;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GuitarsFetchService {


    public List<AvailableGuitar> fetchAllGuitars() {
        return Collections.emptyList();
    }
}
