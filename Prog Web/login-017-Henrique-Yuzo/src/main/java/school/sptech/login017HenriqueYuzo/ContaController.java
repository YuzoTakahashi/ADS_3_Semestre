package school.sptech.login017HenriqueYuzo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("usuarios")
public class ContaController {
    private List<Conta> contas;

    public ContaController() {
        this.contas = new ArrayList<>();
    }

    @GetMapping
    public List<Conta> listar(){
        if(contas.isEmpty()){
            return null;
        }
        return contas;
    }

    @PostMapping
    public Conta cadastrar(@RequestBody Conta contaNova){
        contas.add(contaNova);
        return contaNova;
    }

    @PostMapping("/autenticacao/{usuario}/{senha}")
    public Conta autenticar(@PathVariable String usuario, @PathVariable String senha){
        for(Conta c : contas){
            if(c.getUsuario() == usuario && c.getSenha() == senha){
                c.setAutenticado(true);
                return  c;
            }
        }
        return null;
    }

    @DeleteMapping("/autenticacao/{usuario}")
    public String deletar(@PathVariable String usuario){
        for(Conta c : contas){
            if(c.getUsuario() == usuario){
                if(c.isAutenticado()) {
                    c.setAutenticado(false);
                    return "Logoff do usuário " + c.getNome() + " concluído";
                }else{
                    return "Usuario" + c.getNome() + " NÃO encontrado";
                }
            }
        }
        return "Usuário " + usuario + " não encontrado";
    }

    @PutMapping("{usuario}/{senhaAntiga}/{senhaNova}")
    public String alterarSenha(@PathVariable String usuario, @PathVariable String senhaAntiga, @PathVariable String senhaNova){
        for(Conta c : contas){
            if(c.getUsuario() == usuario && c.getSenha() == senhaAntiga){
                c.setSenha(senhaNova);
                return "Senha alterada com sucesso";
            }
        }
        return "Usuario e/ou senha não encontrada";
    }
}
