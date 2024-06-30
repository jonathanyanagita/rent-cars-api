package br.gov.sp.fatec.domain.entity;

import br.gov.sp.fatec.domain.enums.CarroStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Carro {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private CarroStatus status;

    private String modelo;
    private String marca;
    private int ano;

    @OneToOne(mappedBy = "aluguel", cascade = CascadeType.ALL)
    private Aluguel aluguel;
}
