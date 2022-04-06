
package com.itrail.test.rest.impl;

import com.itrail.test.domain.BaseResponce;
import com.itrail.test.domain.User;
import com.itrail.test.rest.UserResourceTwo;
import com.itrail.test.service.UserServiceTwo;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Path;
/**
 *
 * @author barysevich_k
 */
@Path("entitymanager")
public class UserTwoAPI implements UserResourceTwo {
    
    @EJB private UserServiceTwo service;
    @Override
    public BaseResponce getAllUsers() {
        BaseResponce bs = new BaseResponce(200,"success");
        List<User> rezult =  service.getAllUser();
        bs.setData(rezult);
        return bs;
    }
    
    @Override
    public BaseResponce getUserByID(Integer idUser) {
        BaseResponce bs = new BaseResponce(200, "success");
        bs.setData(service.getUs(idUser));
        return bs;
    }
    
    @Override
    public BaseResponce createUser(User user) {
        BaseResponce bs = new BaseResponce(200, "success");
        bs.setData("Create User:" + user);
        service.createUser(user);
        return bs;
    }

    @Override
    public BaseResponce deleteUserUM(Integer idUser){
        BaseResponce bs = new BaseResponce(200, "success");
        bs.setData("Delete User: " + idUser);
        service.deleteUser(idUser);
        return bs;
    }

    @Override
    public BaseResponce updateUser(Integer idUser, String name) {
        BaseResponce bs = new BaseResponce(200, "success");
        bs.setData("IdUser: "+ idUser +" Name: " + name);
        service.updateUser(idUser, name);
        return bs;
    }  
 
}
