package service;

import dao.SpectacleDao;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
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

        when(mockDao.trouver(anyString())).thenReturn("DAO trouver CALLED !");

        String found = spectacleService.trouver("blabla");

        assertEquals("DAO trouver CALLED !", found);
    }

    @Test
    public void shouldUseDaoCreer() throws Exception {

        when(mockDao.creer(anyString())).thenReturn("DAO creer CALLED !");

        String created = spectacleService.creer("blabla");

        assertEquals("DAO creer CALLED !", created);
    }
}