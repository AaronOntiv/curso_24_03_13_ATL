// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#usuarios').DataTable();
});

//Libreria de javaScript que selecciona la talbla usuarios y con datatable le da funcionalidades de
//Paginacion y etc.


async function cargarUsuarios(){
  //El await hace mencion a que tiene que espera el resultado del llamado. Por lo que el codigo
  //Se detiene en ese punto. hasta obtener el resultado y guardarlo en esa variable.
  //Se debe indicar a la funcion que es asincronica por eso se pone async en cargar usuarios.
  const request = await fetch('usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const usuarios = await request.json();

  console.log(usuarios);

  let listadoHtml;
  for(let usuario of usuarios){
    let usuarioHtml='<tr><td>'+usuario.id+'</td><td>'+usuario.nombre+' '+usuario.apellido+'</td><td>'
    +usuario.email+'</td><td>'+usuario.telefono
    +'</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>'

    listadoHtml+=usuarioHtml;
  }


  document.querySelector('#usuarios tbody').outerHTML=listadoHtml;




}