<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="se">
<head>
    <meta charset="UTF-8">
    <title>Add a new invoice</title>
</head>
<body>

<form action="/invoice/new" method="POST">
    <label>titel</label>
    <input type="text" name="titel"/>

    <br>

    <label>Beskrivning</label>
    <textarea name="beskrivning"></textarea>

    <br>

    <label>Kategori</label>
    <input type="text" name="kategori"/>

    <br>

    <label>Pris</label>
    <input type="text" name="pris"/>

    <br>

    <button>Add invoice</button>
</form>
</body>
</html>