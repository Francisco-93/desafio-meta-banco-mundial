# World Bank API
#### API responsável por retornar os dados do banco mundial referentes ao percentual de pessoas que vivem com até $1,90 por dia em diferentes países do mundo

# Para iniciar a aplicação
Existem dois microsserviços, sendo o microsserviço A responsável por retornar ao frontent e o microsserviço B responsável por consultar a API pública do banco mundial referente ao tema mencionado.

Para iniciar a aplicação backend siga o seguinte passo:
Ir até a raíz do microsserviço A e rodar o seguinte comando:
```
docker-compose up
```

Para rodar a aplicação frontend, baixe o projeto do repositório do github no seguinte link: https://github.com/Francisco-93/desafio-meta-banco-mundial.git

```
git clone https://github.com/Francisco-93/desafio-meta-banco-mundial.git
```
 
entre dentro da pasta /frontend e execute o comando

```
npm install
```

terminado o processo digite o comando 

```
ng serve
```
