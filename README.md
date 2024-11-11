## Disciplina - Arquitetura Java - Pós Graduação

A proposta do projeto é simular um serviço que serve como intermediário no processo de entrega de produtos entre duas pessoas. Possibilitando que um cliente encontre um motorista que transporte um pacote / produto para outro cliente.

## Como rodar o projeto?
- Execute o `DivinoMatheusApplication.java`
- A aplicação estará disponível em: http://localhost:8080/swagger-ui.html

## Arquitetura do projeto
![alt text](./arquitetura-projeto.svg)

## Diagrama de classes
![alt text](./arquitetura-java.svg)

## Como conectar com o banco de dados
Após rodar a aplicação, acesse a página: http://localhost:8080/h2-console

- URL: `jdbc:h2:mem:deliveries-db`
- Usuário: `user`
- Senha: `password`

Depois de preencher os campos, clique em `Connect`