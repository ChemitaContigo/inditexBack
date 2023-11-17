package org.petstore;

import domain.Pet;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.*;

public class PetStoreApiTest {
    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    public static void main(String[] args) {
        List<Pet> pets = getSoldPets();
        if (pets != null) {
            for (Pet pet : pets) {
                System.out.println("ID: " + pet.getId());
                System.out.println("Nombre: " + pet.getName());
                System.out.println("Status: " + pet.getStatus());
                System.out.println();
            }
            formatPetList(pets);
        }}

    private static List<Pet> getSoldPets() {
        Response response = RestAssured.given()
                .param("status", "sold")
                .get(BASE_URL + "/pet/findByStatus");

        if (response.getStatusCode() == 200) {
            try {
                ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                return mapper.readValue(response.getBody().asString(), mapper.getTypeFactory().constructCollectionType(List.class, Pet.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error al obtener mascotas vendidas. Código de estado: " + response.getStatusCode());
        }
        return null;
    }

    private static void formatPetList(List<Pet> pets) {
        Map<String, List<Pet>> petsByName = new HashMap<>();
        for (Pet pet : pets) {
            String name = pet.getName();
            petsByName.computeIfAbsent(name, k -> new ArrayList<>()).add(pet);
        }

        System.out.println("Conteo de mascotas por nombre:");
        petsByName.forEach((name, petList) -> System.out.println(name + ": " + petList.size()));

    }

}
