package ro.tuc;

import Model.Client;
import DataAccess.ClientDAO;
import Presentation.Controller;
import Presentation.View;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

       View v = new View();
       Controller c = new Controller(v);

    }
}