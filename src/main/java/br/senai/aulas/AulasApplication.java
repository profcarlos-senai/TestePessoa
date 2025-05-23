package br.senai.aulas;

import br.senai.aulas.model.Pessoa;
import br.senai.aulas.repo.PessoaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class AulasApplication {

	public static void main(String[] args) {
		SpringApplication.run(AulasApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(PessoaRepository repository) {
		return (args) -> {
			// Adiciona algumas pessoas de exemplo ao banco de dados
			repository.save(
					new Pessoa(null, "Eduardo da Silva",
							new BigDecimal("11111111111"),
							new BigDecimal("46999887766"))
			);
			repository.save(new Pessoa(null, "Roberta da Silva",
					new BigDecimal("22222222222"),
					new BigDecimal("46912345678"))
			);
			repository.save(new Pessoa(null, "Claudio da Silva",
					new BigDecimal("33333333333"),
					new BigDecimal("46991112233"))
			);

			System.out.println("Pessoas adicionadas ao banco de dados:");
			repository.findAll().forEach(System.out::println);
		};
	}
}
