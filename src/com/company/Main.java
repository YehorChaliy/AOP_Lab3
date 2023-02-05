package com.company;
import javax.naming.Name;
import java.util.Scanner;
import java.util.jar.Attributes;

interface Run{
        String getName();
        double getCurrentSpeed();
        int getWeight();
        int getPassengersAmount();
        int getWheelsAmount();
    }

    abstract class Mashine implements Run {
        public static double MAXSPEED = 900;
        public static double MINSPEED = 220;
        public static int MAXPASSENGERSAMOUMT = 410;
        public static int MINPASSENGERSAMOUNT = 0;
        protected String Name;
        protected double currentSpeed;

        Mashine(String name, int speed) {
            this.Name = name;
            this.currentSpeed = speed;
            if (currentSpeed > MINSPEED && currentSpeed < MAXSPEED) {
                this.currentSpeed = speed;
            }
            else{
                System.out.println("Неприпустима швидкість для цього транспорту!");
                currentSpeed = 0;
            }
        }
        public String getName () {return this.Name;}

        public double getCurrentSpeed() {
            return this.currentSpeed;
        }
    }

    class Aircraft extends Mashine {
        int weight;
        int passengersAmount;
        int wheels;

        Aircraft(String name, int speed, int weight, int passengersAmount, int wheels) {
            super(name, speed);
            this.weight = weight;
            if (passengersAmount >= MINPASSENGERSAMOUNT && passengersAmount <= MAXPASSENGERSAMOUMT) {
                this.passengersAmount = passengersAmount;
            }
            else {
                System.out.println("Недопустима кількість пасажирів!");
            }

            this.wheels = wheels;
        }


            public int getWeight () {
                return this.weight;
            }

            public int getPassengersAmount () {
                return this.passengersAmount;
            }

            public int getWheelsAmount () {
                return this.wheels;
            }
    }

    class Transport extends Aircraft {
        boolean hasLargeLoadCapacity;
        Transport(String name, int speed, int weight, int passengersAmount, int wheels, boolean hasCapacity) {
            super(name, speed, weight, passengersAmount, wheels);
            this.hasLargeLoadCapacity = hasCapacity;
        }
    }

    class Passenger extends Aircraft {
        boolean convenienceForPassengers;
        Passenger(String name, int speed, int weight, int passengersAmount, int wheels, boolean convenience){
            super(name, speed, weight, passengersAmount, wheels);
            this.convenienceForPassengers = convenience;
        }
    }

 class Task extends Aircraft{
     Scanner in = new Scanner(System.in);
     Task(String name, int speed, int weight, int passengersAmount, int wheels) {
         super(name, speed, weight, passengersAmount, wheels);
     }
     Passenger passenger = new Passenger("Name", 777, 000, 000, 000, true);
     void InputPassengerData() {
        System.out.println("Введіть дані пасажирського літака: ");
        System.out.println("Назва літака: ");
        passenger.Name = in.next();
        System.out.println("Швидкість (км/год): ");
        while (true) {
            passenger.currentSpeed = in.nextInt();
            if (passenger.currentSpeed > MINSPEED && passenger.currentSpeed < MAXSPEED) {
                this.currentSpeed = passenger.currentSpeed;
                break;
            } else {
                System.out.println("Неприпустима швидкість для цього транспорту!");
                System.out.println("Введіть повторно вірну швидкість!");
                continue;
            }
        }
        System.out.println("Маса (тон): ");
        passenger.weight = in.nextInt();
        System.out.println("Кількість пасажирів: ");
        while (true) {
            passenger.passengersAmount = in.nextInt();
            if (passenger.passengersAmount >= MINPASSENGERSAMOUNT && passenger.passengersAmount <= MAXPASSENGERSAMOUMT) {
                this.passengersAmount = passenger.passengersAmount;
                break;
            } else {
                System.out.println("Недопустима кількість пасажирів!");
                System.out.println("Введіть повторно вірне значення!");
                continue;
            }
        }
        System.out.println("Кількість коліс: ");
        passenger.wheels = in.nextInt();
    }
    void ShowPassengerInfo(){
        System.out.println("Інформація про пасажирський літак: ");
        System.out.println("Назва літака: " + passenger.getName());
        System.out.println("Швидкість: " + passenger.getCurrentSpeed() + " км/год");
        System.out.println("Маса: " + passenger.getWeight() + " тон");
        System.out.println("Кількість пасажирів: " + passenger.getPassengersAmount());
        System.out.println("Кількість коліс: " + passenger.getWheelsAmount());
        System.out.println("Наявність комфортних місць та зручні умови для перельоту: " + true);

    }
    Transport transport = new Transport("Name",777, 000, 000, 000, true);

    void InputTransportData(){
        System.out.println("Введіть дані транспортного літака: ");
        System.out.println("Назва літака: ");
        transport.Name = in.next();
        System.out.println("Швидкість (км/год): ");
        while (true) {
            transport.currentSpeed = in.nextInt();
            if (transport.currentSpeed > MINSPEED && transport.currentSpeed < MAXSPEED) {
                this.currentSpeed = transport.currentSpeed;
                break;
            } else {
                System.out.println("Неприпустима швидкість для цього транспорту!");
                System.out.println("Введіть повторно вірну швидкість!");
                continue;
            }
        }
        System.out.println("Маса (тон): ");
        transport.weight = in.nextInt();
        System.out.println("Кількість пасажирів: ");
        while (true) {
            transport.passengersAmount = in.nextInt();
            if ( transport.passengersAmount >= MINPASSENGERSAMOUNT &&  transport.passengersAmount <= MAXPASSENGERSAMOUMT) {
                this.passengersAmount =  transport.passengersAmount;
                break;
            } else {
                System.out.println("Недопустима кількість пасажирів!");
                System.out.println("Введіть повторно вірне значення!");
                continue;
            }
        }
        System.out.println("Кількість коліс: ");
        transport.wheels = in.nextInt();
    }

    void ShowTransportInfo(){
        System.out.println("Інформація про транспортний літак: ");
        System.out.println("Назва літака: " + transport.getName());
        System.out.println("Швидкість: " + transport.getCurrentSpeed());
        System.out.println("Маса: " + transport.getWeight() + " тон");
        System.out.println("Кількість пасажирів: " + transport.getPassengersAmount());
        System.out.println("Кількість коліс: " + transport.getWheelsAmount());
        System.out.println("Місткість і висока вантажопідйомність: " + true);
    }
}

    public class Main {

        public static void menu(){
            System.out.println("Меню: ");
            System.out.println("1. Вказати дані пасажирського літака: ");
            System.out.println("2. Вказати дані вантажного літака: ");
            System.out.println("3. Показати інформацію про пасажирський літака: ");
            System.out.println("4. Показати інформацію про вантажний літака: ");
            System.out.println("5. Завершення програми. ");
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            Task object = new Task("Name", 777,000,000,000);
            int choice;
            while (true) {
                menu();
                choice = in.nextInt();
                switch (choice) {
                    case 1: {
                        object.InputPassengerData();
                        break;
                    }
                    case 2: {
                        object.InputTransportData();
                        break;
                    }
                    case 3: {
                        object.ShowPassengerInfo();
                        break;
                    }
                    case 4: {
                        object.ShowTransportInfo();
                        break;
                    }
                    case 5: {
                        System.out.println("Програму завершено!");
                        System.exit(0);
                    }
                    default:
                        System.out.println("Помилка! Виберіть правильний варіант.");
                }
            }
        }
    }
