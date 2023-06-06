<!DOCTYPE html>
<html>

<head>
    <title>Cadastro de Tarefa</title>
</head>

<body>
    <h2>Cadastro de Tarefa</h2>
    <form action="CadastroServlet" method="post">
        <label for="titulo">Título:</label><br>
        <input type="text" id="titulo" name="titulo"><br>
        <label for="descricao">Descrição:</label><br>
        <textarea id="descricao" name="descricao"></textarea><br>
        <input type="submit" value="Cadastrar">
    </form>
</body>

</html>