# Ecommerce de Compras Online

Sistema de compras online desenvolvido em Java. O sistema simula funcionalidades básicas de um e-commerce, como gestão de produtos, carrinho de compras, checkout, login de clientes, entre outras.

## Funcionalidades Principais

- **Listar Produtos:** Permite visualizar todos os produtos disponíveis para compra.
- **Adicionar Produto ao Carrinho:** Adiciona um produto selecionado pelo usuário ao carrinho de compras.
- **Ver Carrinho:** Exibe os produtos atualmente no carrinho de compras, incluindo detalhes como quantidade e preço total.
- **Remover Produto do Carrinho:** Remove um produto específico do carrinho de compras.
- **Adicionar Cartão:** Permite aos clientes adicionar informações de pagamento através de cartão de crédito.
- **Adicionar Endereço:** Permite aos clientes adicionar novos endereços de entrega.
- **Finalizar Compra:** Conclui a compra, processando o pagamento e registrando a transação.
- **Verificar Compras Anteriores:** Permite aos clientes visualizar histórico de compras realizadas anteriormente.
- **Ver Seus Dados:** Exibe informações detalhadas do perfil do cliente logado.
- **Fazer Login:** Permite aos visitantes efetuarem login utilizando seu email e senha cadastrados.

## Pré-requisitos

- JDK (Java Development Kit) instalado
- IDE de sua preferência (Eclipse, IntelliJ IDEA, etc.)
- Banco de dados (MySQL) configurado, se necessário

## Como Executar

1. Clone este repositório:

2. Abra o projeto na sua IDE.

3. Certifique-se de que as dependências necessárias estão configuradas.

4. Execute a classe principal `App.java` localizada em `src/main/java`. (rodar build: mvn exec:java -Dexec.mainClass="data.App")

5. Siga as instruções no console para interagir com o sistema.

## Tecnologias Utilizadas

- Java
- JDBC para integração com banco de dados
- MySQL para armazenamento de dados
- Maven para automação de compilação

## Estrutura do Projeto

- **`src/main/java/`**: Contém o código-fonte Java da aplicação.
- `App.java`: Classe principal que inicia a aplicação.
- Pacotes `business`, `data`, `entities`, e `services` com as respectivas classes para a lógica de negócio, acesso a dados, entidades de domínio e serviços.

- **`src/test/java/`**: Diretório para testes unitários, se aplicável.

## Melhorias Futuras

### 1. Adicionar Interface Gráfica (GUI)
   - Implementar uma interface gráfica usando JavaFX, Swing ou outra biblioteca GUI para proporcionar uma experiência mais interativa e amigável para os usuários.

### 2. Implementar Autenticação Multi-Fator (MFA)
   - Reforçar a segurança do sistema implementando autenticação multi-fator (MFA), aumentando a proteção contra acessos não autorizados às contas dos clientes.

### 3. Integração com Métodos de Pagamento Online
   - Integrar APIs de serviços de pagamento online (como PayPal, Stripe, PagSeguro) para oferecer aos clientes mais opções de pagamento e aumentar a conveniência durante o checkout.

### 4. Implementar Recomendações de Produtos
   - Desenvolver um sistema de recomendação de produtos que utilize o histórico de compras dos clientes ou algoritmos de filtragem colaborativa para sugerir produtos relevantes aos usuários.

### 5. Melhorar a Busca de Produtos
   - Aprimorar a funcionalidade de busca de produtos com opções avançadas de filtragem, como pesquisa por categoria, faixa de preço, avaliações dos clientes, entre outros critérios.

### 6. Implementar Testes Automatizados
   - Criar testes unitários e testes de integração automatizados para garantir a estabilidade e a funcionalidade do sistema, facilitando o desenvolvimento contínuo e a manutenção.

### 7. Adicionar Suporte a Avaliações e Comentários de Produtos
   - Permitir que os clientes deixem avaliações e comentários sobre os produtos adquiridos, proporcionando transparência e auxiliando outros usuários na tomada de decisão.

### 8. Implementar Recursos de Notificação
   - Adicionar notificações por e-mail ou SMS para atualizações de status de pedidos, promoções especiais, lembretes de carrinho abandonado, entre outras comunicações relevantes.

### 10. Adicionar Funcionalidades de Assinatura e Promoções
   - Implementar um sistema de assinatura para serviços premium, além de permitir a aplicação de cupons de desconto e promoções especiais para incentivar vendas.

### 11. Internacionalização e Localização
   - Suportar múltiplos idiomas e moedas para atender a uma base de clientes global, adaptando o sistema para diferentes regiões e culturas.

### 12. Monitoramento e Análise de Dados
   - Implementar ferramentas de monitoramento de desempenho e análise de dados para obter insights sobre o comportamento dos clientes, tendências de vendas e eficácia das estratégias de marketing.
