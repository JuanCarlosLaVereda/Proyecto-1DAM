//Comprueba que el usuario a logear es un administrador y si lo es almacena el nombre y inicia sesion

document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    localStorage.clear();
    
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const errorMessage = document.getElementById('error-message');
  
    const validUsers = [
      { username: 'root', password: 'root' },
      { username: 'pepanav', password: '1234' },
      { username: 'lunagarc', password: '1234' }
    ];
  
    const isValidUser = validUsers.some(user => user.username === username && user.password === password);
  
    if (isValidUser) {
        localStorage.setItem("userName",username);
      window.location.href = 'admin.html';
    } else {
      errorMessage.style.display = 'block';
    }
  });