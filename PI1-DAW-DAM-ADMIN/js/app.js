const ipServer = "http://172.30.198.206:8080";
//const ipServer = "http://127.0.0.1:8080";
const mensajeResultado = document.querySelector("#mensaje_resultado");

//Cierra la sesion y devuelve al login
function cerrarSesion(){
  localStorage.removeItem('userName');
  location.href = 'index.html';
}

//Muestra la opcion de Contenido u Usuario depende cual sea pulsado
function openTab(evt, tabName) {
  var i, tabcontent, tablinks;

  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }

  tablinks = document.getElementsByClassName("tablink");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(tabName).style.display = "block";
  evt.currentTarget.className += " active";
}
document.addEventListener('DOMContentLoaded', function() {
  document.querySelector('.tablink').click();
});

//Muestra las opciones de añadir Contenido
function showAddContentForm() {
  document.getElementById('selectContentType').style.display = 'flex';
}

//Muestra el formulario para añadir una pelicula y oculta el resto
function showAddPeliculaForm(){
  document.getElementById('peliculaForm').style.display = 'block';
  document.getElementById('cortoForm').style.display = 'none';
  document.getElementById('capituloForm').style.display = 'none';
  document.getElementById('serieForm').style.display = 'none';
}

//Muestra el formulario para añadir un corto y oculta el resto
function showAddCortoForm(){
  document.getElementById('peliculaForm').style.display = 'none';
  document.getElementById('cortoForm').style.display = 'block';
  document.getElementById('capituloForm').style.display = 'none';
  document.getElementById('serieForm').style.display = 'none';
}

//Muestra el formulario para añadir un capitulo y oculta el resto
function showAddCapituloForm(){
  document.getElementById('peliculaForm').style.display = 'none';
  document.getElementById('cortoForm').style.display = 'none';
  document.getElementById('capituloForm').style.display = 'block';
  document.getElementById('serieForm').style.display = 'none';
}

//Muestra el formulario para añadir una serie y oculta el resto
function showAddSerieForm(){
  document.getElementById('peliculaForm').style.display = 'none';
  document.getElementById('cortoForm').style.display = 'none';
  document.getElementById('capituloForm').style.display = 'none';
  document.getElementById('serieForm').style.display = 'block';
}

//Crea un objeto Json Pelicula y lo añade a la base de datos
function addPelicula(){
  const tituloPelicula = document.querySelector("#peliculaTitle");
  const descripcionPelicula = document.querySelector("#peliculaDescription");
  const directorPelicula = document.querySelector("#peliculaDirector");
  const generoPelicula = document.querySelector("#peliculaGenre");
  const tarifaPelicula = document.querySelector("#peliculaRate");
  const urlPelicula = document.querySelector("#peliculaImageUrl");
  const disponibilidadPelicula = document.querySelector("#peliculaDisponible");

  const Pelicula = {
    "titulo": tituloPelicula.value,
    "descripcion": descripcionPelicula.value,
    "actores": null,
    "puntMedia": null,
    "fechaEstreno": null,
    "duracion_minutos": null,
    "director": directorPelicula.value,
    "idGenero": generoPelicula.value,
    "idTarifa": tarifaPelicula.value,
    "disponible_hasta": disponibilidadPelicula.value,
    "tipo": "Pelicula",
    "url_image": urlPelicula.value
  }

  fetch(ipServer+"/contenido/pelicula/add", {
    method: 'POST',
    mode: 'cors',
    body: JSON.stringify(Pelicula),
    headers: {
      "Content-Type": "application/json",
    }
  })
  .then(respone => respone.json())
  .then(json => {
    mensajeResultado.innerHTML = "Pelicula añadida con exito!";
  })
  .catch(error => {
    console.error(error);
    mensajeResultado.innerHTML = "Se a producido un error al añadir la Pelicula"
  })

}

//Crea un objeto Json Corto y lo añade a la base de datos
function addCorto(){
  const tituloCorto = document.querySelector("#cortoTitle");
  const descripcionCorto = document.querySelector("#cortoDescription");
  const directorCorto = document.querySelector("#cortoDirector");
  const generoCorto = document.querySelector("#cortoGenre");
  const tarifaCorto = document.querySelector("#cortoRate");
  const urlCorto = document.querySelector("#cortoImageUrl");

  const Corto = {
    "titulo": tituloCorto.value,
    "descripcion": descripcionCorto.value,
    "actores": null,
    "puntMedia": null,
    "fechaEstreno": null,
    "duracion_minutos": null,
    "director": directorCorto.value,
    "idGenero": generoCorto.value,
    "idTarifa": tarifaCorto.value,
    "tipo": "Corto",
    "url_image": urlCorto.value
  }

  fetch(ipServer+"/contenido/corto/add", {
    method: 'POST',
    mode: 'cors',
    body: JSON.stringify(Corto),
    headers: {
      "Content-Type": "application/json",
    }
  })
  .then(respone => respone.json())
  .then(json => {
    mensajeResultado.innerHTML = "Corto añadido con exito!";
  })
  .catch(error => {
    console.error(error);
    mensajeResultado.innerHTML = "Se a producido un error al añadir el Corto";
  })

}

