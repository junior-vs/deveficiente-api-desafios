# Cadastro de um novo autor

## Necessidades

É necessário cadastrar um novo autor no sistema. Todo autor tem um nome, email e uma descrição. Também queremos saber o instante exato que ele foi registrado.
restrições

* O instante não pode ser nulo
* O email é obrigatório
* O email tem que ter formato válido
* O nome é obrigatório
* A descrição é obrigatória e não pode passar de 400 caracteres

### minhas

* documentar com openapi

## resultado esperado

* Um novo autor criado e status 200 retornado

## informações de suporte geral

Será que você fez um código parecido com esse exemplo aqui ?
Se a resposta para o ponto 1 foi sim, recomendo de novo esse material aqui sobre arquitetura x design. Também acho que vai ser legal você olhar a minha implementação logo de cara, apenas para ter uma ideia de design que estou propondo.
Controllers 100% coesos para lembrar você a nossa ideia de ter controllers que utilizam todos os atributos.
Como foi que você fez para receber os dados da requisição? Será que aproveitou a facilidade do framework e recebeu a sua entidade(objeto que faz parte do domínio) direto no método mapeado para um endereço? Dá uma olhada nesse pilar aqui.
Dado que você separou os dados que chegam da request do objeto de domínio, como vai fazer para converter dessa entrada para o domínio? Sugiro olhar um pouco sobre nossa ideia de Form Value Objects.
Muitos dos problemas de uma aplicação vem do fato dela trabalhar com objetos em estado inválido. O ponto mais crítico em relação a isso é justamente quando os dados vêm de outra fonte, por exemplo um cliente externo. É por isso que temos o seguinte pilar: quanto mais externa é a borda mais proteção nós temos. Confira uma explicação sobre ele aqui e depois aqui
Todo framework mvc minimamente maduro possui um mecanismo pronto de realizar validação customizada. Spring, NestJS e ASP.NET Core MVC têm.
Nome e email são informações obrigatórias. Como você lidou com isso? Informação natural e obrigatória entra pelo construtor
Deixamos pistas que facilitem o uso do código onde não conseguimos resolver com compilação. Muitas vezes recebemos String, ints que possuem significados. Um email por exemplo. Se você não pode garantir a validação do formato em compilação, que tal deixar uma dica para a outra pessoa?
Utilize um insomnia ou qualquer outra forma para verificar o endpoint
Pegue cada uma das classes que você criou e realize a contagem da carga intrínseca. Esse é o viés de design que estamos trabalhando. Precisamos nos habituar a fazer isso para que se torne algo automático na nossa vida.
Como Alberto faria esse código?


informações de suporte para a combinação Java/Kotlin + Spring
Para receber os dados da request como json, temos a annotation @RequestBody
Usamos a annotation @Valid para pedir que os dados da request sejam validados
Para realizar as validações padrões existe a Bean Validation
Como criar um @RestControllerAdvice para customizar o json de saída com erros de validação
Como externalizar as mensagens de erro no arquivo de configuração.
