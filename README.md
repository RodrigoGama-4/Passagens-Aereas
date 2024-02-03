# Passagens-Aereas

Trabalho feito utlizando a framework Spring boot e um banco de dados em memória.

Para executar API basta rodar a aplicação e ir, por exemplo, para uma ferramenta de testes de API como o Insomnia ou o PostMan.

Utilize localhost:8080/companhia/x

Onde x vai ser passageiro ou tickets.

### Passageiro

#get de passageiro: localhost:8080/companhia/passageiro

#post de passageiro: localhost:8080/companhia/passageiro com body json com nome(string) e nacionalidade.

#delete de passageiro: localhost:8080/companhia/passageiro/id

#put de passageiro: localhost:8080/companhia/passageiro/id com body json com nome(string) e nacionalidade.

### Tickets

#get de tickets: localhost:8080/companhia/tickets

#post de tickets: localhost:8080/companhia/tickets com body json com destino(String), dataVoo(String) e idPassageiro(Passageiro)

#delete de tickets: localhost:8080/companhia/tickets/id

#put de tickets: localhost:8080/companhia/tickets/id com body json com destino(String), dataVoo(String) e idPassageiro(Passageiro)
