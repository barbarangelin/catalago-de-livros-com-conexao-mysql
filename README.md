## Software de catalogação de livro em Java com conexão MySQL
### Esse programa foi feito com o objetivo de possibilitar a visualização, a edição e a inserção de livros em uma biblioteca particular digital

## Tabela de conteúdos
- [Concepção do software](#concepção-do-software)
- [Interfaces gráficas](#interfaces-gráficas)
- [Como utilizar](#como-utilizar)

<img width="936" height="639" alt="Sobre" src="https://github.com/user-attachments/assets/748984ce-d6af-4a7a-82d9-50b90fa3812b" />
<img width="1872" height="639" alt="1" src="https://github.com/user-attachments/assets/abdfaeab-ee9d-44b7-9029-acad2dd1b803" />
<img width="1872" height="639" alt="2" src="https://github.com/user-attachments/assets/6b594592-6e95-4c14-9ad4-f4e85068e18b" />
<img width="1872" height="639" alt="3" src="https://github.com/user-attachments/assets/f290a9be-a893-4873-81c2-5588898802fa" />

# Concepção do software
O software foi primordialmente programado em $\color{pink}{Java}$, além do $\color{pink}{JavaFX}$ e o $\color{pink}{JavaS \space Swing}$ para a elaboração da GUI

Por conta da utilização do **JavaFX**, também foi feito o uso do $\color{pink}{Scene \space Builder}$ como um software auxiliar

Outrossim, foi utilizado o $\color{pink}{MySQL}$ para o armazenamento dos dados, nesse caso, os livros

# Interfaces gráficas
- Tela de login
- Página inicial
- Visualizador de livros
- Página de adição de livros
- Página de procura de livros
- Página de edição de livros
- Sobre

# Como utilizar
É possível fazer uso dos arquivos do repositório através de uma IDE qualquer, como o Netbeans, ou por meio do arquivo Jar. Caso opte pelo arquivo Jar, recomendo que inicialize o arquivo diretamente do terminal caso haja algum erro de inicialização das bibliotecas

Em relação à conexão com o database, é necessário fazer alterações no código onde for necessário especificar o nome do seu database, seu usuário e sua senha. Ou seja, nos controllers onde houver a necessidade de conexão com o MySQL. A seguir está o escopo da tabela **itens** acessada e utilizada no código:
<img width="745" height="164" alt="image" src="https://github.com/user-attachments/assets/bee13040-28c8-4b20-90d6-54933baaa81f" />


