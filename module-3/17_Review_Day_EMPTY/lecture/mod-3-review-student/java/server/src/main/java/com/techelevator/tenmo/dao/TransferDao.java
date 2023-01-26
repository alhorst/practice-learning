package com.techelevator.tenmo.dao;

import java.util.List;

import com.techelevator.tenmo.model.Transfer;

public interface TransferDao {

    Transfer getTransferById(Long transferId);

    Transfer addTransfer(Transfer newTransfer);

    List<Transfer> getTransfersForUser(Long userId);

    List<Transfer> findAll();

    List<Transfer> getPendingTransfersForUser(Long currentUserId);

	void updateStatus(Transfer transfer);
}
