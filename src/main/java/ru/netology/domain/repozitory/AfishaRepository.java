package ru.netology.domain.repozitory;

import ru.netology.domain.Film;

public class AfishaRepository {
    Film[] films = {new Film(1, "Call of the ancestors", "action"),
            new Film(2, "Forward", "action"),
            new Film(3, "Green mile", "drama"),
            new Film(4, "Capernaum", "drama"),
            new Film(5, "Beginning", "fantastic"),
            new Film(6, "Avatar", "fantastic"),
            new Film(7, "Howl's moving castle", "fantastic"),
            new Film(8, "Diamond hand", "comedy"),
            new Film(9, "Good luck gentlemen", "comedy")
    };

    public Film[] findAll() {
        return films;
    }

    public void save(Film film) {
        Film[] tmpArray = new Film[films.length + 1];
        System.arraycopy(films, 0, tmpArray, 0, films.length);
        int lastIndex = tmpArray.length - 1;
        tmpArray[lastIndex] = film;
        films = tmpArray;
    }

    public Film findById(int id) {
        for (Film film : films) {
            if (film.getId() == id) {
                return film;
            }
        }
        return null;
    }

    void removeById(int id) {
        int length = films.length - 1;
        Film[] tmpArray = new Film[length];
        int i = 0;
        for (Film film : films) {
            if (film.getId() != id) {
                tmpArray[i] = film;
                i++;
            }
        }
        films = tmpArray;
    }

    void removeAll() {
        films = new Film[0];
    }
}
