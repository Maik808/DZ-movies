package ru.netology.domain.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.repozitory.AfishaRepository;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {
    AfishaRepository repository = new AfishaRepository();

    private Film filmOne = new Film(1, "Call of the ancestors", "action");
    private Film filmTwo = new Film(2, "Forward", "action");
    private Film filmThree = new Film(3, "Green mile", "drama");
    private Film filmFour = new Film(4, "Capernaum", "drama");
    private Film filmFive = new Film(5, "Beginning", "fantastic");
    private Film filmSix = new Film(6, "Avatar", "fantastic");
    private Film filmSeven = new Film(7, "Howl's moving castle", "fantastic");
    private Film filmEight = new Film(8, "Diamond hand", "comedy");
    private Film filmNine = new Film(9, "Good luck gentlemen", "comedy");


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
    }

    Film[] expected = {new Film(9, "Good luck gentlemen", "comedy"),
            new Film(8, "Diamond hand", "comedy"),
            new Film(7, "Howl's moving castle", "fantastic"),
            new Film(6, "Avatar", "fantastic"),
            new Film(5, "Beginning", "fantastic"),
            new Film(4, "Capernaum", "drama"),
            new Film(3, "Green mile", "drama"),
            new Film(2, "Forward", "action"),
            new Film(1, "Call of the ancestors", "action")
    };

    @Test
    void shouldShowTenFilms() {
        AfishaManager manager = new AfishaManager(repository, 10);
        Film[] actual = manager.getLastAdded();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowPositive() {
        AfishaManager manager = new AfishaManager(repository, 9);
        Film filmToAdd = new Film(30, "Dunkerk", "action");
        manager.addFilm(filmToAdd);
        Film[] actual = manager.getLastAdded();
        Film[] expected = {new Film(30, "Dunkerk", "action"),
                new Film(9, "Good luck gentlemen", "comedy"),
                new Film(8, "Diamond hand", "comedy"),
                new Film(7, "Howl's moving castle", "fantastic"),
                new Film(6, "Avatar", "fantastic"),
                new Film(5, "Beginning", "fantastic"),
                new Film(4, "Capernaum", "drama"),
                new Film(3, "Green mile", "drama"),
                new Film(2, "Forward", "action")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowNothing() {
        AfishaManager manager = new AfishaManager(repository, 0);
        Film[] actual = manager.getLastAdded();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowAboveMax() {
        AfishaManager manager = new AfishaManager(repository, 15);
        Film[] actual = manager.getLastAdded();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowNegative() {
        AfishaManager manager = new AfishaManager(repository, -1);
        Film[] actual = manager.getLastAdded();
        assertArrayEquals(expected, actual);
    }
}