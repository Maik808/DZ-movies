package ru.netology.domain.repozitory;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();


    private Film filmOne = new Film(1, "Call of the ancestors", "action");
    private Film filmTwo = new Film(2, "Forward", "action");
    private Film filmThree = new Film(3, "Green mile", "drama");
    private Film filmFour = new Film(4, "Capernaum", "drama");
    private Film filmFive = new Film(5, "Beginning", "fantastic");
    private Film filmSix = new Film(6, "Avatar", "fantastic");
    private Film filmSeven = new Film(7, "Howl's moving castle", "fantastic");
    private Film filmEight = new Film(8, "Diamond hand", "comedy");
    private Film filmNine = new Film(9, "Good luck gentlemen", "comedy");
    private Film filmTen = new Film(10, "Serf", "comedy");

    @BeforeEach

    public void setUp() {
        repository.save(filmOne);
        repository.save(filmTwo);
        repository.save(filmThree);
        repository.save(filmFour);
        repository.save(filmFive);
        repository.save(filmSix);
        repository.save(filmSeven);
        repository.save(filmEight);
        repository.save(filmNine);
        repository.save(filmTen);
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
                new Film(10, "Serf", "comedy")
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
                new Film(10, "Serf", "comedy"),
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
                new Film(10, "Serf", "comedy")
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