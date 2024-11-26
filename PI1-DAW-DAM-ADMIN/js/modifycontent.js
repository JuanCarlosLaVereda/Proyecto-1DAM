const contentImageView = document.querySelector("#iconoContenido");
const tituloContenido = document.querySelector("#contentTitle");
const desContenido = document.querySelector("#contentDescription");
const directorContenido = document.querySelector("#contentDirector");
const duracionContenido = document.querySelector("#contentDuracion");
const generoContenido = document.querySelector("#contentGenre");
const tarifaContenido = document.querySelector("#contentTarifa");
const actoresContenido = document.querySelector("#contentActores");
const imagenContenido = document.querySelector("#contentImagen");
const estrenoContenido = document.querySelector("#contentEstreno");
const mensajeResultado = document.querySelector("#mensaje_resultado");
const peliculaDispo = document.querySelector("#peliculaCaducidad");
const capituloTemporada = document.querySelector("#capituloTemporada");
const capituloSerie = document.querySelector("#capituloSerie");
const puntuacionContenido = document.querySelector("#contentPunt");


//Cierra sesion y vuelve al login
function cerrarSesion(){
    localStorage.removeItem('userName');
    location.href = 'index.html';
  }

const ipServer = "http://172.30.198.206:8080";
//const ipServer = "http://127.0.0.1:8080";
const totalContenido = obtenerParametroID('idContenido');
const idContenido = totalContenido.split('z')[0];
const tipoContenido = totalContenido.split('z')[1];
colocarInformacion();

//Devuelve la id de Contenido almacenada en la URL
function obtenerParametroID(idContenido){
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(idContenido);
}


//Dependiendo el tipo de contenido colocara una informacion o otra
function colocarInformacion(){
    console.log(tipoContenido);
    console.log(idContenido);
    if(tipoContenido == 'pelicula'){
        colocarPelicula();
    }else if(tipoContenido == 'corto'){
        colocarCorto();
    }else if(tipoContenido == 'capitulo'){
        colocarCapitulo();
    }else if(tipoContenido == 'serie'){
        colocarSerie();
    }
}

//Obtiene la informacion de la pelicula con un get por ID para colocarla en el formulario
function colocarPelicula(){
    fetch(ipServer+"/contenido/pelicula/"+idContenido)
    .then((res) => res.json())
    .then((data) => {
        informacionPelicula(data);
    })
    .catch(error => console.error(error))
}

//Coloca la informacion de la pelicula en el formulario
function informacionPelicula(pelicula){
    contentImageView.src = pelicula.url_image;
    puntuacionContenido.value = pelicula.puntMedia;
    tituloContenido.value = pelicula.titulo; 
    desContenido.value = pelicula.descripcion; 
    directorContenido.value = pelicula.director;
    duracionContenido.value = pelicula.duracion_minutos; 
    generoContenido.value = pelicula.idGenero;
    tarifaContenido.value = pelicula.idTarifa; 
    actoresContenido.value = pelicula.actores; 
    imagenContenido.value = pelicula.url_image; 
    estrenoContenido.value = pelicula.fechaEstreno;
    peliculaDispo.type = 'date';
    peliculaDispo.value = pelicula.disponible_hasta; 
}

//Obtiene la informacion del corto con un get por ID para colocarla en el formulario
function colocarCorto(){
    fetch(ipServer+"/contenido/corto/"+idContenido)
    .then((res) => res.json())
    .then((data) => {
        informacionCorto(data);
    })
    .catch(error => console.error(error))
}

//Coloca la informacion del corto en el formulario
function informacionCorto(corto){
    contentImageView.src = corto.url_image;
    tituloContenido.value = corto.titulo; 
    puntuacionContenido.value = corto.puntMedia;
    desContenido.value = corto.descripcion; 
    directorContenido.value = corto.director; 
    duracionContenido.value = corto.duracion_minutos; 
    generoContenido.value = corto.idGenero;
    tarifaContenido.value = corto.idTarifa; 
    actoresContenido.value = corto.actores; 
    imagenContenido.value = corto.url_image; 
    estrenoContenido.value = corto.fechaEstreno;
}

//Obtiene la informacion del capitulo con un get por ID para colocarla en el formulario
function colocarCapitulo(){
    fetch(ipServer+"/contenido/capitulo/"+idContenido)
    .then((res) => res.json())
    .then((data) => {
        informacionCapitulo(data);
    })
    .catch(error => console.error(error))
}

//Coloca la informacion del capitulo en el formulario
function informacionCapitulo(capitulo){
    contentImageView.src = capitulo.url_image;
    tituloContenido.value = capitulo.titulo; 
    puntuacionContenido.value = capitulo.puntMedia;
    desContenido.value = capitulo.descripcion; 
    directorContenido.value = capitulo.director; 
    duracionContenido.value = capitulo.duracion_minutos; 
    generoContenido.value = capitulo.idGenero;
    tarifaContenido.value = capitulo.idTarifa; 
    actoresContenido.value = capitulo.actores; 
    imagenContenido.value = capitulo.url_image; 
    estrenoContenido.value = capitulo.fechaEstreno;
    capituloTemporada.type = 'number';
    capituloTemporada.value = capitulo.temporada;
    capituloSerie.type = 'number';
    capituloSerie.value = capitulo.idSerie;
}

//Obtiene la informacion de la serie con un get por ID para colocarla en el formulario
function colocarSerie(){
    fetch(ipServer+"/serie/"+idContenido)
    .then((res) => res.json())
    .then((data) => {
        informacionSerie(data);
    })
    .catch(error => console.error(error))
}

