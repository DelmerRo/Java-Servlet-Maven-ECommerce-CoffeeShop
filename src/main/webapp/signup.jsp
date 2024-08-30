<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KillaCoffee - Registro</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
 <style>
        body {
            background-color: #f5f5f5;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .card {
            border: none;
            border-radius: 15px;
            background-color: #ffffff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .card-header {
            background-color: #8b4513; /* Marrón café */
            color: #ffffff;
            text-align: center;
            border-top-left-radius: 15px;
            border-top-right-radius: 15px;
        }
        .btn-login {
            background-color: #4caf50; /* Verde */
            border: none;
            color: #ffffff;
        }
        .btn-login:hover {
            background-color: #388e3c;
        }
        .form-control:focus {
            border-color: #8b4513;
            box-shadow: none;
        }
        .link-password {
            color: #4caf50;
        }
        .link-password:hover {
            color: #388e3c;
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
        <div class="row justify-content-center align-items-center vh-100">
            <div class="col-md-5">
                <div class="card">
                    <div class="card-header">
                        <h3 class="mb-0">Registrate a KillaCoffee</h3>
                    </div>
                    <div class="card-body p-4">
                        <form action="signup" method="post" class="p-4">
                            <div class="mb-3">
                                <label for="text" class="form-label">Usuario</label>
                                <input type="text" class="form-control" id="userName" name="userName" placeholder="jindrg12" required>
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">Contraseña</label>
                                <input type="password" class="form-control" id="password" name="password" placeholder="Ingresa tu contraseña" required>
                            </div>
                           <div class="mb-3">
                            <% String errorMessage = (String) request.getAttribute("error");
                                if (errorMessage != null) { %>
                                <div class="alert alert-danger" role="alert">
                                    <%= errorMessage %>
                                </div>
                             <% } %>
                            </div>
                            
                            <div class="d-flex justify-content-between align-items-center">
                                <button type="submit" value="Registrarme" class="btn btn-login">Registrar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>