package exceptions;

import persistence.DatabaseConnector;

public class DatabaseException extends Exception{

    public DatabaseException(String msg){
        super(msg);
    }
    public DatabaseException(String msg, Throwable e){
        super(msg, e);
    }
}
