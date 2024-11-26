const userContainer = document.querySelector(".user-container");
const userName = document.querySelector("#userName");
const ipServer = "http://172.30.198.206:8080";
//const ipServer = "http://127.0.0.1:8080"
const spinner = document.querySelector("#spinner");

//Cierra la sesion y devuelve al login
function cerrarSesion(){
  localStorage.removeItem('userName');
  location.href = 'index.html';
}


//Obtiene todos los usuarios para crearlos en el listado
function fetchUsuario() {
 
    fetch(ipServer+"/usuario/")
      .then((res) => res.json())
      .then((data) => {
        for(let i=0;i<=data.length;i++){
            if(data[i].nombreUsuario=="root" || data[i].nombreUsuario=="pepanav" || data[i].nombreUsuario=="lunagarc"){
                console.log("admin");
            }else{
                crearUsuario(data[i]);
            }
        }
        spinner.style.display = "none";
      })
      .catch(error => {
        spinner.style.display = "none";
      })
    
  }
  
  //Llamada a obtener los usuarios y indica que la pagina esta cargando
  function fetchUsuarios() {
    
    spinner.style.display = "block";
    fetchUsuario();
    
  }

  //Crea una carta de Usuario en el listado
  function crearUsuario(usuario) {
    const flipCard = document.createElement("div");
    flipCard.classList.add("flip-card");
  
    const cardContainer = document.createElement("div");
    cardContainer.classList.add("card-container");
  
    flipCard.appendChild(cardContainer);
  

    const card = document.createElement("div");
    card.classList.add("user-block");
  
    const iconContainer = document.createElement("div");
    iconContainer.classList.add("img-container-user");
  
    const icon = document.createElement("img");
    icon.classList.add("logocircular");
    icon.src = usuario.url_imagen;
  
    iconContainer.appendChild(icon);

  
    const name = document.createElement("p");
    name.classList.add("name");
    name.textContent = usuario.nombreUsuario;
  
    card.appendChild(iconContainer);
    card.appendChild(name);

  
    const cardBack = document.createElement("div");
    cardBack.classList.add("user-block-back");
  
    cardBack.appendChild(botonesUsuario(usuario));
  
    cardContainer.appendChild(card);
    cardContainer.appendChild(cardBack);
    userContainer.appendChild(flipCard);

  }

  //Crea la parte trasera de la carta de Usuario
  function botonesUsuario(usuario) {
    const buttonsContainer = document.createElement("div");
    buttonsContainer.classList.add("buttons-container");


      const nombreUsuario = usuario.nombreUsuario;
  
      const buttonContainer = document.createElement("button-container");
      buttonContainer.classList.add("button-container");

  
      const botonModificar = document.createElement("a");
      botonModificar.classList.add("button");
      botonModificar.addEventListener("click",function() {verUsuario(nombreUsuario)},false);
      botonModificar.textContent = "Modificar";


      buttonContainer.appendChild(botonModificar);


      const buttonContainerEliminar = document.createElement("button-container");
      buttonContainerEliminar.classList.add("button-container");

      const botonEliminar = document.createElement("a");
      botonEliminar.classList.add("button");
      botonEliminar.addEventListener("click",function() {eliminarUsuario(nombreUsuario)},false);
      botonEliminar.textContent = "Eliminar";

      buttonContainerEliminar.appendChild(botonEliminar);
  
      buttonsContainer.appendChild(buttonContainer);
      buttonsContainer.appendChild(buttonContainerEliminar);

      
  
    return buttonsContainer;
  }

  //Metodo del boton de Modificar de la carta de Usuario que envia a la pagina de modificacion
  function verUsuario(nombreUser){
    window.location.href = 'modificarCliente.html?nombreUser='+encodeURIComponent(nombreUser);
  }

  //Metodo del boton de Eliminar de la carta de Usuario que elimina a este de la base de datos
  function eliminarUsuario(nombreUser){
    fetch(ipServer+"/usuario/delete/"+nombreUser ,{
      method: 'DELETE',
    }).catch(error => {
      spinner.style.display = "none";
      console.error(error);
    })

    actualizarListado();
    fetchUsuarios();
  }

  function flitrarUsuarios(){
    const nombre = userName.value;
    actualizarListado();
    fetch(ipServer+"/usuario/")
      .then((res) => res.json())
      .then((data) => {
        for(let i=0;i<=data.length;i++){
            if(data[i].nombreUsuario=="root" || data[i].nombreUsuario=="pepanav" || data[i].nombreUsuario=="lunagarc"){
                console.log("admin");
            }else{
              if(data[i].nombreUsuario.toLowerCase().includes(nombre.toLowerCase())){
                crearUsuario(data[i]);
              }
            }
        }
        spinner.style.display = "none";
      })
      .catch(error => {
        spinner.style.display = "none";
      })
  }

  //Reinicia el listado de Usuarios
  function actualizarListado(){
    userContainer.innerHTML = '<div id="spinner" class="spinner-border text-light" role="status"><span class="visually-hidden">Cargando...</span></div>'
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

  fetchUsuarios()