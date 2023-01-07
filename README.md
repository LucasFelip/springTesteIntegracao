# Laboratório de Engenharia de Software II
## 📜 Descrição da atividade
Implementação de Testes para uma API REST usando Spring Bootpara um fragmento de um sistema de Transportadora.

## 📚 Questões
1. Camada de Modelo – Mapear as entidades com as anotações JPA
2. Você deverá anotar as validações com o Bean Validation nas classes do modelo
3. Camada de Repositório (deverá ser implementada com Spring Data JPA)
4. Camada de Serviço – Sugestão FreteService
5. Camada de Controle – API REST

## 🛠️ Modelo de banco de dados do sistema de Frete a ser considerado
<img src="modelo-BD.png" alt="modelo banco de dados">

## 🛠️ Pipeline CI
#### tests.yml 
            
        Gatilho - qualquer atualização nas branches </br>
        Jobs: 
        - tests
              steps:
                  Setup Java JDK
                  Setup Maven cache
                  Run Tests
#### ci.yml

        Gatilho - apenas pull requestes com status closed
        Jobs:
        - build
            steps:
                Run a one-line script
        - deploy-dev
            environment: dev 
            steps:
                Checkout Security
                Setup Java JDK
                Build test
                Run test
                Report
        - deploy-prod
            environment: prod
            steps:
                Run a one-line script

## 👨‍🎓 Aluno
Lucas Ferreira - [<img src=https://cdn.iconscout.com/icon/free/png-256/github-163-761603.png width="15" height="15"/> **GitHub**][github.lucas] <br>

Tadeu Viegas - [<img src=https://cdn.iconscout.com/icon/free/png-256/github-163-761603.png width="15" height="15"/> **GitHub**][github.tadeu] <br>

David Gomes - [<img src=https://cdn.iconscout.com/icon/free/png-256/github-163-761603.png width="15" height="15"/> **GitHub**][github.david] <br>

David Alysson - [<img src=https://cdn.iconscout.com/icon/free/png-256/github-163-761603.png width="15" height="15"/> **GitHub**][github.davi] <br>

## 🔗 Sobre
[Atividade 05 - Teste de API desenvolvida com Spring Boot][classroom.tarefa1] <br>
[Atividade 07 Parte 02 - Proposta de um Pipeline para um ambiente de Integração Contínua][classroom.tarefa2] <br>
Sistemas de Informação - DCOMP/IFMA <br>
Professor: Joao Carlos Pinheiro - [<img src=https://cdn.iconscout.com/icon/free/png-256/github-163-761603.png width="15" height="15"/> **GitHub**][github.jcpinheiro]<br>
Engenharia de Software II

<!-- LINKS DE REFERENCIA -->

[github.lucas]: <https://github.com/LucasFelip>
[github.tadeu]: <https://github.com/TadeuViegas>
[github.david]: <https://github.com/DavidGomesh>
[github.davi]: <https://github.com/DavidAly>
[github.jcpinheiro]: <https://github.com/jcpinheiro>
[classroom.tarefa1]: <https://classroom.google.com/u/1/c/NTQ1Mjc4NTMzODgx/a/NTM5NjQ0NjQzNzUw/details>
[classroom.tarefa2]: <https://classroom.google.com/u/1/c/NTQ1Mjc4NTMzODgx/a/NTQwNzY3Mzg3NjYx/details>