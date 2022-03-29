var prod2, data3;


/*
* funcion de inicio del metodo
* */
function begin() {
    //alert("ya se cargo")
    const xhr2 = new XMLHttpRequest();
    //activamos el modo de asincrono con true
    xhr2.open('get', 'hello-servlet?op=1', true);
    xhr2.onreadystatechange = () => {
        if (xhr2.readyState === 4 && xhr2.status === 200) {
            prod2 = JSON.parse(xhr2.responseText);
            prod2.forEach(prods => document.getElementById("participants").add(new Option(prods.name, prods.id)))
        }
    }
    xhr2.send(null);
}

/*
participants variable que toma lo del select
* Orderparti : variable participantes ordenada
* **/
const participants = document.getElementById("participants");
participants.addEventListener('change', function () {
    var selectedOption = this.options[participants.selectedIndex];
    //ordena segun el nombre
    //const Orderparti = prod2.sort((participant1, participant2) => participant1.name.localeCompare(participant2.name))
    prod2.forEach((participant) => {
        if (participant.name == selectedOption.text) {
            funtionData(participant.code, participant.name, participant.surname, participant.posicion, participant.disciplina, participant.modo, participant.evento,participant.edad);
        }
    });
});

function funtionData(id, name, surname, position, discipline, mode, event, edad) {
    var div = document.getElementById("listTable");
    //creando etiqueta para agregar filas (row)
    var row = document.createElement('tr')
    // creando etiquetas para agregar columnas (col)
    var col2 = document.createElement('td')
    //agregando la primera columna del indice de filas
    col2.appendChild(document.createTextNode(name))
    //agregamos columna a la fila
    row.appendChild(col2)

    //creamos un nuevo espacio de columna
    col2 = document.createElement('td')
    //en con esta el numero primo
    col2.appendChild(document.createTextNode(surname))
    //agregamos columna  a la fila
    row.appendChild(col2)

    //creamos un nuevo espacio de columna
    col2 = document.createElement('td')
    //en con esta el numero primo
    col2.appendChild(document.createTextNode(id))
    //agregamos columna  a la fila
    row.appendChild(col2)


    //creamos un nuevo espacio de columna
    col2 = document.createElement('td')
    //en con esta el numero primo
    col2.appendChild(document.createTextNode(discipline))
    //agregamos columna  a la fila
    row.appendChild(col2)


    //creamos un nuevo espacio de columna
    col2 = document.createElement('td')
    //en con esta el numero primo
    col2.appendChild(document.createTextNode(mode))
    //agregamos columna  a la fila
    row.appendChild(col2)

    //creamos un nuevo espacio de columna
    col2 = document.createElement('td')
    //en con esta el numero primo
    col2.appendChild(document.createTextNode(edad))
    //agregamos columna  a la fila
    row.appendChild(col2)


    //creamos un nuevo espacio de columna
    col2 = document.createElement('td')
//en con esta el numero primo
    col2.appendChild(document.createTextNode(event))
//agregamos columna  a la fila
    row.appendChild(col2)


//creamos un nuevo espacio de columna
    col2 = document.createElement('td')
//en con esta el numero primo
    col2.appendChild(document.createTextNode(position))
//agregamos columna  a la fila
    row.appendChild(col2)

    div.appendChild(row)
}

/*
*========================================================================
* funciones para crear participante
* ======================================================================
* */

const xhr = new XMLHttpRequest();
xhr.open('post', 'hello-servlet?op=1', true)
xhr.onreadystatechange = () => {
    if (xhr.readyState === 4 && xhr.status === 200) {
        alert(xhr.responseText)
    }
}
document.getElementById('Crear').addEventListener('click', function () {
    var id = document.getElementById('inputEmail4').value;
    var nombre = document.getElementById('inputPassword4').value;
    var apellido = document.getElementById('inputAddress').value;
    var edad = document.getElementById('inputAddress2').value;
    var modo = document.getElementById('inputModo').value;
    var disciplina = document.getElementById('inputDiscipline').value;
    var evento = document.getElementById('inputEvent').value;
    var posicion = document.getElementById('inputposicion').value;


    const data = `id=${id}&name=${nombre}&surname=${apellido}&edad=${edad}&discipline=${disciplina}&mode=${modo}&evento=${evento}&position=${posicion}`;
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send(data)
    alert("Elemento Agregado")
})

