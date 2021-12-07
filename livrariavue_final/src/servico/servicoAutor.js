import {http} from './configuracoes'

export default{
    lista:() => {return http.get("autores/publico/lista")},
    adiciona:(autor) => {return http.post("autores/protegido/adicionaAutor",autor)}
}
