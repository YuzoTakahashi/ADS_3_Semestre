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
    public String autenticar(@PathVariable String usuario, @PathVariable String senha){
        for(Conta c : contas){
            if(c.autenticar(usuario, senha)){
                c.setAutenticado(true);
                return "Usuário autenticado";
            }
        }
        return "Usuário não encontrado";
    }

    @DeleteMapping("/{usuario}")
    public String deletar(@PathVariable String usuario){
        for(Conta c : contas){
            if(c.getUsuario().equals(usuario)){
                if(c.isAutenticado()) {
                    c.setAutenticado(false);
                    return "Logoff do usuário " + c.getNome() + " concluído";
                }else{
                    return "Usuario " + c.getNome() + " NÃO está autenticado";
                }
            }
        }
        return "Usuário " + usuario + " não encontrado";
    }

    @PutMapping("{usuario}/{senhaNova}")
    public String alterarSenha(@PathVariable String usuario, @PathVariable String senhaNova){
        // esse método alterarSenha recebe o usuario e a senha nova como parametro, e realiza a troca da senha utilizando put.
        for(Conta c : contas){
            if(c.getUsuario().equals(usuario)){
                c.setSenha(senhaNova);
                return "Senha alterada com sucesso";
            }
        }
        return "Usuario não encontrada";
    }
}