/*
 * ===================================================
 * Funciones para Elminar perticipante
 * ===================================================
 * */

var arrayNombres;
var codObten;


const xhr5 = new XMLHttpRequest();

xhr5.open('GET', 'hello-servlet?op=1', true);
xhr5.onreadystatechange = () => {
    if (xhr5.readyState === 4 && xhr5.status === 200) {
        arrayNombres = JSON.parse(xhr5.responseText);
        //alert(arrayNombres)
    }
};
xhr5.send(null)


document.getElementById('deleteButton').addEventListener('click', function () {
    //obtener valor del selector
    //cargamos variable con el archivo
    const sel = document.getElementById('participants')
    //debo obtener el codigo del que deseo eliminar
    var selectedOption = sel.options[sel.selectedIndex];
    var envio = selectedOption.text
    arrayNombres.forEach((names) => {
        if (names.name === envio) {
            codObten = names.code
            alert(names.code)
        }
    })
    var send = "code=" + codObten;
    $.ajax({
        url: 'hello-servlet?op=2',
        type: 'POST',
        data: send
    })
    //alert(codObten)
    document.getElementById("form2").reset()
    begin();

})
/**
 * ================================================
 * funciones para modificar datos
 * ================================================
 * updateButton
 */

var arrayUpdate;
var codObten;


const xhr6 = new XMLHttpRequest();

    xhr6.open('GET', 'hello-servlet?op=1', true);
    xhr6.onreadystatechange = () => {
    if (xhr6.readyState === 4 && xhr6.status === 200) {
        arrayUpdate = JSON.parse(xhr6.responseText);
        //alert(arrayNombres)
        }
    };
    xhr6.send(null)


document.getElementById("updateButton").addEventListener("click",function () {
    //obtener valor del selector
    //cargamos variable con el archivo
    const sel = document.getElementById('participants')
    //debo obtener el codigo del que deseo eliminar
    var selectedOption = sel.options[sel.selectedIndex];
    var envio = selectedOption.text
    arrayUpdate.forEach((names) => {
        if (names.name === envio) {
            codUpdate = names.code
            document.getElementById("inputEmail4").value = codUpdate;
            document.getElementById('inputPassword4').value = names.name;
            document.getElementById('inputAddress').value = names.surname;
            document.getElementById('inputAddress2').value = names.edad;
            document.getElementById('inputModo').value = names.modo;
            document.getElementById('inputDiscipline').value = names.disciplina;
            document.getElementById('inputEvent').value = names.evento;
            document.getElementById('inputposicion').value = names.posicion;
        }
    })
    var send = "code=" + codUpdate;
    $.ajax({
        url: 'hello-servlet?op=2',
        type: 'POST',
        data: send
    })
})




/**
 * ================================================
 * Funciones de validaciones
 * ================================================


 function validate(){
    var arrayStudent;
    var codeCom =document.getElementById('inputEmail4').value;

    const xhr6 = new XMLHttpRequest();
    //activamos el modo de asincrono con true
    xhr6.open('GET', './loadStudent.php', true);
    xhr6.onreadystatechange = () => {
        if (xhr6.readyState === 4 && xhr6.status === 200) {
            arrayStudent = JSON.parse(xhr6.responseText);
        }
    };
    xhr6.send(null);
    arrayStudent.forEach((cod) =>{
        if(cod.id === codeCom){
            return false;
        }if(cod.id !== codeCom){
            return true;
        }


    })

}*/
begin();