//Crea un objeto Json capitulo y lo añade a la base de datos
function addCapitulo(){
  const tituloCapitulo = document.querySelector("#capituloTitle");
  const descripcionCapitulo = document.querySelector("#capituloDescription");
  const directorCapitulo = document.querySelector("#capituloDirector");
  const generoCapitulo = document.querySelector("#capituloGenre");
  const tarifaCapitulo = document.querySelector("#capituloRate");
  const urlCapitulo = document.querySelector("#capituloImageUrl");
  const temporadaCapitulo = document.querySelector("#capituloTemporada");
  const serieCapitulo = document.querySelector("#capituloSerie");

  const Capitulo = {
    "titulo": tituloCapitulo.value,
    "descripcion": descripcionCapitulo.value,
    "actores": null,
    "puntMedia": null,
    "fechaEstreno": null,
    "duracion_minutos": null,
    "director": directorCapitulo.value,
    "idGenero": generoCapitulo.value,
    "idTarifa": tarifaCapitulo.value,
    "idSerie": serieCapitulo.value,
    "temporada": temporadaCapitulo.value,
    "tipo": "Capitulo",
    "url_image": urlCapitulo.value
  }

  fetch(ipServer+"/contenido/capitulo/add", {
    method: 'POST',
    mode: 'cors',
    body: JSON.stringify(Capitulo),
    headers: {
      "Content-Type": "application/json",
    }
  })
  .then(respone => respone.json())
  .then(json => {
    mensajeResultado.innerHTML = "Capitulo añadido con exito!";
  })
  .catch(error => {
    console.error(error);
    mensajeResultado.innerHTML = "Se a producido un error al añadir el Capitulo";
  })

}

//Crea un objeto Json serie y lo añade a la base de datos
function addSerie(){
  const tituloSerie = document.querySelector("#serieTitle");
  const descripcionSerie = document.querySelector("#serieDescription");
  const urlSerie = document.querySelector("#serieImageUrl");
  const disponibilidadSerie = document.querySelector("#serieDisponible");


  const Serie = {
    "disponible_hasta": disponibilidadSerie.value,
    "titulo": tituloSerie.value,
    "descripcion": descripcionSerie.value,
    "url_image": urlSerie.value
  }

  fetch(ipServer+"/serie/add", {
    method: 'POST',
    mode: 'cors',
    body: JSON.stringify(Serie),
    headers: {
      "Content-Type": "application/json",
    }
  })
  .then(respone => respone.json())
  .then(json => {
    mensajeResultado.innerHTML = "Serie añadida con exito!";
  })
  .catch(error => {
    console.error(error);
    mensajeResultado.innerHTML = "Se a producido un error al añadir la Serie";
  })

}

//Muestra el formulario para añadir un cliente
function showAddClientForm() {
  document.getElementById('clientForm').style.display = 'block';
}

//Crea un objeto Json Cliente y lo añade a la base de datos
function addClient() {
  const nombre = document.getElementById('clientName');
  const contrasenya = document.getElementById('clientPassword');
  const apellido = document.getElementById('clientLastName');
  const email = document.getElementById('clientEmail');
  const usuario = document.getElementById('clientUser');

  const Usuario = {
    'nombreUsuario': usuario.value,
    'nombre': nombre.value,
    'apellido': apellido.value,
    'contrasenya': contrasenya.value,
    'email': email.value
  } 
  
  fetch(ipServer + "/usuario/add",{
    method: 'POST',
    mode: 'cors',
    body: JSON.stringify(Usuario),
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then(response => response.json())
    .then(json => {
      mensajeResultado.innerHTML = "Usuario añadido con exito!";
    })
    .catch(error => {
      console.error(error);
      mensajeResultado.innerHTML = "Se a producido un error al añadir el Usuario";
    });
}

//Obtiene la foto del usuario logeado y la coloca en el menu
function obtenerFotoUsuario(){
  console.log("sacando foto..")
  if(!localStorage.hasOwnProperty("userName")){
      console.log("no existe sesion");
      window.location.href = "index.html";
  }else{
      console.log("existe sesion");
  const nombreUsuario = localStorage.getItem("userName");
  fetch(ipServer+"/usuario/"+nombreUsuario)
      .then((res) => res.json())
      .then((data) => {
      
        document.getElementById("iconoUsuario").src = data.url_imagen;
      
      })
      .catch(error => {
        console.error(error);
      })
  }
  
}

obtenerFotoUsuario();