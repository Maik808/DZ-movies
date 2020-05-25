package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BillboardManagerTest {
    BillboardManager manager = new BillboardManager();

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

    Film[] expected = {new Film(10, "Serf", "comedy"),
            new Film(9, "Good luck gentlemen", "comedy"),
            new Film(8, "Diamond hand", "comedy"),
            new Film(7, "Howl's moving castle", "fantastic"),
            new Film(6, "Avatar", "fantastic"),
            new Film(5, "Beginning", "fantastic"),
            new Film(4, "Capernaum", "drama"),
            new Film(3, "Green mile", "drama"),
            new Film(2, "Forward", "action"),
            new Film(1, "Call of the ancestors", "action")
    };

    @BeforeEach
    public void setUp() {
        manager.addFilm(filmOne);
        manager.addFilm(filmTwo);
        manager.addFilm(filmThree);
        manager.addFilm(filmFour);
        manager.addFilm(filmFive);
        manager.addFilm(filmSix);
        manager.addFilm(filmSeven);
        manager.addFilm(filmEight);
        manager.addFilm(filmNine);
        manager.addFilm(filmTen);
    }

    @Test
    void shouldShowTenFilms() {
        BillboardManager manager = new BillboardManager(10);
        manager.films = this.manager.films;
        Film[] actual = manager.getLastAdded();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowPositive() {
        BillboardManager manager = new BillboardManager(6);
        manager.films = this.manager.films;
        Film filmToAdd = new Film(30, "Dunkerk", "action");
        manager.addFilm(filmToAdd);

        Film[] actual = manager.getLastAdded();
        Film[] expected = {new Film(30, "Dunkerk", "action"),
                new Film(10, "Serf", "comedy"),
                new Film(9, "Good luck gentlemen", "comedy"),
                new Film(8, "Diamond hand", "comedy"),
                new Film(7, "Howl's moving castle", "fantastic"),
                new Film(6, "Avatar", "fantastic")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowNothing() {
        BillboardManager manager = new BillboardManager(0);
        manager.films = this.manager.films;
        Film[] actual = manager.getLastAdded();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowAboveMax() {
        BillboardManager manager = new BillboardManager(15);
        manager.films = this.manager.films;
        Film[] actual = manager.getLastAdded();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowNegative() {
        BillboardManager manager = new BillboardManager(-1);
        manager.films = this.manager.films;
        Film[] actual = manager.getLastAdded();
        assertArrayEquals(expected, actual);
    }
}

