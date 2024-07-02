package br.gov.sp.fatec.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String cpf;
    private String telefone;

    @OneToOne(mappedBy = "aluguel", cascade = CascadeType.ALL)
    private Aluguel aluguel;
}
