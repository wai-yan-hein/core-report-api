package cv.report.service;

import cv.report.entity.AppUser;

import java.util.List;

public interface AppUserService {
    AppUser save(AppUser user);

    boolean existUser(AppUser info);

    AppUser login(AppUser user);

    List<AppUser> getUser();

}
