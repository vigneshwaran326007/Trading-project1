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

import com.vignesh.tradingApplication.controller.TransactionController;
import com.vignesh.tradingApplication.model.Transaction;
import com.vignesh.tradingApplication.service.TransactionService;
import com.vignesh.tradingApplication.service.UserNotFoundException;

@ExtendWith(MockitoExtension.class)
public class TransactionControllerTest {
    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private TransactionController transactionController;

    @Test
    public void testGetAllTransactions() {
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(new Transaction(1, null, null, "BUY", 10, 150.0, null));
        transactionList.add(new Transaction(2, null, null, "SELL", 5, 160.0, null));
        when(transactionService.getAllTransaction()).thenReturn(transactionList);

        ResponseEntity<List<Transaction>> response = transactionController.getAllTransactions();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(transactionList, response.getBody());
    }

    @Test
    public void testGetTransactionById() {
        Transaction transaction = new Transaction(1, null, null, "BUY", 10, 150.0, null);
        when(transactionService.getTransactionById(1)).thenReturn(Optional.of(transaction));

        ResponseEntity<Transaction> response = transactionController.getTransactionById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(transaction, response.getBody());
    }

    @Test
    public void testCreateTransaction() {
        Transaction newTransaction = new Transaction(null, null, null, "SELL", 8, 170.0, null);
        when(transactionService.createTransaction(0, 0, newTransaction)).thenReturn(newTransaction);

        ResponseEntity<Transaction> response = transactionController.createTransaction(0, 0, newTransaction);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newTransaction, response.getBody());
    }

    @Test
    public void testUpdateTransaction() throws UserNotFoundException {
        Transaction existingTransaction = new Transaction(1, null, null, "BUY", 10, 150.0, null);
        Transaction updatedTransaction = new Transaction(1, null, null, "BUY", 15, 155.0, null);
        when(transactionService.updateTransaction(1, updatedTransaction)).thenReturn(updatedTransaction);

        ResponseEntity<Transaction> response = transactionController.updateTransaction(1, updatedTransaction);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedTransaction, response.getBody());
    }

    @Test
    public void testDeleteTransaction() {
        ResponseEntity<Void> response = transactionController.deleteTransaction(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(transactionService, times(1)).deleteTransaction(1);
    }
}
