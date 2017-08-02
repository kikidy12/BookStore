package kr.co.tjeit.bookstore.datas;

import java.io.Serializable;

/**
 * Created by the on 2017-07-25.
 */

public class Customer implements Serializable {
    public String Name;
    public String phoneNum;
    public String e_mail;

    public Customer() {

    }

    public Customer(String inputName, String InputPhoneNum, String InputE_mail) {
        this.phoneNum = InputPhoneNum;
        this.Name = inputName;
        this.e_mail = InputE_mail;
    }

    @Override
    public String toString() {
        String str = this.Name + " : " + this.phoneNum + " : " + this.e_mail;
        return str;
    }
}
