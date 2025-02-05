package com.example.api_find_cep_java.Controller;

import com.example.api_find_cep_java.dto.EnderecoDto;
import com.example.api_find_cep_java.servico.ApiServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class CepController {

    @Autowired
    private ApiServico apiServico;

    // Exibe o formulário de CEP
    @GetMapping("/FindCep")
    public String mostrarTelaCep() {
        ;
        return "index"; // Retorna a página index.html
    }

    // Endpoint para buscar o CEP
    @PostMapping("/FindCep")
    @ResponseBody // Responde com os dados no formato JSON
    public EnderecoDto buscarCep(@RequestParam String cep) throws IOException, InterruptedException {
        return apiServico.getEndereco(cep); // Retorna os dados do endereço
    }

}