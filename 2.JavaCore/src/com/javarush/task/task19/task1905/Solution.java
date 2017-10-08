package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
//        Contact contact = new Contact() {
//            @Override
//            public String getName() {
//                return "Ivanov, Ivan";
//            }
//
//            @Override
//            public String getPhoneNumber() {
//                return "+38(050)123-45-67";
//            }
//        };
//        Customer customer = new Customer() {
//            @Override
//            public String getCompanyName() {
//                return "JavaRush Ltd.";
//            }
//
//            @Override
//            public String getCountryName() {
//                return "Ukraine";
//            }
//        };
//        RowItem rowItem = new DataAdapter(customer, contact);
//        System.out.println(rowItem.getContactFirstName());
//        System.out.println(rowItem.getContactLastName());
//        System.out.println(rowItem.getCountryCode());
//        System.out.println(rowItem.getCompany());
//        System.out.println(rowItem.getDialString());
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String countryCode = null;
            for (Map.Entry<String, String> pair : countries.entrySet()) {
                if (pair.getValue().equals(customer.getCountryName())) {
                    countryCode = pair.getKey();
                }
            }
            return countryCode;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] firstName;
            firstName = contact.getName().split(" ");
            return firstName[1];
        }

        @Override
        public String getContactLastName() {
            String[] lastName;
            lastName = contact.getName().split(",");
            return lastName[0];
        }

        @Override
        public String getDialString() {
            return "callto://" + contact.getPhoneNumber().replaceAll("[()-]", "");
//            return contact.getName().substring(0, 2) +
//                    contact.getName().substring(4, 6) +
//                    contact.getName().substring(8, 10) +
//                    contact.getName().substring(12, 13) +
//                    contact.getName().substring(15, 16);
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}