//Coloca la informacion de la serie en el formulario
function informacionSerie(serie){
    contentImageView.src = serie.url_image;
    tituloContenido.value = serie.titulo; 
    desContenido.value = serie.descripcion; 
    directorContenido.type = 'hidden'; 
    generoContenido.type = 'hidden';
    duracionContenido.type = 'hidden';
    tarifaContenido.type = 'hidden'; 
    actoresContenido.type = 'hidden'; 
    imagenContenido.value = serie.url_image; 
    estrenoContenido.type = 'hidden';
    peliculaDispo.type = 'date';
    peliculaDispo.value = serie.disponible_hasta;
}

//Dependiendo del tipo de contenido se enviaran unos datos a modificar o otros
function modificarContenido(){
   if(tipoContenido == 'pelicula'){
    modificarPelicula();
   }else if(tipoContenido == 'corto'){
    modificarCorto();
   }else if(tipoContenido == 'capitulo'){
    modificarCapitulo();
   }else if(tipoContenido == 'serie'){
    modificarSerie();
   }
}

//Obtiene la informacion del formulario y con un put actualiza la pelicula
function modificarPelicula(){
    const Pelicula = {
        "id": idContenido,
        "titulo": tituloContenido.value,
        "descripcion": desContenido.value,
        "actores": actoresContenido.value,
        "puntMedia": puntuacionContenido.value,
        "fechaEstreno": estrenoContenido.value,
        "duracion_minutos": duracionContenido.value,
        "director": directorContenido.value,
        "idGenero": generoContenido.value,
        "idTarifa": tarifaContenido.value,
        "disponible_hasta": peliculaDispo.value,
        "tipo": "Pelicula",
        "url_image": imagenContenido.value
    }

    fetch(ipServer+"/contenido/pelicula/update", {
        method: 'PUT',
        mode: 'cors',
        body: JSON.stringify(Pelicula),
        headers: {
            "Content-Type": "application/json",
        },
    }).then(response => response.json())
    .then((data) => {
        if(data == 1){
            mensajeResultado.innerHTML = "La Pelicula se a actualizado correctamente";
        }
    })
    .catch(error => {
        mensajeResultado.innerHTML = "Ha ocurrido un error al actualizar la pelicula";
        console.error(error);
    })
}

//Obtiene la informacion del formulario y con un put actualiza el corto
function modificarCorto(){
    const Corto = {
        "id": idContenido,
        "titulo": tituloContenido.value,
        "descripcion": desContenido.value,
        "actores": actoresContenido.value,
        "puntMedia": puntuacionContenido.value,
        "fechaEstreno": estrenoContenido.value,
        "duracion_minutos": duracionContenido.value,
        "director": directorContenido.value,
        "idGenero": generoContenido.value,
        "idTarifa": tarifaContenido.value,
        "tipo": "Corto",
        "url_image": imagenContenido.value
    }

    fetch(ipServer+"/contenido/corto/update", {
        method: 'PUT',
        mode: 'cors',
        body: JSON.stringify(Corto),
        headers: {
            "Content-Type": "application/json",
        },
    }).then(response => response.json())
    .then((data) => {
        if(data == 1){
            mensajeResultado.innerHTML = "El Corto se a actualizado correctamente";
        }
    })
    .catch(error => {
        mensajeResultado.innerHTML = "Ha ocurrido un error al actualizar el corto";
        console.error(error);
    })
}

//Obtiene la informacion del formulario y con un put actualiza el capitulo
function modificarCapitulo(){
    const Capitulo = {
        "id": idContenido,
        "titulo": tituloContenido.value,
        "descripcion": desContenido.value,
        "actores": actoresContenido.value,
        "puntMedia": puntuacionContenido.value,
        "fechaEstreno": estrenoContenido.value,
        "duracion_minutos": duracionContenido.value,
        "director": directorContenido.value,
        "idGenero": generoContenido.value,
        "idTarifa": tarifaContenido.value,
        "idSerie": capituloSerie.value,
        "temporada": capituloTemporada.value,
        "tipo": "Capitulo",
        "url_image": imagenContenido.value
    }

    fetch(ipServer+"/contenido/capitulo/update", {
        method: 'PUT',
        mode: 'cors',
        body: JSON.stringify(Capitulo),
        headers: {
            "Content-Type": "application/json",
        },
    }).then(response => response.json())
    .then((data) => {
        if(data == 1){
            mensajeResultado.innerHTML = "El Capitulo se a actualizado correctamente";
        }
    })
    .catch(error => {
        mensajeResultado.innerHTML = "Ha ocurrido un error al actualizar el capitulo";
        console.error(error);
    })
}

function modificarSerie(){
    const Serie = {
        "id": idContenido,
        "disponible_hasta": peliculaDispo.value,
        "titulo": tituloContenido.value,
        "descripcion": desContenido.value,
        "url_image": imagenContenido.value
    }

    fetch(ipServer+"/serie/update", {
        method: 'PUT',
        mode: 'cors',
        body: JSON.stringify(Serie),
        headers: {
            "Content-Type": "application/json",
        },
    }).then(response => response.json())
    .then((data) => {
        if(data == 1){
            mensajeResultado.innerHTML = "La Serie se a actualizado correctamente";
        }
    })
    .catch(error => {
        mensajeResultado.innerHTML = "Ha ocurrido un error al actualizar la serie";
        console.error(error);
    })
}

//Obtiene la foto del usuario que a realizado el login y la coloca en el menu
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