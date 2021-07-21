package com.webservice.client;

import com.webservice.client.StudentInterfaceImp;
import com.webservice.client.StudentInterfaceImpService;

import java.util.Scanner;

public class Client {


    public static void main(String[] args) {
        StudentInterfaceImpService impService;
        StudentInterfaceImp imp;

        impService = new StudentInterfaceImpService();
        //  获得服务端点
        imp = impService.getStudentInterfaceImpPort();
        Scanner out = new Scanner(System.in);
        int number = out.nextInt();
        System.out.println(imp.studentQuery(number));


    }
}

