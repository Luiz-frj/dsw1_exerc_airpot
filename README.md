DSW1 - Sistema de Gerenciamento de Aeroporto
Este é um projeto acadêmico para gerenciamento de voos em um aeroporto, desenvolvido como parte das atividades da disciplina Desenvolvimento de Sistemas Web 1.

Descrição
O sistema permite o gerenciamento de voos, incluindo:
- Cadastro de novos voos.
- Controle de estados de voo (chegando, embarcando, decolando, decolado).
- Notificação de alterações por meio de Observers.
- Autenticação para administradores.


Tecnologias Utilizadas:

- Java: Linguagem principal do projeto.
- Jakarta EE: Framework para desenvolvimento web.
- Servlets: Para manipulação de requisições HTTP.
- JSP: Para renderização das interfaces dinâmicas.

Padrões de Projeto:

- Observer: Para sincronização de estados.
- State: Para controle dos estados de voos.

Funcionalidades
- Autenticação:
  - Login e logout de administradores.
  - Controle de sessões com limite de tempo.

- Gerenciamento de Voos
  - Cadastro de voos com informações como número, agência e horário.
  - Atualização do estado dos voos.
  - Exibição de voos por estado (chegando, embarcando, etc.).

- Notificações
  - Observers são atualizados automaticamente ao alterar o estado de um voo.

Estrutura do Projeto
- controller/: Contém as classes de controle, como ProjectServlet.
- model/: Implementa as regras de negócio e padrões de projeto.
- entity/: Classes para representar os dados, como FlightData.
- observer/: Interfaces e classes para o padrão Observer.
- flightstates/: Classes de estados de voos (chegando, embarcando, etc.).
- view/: Arquivos JSP para exibição ao usuário.
