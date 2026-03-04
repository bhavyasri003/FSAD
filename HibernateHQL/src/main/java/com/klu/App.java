package com.klu;

import java.util.List;
import org.hibernate.Session;

public class App {

public static void main(String[] args) {

Session session = HibernateUtil.getSessionFactory().openSession();

/* Sorting using HQL */

List<Product> list =
session.createQuery("FROM Product ORDER BY price ASC",Product.class).list();

System.out.println("Products Sorted by Price:");

for(Product p:list)
{
System.out.println(p.getName()+" "+p.getPrice());
}

/* Count products */

Long count =
session.createQuery("SELECT COUNT(p) FROM Product p",Long.class).uniqueResult();

System.out.println("Total Products: "+count);

session.close();

}
}