package cv.report.service;

import cv.report.common.Util1;
import cv.report.entity.AppUser;
import cv.report.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    private AppUserRepo repo;
    @Autowired
    private SeqService seqService;

    @Override
    public AppUser save(AppUser user) {
        if (Util1.isNullOrEmpty(user.getUserCode())) {
            user.setUserCode(getUserCode());
        }
        user.setPassword(Util1.clearStr(user.getPassword()));
        return repo.save(user);
    }

    @Override
    public boolean existUser(AppUser info) {
        return !repo.search(info.getShortName()).isEmpty();
    }

    @Override
    public AppUser login(AppUser user) {
        String userShort = user.getShortName();
        String password = Util1.clearStr(user.getPassword());
        List<AppUser> users = repo.login(userShort, password);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public List<AppUser> getUser() {
        return repo.findAll();
    }

    private String getUserCode() {
        int seqNo = seqService.getSeqNo("User", "-");
        return String.format("%0" + 5 + "d", seqNo);
    }
}
