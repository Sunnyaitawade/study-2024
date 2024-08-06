package com.study.sb_transaction_managment.service;

public interface MessageService {

	String saveMessage(int i);

	String saveMessageWithNewTransaction(int i);

	String saveMessageWithoutTransaction(int i);

	String saveMessageWithSupportTransaction();

	String saveMessageWithMandatoryTransaction();
}
