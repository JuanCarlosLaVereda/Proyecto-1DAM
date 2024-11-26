const clientImageView = document.querySelector("#iconocliente");
const nombreUser = document.querySelector("#nombreUser");
const clientName = document.querySelector("#clientName");
const clientLastName = document.querySelector("#clientLastName");
const clientEmail = document.querySelector("#clientEmail");
const clientPassword = document.querySelector("#clientPassword");
const clientDomicilio = document.querySelector("#clientDomicilio");
const clientFechaNac = document.querySelector("#clientFechNac");
const clientNumTarjeta = document.querySelector("#clientNumTarjeta");
const clientIcon = document.querySelector("#clientIcon");
const clientCodPostal = document.querySelector("#clientCodPostal");
const mensajeResultado = document.querySelector("#mensaje_resultado");

//Cierra la sesion y devuelve al login
function cerrarSesion(){
    localStorage.removeItem('userName');
    location.href = 'index.html';
  }

const ipServer = "http://172.30.198.206:8080";
//const ipServer = "http://127.0.0.1:8080";
const nombreUsuario = obtenerParametro('nombreUser');
colocarInformacion();

//Obtiene el nombre de Usuario almacenado en la URL
function obtenerParametro(nombreUser){
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(nombreUser);
}

//Obtiene la informacion del usuario y la muestra en el formulario
function colocarInformacion(){
    fetch(ipServer+"/usuario/"+nombreUsuario)
      .then((res) => res.json())
      .then((data) => {
        informacionUsuario(data);
      })
      .catch(error => {
        console.error(error);
      })
}

//Muestra la informacion del usuario en el formulario
function informacionUsuario(usuario){
    nombreUser.value = usuario.nombreUsuario;
    clientName.value = usuario.nombre;
    clientLastName.value = usuario.apellido;
    clientEmail.value = usuario.email;
    clientPassword.value = usuario.contrasenya;
    clientDomicilio.value = usuario.domicilio;
    clientFechaNac.value = usuario.fechaNacimiento;
    clientNumTarjeta.value = usuario.num_tarjeta;
    clientIcon.value = usuario.url_imagen;
    clientImageView.src = usuario.url_imagen;
    clientCodPostal.value = usuario.cp;
}

//A partir de la informacion del formulario realiza un put y actualiza al usuario
function modificarCliente(){
    const Usuario = {
        'nombreUsuario': nombreUser.value,
        'nombre': clientName.value,
        'apellido': clientLastName.value,
        'email': clientEmail.value,
        'contrasenya': clientPassword.value,
        'domicilio': clientDomicilio.value,
        'fechaNacimiento': clientFechaNac.value,
        'num_tarjeta': clientNumTarjeta.value,
        'url_imagen': clientIcon.value,
        'cp': clientCodPostal.value
    };
    

    fetch(ipServer+"/usuario/update", {
        
        method: 'PUT',
        mode: 'cors',
        body: JSON.stringify(Usuario),
        headers: {
            "Content-Type": "application/json",
        },
    }).then(response => response.json())
    .then((data) => {
        if(data == 1){
            mensajeResultado.innerHTML = "El Usuario se a actualizado correctamente";
        }
    })
    .catch(error => {
        mensajeResultado.innerHTML = "Ha ocurrido un error al actualizar el usuario";
        console.error(error);
    })
    
}

//obtiene la foto del usuario logeado y la coloca en el menu
function obtenerFotoUsuario(){
    const nombreUser = localStorage.getItem("userName");
    fetch(ipServer+"/usuario/"+nombreUser)
        .then((res) => res.json())
        .then((data) => {
        
          document.getElementById("iconoUsuario").src = data.url_imagen;
        
        })
        .catch(error => {
          console.error(error);
        })
  }
  
  obtenerFotoUsuario();

