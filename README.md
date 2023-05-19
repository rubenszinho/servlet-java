# Projeto de Autenticação e Exibição de Detalhes de Empregados

Este projeto é um aplicativo web simples que permite a autenticação do usuário (login) e a exibição dos detalhes do empregado logado.

## Especificações do Projeto

O projeto foi desenvolvido de acordo com as seguintes especificações:

### Servlets

1. `Login.java` - Classe servlet responsável pelo login do usuário. Ela possui os métodos `GET` e `POST`. O método `POST` recebe os dados de login do usuário, verifica se são válidos e autentica o usuário. O método `GET` carrega a página de login.

2. `DadosEmpregado.java` - Classe servlet responsável por exibir os dados do empregado logado. Ela possui os métodos `GET` e `POST`. O método `GET` exibe os dados do empregado logado em uma tabela. O método `POST` não realiza nenhuma ação neste momento.

### Views

1. `login.jsp` - Página de login que exibe campos para o nome do usuário e a senha, além de um botão para enviar as informações. Esta página é associada ao método `POST` da classe `Login`.

## Código

### Login.java

```java
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // O código para carregar a página de login vai aqui
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // O código para processar os dados de login do usuário vai aqui
    }
}
```

### DadosEmpregado.java

```java
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employeeDetails")
public class DadosEmpregado extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Aqui, você deve obter os detalhes do usuário do banco de dados (usando o
        // EmployeeDao, por exemplo)
        // e definir os atributos de solicitação, para que você possa exibí-los na
        // página JSP
        // Como ainda não se tem um gerenciamento adequado de sessão, o
        // nome de usuário será "testUser"
        EmployeeDao dao = new EmployeeDao();
        Employee employee = dao.getEmployee("testUser");

        req.setAttribute("employee", employee);
        req.getRequestDispatcher("/WEB-INF/views/employeedetails.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Por enquanto, não é preciso fazer nada aqui
    }
}
```

### Login.jsp

```html
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <form action="Login" method="post">
        <div>
            <label for="username">Username:</label>
```

## Banco de Dados

O banco de dados do projeto é composto por uma única tabela, employee, que armazena os detalhes dos empregados. O script de criação da tabela é o seguinte:

```sql
CREATE DATABASE `employees` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `username` varchar(250) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```