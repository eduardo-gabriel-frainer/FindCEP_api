package com.example.api_find_cep_java.servico;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

import com.example.api_find_cep_java.dto.EnderecoDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ApiServico {

    public EnderecoDto getEndereco(String cep) throws IOException, InterruptedException {
        EnderecoDto enderecoDto = null;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://viacep.com.br/ws/" + cep + "/json/")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            enderecoDto = mapper.readValue(response.body(), EnderecoDto.class);
        } catch (Exception e) {
            System.out.println("Erro ao buscar o CEP " + e.getMessage());
        }
        return enderecoDto;
    }
}
