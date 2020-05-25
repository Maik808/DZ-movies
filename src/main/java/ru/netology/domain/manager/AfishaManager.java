package ru.netology.domain.manager;

import ru.netology.domain.Film;
import ru.netology.domain.repozitory.AfishaRepository;

public class AfishaManager {
    private AfishaRepository repository;
    private int show = 10;
    AfishaManager (){}

    public AfishaManager(AfishaRepository repository,int howManyFilmsToShow) {
        this.repository = repository;

        if (howManyFilmsToShow > 0 & howManyFilmsToShow < 10) {
            show = howManyFilmsToShow;
        }
        Film[] films = repository.findAll();
        int filmsLength = films.length;
        if ( filmsLength< show ){
            show = filmsLength;
        }
    }

    public void addFilm(Film film) {
       repository.save(film);
    }


    public Film[] getLastAdded() {
        Film[] films = repository.findAll();
        int filmsLength = films.length;

        Film[] customFilm = new Film[show];
        for (int current = 0; current < customFilm.length; current++) {
            int result = filmsLength - current - 1;
            customFilm[current] = films[result];
        }
        return customFilm;
    }

    public Film[] getAll(){
        Film[] films = repository.findAll();
        Film[] result = new Film[films.length];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    public Film[] showAll() {
        return repository.findAll();
    }
}


