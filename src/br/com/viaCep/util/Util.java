package br.com.viaCep.util;

import br.com.viaCep.entity.Endereco;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Util {

    public void gerarMenu() throws IOException, InterruptedException {
        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        List<Endereco> lista = new ArrayList<>();
        do {

            System.out.println("__________MENU VIACEP__________");
            System.out.println();
            System.out.println("\t1 - Consultar um endereço");
            System.out.println("\t2 - Gerar arquivos com minhas consultas");
            System.out.println("\t3 - Encerrar programa");
            System.out.print("opção --> ");
            opcao = sc.nextInt();

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setPrettyPrinting()
                    .create();
            switch (opcao){
                case 1:
                    colsultarCep(lista);
                    break;
                case 2:
                    gerarArquivo(lista);

                    System.out.println("Deseja continuar ou encerrar o programa? (Sim - continuar | Não - Encerrar o programa)");
                    String resposta = sc.next();

                    if (resposta.equalsIgnoreCase("não")){
                        opcao = 3;
                    }
                    break;
            }

        }while(opcao != 3);

        System.out.println(lista);
        System.out.println("Programa finalizado!!!");
    }

    public void gerarArquivo(List<Endereco> lista) throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar arquivo");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos de Texto (*.txt)", "txt"));

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            try (FileWriter escrita = new FileWriter(fileToSave + ".txt")) {
                for (Endereco endereco : lista) {
                    escrita.write(endereco.toString());
                    escrita.write("\n"); // Adiciona uma quebra de linha entre os endereços
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Seu arquivo está sendo gerado e foi salvo em: " + fileToSave.getAbsolutePath());
            System.out.println();
        } else {
            System.out.println("Operação cancelada pelo usuário.");
        }
    }

    public void colsultarCep(List<Endereco>lista) {
        Gson gson = new Gson();
        Scanner sc = new Scanner(System.in);
        String cep;
        do {
            System.out.println();
            System.out.print("Digite um cep--> ");
            cep = sc.next();
            System.out.println();
            if (cep.length() < 8 ){
                System.out.println("C.E.P Invalido!!! tem menos que 8 caracteres!");
            }
        }while (cep.length() < 8 );

        URI url = URI.create("https://viacep.com.br/ws/" + cep +"/json/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        HttpResponse<String> response = null;

        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            new Gson().fromJson(response.body(),Endereco.class);
            String json = response.body();
            //System.out.println(json);
            Endereco endereco = gson.fromJson(json, Endereco.class);
            System.out.println(endereco);
            lista.add(endereco);


        } catch (RuntimeException e){
            System.out.println("***Error!*** Details:O C.E.P fornecido está incorreto");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}


