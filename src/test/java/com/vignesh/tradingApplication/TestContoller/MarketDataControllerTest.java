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

import com.vignesh.tradingApplication.controller.MarketDataController;
import com.vignesh.tradingApplication.model.MarketData;
import com.vignesh.tradingApplication.service.MarketDataService;

@ExtendWith(MockitoExtension.class)
public class MarketDataControllerTest {
    @Mock
    private MarketDataService marketDataService;

    @InjectMocks
    private MarketDataController marketDataController;

    @Test
    public void testGetAllMarketData() {
        List<MarketData> marketDataList = new ArrayList<>();
        marketDataList.add(new MarketData(1, "AAPL", 150.0, 152.0));
        marketDataList.add(new MarketData(2, "GOOGL", 2800.0, 2820.0));
        when(marketDataService.getAllMarketData()).thenReturn(marketDataList);

        ResponseEntity<List<MarketData>> response = marketDataController.getAllMarketData();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(marketDataList, response.getBody());
    }

    @Test
    public void testGetMarketDataById() {
        MarketData marketData = new MarketData(1, "AAPL", 150.0, 152.0);
        when(marketDataService.getMarketDataById(1)).thenReturn(Optional.of(marketData));

        ResponseEntity<MarketData> response = marketDataController.getMarketDataById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(marketData, response.getBody());
    }

    @Test
    public void testCreateMarketData() {
        MarketData newMarketData = new MarketData(null, "TSLA", 800.0, 810.0);
        when(marketDataService.createMarketData(0, newMarketData)).thenReturn(newMarketData);

        ResponseEntity<MarketData> response = marketDataController.createMarketData(0, newMarketData);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newMarketData, response.getBody());
    }

    @Test
    public void testUpdateMarketData() {
        MarketData existingMarketData = new MarketData(1, "AAPL", 150.0, 152.0);
        MarketData updatedMarketData = new MarketData(1, "AAPL", 155.0, 158.0);
        when(marketDataService.updateMarketData(1, updatedMarketData)).thenReturn(updatedMarketData);

        ResponseEntity<MarketData> response = marketDataController.updateMarketData(1, updatedMarketData);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedMarketData, response.getBody());
    }

    @Test
    public void testDeleteMarketData() {
        ResponseEntity<Void> response = marketDataController.deleteMarketData(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(marketDataService, times(1)).deleteMarketData(1);
    }
}
