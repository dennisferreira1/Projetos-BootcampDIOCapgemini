package com.digitalinnovationone.apigerenciamentopessoas.service;

import com.digitalinnovationone.apigerenciamentopessoas.dto.MensagemRespostaDTO;
import com.digitalinnovationone.apigerenciamentopessoas.dto.request.PessoaDTO;
import com.digitalinnovationone.apigerenciamentopessoas.entity.Pessoa;
import com.digitalinnovationone.apigerenciamentopessoas.exception.PessoaNaoEncontradaException;
import com.digitalinnovationone.apigerenciamentopessoas.mapper.PessoaMapper;
import com.digitalinnovationone.apigerenciamentopessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    @Autowired
    public PessoaService(PessoaRepository peesoaRepository) {
        this.pessoaRepository = peesoaRepository;
    }

    public MensagemRespostaDTO cadastrar(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoaCadastrar = pessoaMapper.toModel(pessoaDTO);
        Pessoa pessoaCadastrada= pessoaRepository.save(pessoaCadastrar);

        return criarMensagemRespostaDTO("Pessoa cadastrada com sucesso. ID:  " + pessoaCadastrada.getId());
    }

    public List<PessoaDTO> listar() {
        List<Pessoa> todasPessoas = pessoaRepository.findAll();
        return todasPessoas.stream().map(pessoa -> pessoaMapper.toDto(pessoa)).collect(Collectors.toList());
    }

    public PessoaDTO buscarPessoa(Long id) throws PessoaNaoEncontradaException {
        Pessoa pessoaBuscada = verificaSeExiste(id);
        return this.pessoaMapper.toDto(pessoaBuscada);
    }

    public void excluirPessoa(Long id) throws PessoaNaoEncontradaException {
        verificaSeExiste(id);
        this.pessoaRepository.deleteById(id);
    }

    public MensagemRespostaDTO atualizarPessoa(Long id, PessoaDTO pessoaDTO) throws PessoaNaoEncontradaException {

        verificaSeExiste(id);
        Pessoa pessoaAtualizar = pessoaMapper.toModel(pessoaDTO);
        Pessoa pessoaAtualizada= pessoaRepository.save(pessoaAtualizar);

        return criarMensagemRespostaDTO("Pessoa com id " + pessoaAtualizada.getId() + " atualizada com sucesso.");
    }

    private Pessoa verificaSeExiste(Long id) throws PessoaNaoEncontradaException {
        return this.pessoaRepository.findById(id).orElseThrow(() -> new PessoaNaoEncontradaException(id));
    }

    private MensagemRespostaDTO criarMensagemRespostaDTO(String mensagem) {
        return MensagemRespostaDTO.builder()
                .mensagem(mensagem)
                .build();
    }
}
