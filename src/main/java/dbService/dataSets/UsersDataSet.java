package dbService.dataSets;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class UsersDataSet implements Serializable
{
    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true, updatable = false)
    private String name;

    @Column(name = "password")
    private String password;

    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet()
    {
    }

    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet( String name, String password)
    {
        this.setId( -1 );
        this.setName( name );
        this.setPassword( password );
    }

    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet( long id, String name )
    {
        this.setId( id );
        this.setName( name );
        this.setPassword( name );
    }

    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet( String name )
    {
        this.setId( -1 );
        this.setName( name );
        this.setPassword( name );
    }

    public long getId()
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    @SuppressWarnings("UnusedDeclaration")
    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "UserDataSet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
