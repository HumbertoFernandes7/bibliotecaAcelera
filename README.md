# bibliotecaAcelera

Projeto desenvolvido em Java 17 com Spring Boot, Spring Data JPA, Hibernate, Swagger e Banco de Dados MySql.

Um projeto de API para gerenciamento de uma Biblioteca com as seguintes funções até o momento.

O projeto permite que você:

+ Adicione autores
+ Altere autores
+ Liste todos os autores cadastrados
+ Liste um autor pelo id

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

+ Adicione livros
+ Altere livros
+ Liste todos os livros
+ Liste um livro pelo id
+ Exclusão de livros pelo id

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

(Banco de dados Mysql)
Em aplication.properties o nome padrão gerado é: 
+ (bibliotecaDB)
+ Nome de usuario e senha padrão: (root)
<p>As informações acima podem ser livremente alteradas caso necessario</p>

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Observações:
+ Todos os campos são obrigatorios e não podem estar nulos.

Autor:
+ Nome não podera ultrapassar 100 caracteres
+ Biografia não podera ultrapassar 1000 caracteres



Livro:
+ Titulo não podera ultrapassar 200 caracteres
+ DataLancamento não podera ultrapassar 4 caracteres
+ Deve conter ao menos 1 autor
