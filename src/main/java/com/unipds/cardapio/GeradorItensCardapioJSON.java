package com.unipds.cardapio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.google.gson.Gson;
import com.unipds.cardapio.entities.Database;
import com.unipds.cardapio.entities.ItemCardapio;

public class GeradorItensCardapioJSON {

    public static void main(String[] args) throws IOException {
        Database database = new Database();
        List<ItemCardapio> listaItensCardapio = database.listaItensCardapio();

        Gson gson = new Gson();
        String json = gson.toJson(listaItensCardapio);

        Path path = Path.of("itensCardapio.json");
        Files.writeString(path, json);

    }

}