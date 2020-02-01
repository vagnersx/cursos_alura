var btnAdicionar = document.querySelector('#adicionar-paciente');
btnAdicionar.addEventListener('click', clickBotao);

function clickBotao(e) {
    e.preventDefault();

    var form = document.querySelector('#form-adiciona');

    var paciente = obtemPacienteFormulario(form);

    var erros = validaPaciente(paciente);
    
    if (erros.length > 0) {
        exibeMensagensErro(erros);
        return;
    }

    adicionaPacienteTabela(paciente)

    form.reset();
    var mensagemErro = document.querySelector('#mensagens-erro');
    mensagemErro.innerHTML = ''
}

function adicionaPacienteTabela(paciente) {
    var pacienteTr = montaTr(paciente);
    tbPacientes.appendChild(pacienteTr);
}

function obtemPacienteFormulario(form) {
    var paciente = {
        nome: form.nome.value,
        peso: form.peso.value,
        altura: form.altura.value,
        gordura: form.gordura.value,
        imc: calculaImc(form.peso.value, form.altura.value),
    }

    return paciente;
}

function montaTr(paciente) {
    var pacienteTr = document.createElement('tr');
    pacienteTr.classList.add('paciente');

    var nomeTd = montaTd(paciente.nome, 'info-nome');
    var pesoTd = montaTd(paciente.peso, 'info-peso');
    var alturaTd = montaTd(paciente.altura, 'info-altura');
    var gorduraTd = montaTd(paciente.gordura, 'info-gordura');
    var imcTd = montaTd(paciente.imc, 'info-imc');

    pacienteTr.appendChild(nomeTd);
    pacienteTr.appendChild(pesoTd);
    pacienteTr.appendChild(alturaTd);
    pacienteTr.appendChild(gorduraTd);
    pacienteTr.appendChild(imcTd);

    return pacienteTr;
}

function montaTd(dado, classe) {
    var nomeTd = document.createElement('td');
    nomeTd.textContent = dado;
    nomeTd.classList.add(classe);
    return nomeTd;
}

function validaPaciente(paciente) {
    var erros = [];

    if(paciente.nome.length == 0){
        erros.push('O nome não pode ser em branco');
    }

    !validaPeso(paciente.peso) &&  erros.push('O Peso é inválido');
    !validaAltura(paciente.altura) && erros.push('A Altura é inválida');

    if(paciente.gordura.length == 0){
        erros.push('A gorduda não pode ser em branco');
    }

    if(paciente.peso.length == 0){
        erros.push('O peso não pode ser em branco');
    }

    if(paciente.altura.length == 0){
        erros.push('A altura não pode ser em branco');
    }

    return erros;
}

function exibeMensagensErro(erros){
    var mensagemErro = document.querySelector('#mensagens-erro');

    mensagemErro.innerHTML = '';
    for (const mensagem of erros) {
        var liErro = document.createElement('li');
        liErro.textContent = mensagem;
        mensagemErro.appendChild(liErro);
    }
}

