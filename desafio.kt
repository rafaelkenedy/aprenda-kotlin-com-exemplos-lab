// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        if (inscritos.contains(usuario)) {
            println("O usuário ${usuario.nome} já está matriculado.")
        } else {
            inscritos.add(usuario)
            println("O usuário ${usuario.nome} foi matriculado com sucesso.")
        }
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
        println("Conteúdo ${conteudo.nome} foi adicionado.")
    }

    fun removerConteudo(conteudo: ConteudoEducacional) {
        if (conteudos.remove(conteudo)) {
            println("Conteúdo ${conteudo.nome} foi removido.")
        } else {
            println("Conteúdo ${conteudo.nome} não foi encontrado.")
        }
    }
}

fun main() {
    // Criar alguns conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 60)
    val conteudo2 = ConteudoEducacional("OOP em Kotlin", 90)

    // Criar uma formação
    val formacao = Formacao("Desenvolvimento Android", Nivel.BASICO)

    // Adicionar conteúdo à formação
    formacao.adicionarConteudo(conteudo1)
    formacao.adicionarConteudo(conteudo2)

    // Criar alguns usuários
    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("Bob")

    // Matricular usuários
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario1) // Teste de duplicação

    println("Usuários inscritos: ${formacao.inscritos.map { it.nome }}")
}

