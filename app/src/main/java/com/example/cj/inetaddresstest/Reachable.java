package com.example.cj.inetaddresstest;

import java.io.IOException;
import java.net.InetAddress;

/**
 * Created by cj on 2017-02-06.
 */

public class Reachable {
  public static void getIPAddress(final String inputAddress) {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        InetAddress thisComputer = null;
        try {
          thisComputer = InetAddress.getByName(inputAddress);
          // getHostAddress() 바이너리 ip주소를 문자열로 만들어 반환
          System.out.println("ocj" + thisComputer.getHostAddress());
          // 서버의 정상 동작을 확인하기 위해 2초간 응답 메세지를 대기함
          if (thisComputer.isReachable(2000)) {
            System.out.println("%s is reachable \n" + thisComputer.getHostName());
          } else {
            System.out.println("%s is unreachable \n" + thisComputer.getHostName());
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });
    thread.start();
  }
}
