package br.com.viaCep.entity;

public record Endereco
        (
                String cep,
                String logradouro,
                String localidade,
                String complemento,
                String bairro,
                String uf
        ) {
    @Override
    public String toString() {
        return  "\n" + "*** ENDEREÇO *** " + "\n" +
                "C.E.P: " + cep + "\n" +
                "Logradouro: " + logradouro + "\n" +
                "Localidade: " + localidade + "\n" +
                "Complemento: " + complemento + "\n" +
                "Bairro: " + bairro + "\n" +
                "UF: " + uf + "\n";
    }
}
