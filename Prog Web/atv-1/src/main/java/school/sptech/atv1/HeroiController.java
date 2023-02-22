package school.sptech.atv1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {
    private List<Heroi> herois = new ArrayList<Heroi>();

    @GetMapping
    public List<Heroi> listar() {
        return herois;
    }

    @GetMapping("/{indice}")
    public Heroi buscarHeroi(@PathVariable int indice){
        if (indice > 0 && indice < herois.size()) {
            return herois.get(indice);
        }
        return null;
    }

    @GetMapping("/cadastrar/{nome}/{habilidade}/{idade}/{forca}/{vivo}")
    public Heroi cadastrarHeroi(@PathVariable String nome, @PathVariable String habilidade, @PathVariable int idade, @PathVariable double forca, @PathVariable boolean vivo) {
        Heroi heroi = new Heroi(nome, habilidade, idade, forca, vivo);
        herois.add(heroi);
        return heroi;
    }

    @GetMapping("/atualizar/{indice}/{nome}/{habilidade}/{idade}/{forca}/{vivo}")
    public Heroi atualizarHeroi(@PathVariable int indice, @PathVariable String nome, @PathVariable String habilidade, @PathVariable int idade, @PathVariable double forca, @PathVariable boolean vivo) {
        herois.set(indice, new Heroi(nome, habilidade, idade, forca, vivo));
        return herois.get(indice);
    }

    @GetMapping("/remover/{indice}")
    public String removerHeroi(@PathVariable int indice) {
        String resposta = "Herói não encontrado...";
        if (indice > 0 && indice < herois.size()) {
            herois.remove(indice);
            resposta = "Heroi removido";
        }
        return resposta;
    }
}
