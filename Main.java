import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        String[] menu = new String[] {"кофе", "газ. напиток", "сок", "пицца", "бургер", "шаурма"}; //массив для сравнения с тем, что вводят в консоль

        int  coffee = 0, soda = 0, juice = 0, pizza = 0, burger = 0, shaurma = 0, count_int;
        boolean is_online,is_digits;
        String count;

        while (true) {     //офлайн или онлайн до тех пор, пока не введут корректный ответ
            System.out.println("Онлайн или оффлайн заказ?");
            String online = myObj.nextLine();
            if ("онлайн".equalsIgnoreCase(online)){
                is_online = true;
                break;
            } else if (("оффлайн".equalsIgnoreCase(online))){
                is_online = false;
                break;
            } else {
                System.out.println("Кажется вы ошиблись, попробуйте еще раз\n");
            }
        }
        System.out.println("Наше меню: \n" +
                "Кофе - 150 руб.\n" +
                "Газ. напиток - 100 руб.\n" +
                "Сок - 120 руб. \n" +
                "Пицца - 500 руб. \n" +
                "Бургер - 140 руб.\n" +
                "Шаурма - 120 руб.  \n");
        first: while (true) {
            second: while (true) { // заказ, пока  не введут корректный ответ
                System.out.println("Что вы хотели бы заказать?");
                String zakaz = myObj.nextLine();
                for (String i: menu) {   //for each для меню
                    if (i.equalsIgnoreCase(zakaz)) {
                        while (true) {
                            System.out.println("В каком количестве?");
                            count = myObj.nextLine();
                            if (isNumeric(count) == false) { //isNumeric - для проверки на int
                                System.out.println("Кажется вы ошиблись, попроуйте еще раз\n");
                            } else break;
                        }
                        count_int = Integer.parseInt(count);
                        switch (i.toLowerCase()) { //switch case для добавления значения
                            case "кофе":
                                coffee += count_int;
                                break;
                            case "газ. напиток":
                                soda += count_int;
                                break;
                            case "сок":
                                juice += count_int;
                                break;
                            case "пицца":
                                pizza += count_int;
                                break;
                            case "бургер":
                                burger += count_int;
                                break;
                            case "шаурма":
                                shaurma += count_int;
                                break;
                        }
                        break second;
                    }
                }
                System.out.println("Кажется вы ошиблись попробуйте еще раз\n");
            }

            while (true){
                System.out.println("Хотите добваить еще что-то к заказу? \nда\\заказ окончен?");
                String is_continue = myObj.nextLine();
                if ("да".equalsIgnoreCase(is_continue)){
                    break;
                } else if ("заказ окончен".equalsIgnoreCase(is_continue)){
                    break first;
                }else System.out.println("Кажется вы ошиблись попробуйте еще раз\n");
            }
        }
        System.out.println("Online = " + is_online + "\n" + "кофе = " + coffee + "\n" + "soda = " + soda + "\n" + "сок = " + juice + "\n" + "пицца = " + pizza + "\n" + "бургер = " + burger + "\n" + "шаурма = " + shaurma);
        counting(is_online, coffee, soda, juice, pizza, burger, shaurma);
    }

    public static boolean isNumeric(String count) { //функция для проверки на int
        try {
            Integer.parseInt(count);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    //Математика: для скидки 50% на каждое второе блюдо - нацело делю на два и умножаю на полторы цены и, если количество нечетное, добавляю один фул прайс
    //Для каждого второго напитка в подарок - остаток от деления на два + делени нацело на два умножаю на стоимость
    public static void counting(boolean is_online, int coffee, int soda, int juice, int pizza, int burger, int shaurma){
        int summa = 0;
        if (is_online){
            summa += ((pizza / 2) * 750 + (pizza % 2) * 500 + (burger / 2) * 210 + (burger % 2) * 140 + (shaurma / 2) * 180 + (shaurma % 2) * 120 + coffee * 150 + soda * 100 + juice * 120) * 0.85;
        }else{
            summa += (pizza / 2) * 750 + (pizza % 2) * 500 + (burger / 2) * 210 + (burger % 2) * 140 + (shaurma / 2) * 180 + (shaurma % 2) * 120 + (coffee / 2 + coffee % 2) * 150 + (soda / 2 + soda % 2) * 150 + (juice / 2 + juice % 2) * 150;
        }
        System.out.println(summa);
    }
}