package ru.netology.domain;

public class BillboardManager {
    Film[] films = new Film[0];

    int show = 10;

    BillboardManager() {
    }

    public BillboardManager(int howManyFilmsToShow) {

        if (howManyFilmsToShow > 0) {
            show = howManyFilmsToShow;
        }
    }



    public void addFilm(Film film) {
        int filmsLength = films.length;
        Film[] tmpArray = new Film[filmsLength + 1];
        System.arraycopy(films, 0, tmpArray, 0, filmsLength);
        int lastIndex = tmpArray.length - 1;
        tmpArray[lastIndex] = film;
        films = tmpArray;
    }

    public Film[] getLastAdded() {
        int filmsLength = films.length;
        if (filmsLength < show){
            show = filmsLength;
        }
        Film[] customFilm = new Film[show];
        for (int current = 0; current < customFilm.length; current++) {
            int result = filmsLength - current - 1;
            customFilm[current] = films[result];
        }
        return customFilm;
    }
}