package school.sptech.primeiraapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    private List<String> pokemon = new ArrayList<>();

    @GetMapping
    public String exibePokemon(){
        return "Total de pokemon cadastrado: " + pokemon.size();
    }

    @GetMapping("/cadastrar/{nomePokemon}")
    public String cadastrarPokemon(@PathVariable String nomePokemon){
        pokemon.add(nomePokemon);
        return "Pokemon cadastrado";
    }

    @GetMapping("/recuperar/{indice}")
    public String exibirPorIndice(@PathVariable int indice){
        String frase = "Pokemon não encontrado";
        if(indice < pokemon.size()){
            frase = pokemon.get(indice);
        }
        return frase;
    }

    @GetMapping("/excluir/{indice}")
    public String excluirPorIndice(@PathVariable int indice){
        String frase = "Pokemon não encontrado";

        if(indice < pokemon.size()){
            pokemon.remove(indice);
            frase = "Excluido";
        }
        return frase;
    }

    @GetMapping("/atualizar/{indice}/{novoNome}")
    public String atualizarNome(@PathVariable int indice, @PathVariable String novoNome){
        String frase = "Pokemon não encontrado";

        if(indice < pokemon.size()){
            pokemon.set(indice, novoNome);
            frase = "Pokemon Atualizado ";
        }
        return frase;
    }
}
