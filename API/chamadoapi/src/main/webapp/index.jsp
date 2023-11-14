<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Documentação da API de Chamados de Guinchos</title>
    <style>
        body {
            background-color: #f7f0e1;
            font-family: Arial, sans-serif;
            text-align: center;
        }

        h1 {
            color: #333;
            font-size: 36px;
            margin: 20px 0;
        }

        p {
            color: #555;
            font-size: 20px;
        }

        .container {
            margin: 20px auto;
            max-width: 800px;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: left;
        }

        pre {
            background-color: #f5f5f5;
            padding: 10px;
            border-radius: 5px;
            overflow-x: auto;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Documentação da API de Chamados de Guinchos</h1>
        <p><strong>Endpoint:</strong> chamadoapi/webapi/chamado/</p>
        <p><strong>Método:</strong> POST</p>
        <p>Abrir um Novo Chamado</p>
        <pre>
{
    "solicitante": {
        "nome": "Lucas",
        "sobrenome": "dos Santos",
        "email": "lucas@teste.com",
        "telefone": "11976543210",
        "cpf": "98765432109",
        "dataNascimento": "1981-05-15",
        "cep": "54321-876",
        "estado": "RJ",
        "cidade": "Rio de Janeiro",
        "logradouro": "Avenida Exemplo, 456",
        "numero": "789",
        "complemento": "Bloco C",
        "genero": "Masculino"
    },
    "veiculo": {
        "marcaCarro": "Toyota",
        "modeloCarro": "Corolla",
        "placaCarro": "ABC1234",
        "anoCarro": "2022",
        "eixosCarro": "2",
        "comprimentoCarro": "4.6m",
        "alturaCarro": "1.4m",
        "pesoCarro": "1200kg",
        "chassisCarro": "ABC123456789XYZ"
    },
    "incidente": {
        "horaIncidente": "12:30",
        "estadoIncidente": "SP",
        "cidadeIncidente": "São Paulo",
        "logradouroIncidente": "Avenida Teste, 789",
        "numeroIncidente": "101",
        "complementoIncidente": "Na esquina do supermercado",
        "descricaoIncidente": "Colisão frontal"
    }
}
        </pre>
    </div>
</body>
</html>
