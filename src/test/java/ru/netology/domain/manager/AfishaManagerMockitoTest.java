package ru.netology.domain.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Film;
import ru.netology.domain.repozitory.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class AfishaManagerMockitoTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    AfishaManager manager =new AfishaManager();

   // private AfishaManager manager;
    private Film first = new Film(111, "The Irishman", "action");
    private Film second = new Film(122, "Gisaengchung", "thriller");
    private Film third = new Film(133, "Ford v Ferrari", "drama");

    @Test
    void shouldAddFilmWithMock() {
        Film[] returned = new Film[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(third);
        manager.addFilm(third);
        Film[] expected = new Film[]{third, second, first};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void showAll() {
        Film[] returned = new Film[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        Film[] expected = new Film[]{first, second, third};
        Film[] actual = manager.showAll();
        assertArrayEquals(expected, actual);
    }
}
