package br.senai.teste.control;

import br.senai.teste.model.Pessoa;
import br.senai.teste.repo.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Pessoa> buscar(@PathVariable Long id) {
        return pessoaRepository.findById(id);
    }

    @PostMapping
    public Pessoa criar(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @PutMapping("/{id}")
    public Pessoa atualizar(@PathVariable Long id, @RequestBody Pessoa novaPessoa) {
        return pessoaRepository.findById(id)
                .map(pessoa -> {
                    pessoa.setNome(novaPessoa.getNome());
                    pessoa.setCpf(novaPessoa.getCpf());
                    pessoa.setFone(novaPessoa.getFone());
                    return pessoaRepository.save(pessoa);
                })
                .orElseGet(() -> {
                    novaPessoa.setId(id);
                    return pessoaRepository.save(novaPessoa);
                });
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        pessoaRepository.deleteById(id);
    }
}
