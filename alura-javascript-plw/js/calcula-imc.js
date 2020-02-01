var titulo = document.querySelector(".titulo");
titulo.textContent = 'Aparecida Nutricionista'

tbPacientes = document.querySelector('#tabela-pacientes');
var pacientes = tbPacientes.querySelectorAll('tr');

for (const trPaciente of pacientes) {
    //var trPaciente = pacientes[index];
    let tdPeso = trPaciente.querySelector(".info-peso");
    const peso = tdPeso.textContent;

    var tdAltura = trPaciente.querySelector(".info-altura");
    const altura = tdAltura.textContent;

    var pesoValido = validaPeso(peso);
    var alturaValida = validaAltura(altura);

    var tdImc = trPaciente.querySelector(".info-imc");

    if (!pesoValido) {
        console.log('Peso inválido');
        pesoValido = false;
        tdImc.textContent = "Peso inválido";
        trPaciente.classList.add('paciente-invalido');
    }

    if (!alturaValida) {
        console.log('Altura inválida');
        alturaValida = false;
        tdImc.textContent = 'Altura inválida';
        trPaciente.classList.add('paciente-invalido');
    }

    if (alturaValida && pesoValido) {
        var imc = calculaImc(peso, altura);
        tdImc.textContent = imc;
    }
}

function validaPeso(peso) {
    if (peso >= 0 && peso < 1000) {
        return true;
    } else {
        return false;
    }
}

function validaAltura(altura) {
    if (altura >= 0 && altura < 3) {
        return true;
    } else {
        return false;
    }
}

function calculaImc(peso, altura){
    return (peso / (altura * altura)).toFixed(2);
}