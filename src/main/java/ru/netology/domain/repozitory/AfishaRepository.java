package ru.netology.domain.repozitory;

import ru.netology.domain.Film;

public class AfishaRepository {
    Film[] films = new Film[0];


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
