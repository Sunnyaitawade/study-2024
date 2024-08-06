package com.study.sb_transaction_managment.service.impl;


import com.study.sb_transaction_managment.entity.User;
import com.study.sb_transaction_managment.repository.UserRepository;
import com.study.sb_transaction_managment.service.MessageService;
import com.study.sb_transaction_managment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageService messageService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)// Propagation.REQUIRED by default
    public String saveUserTransactionRequired(int i) {
        try {
            User user = new User("hello-world", new Random().nextInt(10000));
            userRepository.save(user);
            if (i == 6) {
                messageService.saveMessageWithMandatoryTransaction();
            } else if (i == 5) {
                messageService.saveMessageWithSupportTransaction();
            } else if (i >= 3) {
                messageService.saveMessageWithNewTransaction(i);
            } else {
                messageService.saveMessage(i);
            }
            System.out.println("User saved.");
            return "Transaction - Both Entity are saved";
        } catch (Exception exception) {
            System.out.println("Exception + " + exception.getMessage());
            return "User is only saved - Message got exception";
        }
    }

    @Override
    public String saveUserWithoutTransactionAnnotation(int i) {
        User user = new User("hello-world", new Random().nextInt(10000));
        userRepository.save(user);
        messageService.saveMessageWithoutTransaction(i);
        System.out.println("User saved.");
        return "User & Message are saved Without Transaction";
    }
}
