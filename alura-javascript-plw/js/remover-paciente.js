// var pacientes = document.querySelectorAll('.paciente');
// pacientes.forEach((trPaciente) =>{
//     trPaciente.addEventListener('dblclick', function(e){
//         console.log('tr')
//         console.log(e)
//         e.preventDefault();
//         this.remove();
//     })
// })

var tabela = document.querySelector('table');

tabela.addEventListener('dblclick', function(e) {
    e.target.parentElement.classList.add('fadeOut');
    setTimeout(() => {
        e.target.parentElement.remove();
    }, 500);
})