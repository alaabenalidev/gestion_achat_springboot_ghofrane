package com.gestionProduit.backEnd.Entity.dtos;

import java.util.List;

public record CommandeDto(List<ItemDto> items) {

    public record ItemDto(Integer id, Integer qte) {
    }

}
