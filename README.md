# MyApp_consumindo_ViaCEP

## Descrição
Este repositório contém o código-fonte do backend para o projeto "MyApp_consumindo_ViaCEP". O objetivo principal do projeto é fornecer um serviço que consome a API Pública do ViaCEP, permitindo que os usuários realizem consultas de endereços utilizando um CEP. Além disso, a aplicação oferece a funcionalidade de baixar um arquivo de texto contendo o histórico de consultas do usuário.

**Recursos:**
- Consulta de endereço por CEP utilizando a API ViaCEP.
- Download de um arquivo de texto com o histórico de consultas do usuário.

**Nota: Este projeto ainda não possui uma interface web, portanto, recomenda-se baixar e utilizar a aplicação no desktop.**

## Comandos para Clonar o Repositório

### HTTP
```bash
git clone https://github.com/seu-usuario/MyApp_consumindo_ViaCEP.git
```

### SSH
```bash
git clone git@github.com:seu-usuario/MyApp_consumindo_ViaCEP.git
```

**Nota: Caso você não tenha uma chave SSH configurada, siga os passos abaixo:**

1. **Gerar uma nova chave SSH (se ainda não tiver uma):**
   ```bash
   ssh-keygen -t rsa -b 4096 -C "seu-email@example.com"
   ```

2. **Adicionar sua chave SSH ao agente SSH:**
   ```bash
   eval "$(ssh-agent -s)"
   ssh-add ~/.ssh/id_rsa
   ```

3. **Copiar a chave SSH para a área de transferência:**
   ```bash
   pbcopy < ~/.ssh/id_rsa.pub   # Este comando é específico para sistemas macOS
   ```

4. **Adicionar a chave SSH ao seu perfil GitHub:**
   - Acesse as configurações do seu perfil GitHub.
   - Navegue até "SSH and GPG keys".
   - Clique em "New SSH key" e cole a chave previamente copiada.

Agora você deve conseguir clonar o repositório usando o comando SSH mencionado acima.

**Nota: Certifique-se de substituir "seu-usuario" pelo seu nome de usuário GitHub.**

## Configuração da Biblioteca GSON

Para executar o projeto, siga os passos abaixo para adicionar a biblioteca GSON:

1. Acesse o link: [GSON 2.10.1](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.10.1)
2. Baixe o arquivo .jar da biblioteca.

**Configuração no IntelliJ IDEA:**

3. Com o projeto aberto, vá em `File > Project Structure`.
4. Na janela de configuração, clique em `Modules > Dependencies`.
5. Clique no ícone de "+" para adicionar uma nova dependência e selecione o arquivo .jar da biblioteca GSON que você baixou.
6. Clique em "OK" na parte inferior da janela para finalizar.

Agora o projeto está configurado corretamente para utilizar a biblioteca GSON. Certifique-se de incluir o arquivo .jar da GSON sempre que distribuir o projeto.
