

class LivroDao {
    constructor(db) {
        this._db = db;
    }

    lista() {
        return new Promise((resolve, reject) => {
            this._db.all('SELECT * FROM livros', (erros, resultados) => {
                if (erros)
                    reject({ mensagem: 'Não foi possível listar os livros' });
                else
                    resolve(resultados);
            });
        });

    }

    adiciona({ titulo, preco, descricao }) {
        return new Promise((resolve, reject) => {
            this._db.run(`
                INSERT INTO LIVROS (
                        titulo,
                        preco,
                        descricao
                    ) values (?, ?, ?)
                `,
                [titulo, preco, descricao],
                function (err) {
                    if (err) {
                        console.log(err);
                        return reject('Não foi possível adicionar o livro!');
                    }

                    resolve();
                }
            );
        });
    }

    buscaPorId(id) {
        return new Promise((resolve, reject) => {
            this._db.get('SELECT * FROM livros WHERE id = ?', id, (erros, resultado) => {
                if (erros)
                    reject({ mensagem: 'Não foi possível buscar o livro' });
                else
                    resolve(resultado);
            });
        });
    }

    atualiza(livro) {
        return new Promise((resolve, reject) => {
            this._db.run('UPDATE livros SET titulo=?, preco=?, descricao=? WHERE id = ?', livro.titulo, livro.preco, livro.descricao, livro.id,
                (erros) => {
                    if (erros)
                        return reject({ mensagem: 'Não foi possível atualizar o livro' });

                    resolve();
                });
        });
    }

    remove(id) {
        return new Promise((resolve, reject) => {
            this._db.run('DELETE FROM livros WHERE id = ?', id,
                (erros) => {
                    if (erros)
                        return reject({ mensagem: 'Não foi possível remover o livro' });

                    resolve();
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