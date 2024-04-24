package com.example.bibliothequeexpress.service;

import com.example.bibliothequeexpress.entity.Categorie;
import com.example.bibliothequeexpress.repository.CategorieRepository;
import com.example.bibliothequeexpress.services.serviceImpl.CategorieServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CategoryTest {
    @Mock
    private CategorieRepository categorieRepository;
    @InjectMocks
    private CategorieServiceImpl categorieService;

    @Test
    void testGetAllCategories() {
        Mockito.when(categorieRepository.findAll()).thenReturn(Collections.singletonList(new Categorie()));

        List<Categorie> categories = categorieService.getAllCategories();

        Assertions.assertEquals(1, categories.size());
        verify(categorieRepository, times(1)).findAll();
    }

    @Test
    void testGetCategorieById() {
        Mockito.when(categorieRepository.findById(1L)).thenReturn(Optional.of(new Categorie()));

        Optional<Categorie> categorie = categorieService.getCategorieById(1L);

        Assertions.assertEquals(Optional.of(new Categorie()), categorie);
        verify(categorieRepository, times(1)).findById(1L);
    }
}
