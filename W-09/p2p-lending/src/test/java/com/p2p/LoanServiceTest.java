package com.p2p;
import com.p2p.domain.*;
import com.p2p.service.LoanService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoanServiceTest {
    private static final Logger logger = LogManager.getLogger(LoanServiceTest.class);

    @Test
    void shouldRejectLoanWhenBorrowerNotVerified() {
        logger.info("Menjalankan TC-01: shouldRejectLoanWhenBorrowerNotVerified");
        Borrower borrower = new Borrower(false, 700);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });
        assertEquals("Borrower not verified", exception.getMessage());
    }

    @Test
    void shouldRejectLoanWhenAmountIsZeroOrNegative() {
        logger.info("Menjalankan TC-02: shouldRejectLoanWhenAmountIsZeroOrNegative");
        Borrower borrower = new Borrower(true, 700);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(-1);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });
        assertEquals("Loan amount must be greater than zero", exception.getMessage());
    }

    @Test
    void shouldApproveLoanWhenCreditScoreHigh() {
        logger.info("Menjalankan TC-03: shouldApproveLoanWhenCreditScoreHigh");
        Borrower borrower = new Borrower(true, 700);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        Loan loan = loanService.createLoan(borrower, amount);

        assertEquals(Loan.Status.APPROVED, loan.getStatus());
        logger.info("TC-03 Berhasil: Status sesuai (APPROVED)");
    }

    @Test
    void shouldRejectLoanWhenCreditScoreLow() {
        logger.info("Menjalankan TC-04: shouldRejectLoanWhenCreditScoreLow");
        Borrower borrower = new Borrower(true, 0);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        Loan loan = loanService.createLoan(borrower, amount);

        assertEquals(Loan.Status.REJECTED, loan.getStatus());
        logger.info("TC-04 Berhasil: Status sesuai (REJECTED)");
    }
}