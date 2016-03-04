package dao;

import dbService.dataSets.UsersDataSet;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UsersDAO
{
    private Session session;

    public UsersDAO( Session session )
    {
        this.session = session;
    }

    public UsersDataSet get( long id )
    {
        return ( UsersDataSet ) session.get( UsersDataSet.class, id );
    }

    public UsersDataSet get( String name )
    {
        Criteria criteria = session.createCriteria( UsersDataSet.class );
        return ( UsersDataSet ) criteria.add( Restrictions.eq( "name", name ) ).uniqueResult();
    }

    public long getUserId( String name )
    {
        Criteria criteria = session.createCriteria( UsersDataSet.class );
        return ( ( UsersDataSet ) criteria.add( Restrictions.eq( "name", name ) ).uniqueResult() ).getId();
    }

    public long insertUser( String name )
    {
        return ( long ) session.save( new UsersDataSet( name ) );
    }

    public long insertUser( String name, String password )
    {
        return ( long ) session.save( new UsersDataSet( name, password ) );
    }
}
