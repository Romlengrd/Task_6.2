package com.company;

        public class Main {

            public static void main(String[] args) {
                Prop p = new Prop();
                p.getFile();
                try {
                    p.getProps();
                } catch (NoSuchFieldException e) {
                    System.out.println("Не найден ключ");
                }
                p.putExistentKey("value1", "lalala");


    }
}
