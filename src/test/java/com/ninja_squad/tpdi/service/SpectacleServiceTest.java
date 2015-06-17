package com.ninja_squad.tpdi.service;

import com.ninja_squad.tpdi.dao.SpectacleDao;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by jordan on 21/05/15.
 */
public class SpectacleServiceTest{


    private SpectacleDao mockDao;
    private SpectacleService spectacleService;

    @Before
    public void setUp() throws Exception {
        mockDao = mock(SpectacleDao.class);
        spectacleService = new SpectacleService(mockDao);
    }

    @Test
    public void shouldUseDaoTrouver() throws Exception {
        Stream<String> str = Stream.of("test1", "test2");
        when(mockDao.trouver()).thenReturn(str);

        String found = spectacleService.trouver("test1");

        assertEquals("test1", found);
    }

    @Test
    public void shouldReturnEmptyIfMovieDoesntExists() throws Exception {
        Stream<String> str = Stream.of("test1", "test2");
        when(mockDao.trouver()).thenReturn(str);

        String notFound = spectacleService.trouver("blabla");

        assertEquals("empty", notFound);
    }

    @Test
    public void shouldUseDaoCreer() throws Exception {
        Stream<String> str = Stream.of("test1", "test2");
        when(mockDao.trouver()).thenReturn(str);

        spectacleService.creer("test3");

        verify(mockDao).creer(anyString());
    }
}