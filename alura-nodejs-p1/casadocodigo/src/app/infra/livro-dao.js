

class LivroDao {
    constructor(db){
        this._db = db;
    }

    lista() {
        return new Promise((resolve, reject) => {
            this._db.all('SELECT * FROM livros', (erros, resultados)=>{
                if(erros)
                    reject('Não foi possível listar os livros');
                else
                    resolve(resultados);
            });
        });
  
    }
}

// module.exports = {
//     listaLivros: (callback) => {
//         db.all('SELECT * FROM livros', (erros, resultados)=> callback(resultados) );
//     }
// }

module.exports = LivroDao;