const contentContainer = document.querySelector(".content-container");
const tituloContenido = document.querySelector("#tituloContenido");
const selectGenero = document.querySelector("#generoContenido");
const filtroTipo = document.querySelector("#tipoContenido");
const ipServer = "http://172.30.198.206:8080";
//const ipServer = "http://127.0.0.1:8080";
const spinner = document.querySelector("#spinner");

//Cierra la sesion y devuelve al login
function cerrarSesion(){
  localStorage.removeItem('userName');
  location.href = 'index.html';
}

//Obtiene todo el contenido para añadirlo al listado
function fetchContenido(titulo) {

  const generoSeleccionado = selectGenero.value;
  
 
    fetch(ipServer+"/contenido/")
      .then((res) => res.json())
      .then((data) => {
        for(let i=0;i<=data.length-1;i++){
          if(data[i].idGenero == generoSeleccionado || generoSeleccionado == "Todo"){
            if(data[i].titulo.toLowerCase().includes(titulo.toLowerCase())){
              crearContenido(data[i]);
            }
          }
        }
        spinner.style.display = "none";
      })
      .catch(error => {
        spinner.style.display = "none";
        console.error(error);
      })
    
  }

  //Obtiene todas las Series para añadirlas al listado
  function fetchSeries(titulo){

    const generoSeleccionado = selectGenero.value;

      fetch(ipServer+"/serie/")
        .then((res) => res.json())
        .then((data) => {
          for(let i=0;i<=data.length-1;i++){
            if(generoSeleccionado == "Todo"){
              if(data[i].titulo.toLowerCase().includes(titulo.toLowerCase())){
                crearContenido(data[i],'serie');
              }
            }
              
          }
          spinner.style.display = "none";
        })
        .catch(error => {
          spinner.style.display = "none";
          console.error(error);
        })
      
  }
  
  //Llamada a obtener Contenido y Series, ademas, muestra que la pagina esta cargando
  function fetchContenidos(titulo) {
    
    spinner.style.display = "block";
    fetchContenido(titulo);
    fetchSeries(titulo);
    
  }

  //Crea una carta de Contenido y la añade al listado
  function crearContenido(contenido,tipo) {
    const flipCard = document.createElement("div");
    flipCard.classList.add("flip-card");
  
    const cardContainer = document.createElement("div");
    cardContainer.classList.add("card-container");
  
    flipCard.appendChild(cardContainer);
  
    const card = document.createElement("div");
    card.classList.add("content-block");
  
    const iconContainer = document.createElement("div");
    iconContainer.classList.add("img-container");
  
    const icon = document.createElement("img");
    icon.src = contenido.url_image;
  
    iconContainer.appendChild(icon);

  
    const name = document.createElement("p");
    name.classList.add("name");
    name.textContent = contenido.titulo;
  
    card.appendChild(iconContainer);
    card.appendChild(name);

  
    const cardBack = document.createElement("div");
    cardBack.classList.add("content-block-back");
  
    cardBack.appendChild(botonesContenido(contenido,tipo));
  
    cardContainer.appendChild(card);
    cardContainer.appendChild(cardBack);
    contentContainer.appendChild(flipCard);

  }

  //Crea la parte trasera de la carta Contenido
  function botonesContenido(contenido,tipo) {
    const buttonsContainer = document.createElement("div");
    buttonsContainer.classList.add("buttons-container");


      const idContenido = contenido.id;
  
      const buttonContainer = document.createElement("button-container");
      buttonContainer.classList.add("button-container");

  
      const botonModificar = document.createElement("a");
      botonModificar.classList.add("button");
      botonModificar.addEventListener("click",function() {verContenido(idContenido,tipo)},false);
      botonModificar.textContent = "Modificar";


      buttonContainer.appendChild(botonModificar);


      const buttonContainerEliminar = document.createElement("button-container");
      buttonContainerEliminar.classList.add("button-container");

      const botonEliminar = document.createElement("a");
      botonEliminar.classList.add("button");
      botonEliminar.addEventListener("click",function() {eliminarContenido(idContenido,tipo)},false);
      botonEliminar.textContent = "Eliminar";

      buttonContainerEliminar.appendChild(botonEliminar);
  
      buttonsContainer.appendChild(buttonContainer);
      buttonsContainer.appendChild(buttonContainerEliminar);

      
  
    return buttonsContainer;
  }

  //Funcion del Boton Modificar de la Carta Contenido, dirige a la pagina de modificacion
  function verContenido(idContenido,tipoContenido){
    window.location.href = 'modificarContenido.html?idContenido='+encodeURIComponent(idContenido+'z'+tipoContenido);
  }

  //Funcion del Boton Eliminar de la Carta Contenido, dependiendo el tipo de contenido realiza una llamada a la API u otra
  function eliminarContenido(idContenido,tipo){
    console.log(tipo);
    if(tipo=="pelicula"){
      fetch(ipServer+"/contenido/pelicula/"+idContenido)
      .then((res) => res.json())
      .then((data) => {
          borrarContenido(data);
      })
      .catch(error => console.error(error))
    }else if(tipo == "corto"){
      fetch(ipServer+"/contenido/corto/"+idContenido)
      .then((res) => res.json())
      .then((data) => {
          borrarContenido(data);
      })
      .catch(error => console.error(error))
    }else if(tipo == "capitulo"){
      fetch(ipServer+"/contenido/capitulo/"+idContenido)
      .then((res) => res.json())
      .then((data) => {
          borrarContenido(data);
      })
      .catch(error => console.error(error))
    }else if(tipo=="serie"){
      fetch(ipServer+"/serie/"+idContenido)
      .then((res) => res.json())
      .then((data) => {
          borrarSerie(data);
      })
      .catch(error => console.error(error))
    }
   
    actualizarListado();
    filtrarContenido();
  }

  //Añade generos a la seleccion de los filtros
  function generarGeneros(){
    fetch(ipServer+"/genero/")
    .then((res) => res.json())
    .then((data) => {
      for(let i=0;i<data.length;i++){
        anyadirGenero(data[i]);
      }
    })
  }

  //Borra el contenido de la base de datos
  function borrarContenido(contenido){
    
    fetch(ipServer+"/contenido/delete/&id="+contenido.id+"&tipo="+contenido.tipo ,{
      method: 'DELETE',
      mode: 'cors',
      body: contenido,
      headers: {
        "Content-Type": "application/json",
      }
    }).catch(error => {
      spinner.style.display = "none";
      console.error(error);
    })
  }

  //Borra la serie de la base de datos
  function borrarSerie(serie){
    fetch(ipServer+"/serie/delete/"+serie.id,{
      method: 'DELETE',
      mode: 'cors',
      body: serie,
      headers: {
        "Content-Type": "application/json",
      }
    }).catch(error => {
      spinner.style.display = "none";
      console.error(error);
    })
  }

  //Añade el genero al select del formulario de filtrado
  function anyadirGenero(genero){
    selectGenero.innerHTML += '<option value='+genero.id+'>'+genero.tipo+'</option>';
  }

  //Dependiendo los filtros seleccionados muestra un listado diferente
  function filtrarContenido(){
    const tituloSeleccionado = tituloContenido.value;
    const tipo = filtroTipo.value; 
    console.log(tipo);
    actualizarListado();
    if(tipo == "Todo"){
      fetchContenidos(tituloSeleccionado);
    }else if(tipo == "Peliculas"){
      spinner.style.display = "block";
      sacarPeliculas(tituloSeleccionado);
    }else if(tipo == "Cortos"){
      spinner.style.display = "block";
      sacarCortos(tituloSeleccionado);
    }else if(tipo == "Capitulos"){
      spinner.style.display = "block";
      sacarCapitulos(tituloSeleccionado);
    }else{
      spinner.style.display = "block";
      fetchSeries(tituloSeleccionado);
    }
  }

  //Obtiene todas las peliculas filtradas y las coloca en el listado
  function sacarPeliculas(titulo){
    const generoSeleccionado = selectGenero.value;
    
   
      fetch(ipServer+"/contenido/pelicula/")
        .then((res) => res.json())
        .then((data) => {
          for(let i=0;i<=data.length-1;i++){
            if(data[i].idGenero == generoSeleccionado || generoSeleccionado == "Todo"){
              if(data[i].titulo.toLowerCase().includes(titulo.toLowerCase())){
                crearContenido(data[i],'pelicula');
              }
            }
          }
          spinner.style.display = "none";
        })
        .catch(error => {
          spinner.style.display = "none";
          console.error(error);
        })
      
  }

  //Obtiene todos los cortos filtrados y los coloca en el listado
  function sacarCortos(titulo){
    const generoSeleccionado = selectGenero.value;
   
      fetch(ipServer+"/contenido/corto/")
        .then((res) => res.json())
        .then((data) => {
          for(let i=0;i<=data.length-1;i++){
            if(data[i].idGenero == generoSeleccionado || generoSeleccionado == "Todo"){
              if(data[i].titulo.toLowerCase().includes(titulo.toLowerCase())){
                crearContenido(data[i],'corto');
              }
            }
          }
          spinner.style.display = "none";
        })
        .catch(error => {
          spinner.style.display = "none";
          console.error(error);
        })
  }

  //Obtiene todos los capitulos filtrados y los coloca en el listado
  function sacarCapitulos(titulo){
    const generoSeleccionado = selectGenero.value;

    fetch(ipServer+"/contenido/capitulo/")
    .then((res) => res.json())
    .then((data) => {
      for(let i=0;i<=data.length-1;i++){
        if(data[i].idGenero == generoSeleccionado || generoSeleccionado == "Todo"){
          if(data[i].titulo.toLowerCase().includes(titulo.toLowerCase())){
            crearContenido(data[i],'capitulo');
          }
        }
      }
      spinner.style.display = "none";
    })
    .catch(error => {
      spinner.style.display = "none";
      console.error(error);
    })
  }

  //Reinicia el listado de contenido
  function actualizarListado(){
    contentContainer.innerHTML = '<div id="spinner" class="spinner-border text-light" role="status"><span class="visually-hidden">Cargando...</span></div>'
  }

  //Obtiene la foto del usuario logeado y la coloca en el menu
  function obtenerFotoUsuario(){
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
  
  obtenerFotoUsuario();

  filtrarContenido("")
  generarGeneros()