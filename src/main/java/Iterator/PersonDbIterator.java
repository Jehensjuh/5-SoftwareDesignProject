package Iterator;

import Database.PersonDatabase;

public class PersonDbIterator extends Iterator{

    private PersonDatabase database;

    public PersonDbIterator(PersonDatabase database){
        this.database = database;
    }

    @Override
    boolean end() {
        return this.index == database.getDbp().size();//if we reached the end we'll be at the last index
    }

    @Override
    void next() {
        if(!this.end()){//if we are not at the last element
            index++;//go to the next element
        }else{
            this.index = 0;//if we are currently at the end, start at the beginning again.
        }
    }

    @Override
    void prev() {
        if(!(this.index == 0)){//if we are not at the start
            index--;//go back an element
        }else{
            this.index = database.getDbp().size();//else go to the last element
        }
    }

    @Override
    Object first() {
        return database.getDbp().get(0);
    }

    @Override
    Object current() {
        return database.getDbp().get(this.index);
    }
}
