package com.ajt.projeto

fun main() {

    val maria = Funcionario("Maria", "(35)91234-5678", "123.456.789-55", "faz tudo")
    val jose = Funcionario("Jose", "(35)91234-5678", "123.456.789-55", "faz tudo")

    val funcionarios = mutableListOf(maria, jose)

    val mesa1 = Mesa(1)
    val mesa2 = Mesa(2)
    val mesa3 = Mesa(3)
    val mesa4 = Mesa(4)
    val mesa5 = Mesa(5)
    val mesa6 = Mesa(6)
    val mesa7 = Mesa(7)
    val mesa8 = Mesa(8)
    val mesa9 = Mesa(9)

    val mesas = mutableListOf(mesa1, mesa2, mesa3, mesa4, mesa5, mesa6, mesa7, mesa8, mesa9)

    val estabelecimento = Estabelecimento("7-Bar", "(35)91234-5678", 0.0, "83.887.335/0001-09", "Rua Padre Bartolomeu Sipolis 112-B", Cardapio.lista, funcionarios, mesas)

    estabelecimento.boasVindas()
    estabelecimento.verLucroAtual()
    estabelecimento.verMesasOcupadas()

    val tuanne = Cliente("Tuanne", "(35)91234-5678", "123.456.789-55")
    estabelecimento.alocarClienteNaMesa(mesa5, tuanne)
    tuanne.verCardapio()
    val pedidoTuanne = mutableListOf(Cardapio.vinho)
    estabelecimento.receberPedido(tuanne.nome, tuanne.fazerPedido(pedidoTuanne))

    val jm = Cliente("João Marcelo", "(35)91234-5678", "123.456.789-55")
    estabelecimento.alocarClienteNaMesa(mesa3, jm)

    val pedidoJM = mutableListOf(Cardapio.cerveja, Cardapio.pastel)
    estabelecimento.receberPedido(jm.nome, jm.fazerPedido(pedidoJM))


    val outroPedidoTuanne = mutableListOf(Cardapio.agua)
    estabelecimento.receberPedido(tuanne.nome, tuanne.fazerPedido(outroPedidoTuanne))


    val angelica = Cliente("Angelica", "(35)91234-5678", "123.456.789-55")
    estabelecimento.alocarClienteNaMesa(mesa8, angelica)

    val pedidoAngelica = mutableListOf(Cardapio.suco, Cardapio.refrigerante, Cardapio.salgadinho, Cardapio.pastel)
    estabelecimento.receberPedido(angelica.nome, angelica.fazerPedido(pedidoAngelica))

    estabelecimento.verMesasOcupadas()

    estabelecimento.finalizarMesa(tuanne.nome)
    estabelecimento.verMesasOcupadas()

    estabelecimento.verLucroAtual()

    estabelecimento.finalizarMesa(jm.nome)
    estabelecimento.finalizarMesa(angelica.nome)

    estabelecimento.verMesasOcupadas()
    estabelecimento.verLucroAtual()
}

class Cardapio {
    companion object {
        //todos os itens do cardapio
        val agua = Consumivel("Agua", 2.50)
        val refrigerante = Consumivel("Refrigerante", 5.0)
        val suco = Consumivel("Suco", 3.0)
        val salgadinho = Consumivel("Salgadinho", 5.0)
        val cerveja = Consumivel("Cerveja", 9.0)
        val vinho = Consumivel("Vinho", 13.0)
        val pastel = Consumivel("Pastel", 6.0)

        val lista = mutableListOf(agua, refrigerante, salgadinho, suco, cerveja, vinho, pastel)

        fun verCardapio() {
            println("\nCARDAPIO")
            lista.forEach {
                println("- ${it.nome} ----- ${it.valor}")
            }

            println("\n")
        }
    }
}

class Cliente(var nome: String, var telefone: String, var cpf: String) {

    fun verCardapio() {
        println("Cliente ${nome} pediu o cardapio")
        Cardapio.verCardapio()
    }

    fun fazerPedido(consumivel: MutableList<Consumivel>): Pedido {
        return Pedido(consumivel)
    }
}

class Estabelecimento(var nome: String, var telefone: String, private var lucro: Double, var cnpj: String, var endereco: String, var cardapio: MutableList<Consumivel>, var funcionarios: MutableList<Funcionario>, var mesas: MutableList<Mesa>) {

    fun boasVindas() {
        println("Bem-vindo ao ${nome}, estamos no endereço: ${endereco}. Para delivery ligue: ${telefone}")
    }

    fun verMesasOcupadas() {
        val mesasOcupadas = mesas.filter { it.comanda != null }

        if (mesasOcupadas.isEmpty()) {
            println("Não há mesas ocupadas")
        } else {
            println("\n\nAs seguintes mesas estão ocupadas:")
            mesasOcupadas.forEach {
                println(" - ${it.numero}")
            }
        }
    }

    fun verLucroAtual() {
        println("\nO lucro atual do estabelecimento ${nome} é de: R$${lucro}")
    }

    fun alocarClienteNaMesa(mesa: Mesa, cliente: Cliente) {

        val comanda = Comanda(cliente)
        mesa.comanda = comanda
        println("\n${cliente.nome} foi alocado à mesa ${mesa.numero}")
    }

    fun receberPedido(cliente: String, pedido: Pedido) {

        val mesaCliente = mesas.first { it.comanda?.cliente?.nome == cliente }
        mesaCliente.comanda?.pedidos?.add(pedido)

        println("Os seguintes pedidos da mesa ${mesaCliente.numero} do cliente ${cliente} foram recebidos e está em preparo!")
        pedido.consumivel.forEach {
            println(" - ${it.nome}")
        }
        println("")
    }

    fun finalizarMesa(cliente: String) {

        val mesaCliente = mesas.first { it.comanda?.cliente?.nome == cliente }
        var valor = 0.0

        println("\n\nFinalizando os serviços para a mesa ${mesaCliente.numero}")

        println("A comanda da mesa contém os seguintes itens e valores:")
        mesaCliente.comanda?.pedidos?.forEach { pedido ->
            pedido.consumivel.forEach {
                println(" - ${it.nome} > R$${it.valor}")
                valor += it.valor
            }
        }

        mesaCliente.comanda?.valorTotal = valor

        println("\nO total a ser pago para essa mesa é: R$${mesaCliente.comanda?.valorTotal}")

        mesaCliente.comanda = null

        receberPagamento(valor)
    }

    private fun receberPagamento(valorRecebido: Double) {
        lucro += valorRecebido
        println("\nO ${nome} agradece sua preferência, volte sempre! :)")
    }
}

data class Pedido(var consumivel: MutableList<Consumivel>)

data class Comanda(var cliente: Cliente, var valorTotal: Double = 0.0, var pedidos: MutableList<Pedido> = mutableListOf())

data class Mesa(var numero: Int, var comanda: Comanda? = null)

data class Funcionario(var nome: String, private var telefone: String, private var cpf: String, var cargo: String)

data class Consumivel(var nome: String, var valor: Double)
