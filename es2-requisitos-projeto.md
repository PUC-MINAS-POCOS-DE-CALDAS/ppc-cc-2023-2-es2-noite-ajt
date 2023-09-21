
<h1 align="center">PROPOSTA DE DESENVOLVIMENTO DE SISTEMA PARA GESTÃO DE COMANDAS</h1>

 

##### Proponentes:   Angelica, João Marcelo, Tuanne Assenço
##### Cliente: Gabriel Henrique Garcia
##### Orientador: Diego Roberto Gonçalves de Pontes

### Escopo do problema fornecido pelo cliente
Esta proposta de projeto pretende criar uma plataforma digital com sua usabilidade voltada à dispositivos móveis, com a finalidade principal de gerenciar a comanda de pedidos dos clientes de um estabelecimento comercial voltado ao consumo de serviços locais, a fim de promover praticidade e comodidade para os clientes e melhoraria na prestação de serviços do estabelecimento.
### Levantamento de Requisitos
#### Requisitos Funcionais:
| RF | Descrição | Prioridade |
|--|--| -- |
| RF1 | CRUD de pratos, bebidas e itens ofertados no estabelecimento |Alta |
| RF2 | CRUD de usuários | Alta |
| RF3 | Vinculação do pedido à uma mesa do estabelecimento | Alta |
| RF4 | Ver cardápio | Alta |
| RF5 | Adicionar itens à lista(comanda) de pedido | Alta |
| RF6 | Finalizar a solicitação do pedido | Alta |
| RF7 | Acrescentar mais itens à comanda | Média |
| RF8 | Finalizar o acréscimo de itens e solicitar o novo pedido | Média |
| RF9 | Solicitar o fechamento da comanda | Alta |
| RF10 | Visualização do resumo dos itens e valor do pedido feito | Alta |
| RF11 | Escolha do meio de pagamento | Baixa |
| RF12 | Vinculação de cartão de Crédito/Débito ao perfil pessoal | Baixa |
| RF13 | Pagamento por meio da aplicação | Baixa |
| RF14 | Acesso ao recibo de pagamento | Alta |
| RF15 | CRUD de Comandas | Alta |


#### Requisitos Não Funcionais:
| RNF | Descrição | Categoria | Prioridade |
|--|--| -- | -- |
| RNF1 | O sistema deve ser compatível para o sistema operacional Android e iOS | Suportabilidade ou Implementação? | Alta |
| RNF2 | O sistema deverá ter um tempo de resposta curto | Performance | Baixa |
| RNF4 | O sistema deverá ter suporte para versões antigas do Android e iOS | Suportabilidade | Alta |
| RNF5 | O sistema deverá mostrar ao usuários respostas amigáveis para casos de erro no sistema | Usabilidade | Alta |
| RNF6 | O sistema deverá ter um suporte para tratamento de falhas no pagamento interno da aplicação | Usabilidade | Alta |
| RNF7 | O sistema deverá apresentar ao usuário uma interface amigável e simples, seguindo guidelines e boas práticas para criação de uma aplicação móvel para uma boa experiência de usuário | Implementação | Baixa |
| RNF8 | A aplicação deverá ser implementada em ReactNative | Implementação | Alta |


### Detalhamento dos Requisitos
#### Requisitos Funcionais:
 1. CRUD de pratos, bebidas e itens ofertados no estabelecimento: Para criação de um cardápio, será necessário cadastrar no sistema todos os itens que o estabelecimento oferecerá aos clientes;
 2. CRUD de usuários: Todos os clientes só conseguirão fazer o pedido se estiverem cadastrados na plataforma;
 3. Vinculação do pedido à uma mesa do estabelecimento: Quando o usuário acessar o aplicativo, será necessário informar qual o número da mesa em que se localiza, para que os pedidos sejam entregues no local correto;
 4. Ver cardápio: No sistema deve ser disponibilizado um menu do cardápio para que os usuários consulte os itens ofertados no estabelecimento;
 5. Adicionar itens à lista (comanda) de pedido: Através do cardápio, o usuário poderá escolher os itens aos quais quer solicitar, adicionando-os à comanda da mesa em que se encontra;
 6. Finalizar a solicitação do pedido: Após adicionar à comanda todos os itens, o usuário poderá confirmar o pedido e ele será enviado ao sistema interno para preparação;
 7. Acrescentar mais itens à comanda: Mesmo após solicitar um pedido, é possível adicionar novos itens à uma nova lista para um novo pedido;
 8. Finalizar o acréscimo de itens e solicitar o novo pedido: Após a escolha dos novos itens, o usuário poderá novamente solicitar o pedido, que será acrescentado à comanda da mesa e enviado ao sistema interno para preparação;
 9. Solicitar o fechamento da comanda: Ao solicitar o fechamento da comanda, será apresentado ao usuário a lista de todos os itens presentes na comanda, assim como seus respectivos preços e o valorfinal a ser pago ao estabelecimento;
 10. Visualização do resumo dos itens e valor do pedido feito: A qualquer momento o usuário poderá acessar a lista da comanda com todos os itens e seus preços, bem como o valor final a ser pago ao estabelecimento
 11. Escolha do meio de pagamento: O usuário poderá informar qual o método de pagamento que deseja utilizar (Dinheiro, Pix, Cartão), antes de finalizar a solicitação do fechamento da comanda;
 12. Vinculação de cartão de Crédito/Débito ao perfil pessoal: O usuário poderá cadastrar seu cartão à sua conta, podendo utilizá-lo para o pagamento posteriormente
 13. Pagamento por meio da aplicação: Para que não haja a necessidade de um funcionário para atendê-los a fim de receber o pagamento, o usuário poderá efetuar o pagamento da comanda por meio da aplicação, de mandeira prática e rápida;
 14. Acesso ao recibo de pagamento: Todos os pagamentos feitos pela aplicação deverão ser vinculados à conta do usuário para consulta posteriores;
 15. CRUD das comandas: No sistema interno, o funcionário poderá gerenciar as comandas de cada mesa, podendo fazer a troca de mesa, adição, edição e remoção de itens;
 
