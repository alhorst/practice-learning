package com.techelevator.tenmo.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.AuthorizationException;
import com.techelevator.tenmo.model.NewTransferDTO;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferAuthorization;
import com.techelevator.tenmo.model.TransferStatusUpdateDTO;
import com.techelevator.tenmo.model.User;

@RestController
@RequestMapping("/transfers")
@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class TransferController {

    private TransferDao transferDao;
    private AccountDao accountDao;
    private UserDao userDao;

    public TransferController(TransferDao transferDao, AccountDao accountDao, UserDao userDao) {
        this.transferDao = transferDao;
        this.accountDao = accountDao;
        this.userDao = userDao;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Transfer getTransfer(@PathVariable Long id, Principal principal) {
        Transfer transfer = transferDao.getTransferById(id);
        validateAuthorizationToView(principal, transfer);
        return transfer;
    }

	@ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Transfer createTransfer(@Valid @RequestBody NewTransferDTO transferDTO, Principal principal) {
    	Transfer transfer = buildTransferFromTransferDTO(transferDTO);
    	validateAuthorizationToCreate(principal, transfer);
    	transfer = transferDao.addTransfer(transfer);
    	if(transfer.isApproved()) {
    		transferBucksBetweenAccounts(transfer);
    	}
    	return transfer;
    }

    @RequestMapping(value = "/{transferId}", method = RequestMethod.PUT)
	public Transfer updateTransferStatus(@PathVariable Long transferId, @Valid @RequestBody TransferStatusUpdateDTO dto, Principal principal) {
    	String newStatus = dto.getTransferStatus();
    	Transfer transfer = transferDao.getTransferById(transferId);
    	validateAuthorizationToUpdateStatus(principal, transfer);
    	if(Transfer.TRANSFER_STATUS_APPROVED.equals(newStatus)) {
    		transfer.approve();
    		transferBucksBetweenAccounts(transfer);
    	} else if(Transfer.TRANSFER_STATUS_REJECTED.equals(newStatus)) {
    		transfer.reject();
    	} 
    	transferDao.updateStatus(transfer);
		return transfer;
    }

	private Transfer buildTransferFromTransferDTO(NewTransferDTO transferDTO) {
		User userFrom = userDao.getUserById(transferDTO.getUserFrom());
    	User userTo = userDao.getUserById(transferDTO.getUserTo());
    	
    	return new Transfer(transferDTO.getTransferType(),
						    userFrom,
						    userTo,
						    transferDTO.getAmount());
	}

	private void transferBucksBetweenAccounts(Transfer transfer) {
		Account accountFrom = accountDao.getAccountByUserId(transfer.getUserFrom().getId());
		Account accountTo = accountDao.getAccountByUserId(transfer.getUserTo().getId());
		accountFrom.transfer(accountTo, transfer.getAmount());
		accountDao.updateBalance(accountFrom);
		accountDao.updateBalance(accountTo);
	}
	
	private void validateAuthorizationToView(Principal principal, Transfer transfer) {
		TransferAuthorization auth = new TransferAuthorization(principal, transfer);
        if(!auth.isAllowedToView()) {
        	throw new AuthorizationException();
        }
	}
	
	private void validateAuthorizationToCreate(Principal principal, Transfer transfer) {
		TransferAuthorization auth = new TransferAuthorization(principal, transfer);
        if(!auth.isAllowedToCreate()) {
        	throw new AuthorizationException();
        }
	}
	
	private void validateAuthorizationToUpdateStatus(Principal principal, Transfer transfer) {
		TransferAuthorization auth = new TransferAuthorization(principal, transfer);
        if(!auth.isAllowedToApproveOrReject()) {
        	throw new AuthorizationException();
        }
	}
}
