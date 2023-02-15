package school.sptech.primeiraapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {
    private List<Heroi> herois = new ArrayList<>();

    @GetMapping("/favorito")
    public Heroi favorito(){
        Heroi heroi = new Heroi("Batman", 22, "Rico", 8000.1, true, 10);
        herois.add(heroi);
        return heroi;
    }

    @GetMapping
    public List<Heroi> listar() {
        for(Heroi h : herois){
            h.setHp(h.getHp() - 5);
        }
        return herois;
    }
}
