package com.vignesh.tradingApplication.TestContoller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.vignesh.tradingApplication.controller.PortfolioController;
import com.vignesh.tradingApplication.model.Portfolio;
import com.vignesh.tradingApplication.service.PortfolioService;
import com.vignesh.tradingApplication.service.UserNotFoundException;

@ExtendWith(MockitoExtension.class)
public class PortfolioControllerTest {
    @Mock
    private PortfolioService portfolioService;

    @InjectMocks
    private PortfolioController portfolioController;

    @Test
    public void testGetAllPortfolios() {
        List<Portfolio> portfolioList = new ArrayList<>();
        portfolioList.add(new Portfolio(1, "AAPL", 10, 150.0, 1500.0));
        portfolioList.add(new Portfolio(2, "GOOGL", 5, 2800.0, 14000.0));
        when(portfolioService.getAllPortfolios()).thenReturn(portfolioList);

        ResponseEntity<List<Portfolio>> response = portfolioController.getAllPortfolios();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(portfolioList, response.getBody());
    }

    @Test
    public void testGetPortfolioById() {
        Portfolio portfolio = new Portfolio(1, "AAPL", 10, 150.0, 1500.0);
        when(portfolioService.getPortfolioById(1)).thenReturn(Optional.of(portfolio));

        ResponseEntity<Portfolio> response = portfolioController.getPortfolioById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(portfolio, response.getBody());
    }

    @Test
    public void testCreatePortfolio() {
        Portfolio newPortfolio = new Portfolio(null, "TSLA", 5, 800.0, 4000.0);
        when(portfolioService.createPortfolio(0, 0, newPortfolio)).thenReturn(newPortfolio);

        ResponseEntity<Portfolio> response = portfolioController.createPortfolio(0, 0, newPortfolio);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newPortfolio, response.getBody());
    }

    @Test
    public void testUpdatePortfolio() throws UserNotFoundException {
        Portfolio existingPortfolio = new Portfolio(1L, "AAPL", 10, 150.0, 1500.0);
        Portfolio updatedPortfolio = new Portfolio(1L, "AAPL", 12, 155.0, 1860.0);
        when(portfolioService.updatePortfolio(1, updatedPortfolio)).thenReturn(updatedPortfolio);

        ResponseEntity<Portfolio> response = portfolioController.updatePortfolio(1, updatedPortfolio);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedPortfolio, response.getBody());
    }

    @Test
    public void testDeletePortfolio() {
        ResponseEntity<Void> response = portfolioController.deletePortfolio(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(portfolioService, times(1)).deletePortfolio(1);
    }
}
