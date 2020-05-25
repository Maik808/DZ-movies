package ru.netology.domain.repozitory;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();
    private Film filmToAdd = new Film(30, "Dunkerk", "action");

    @BeforeEach
    void setUp() {
        repository.save(filmToAdd);
    }

    @Test
    void shouldFindAll() {
        Film[] actual = repository.findAll();
        Film[] expected = {
                new Film(1, "Call of the ancestors", "action"),
                new Film(2, "Forward", "action"),
                new Film(3, "Green mile", "drama"),
                new Film(4, "Capernaum", "drama"),
                new Film(5, "Beginning", "fantastic"),
                new Film(6, "Avatar", "fantastic"),
                new Film(7, "Howl's moving castle", "fantastic"),
                new Film(8, "Diamond hand", "comedy"),
                new Film(9, "Good luck gentlemen", "comedy"),
                new Film(30, "Dunkerk", "action")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSave() {
        Film filmToAdd = new Film(32, "Terminator2", "action");
        repository.save(filmToAdd);
        Film[] actual = repository.findAll();
        Film[] expected = {
                new Film(1, "Call of the ancestors", "action"),
                new Film(2, "Forward", "action"),
                new Film(3, "Green mile", "drama"),
                new Film(4, "Capernaum", "drama"),
                new Film(5, "Beginning", "fantastic"),
                new Film(6, "Avatar", "fantastic"),
                new Film(7, "Howl's moving castle", "fantastic"),
                new Film(8, "Diamond hand", "comedy"),
                new Film(9, "Good luck gentlemen", "comedy"),
                new Film(30, "Dunkerk", "action"),
                new Film(32, "Terminator2", "action")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        Film actual = repository.findById(1);
        Film expected = new Film(1, "Call of the ancestors", "action");
        assertEquals(expected,actual);
    }

    @Test
    void shouldFindNonexistentId() {
        Film actual = repository.findById(55);
        Film expected = null;
        assertEquals(expected,actual);
    }

    @Test
    void shouldRemoveById() {
        repository.removeById(6);
        Film[] actual = repository.findAll();
        Film[] expected = {
                new Film(1, "Call of the ancestors", "action"),
                new Film(2, "Forward", "action"),
                new Film(3, "Green mile", "drama"),
                new Film(4, "Capernaum", "drama"),
                new Film(5, "Beginning", "fantastic"),
                new Film(7, "Howl's moving castle", "fantastic"),
                new Film(8, "Diamond hand", "comedy"),
                new Film(9, "Good luck gentlemen", "comedy"),
                new Film(30, "Dunkerk", "action")
        };
        assertArrayEquals(expected,actual);
    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll();
        Film[] expected ={};
        Film[] actual =repository.findAll();
        assertArrayEquals(expected,actual);
    }

}