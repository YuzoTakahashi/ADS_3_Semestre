package school.sptech.projeto02;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("musicas")
public class MusicaController {
    private List<Musica> playlist;

    public MusicaController() {
        this.playlist = new ArrayList<>();
        playlist.add(new Musica("Razões e emoções", "NXZero", 2006));
        playlist.add(new Musica("Sugar", "Maroom 5", 2016));
        playlist.add(new Musica("Perfect" , "Ed Sheeran", 2006));
    }

    @GetMapping
    public List<Musica> list(){
        return playlist;
    }

    @GetMapping("/{indice}")
    public Musica recuperar(@PathVariable int indice){
        if(indice >= 0 && indice < playlist.size()) {
            return playlist.get(indice);
        }
        return null;
    }

    @DeleteMapping("/{indice}")
    public String remover(@PathVariable int indice){
        if(indice >= 0 && indice < playlist.size()){
            playlist.remove(indice);
            return "Musica removida com sucesso";
        }
        return "Musica não encontrada";
    }

    @PostMapping
    public Musica cadastrar(@RequestBody Musica novaMusica){
        playlist.add(novaMusica);
        return novaMusica;
    }

    @PatchMapping("/{indice}")
    public Musica alterarPatch(@RequestBody Musica musicaAlterada, @PathVariable int indice){
        if(indice >= 0 && indice < playlist.size()){
            playlist.set(indice, musicaAlterada);
            return musicaAlterada;
        }
        return null;
    }

    @PutMapping("/{indice}")
    public Musica alterarPut(@RequestBody Musica musicaAlterada, @PathVariable int indice){
        if(indice >= 0 && indice < playlist.size()){
            playlist.set(indice, musicaAlterada);
            return musicaAlterada;
        }
        return null;
    }
}
