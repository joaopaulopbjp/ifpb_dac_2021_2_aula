<template>
  <main class="container">
    <div>
      <header>
        <div class="jumbotron mb-0">
          <h1 class="display-4">Lista de Autores</h1>
        </div>
      </header>
      <div class="listaLivros" v-for="autor in autores" :key="autor.nome">
        <div class="card">
          <div class="card-header">
          </div>
          <div class="card-body">
            <div> Nome: {{autor.nome}}</div>
            <div > E-mail: {{autor.email}}</div>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import servicoAutor from '../servico/servicoAutor'

export default {
  name: 'Home',
  data() {
      return {
        autores: this.$store.state.autores
      }
    },
  created(){
    console.log("Created.")
    servicoAutor.lista().then(
      dado => {console.log( dado.data),
      this.$store.state.autores = dado.data,
      this.autores = this.$store.state.autores})
  }

}
</script>
