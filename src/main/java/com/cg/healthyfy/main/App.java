package com.cg.healthyfy.main;

import java.util.Scanner;
import com.cg.healthyfy.exception.NoRecordFoundException;
import com.cg.healthyfy.menu.LoginMenu;
import com.cg.healthyfy.menu.MainMenu;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String args[]) {
  LoginMenu mains=new LoginMenu();
  mains.loginMenu();
    }
}

