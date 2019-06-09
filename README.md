# pagamento-api
Desacoplamento da funcionalidade de pagamento do sistema legado.

Guia de inicialização do projeto:

O projeto esta dividido em duas pastas frontEnd e backEnd sendo que na pasta frontEnd é possivel localizar o arquivo index.html que o levará a pagina da aplicação.
note que ela carrega apenas uma tabela sem valores, para subir o servidor de aplicação contido na pasta backEnd faça:

Dentro da pasta ...pagamento\backend\target

Execute o comando abaixo no cmd:
java -jar pagamento-0.0.1-SNAPSHOT.jar

IMPORTANTE: Garantir que tenha o java instalado na maquina, nesta  versão foi utilizado o java 1.8.0.201.

Pós subir o servidor é preciso popular o banco de dados:

Banco de dados: MySql
User: root
Senha: 123456

NOTA: Todas as tabelas são criadas automaticamente sendo nescessario somente executar as querys abaixo:

insert into produto (nome, valor, parcelas, tipo_pagamento) values ("Cartao de credito", 200.0, 3, "PAGAMENTO_A_PRAZO");
insert into produto (nome, valor, parcelas, tipo_pagamento) values ("Cartao corporativo", 33.05, 1, "DEBITO_EM_CONTA");
insert into produto (nome, valor, parcelas, tipo_pagamento) values ("Cartao cidadao", 44.89, 1, "PAGAMENTO_BOLETO");
insert into produto (nome, valor, parcelas, tipo_pagamento) values ("Cartao Pre pago", 78.50, 10, "PAGAMENTO_A_PRAZO");

Importante: A aplicação esta configurada para criar um tabela nova a cada nova execução então sempre que executar é preciso popular o banco novamente executando as querys.

Tudo pronto ! agora é só abrir o arquivo index.html com o seu navegador e testar o serviço.

Exibe todos os produtos contidos no banco após a execução das querys no formato Json padrão Rest.
URLs:http://localhost:8080/api/produto/todos


