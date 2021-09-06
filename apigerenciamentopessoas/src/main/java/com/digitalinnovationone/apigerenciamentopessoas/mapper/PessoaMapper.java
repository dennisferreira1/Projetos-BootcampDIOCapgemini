package com.digitalinnovationone.apigerenciamentopessoas.mapper;

import com.digitalinnovationone.apigerenciamentopessoas.dto.request.PessoaDTO;
import com.digitalinnovationone.apigerenciamentopessoas.entity.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PessoaMapper {
    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    @Mapping(target = "dataNascimento", source = "dataNascimento", dateFormat = "dd-MM-yyyy")
    Pessoa toModel(PessoaDTO pessoaDTO);

    PessoaDTO toDto(Pessoa pessoa);
}
