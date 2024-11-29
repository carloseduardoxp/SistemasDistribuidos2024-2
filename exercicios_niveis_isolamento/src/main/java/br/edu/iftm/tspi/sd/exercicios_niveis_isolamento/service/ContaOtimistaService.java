package br.edu.iftm.tspi.sd.exercicios_niveis_isolamento.service;

import org.springframework.stereotype.Service;

import br.edu.iftm.tspi.sd.exercicios_niveis_isolamento.domain.ContaOtimista;
import br.edu.iftm.tspi.sd.exercicios_niveis_isolamento.repository.ContaOtimistaRepository;
import jakarta.transaction.Transactional;

@Service
public class ContaOtimistaService {

    private final ContaOtimistaRepository repository;

    public ContaOtimistaService(ContaOtimistaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void saque(String numero,Double valor) {
        ContaOtimista conta = repository.findById(numero)
            .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));

        if (conta.getSaldo() < valor) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        conta.setSaldo(conta.getSaldo() - valor);

        repository.save(conta);
    }

    @Transactional
    public void deposita(String numero,Double valor) {
        ContaOtimista conta = repository.findById(numero)
            .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));

        conta.setSaldo(conta.getSaldo() + valor);

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        repository.save(conta);
    }
    
    
}
