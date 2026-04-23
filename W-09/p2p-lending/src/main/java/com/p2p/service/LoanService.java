package com.p2p.service;
import com.p2p.domain.*;
import java.math.BigDecimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoanService {
    private static final Logger logger = LogManager.getLogger(LoanService.class);

    public Loan createLoan(Borrower borrower, BigDecimal amount) {
        logger.info("Memulai proses pembuatan Loan sebesar: " + amount);

        validateBorrower(borrower);

        if(amount.compareTo(BigDecimal.ZERO) <= 0) {
            logger.error("Gagal: Amount pinjaman kurang dari atau sama dengan nol.");
            throw new IllegalArgumentException("Loan amount must be greater than zero");
        }

        Loan loan = new Loan();
        if (borrower.getCreditScore() >= 600) {
            loan.approve();
            logger.info("Loan APPROVED. Credit score memenuhi syarat: " + borrower.getCreditScore());
        } else {
            loan.reject();
            logger.warn("Loan REJECTED. Credit score terlalu rendah: " + borrower.getCreditScore());
        }

        return loan;
    }

    public void validateBorrower(Borrower borrower) {
        if (!borrower.isVerified()) {
            logger.error("Gagal: Borrower belum terverifikasi (KYC).");
            throw new IllegalArgumentException("Borrower not verified");
        }
    }
}