package dbService;

import dao.UsersDAO;
import dbService.dataSets.UsersDataSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.SQLException;

public class DBService
{
    public static final String hibernate_show_sql = "false";
//    public static final String hibernate_hbm2ddl_auto = "create";
    public static final String hibernate_hbm2ddl_auto = "update";

    private final SessionFactory sessionFactory;

    public DBService()
    {
//        Configuration configuration = getH2Configuration();
        Configuration configuration = getMySqlConfiguration();
        sessionFactory = createSessionFactory( configuration );
    }

    @SuppressWarnings("UnusedDeclaration")
    private Configuration getMySqlConfiguration()
    {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass( UsersDataSet.class );

        configuration.setProperty( "hibernate.dialect", "org.hibernate.dialect.MySQLDialect" );
        configuration.setProperty( "hibernate.connection.driver_class", "com.mysql.jdbc.Driver" );
        configuration.setProperty( "hibernate.connection.url", "jdbc:mysql://localhost:3306/sws" );
        configuration.setProperty( "hibernate.connection.username", "sws" );
        configuration.setProperty( "hibernate.connection.password", "sws" );
        configuration.setProperty( "hibernate.show_sql", hibernate_show_sql );
        configuration.setProperty( "hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto );
        return configuration;
    }

    private Configuration getH2Configuration()
    {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass( UsersDataSet.class );

        configuration.setProperty( "hibernate.dialect", "org.hibernate.dialect.H2Dialect" );
        configuration.setProperty( "hibernate.connection.driver_class", "org.h2.Driver" );
        configuration.setProperty( "hibernate.connection.url", "jdbc:h2:./h2db" );
        configuration.setProperty( "hibernate.connection.username", "sws" );
        configuration.setProperty( "hibernate.connection.password", "sws" );
        configuration.setProperty( "hibernate.show_sql", hibernate_show_sql );
        configuration.setProperty( "hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto );
        return configuration;
    }

    private static SessionFactory createSessionFactory( Configuration configuration )
    {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings( configuration.getProperties() );
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory( serviceRegistry );
    }

    public UsersDataSet getUser( long id )
    {
        Session session = sessionFactory.openSession();
        UsersDAO dao = new UsersDAO( session );
        UsersDataSet usersDataSet = dao.get( id );
        session.close();
        return usersDataSet;
    }

    public UsersDataSet getUser( String name )
    {
//        System.out.println( "getting user: " + name );
        Session session = sessionFactory.openSession();
        UsersDAO dao = new UsersDAO( session );
        UsersDataSet usersDataSet = dao.get( name );
        session.close();
        return usersDataSet;
    }

    public long addUser( String name )
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        UsersDAO dao = new UsersDAO( session );
        long id = dao.insertUser( name );
        transaction.commit();
        session.close();
        return id;
    }

    public long addUser( String name, String password )
    {
//        System.out.println( "adding user: " + name + ", pass: " + password );
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        UsersDAO dao = new UsersDAO( session );
        long id = dao.insertUser( name, password );
        transaction.commit();
        session.close();
        return id;
    }

    public void printConnectInfo()
    {
        try
        {
            SessionFactoryImpl sessionFactoryImpl = (SessionFactoryImpl) sessionFactory;
            Connection connection = sessionFactoryImpl.getConnectionProvider().getConnection();
            System.out.println("DB name: " + connection.getMetaData().getDatabaseProductName());
            System.out.println("DB version: " + connection.getMetaData().getDatabaseProductVersion());
            System.out.println("Driver: " + connection.getMetaData().getDriverName());
            System.out.println("Autocommit: " + connection.getAutoCommit());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
