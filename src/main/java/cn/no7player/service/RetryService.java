package cn.no7player.service;

import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Author:HisenSong
 * DateTime: 2017/5/23 17:04
 */
@Service
public class RetryService {

    @Retryable(value = {RemoteAccessException.class},maxAttempts = 5,backoff = @Backoff(delay = 2000L,multiplier = 1))
    public void retryTest(){
        System.out.println("do something ......");
        throw new RemoteAccessException("RemoteAccessException");
    }

    @Recover
    public void recover(RemoteAccessException e){
        System.out.println(e.getMessage());
        System.out.println("recover....");
    }


}
