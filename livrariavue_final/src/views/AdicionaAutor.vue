<template>
<main class="container">
  <div>
    <header>
      <div class="jumbotron mb-0">
        <h1 class="display-4">Adicionar Autore</h1>
      </div>
    </header>

    <div class="card">
      <form class="card-body" @submit.prevent>
        <div class="form-group">
          <label for="nome" class="form-label">Nome:</label>
          <input type="text" required id="nome" class="form-control" v-model="autor.nome">
          <div class="invalid-feedback"></div>
        </div>
        <div class="form-group">
					<label for="email" class="form-label">E-mail:</label>
					<input type="email" required id="email" class="form-control" v-model="autor.email">
					<div class="invalid-feedback"></div>
				</div> 
				
        <button type="submit" value="Enviar" v-on:click="enviarNovoAutor()">Enviar</button>
      </form>
		</div>
	</div>
</main>
</template>

<script>
import servicoAutor from '../servico/servicoAutor'

export default {
  name: 'AdicionaAutor',
  data() {
      return {
        autor:{
          nome:"",
          email:""
        }
      }
    },
  methods:{
    enviarNovoAutor: function(){
      if(this.autor.nome != '' && this.autor.email != ''){
        servicoAutor.adiciona(this.autor).then(
          dado => {console.log( dado.data),
          this.$store.commit('ADICIONA_AUTOR',this.autor)})
        console.log("Autor adicionado: "+this.autor.nome);
        this.$router.push("/");
      }else{
        console.log("ERRO: Autor com valores vazios ");
      }
    }
  }
}
</script>
