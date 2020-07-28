# Introdução
Esse repositório contém instruções para o teste da vaga de Desenvolvedor Júnior nas Empresas Randon.

# Atividades

1. Faça um fork deste repositório Git e crie um novo repositório público na sua conta do GitHub (caso ainda não possua, crie uma gratuitamente)
   
2. Desenvolva uma API simples utilizando Node.js (Javascript ou TypeScript) ou Python (Flask ou Django)

3. Consulte dados do banco de dados público de sequenciamento de RNA da organização RNA Central (https://rnacentral.org/help/public-database) utilizando as credenciais do arquivo **config-db.json**

4. Crie 2 endpoints na sua API:
   - **GET /proteins**
     - propósito: listar proteínas
     - retornar JSON contendo todos os campos da tabela *protein_info*
     - utilizar páginas para retornar os resultados
     - parâmetro *limit* controla o número de registros retornados
     - parâmetro *offset* controla o número de registros que serão pulados
     - para implementar a funcionalidade na consulta SQL ao banco da dados, veja: https://www.postgresql.org/docs/8.1/queries-limit.html
  
   - **GET /proteins/:id**
     - propósito: consultar dados de uma proteína
     - buscar uma proteína específica do *id* informado
     - retornar JSON contendo todos os campos da tabela *protein_info* para aquela proteína

5. Trate as exceções utilizando os códigos de retorno do protocolo HTTP que considerar apropriados
   
6. Crie uma especificação Open API (Swagger) para sua API

7. Faça commit de todo o seu código no seu repositório GitHub (lembre-se de marcá-lo como público!)
   
8. Envie-nos o link de acesso ao seu repositório (via plataforma Gupy)
 