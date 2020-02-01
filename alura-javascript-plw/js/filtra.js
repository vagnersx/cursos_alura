var campoFiltro = document.querySelector('#filtrar-tabela');

campoFiltro.addEventListener('input', function(e) {
    var pacientes = document.querySelectorAll('.paciente');
    //console.log(this.value)
    for (const paciente of pacientes) {
        var nome = paciente.querySelector('.info-nome').textContent;

        var expressao = new RegExp(this.value, "i")

        //if (nome.search(this.value) == -1 ) {
        //if (nome != this.value && this.value != 0) {
        if (!expressao.test(nome)) {
            paciente.classList.add("invisivel");
        } else {
            paciente.classList.remove("invisivel");
        }
    }
})