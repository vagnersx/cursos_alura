//nodejs v10.18.1

const app = require('./src/config/custom-express');

app.listen(3000, function () {
    console.log('Servidor rodando na porta 3000');
});