package hu.itguruk.allaskeresoportal.service;

import hu.itguruk.allaskeresoportal.entity.BaseUser;

public interface UserService {

  BaseUser findByUsername(String username);

}
