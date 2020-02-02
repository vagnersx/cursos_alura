const db = require('../../config/database');

const LivroDao = require('../infra/livro-dao');



module.exports = function (app) {

    app.get('/', function (req, resp) {
        resp.send(`
        <html>
            <head>
                <meta charset="utf-8">
            </head>
            <body>
                <h1> Casa do Código </h1>
            </body> 
        </html>`);

    });

    app.get('/livros', async function (req, resp) {
        const livroDao = new LivroDao(db);

        try {
            const livros = await livroDao.lista();
            resp.marko(
                require('../views/livros/lista/lista.marko'),
                {
                    livros: livros
                }
            );

        } catch (erro) {
            resp.send(erro);
        }
    });

    app.get('/livros/form', function (req, resp) {
        resp.marko(
            require('../views/livros/form/form.marko'),
            {livro: {id: null, titulo: null, preco: null, descricao: null}}
        )
    });

    app.get('/livros/form/:id', function (req, resp) {
        const id = req.params.id;
        const livroDao = new LivroDao(db);

        livroDao.buscaPorId(id)
            .then(livro => {
                console.log(livro)
                resp.marko(
                    require('../views/livros/form/form.marko'),
                    { livro: livro }
                )
            }
            )
            .catch(erro => console.log(erro));

    });

    app.post('/livros', function (req, resp) {
        console.log(req.body);
        const livroDao = new LivroDao(db);

        livroDao.adiciona(req.body)
            .then(resp.redirect('/livros'))
            .catch(erro => console.log(erro));
    });

    app.put('/livros', function (req, resp) {
        const livroDao = new LivroDao(db);

        livroDao.atualiza(req.body)
            .then(resp.redirect('/livros'))
            .catch(erro => console.log(erro));
    });

    app.delete('/livros/:id', (req, res) => {
        const id = req.params.id;
        const livroDao = new LivroDao(db);
        livroDao.remove(id)
            .then(res.status(200).end())
            .catch(erro => console.log(erro));
    });
}