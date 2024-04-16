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

import com.vignesh.tradingApplication.controller.StockController;
import com.vignesh.tradingApplication.model.Stock;
import com.vignesh.tradingApplication.service.StockService;
import com.vignesh.tradingApplication.service.UserNotFoundException;

@ExtendWith(MockitoExtension.class)
public class StockControllerTest {
    @Mock
    private StockService stockService;

    @InjectMocks
    private StockController stockController;

    @Test
    public void testGetAllStocks() {
        List<Stock> stockList = new ArrayList<>();
        stockList.add(new Stock(1, "AAPL", "Apple Inc.", 150.0));
        stockList.add(new Stock(2, "GOOGL", "Alphabet Inc.", 2800.0));
        when(stockService.getAllStock()).thenReturn(stockList);

        ResponseEntity<List<Stock>> response = stockController.getAllStocks();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(stockList, response.getBody());
    }

    @Test
    public void testGetStockById() {
        Stock stock = new Stock(1, "AAPL", "Apple Inc.", 150.0);
        when(stockService.getStockById(1)).thenReturn(Optional.of(stock));

        ResponseEntity<Stock> response = stockController.getStockById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(stock, response.getBody());
    }

    @Test
    public void testCreateStock() {
        Stock newStock = new Stock(null, "TSLA", "Tesla Inc.", 800.0);
        when(stockService.createStock(newStock)).thenReturn(newStock);

        ResponseEntity<Stock> response = stockController.createStock(newStock);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newStock, response.getBody());
    }

    @Test
    public void testUpdateStock() throws UserNotFoundException {
        Stock existingStock = new Stock(1, "AAPL", "Apple Inc.", 150.0);
        Stock updatedStock = new Stock(1, "AAPL", "Apple Inc.", 155.0);
        when(stockService.updateStock(1, updatedStock)).thenReturn(updatedStock);

        ResponseEntity<Stock> response = stockController.updateStock(1, updatedStock);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedStock, response.getBody());
    }

    @Test
    public void testDeleteStock() {
        ResponseEntity<Void> response = stockController.deleteStock(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(stockService, times(1)).deleteStock(1);
    }
}
