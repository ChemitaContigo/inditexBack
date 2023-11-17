Feature: Tratamiento de datos en APIs

  Background:
    * url 'https://petstore.swagger.io'

  Scenario: Crear usuario
    Given path '/v2/user'
    And request {"id": 1,"username": "vsolis","firstName": "vicente","lastName": "solis","email": "vsolis272@gmail.com","password": "Contraseña_2024","phone": "665847253","userStatus": 0}
    When method POST
    Then status 200

  Scenario: Recuperar datos del usuario creado
    Given path '/v2/user/vsolis'
    When method GET
    Then status 200
    And match response.username == 'vsolis'

