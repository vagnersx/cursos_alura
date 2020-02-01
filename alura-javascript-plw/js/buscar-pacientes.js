var buscar = document.querySelector('#buscar-pacientes')

buscar.addEventListener('click', function () {
    var xhr = new XMLHttpRequest();

    xhr.open('GET', 'http://api-pacientes.herokuapp.com/pacientes');
    
    xhr.onload = function(e) {
        var erroAjax = document.querySelector('#erro-ajax');
        if(xhr.status === 200) {
            erroAjax.classList.add('invisivel');
            var resultado = JSON.parse(xhr.responseText);

            var tbPacientes = document.querySelector('#tabela-pacientes');
            //tbPacientes.innerHTML = ''
    
            resultado.forEach(paciente => {
                adicionaPacienteTabela(paciente);
            });

        } else {
            console.log(xhr.status)
            console.log(xhr.responseText)

            erroAjax.classList.remove('invisivel');

        }


    }
    

    xhr.send();
});